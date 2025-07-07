package com.facebook.widget;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.facebook.Session;
import com.facebook.android.R;
import com.facebook.android.Util;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
/* loaded from: classes3.dex */
public class WebDialog extends Dialog {
    private static final int BACKGROUND_GRAY = -872415232;
    static final String CANCEL_URI = "fbconnect://cancel";
    public static final int DEFAULT_THEME = 16973840;
    static final boolean DISABLE_SSL_CHECK_FOR_TESTING = false;
    private static final String DISPLAY_TOUCH = "touch";
    private static final String LOG_TAG = "FacebookSDK.WebDialog";
    private static final int MAX_BUFFER_SCREEN_WIDTH = 1024;
    private static final double MIN_SCALE_FACTOR = 0.6d;
    private static final int NO_BUFFER_SCREEN_WIDTH = 512;
    static final String REDIRECT_URI = "fbconnect://success";
    private static final String USER_AGENT = "user_agent";
    private FrameLayout contentFrameLayout;
    private ImageView crossImageView;
    private boolean isDetached;
    private boolean listenerCalled;
    private OnCompleteListener onCompleteListener;
    private ProgressDialog spinner;
    private String url;
    private WebView webView;

    /* loaded from: classes3.dex */
    public static class Builder extends BuilderBase<Builder> {
        public Builder(Context context, Session session, String str, Bundle bundle) {
            super(context, session, str, bundle);
        }

        public Builder(Context context, String str, String str2, Bundle bundle) {
            super(context, str, str2, bundle);
        }

        @Override // com.facebook.widget.WebDialog.BuilderBase
        public /* bridge */ /* synthetic */ WebDialog build() {
            return super.build();
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.facebook.widget.WebDialog$BuilderBase, com.facebook.widget.WebDialog$Builder] */
        @Override // com.facebook.widget.WebDialog.BuilderBase
        public /* bridge */ /* synthetic */ Builder setOnCompleteListener(OnCompleteListener onCompleteListener) {
            return super.setOnCompleteListener(onCompleteListener);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.facebook.widget.WebDialog$BuilderBase, com.facebook.widget.WebDialog$Builder] */
        @Override // com.facebook.widget.WebDialog.BuilderBase
        public /* bridge */ /* synthetic */ Builder setTheme(int i) {
            return super.setTheme(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class BuilderBase<CONCRETE extends BuilderBase<?>> {
        private String action;
        private String applicationId;
        private Context context;
        private OnCompleteListener listener;
        private Bundle parameters;
        private Session session;
        private int theme = WebDialog.DEFAULT_THEME;

        protected BuilderBase(Context context, Session session, String str, Bundle bundle) {
            Validate.notNull(session, "session");
            if (!session.isOpened()) {
                throw new FacebookException("Attempted to use a Session that was not open.");
            }
            this.session = session;
            finishInit(context, str, bundle);
        }

        protected BuilderBase(Context context, String str, String str2, Bundle bundle) {
            Validate.notNullOrEmpty(str, "applicationId");
            this.applicationId = str;
            finishInit(context, str2, bundle);
        }

        private void finishInit(Context context, String str, Bundle bundle) {
            this.context = context;
            this.action = str;
            if (bundle != null) {
                this.parameters = bundle;
            } else {
                this.parameters = new Bundle();
            }
        }

        public WebDialog build() {
            Session session = this.session;
            if (session == null || !session.isOpened()) {
                this.parameters.putString("app_id", this.applicationId);
            } else {
                this.parameters.putString("app_id", this.session.getApplicationId());
                this.parameters.putString("access_token", this.session.getAccessToken());
            }
            if (!this.parameters.containsKey(ServerProtocol.DIALOG_PARAM_REDIRECT_URI)) {
                this.parameters.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, "fbconnect://success");
            }
            return new WebDialog(this.context, this.action, this.parameters, this.theme, this.listener);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public String getApplicationId() {
            return this.applicationId;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Context getContext() {
            return this.context;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public OnCompleteListener getListener() {
            return this.listener;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Bundle getParameters() {
            return this.parameters;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int getTheme() {
            return this.theme;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CONCRETE setOnCompleteListener(OnCompleteListener onCompleteListener) {
            this.listener = onCompleteListener;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CONCRETE setTheme(int i) {
            this.theme = i;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class DialogWebViewClient extends WebViewClient {
        private DialogWebViewClient() {
        }

        /* synthetic */ DialogWebViewClient(WebDialog webDialog, DialogWebViewClient dialogWebViewClient) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!WebDialog.this.isDetached) {
                WebDialog.this.spinner.dismiss();
            }
            WebDialog.this.contentFrameLayout.setBackgroundColor(0);
            WebDialog.this.webView.setVisibility(0);
            WebDialog.this.crossImageView.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Utility.logd(WebDialog.LOG_TAG, "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
            if (WebDialog.this.isDetached) {
                return;
            }
            WebDialog.this.spinner.show();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            WebDialog.this.sendErrorToListener(new FacebookDialogException(str, i, str2));
            WebDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            WebDialog.this.sendErrorToListener(new FacebookDialogException(null, -11, null));
            sslErrorHandler.cancel();
            WebDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            int parseInt;
            Utility.logd(WebDialog.LOG_TAG, "Redirect URL: " + str);
            if (!str.startsWith("fbconnect://success")) {
                if (str.startsWith("fbconnect://cancel")) {
                    WebDialog.this.sendCancelToListener();
                    WebDialog.this.dismiss();
                    return true;
                } else if (str.contains(WebDialog.DISPLAY_TOUCH)) {
                    return false;
                } else {
                    WebDialog.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                }
            }
            Bundle parseUrl = Util.parseUrl(str);
            String string = parseUrl.getString("error");
            if (string == null) {
                string = parseUrl.getString("error_type");
            }
            String string2 = parseUrl.getString("error_msg");
            if (string2 == null) {
                string2 = parseUrl.getString("error_description");
            }
            String string3 = parseUrl.getString("error_code");
            if (!Utility.isNullOrEmpty(string3)) {
                try {
                    parseInt = Integer.parseInt(string3);
                } catch (NumberFormatException unused) {
                }
                if (!Utility.isNullOrEmpty(string) && Utility.isNullOrEmpty(string2) && parseInt == -1) {
                    WebDialog.this.sendSuccessToListener(parseUrl);
                } else if (string == null && (string.equals("access_denied") || string.equals("OAuthAccessDeniedException"))) {
                    WebDialog.this.sendCancelToListener();
                } else {
                    WebDialog.this.sendErrorToListener(new FacebookServiceException(new FacebookRequestError(parseInt, string, string2), string2));
                }
                WebDialog.this.dismiss();
                return true;
            }
            parseInt = -1;
            if (!Utility.isNullOrEmpty(string)) {
            }
            if (string == null) {
            }
            WebDialog.this.sendErrorToListener(new FacebookServiceException(new FacebookRequestError(parseInt, string, string2), string2));
            WebDialog.this.dismiss();
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static class FeedDialogBuilder extends BuilderBase<FeedDialogBuilder> {
        private static final String CAPTION_PARAM = "caption";
        private static final String DESCRIPTION_PARAM = "description";
        private static final String FEED_DIALOG = "feed";
        private static final String FROM_PARAM = "from";
        private static final String LINK_PARAM = "link";
        private static final String NAME_PARAM = "name";
        private static final String PICTURE_PARAM = "picture";
        private static final String SOURCE_PARAM = "source";
        private static final String TO_PARAM = "to";

        public FeedDialogBuilder(Context context, Session session) {
            super(context, session, FEED_DIALOG, (Bundle) null);
        }

        public FeedDialogBuilder(Context context, Session session, Bundle bundle) {
            super(context, session, FEED_DIALOG, bundle);
        }

        @Override // com.facebook.widget.WebDialog.BuilderBase
        public /* bridge */ /* synthetic */ WebDialog build() {
            return super.build();
        }

        public FeedDialogBuilder setCaption(String str) {
            getParameters().putString(CAPTION_PARAM, str);
            return this;
        }

        public FeedDialogBuilder setDescription(String str) {
            getParameters().putString(DESCRIPTION_PARAM, str);
            return this;
        }

        public FeedDialogBuilder setFrom(String str) {
            getParameters().putString("from", str);
            return this;
        }

        public FeedDialogBuilder setLink(String str) {
            getParameters().putString(LINK_PARAM, str);
            return this;
        }

        public FeedDialogBuilder setName(String str) {
            getParameters().putString("name", str);
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.facebook.widget.WebDialog$BuilderBase, com.facebook.widget.WebDialog$FeedDialogBuilder] */
        @Override // com.facebook.widget.WebDialog.BuilderBase
        public /* bridge */ /* synthetic */ FeedDialogBuilder setOnCompleteListener(OnCompleteListener onCompleteListener) {
            return super.setOnCompleteListener(onCompleteListener);
        }

        public FeedDialogBuilder setPicture(String str) {
            getParameters().putString(PICTURE_PARAM, str);
            return this;
        }

        public FeedDialogBuilder setSource(String str) {
            getParameters().putString("source", str);
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.facebook.widget.WebDialog$BuilderBase, com.facebook.widget.WebDialog$FeedDialogBuilder] */
        @Override // com.facebook.widget.WebDialog.BuilderBase
        public /* bridge */ /* synthetic */ FeedDialogBuilder setTheme(int i) {
            return super.setTheme(i);
        }

        public FeedDialogBuilder setTo(String str) {
            getParameters().putString("to", str);
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public interface OnCompleteListener {
        void onComplete(Bundle bundle, FacebookException facebookException);
    }

    /* loaded from: classes3.dex */
    public static class RequestsDialogBuilder extends BuilderBase<RequestsDialogBuilder> {
        private static final String APPREQUESTS_DIALOG = "apprequests";
        private static final String DATA_PARAM = "data";
        private static final String MESSAGE_PARAM = "message";
        private static final String TITLE_PARAM = "title";
        private static final String TO_PARAM = "to";

        public RequestsDialogBuilder(Context context, Session session) {
            super(context, session, APPREQUESTS_DIALOG, (Bundle) null);
        }

        public RequestsDialogBuilder(Context context, Session session, Bundle bundle) {
            super(context, session, APPREQUESTS_DIALOG, bundle);
        }

        @Override // com.facebook.widget.WebDialog.BuilderBase
        public /* bridge */ /* synthetic */ WebDialog build() {
            return super.build();
        }

        public RequestsDialogBuilder setData(String str) {
            getParameters().putString("data", str);
            return this;
        }

        public RequestsDialogBuilder setMessage(String str) {
            getParameters().putString(MESSAGE_PARAM, str);
            return this;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.facebook.widget.WebDialog$BuilderBase, com.facebook.widget.WebDialog$RequestsDialogBuilder] */
        @Override // com.facebook.widget.WebDialog.BuilderBase
        public /* bridge */ /* synthetic */ RequestsDialogBuilder setOnCompleteListener(OnCompleteListener onCompleteListener) {
            return super.setOnCompleteListener(onCompleteListener);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.facebook.widget.WebDialog$BuilderBase, com.facebook.widget.WebDialog$RequestsDialogBuilder] */
        @Override // com.facebook.widget.WebDialog.BuilderBase
        public /* bridge */ /* synthetic */ RequestsDialogBuilder setTheme(int i) {
            return super.setTheme(i);
        }

        public RequestsDialogBuilder setTitle(String str) {
            getParameters().putString(TITLE_PARAM, str);
            return this;
        }

        public RequestsDialogBuilder setTo(String str) {
            getParameters().putString("to", str);
            return this;
        }
    }

    public WebDialog(Context context, String str) {
        this(context, str, DEFAULT_THEME);
    }

    public WebDialog(Context context, String str, int i) {
        super(context, i);
        this.listenerCalled = false;
        this.isDetached = false;
        this.url = str;
    }

    public WebDialog(Context context, String str, Bundle bundle, int i, OnCompleteListener onCompleteListener) {
        super(context, i);
        this.listenerCalled = false;
        this.isDetached = false;
        bundle = bundle == null ? new Bundle() : bundle;
        bundle.putString("display", DISPLAY_TOUCH);
        bundle.putString("type", USER_AGENT);
        this.url = Utility.buildUri(ServerProtocol.getDialogAuthority(), ServerProtocol.DIALOG_PATH + str, bundle).toString();
        this.onCompleteListener = onCompleteListener;
    }

    private void createCrossImage() {
        ImageView imageView = new ImageView(getContext());
        this.crossImageView = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.widget.WebDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WebDialog.this.sendCancelToListener();
                WebDialog.this.dismiss();
            }
        });
        this.crossImageView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.com_facebook_close));
        this.crossImageView.setVisibility(4);
    }

    private Pair<Integer, Integer> getMargins() {
        double d;
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        int i3 = (int) (i / displayMetrics.density);
        if (i3 <= 512) {
            d = 1.0d;
        } else {
            d = MIN_SCALE_FACTOR;
            if (i3 < 1024) {
                d = MIN_SCALE_FACTOR + (((1024 - i3) / 512.0d) * 0.4d);
            }
        }
        double d2 = 1.0d - d;
        return new Pair<>(Integer.valueOf((int) ((i * d2) / 2.0d)), Integer.valueOf((int) ((i2 * d2) / 2.0d)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCancelToListener() {
        sendErrorToListener(new FacebookOperationCanceledException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendErrorToListener(Throwable th) {
        if (this.onCompleteListener == null || this.listenerCalled) {
            return;
        }
        this.listenerCalled = true;
        this.onCompleteListener.onComplete(null, th instanceof FacebookException ? (FacebookException) th : new FacebookException(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSuccessToListener(Bundle bundle) {
        OnCompleteListener onCompleteListener = this.onCompleteListener;
        if (onCompleteListener == null || this.listenerCalled) {
            return;
        }
        this.listenerCalled = true;
        onCompleteListener.onComplete(bundle, null);
    }

    private void setUpWebView(int i) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        WebView webView = new WebView(getContext());
        this.webView = webView;
        webView.setVerticalScrollBarEnabled(false);
        this.webView.setHorizontalScrollBarEnabled(false);
        this.webView.setWebViewClient(new DialogWebViewClient(this, null));
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.loadUrl(this.url);
        this.webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.webView.setVisibility(4);
        this.webView.getSettings().setSavePassword(false);
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.webView);
        linearLayout.setBackgroundColor(BACKGROUND_GRAY);
        this.contentFrameLayout.addView(linearLayout);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        WebView webView = this.webView;
        if (webView != null) {
            webView.stopLoading();
        }
        if (this.isDetached) {
            return;
        }
        if (this.spinner.isShowing()) {
            this.spinner.dismiss();
        }
        super.dismiss();
    }

    public OnCompleteListener getOnCompleteListener() {
        return this.onCompleteListener;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        this.isDetached = false;
        super.onAttachedToWindow();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.facebook.widget.WebDialog.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WebDialog.this.sendCancelToListener();
            }
        });
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        this.spinner = progressDialog;
        progressDialog.requestWindowFeature(1);
        this.spinner.setMessage(getContext().getString(R.string.com_facebook_loading));
        this.spinner.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.facebook.widget.WebDialog.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WebDialog.this.sendCancelToListener();
                WebDialog.this.dismiss();
            }
        });
        requestWindowFeature(1);
        this.contentFrameLayout = new FrameLayout(getContext());
        Pair<Integer, Integer> margins = getMargins();
        this.contentFrameLayout.setPadding(((Integer) margins.first).intValue(), ((Integer) margins.second).intValue(), ((Integer) margins.first).intValue(), ((Integer) margins.second).intValue());
        createCrossImage();
        setUpWebView((this.crossImageView.getDrawable().getIntrinsicWidth() / 2) + 1);
        this.contentFrameLayout.addView(this.crossImageView, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.contentFrameLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.isDetached = true;
        super.onDetachedFromWindow();
    }

    public void setOnCompleteListener(OnCompleteListener onCompleteListener) {
        this.onCompleteListener = onCompleteListener;
    }
}
