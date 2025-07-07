package com.google.example.games.basegameutils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.appstate.AppStateManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.plus.Plus;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class GameHelper implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public static final int CLIENT_ALL = 15;
    public static final int CLIENT_APPSTATE = 4;
    public static final int CLIENT_DRIVE = 8;
    public static final int CLIENT_GAMES = 1;
    public static final int CLIENT_NONE = 0;
    public static final int CLIENT_PLUS = 2;
    static final int DEFAULT_MAX_SIGN_IN_ATTEMPTS = 0;
    static final int RC_RESOLVE = 9001;
    static final int RC_UNUSED = 9002;
    static final String TAG = "GameHelper";
    Activity mActivity;
    Context mAppContext;
    Games.GamesOptions mGamesApiOptions;
    Invitation mInvitation;
    Plus.PlusOptions mPlusApiOptions;
    int mRequestedClients;
    ArrayList<GameRequest> mRequests;
    TurnBasedMatch mTurnBasedMatch;
    private boolean mSetupDone = false;
    private boolean mConnecting = false;
    boolean mExpectingResolution = false;
    boolean mSignInCancelled = false;
    GoogleApiClient.Builder mGoogleApiClientBuilder = null;
    GoogleApiClient mGoogleApiClient = null;
    boolean mConnectOnStart = true;
    boolean mUserInitiatedSignIn = false;
    ConnectionResult mConnectionResult = null;
    SignInFailureReason mSignInFailureReason = null;
    boolean mShowErrorDialogs = true;
    boolean mDebugLog = false;
    Handler mHandler = null;
    GameHelperListener mListener = null;
    int mMaxAutoSignInAttempts = 0;
    private final String GAMEHELPER_SHARED_PREFS = "GAMEHELPER_SHARED_PREFS";
    private final String KEY_SIGN_IN_CANCELLATIONS = "KEY_SIGN_IN_CANCELLATIONS";

    /* loaded from: classes4.dex */
    public interface GameHelperListener {
        void onSignInFailed();

        void onSignInSucceeded();
    }

    /* loaded from: classes4.dex */
    public static class SignInFailureReason {
        public static final int NO_ACTIVITY_RESULT_CODE = -100;
        int mActivityResultCode;
        int mServiceErrorCode;

        public SignInFailureReason(int i) {
            this(i, -100);
        }

        public SignInFailureReason(int i, int i2) {
            this.mServiceErrorCode = i;
            this.mActivityResultCode = i2;
        }

        public int getActivityResultCode() {
            return this.mActivityResultCode;
        }

        public int getServiceErrorCode() {
            return this.mServiceErrorCode;
        }

        public String toString() {
            return "SignInFailureReason(serviceErrorCode:" + GameHelperUtils.errorCodeToString(this.mServiceErrorCode) + (this.mActivityResultCode != -100 ? ",activityResultCode:" + GameHelperUtils.activityResponseCodeToString(this.mActivityResultCode) + ")" : ")");
        }
    }

    public GameHelper(Activity activity, int i) {
        this.mAppContext = null;
        this.mGamesApiOptions = null;
        this.mPlusApiOptions = null;
        this.mRequestedClients = 0;
        this.mActivity = activity;
        this.mAppContext = activity.getApplicationContext();
        this.mRequestedClients = i;
        this.mGamesApiOptions = Games.GamesOptions.builder().build();
        this.mPlusApiOptions = Plus.PlusOptions.builder().build();
    }

    private void doApiOptionsPreCheck() {
        if (this.mGoogleApiClientBuilder == null) {
            return;
        }
        logError("GameHelper: you cannot call set*ApiOptions after the client builder has been created. Call it before calling createApiClientBuilder() or setup().");
        throw new IllegalStateException("GameHelper: you cannot call set*ApiOptions after the client builder has been created. Call it before calling createApiClientBuilder() or setup().");
    }

    private boolean isAndroidConnected() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mActivity.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    static Dialog makeSimpleDialog(Activity activity, String str) {
        return new AlertDialog.Builder(activity).setMessage(str).setNeutralButton(17039370, (DialogInterface.OnClickListener) null).create();
    }

    static Dialog makeSimpleDialog(Activity activity, String str, String str2) {
        return new AlertDialog.Builder(activity).setMessage(str2).setTitle(str).setNeutralButton(17039370, (DialogInterface.OnClickListener) null).create();
    }

    public static void showFailureDialog(Activity activity, int i, int i2) {
        int i3;
        String string;
        Dialog dialog;
        if (activity == null) {
            Log.e(TAG, "*** No Activity. Can't show failure dialog!");
            return;
        }
        switch (i) {
            case 10002:
                i3 = 1;
                string = GameHelperUtils.getString(activity, i3);
                dialog = makeSimpleDialog(activity, string);
                break;
            case 10003:
                i3 = 3;
                string = GameHelperUtils.getString(activity, i3);
                dialog = makeSimpleDialog(activity, string);
                break;
            case 10004:
                i3 = 2;
                string = GameHelperUtils.getString(activity, i3);
                dialog = makeSimpleDialog(activity, string);
                break;
            default:
                Dialog errorDialog = GooglePlayServicesUtil.getErrorDialog(i2, activity, RC_UNUSED, null);
                if (errorDialog != null) {
                    dialog = errorDialog;
                    break;
                } else {
                    Log.e(TAG, "No standard error dialog available. Making fallback dialog.");
                    string = GameHelperUtils.getString(activity, 0) + " " + GameHelperUtils.errorCodeToString(i2);
                    dialog = makeSimpleDialog(activity, string);
                    break;
                }
        }
        dialog.show();
    }

    void assertConfigured(String str) {
        if (this.mSetupDone) {
            return;
        }
        String str2 = "GameHelper error: Operation attempted without setup: " + str + ". The setup() method must be called before attempting any other operation.";
        logError(str2);
        throw new IllegalStateException(str2);
    }

    public void beginUserInitiatedSignIn() {
        debugLog("beginUserInitiatedSignIn: resetting attempt count.");
        resetSignInCancellations();
        this.mSignInCancelled = false;
        this.mConnectOnStart = true;
        if (this.mGoogleApiClient.isConnected()) {
            logWarn("beginUserInitiatedSignIn() called when already connected. Calling listener directly to notify of success.");
            notifyListener(true);
        } else if (this.mConnecting) {
            logWarn("beginUserInitiatedSignIn() called when already connecting. Be patient! You can only call this method after you get an onSignInSucceeded() or onSignInFailed() callback. Suggestion: disable the sign-in button on startup and also when it's clicked, and re-enable when you get the callback.");
        } else {
            debugLog("Starting USER-INITIATED sign-in flow.");
            this.mUserInitiatedSignIn = true;
            if (this.mConnectionResult != null) {
                debugLog("beginUserInitiatedSignIn: continuing pending sign-in flow.");
                this.mConnecting = true;
                resolveConnectionResult();
                return;
            }
            debugLog("beginUserInitiatedSignIn: starting new sign-in flow.");
            this.mConnecting = true;
            connect(true);
        }
    }

    public void clearInvitation() {
        this.mInvitation = null;
    }

    public void clearRequests() {
        this.mRequests = null;
    }

    public void clearTurnBasedMatch() {
        this.mTurnBasedMatch = null;
    }

    void connect() {
        connect(false);
    }

    void connect(boolean z) {
        if (this.mGoogleApiClient.isConnected()) {
            debugLog("Already connected.");
            return;
        }
        debugLog("Starting connection.");
        this.mConnecting = true;
        this.mInvitation = null;
        this.mTurnBasedMatch = null;
        if (z) {
            this.mGoogleApiClient.blockingConnect(15L, TimeUnit.SECONDS);
        } else {
            this.mGoogleApiClient.connect();
        }
    }

    public GoogleApiClient.Builder createApiClientBuilder() {
        if (this.mSetupDone) {
            logError("GameHelper: you called GameHelper.createApiClientBuilder() after calling setup. You can only get a client builder BEFORE performing setup.");
            throw new IllegalStateException("GameHelper: you called GameHelper.createApiClientBuilder() after calling setup. You can only get a client builder BEFORE performing setup.");
        }
        GoogleApiClient.Builder builder = new GoogleApiClient.Builder(this.mActivity, this, this);
        if ((this.mRequestedClients & 8) != 0) {
            builder.addApi(Drive.API);
            builder.addScope(Drive.SCOPE_APPFOLDER);
        }
        if ((this.mRequestedClients & 1) != 0) {
            builder.addApi(Games.API, this.mGamesApiOptions);
            builder.addScope(Games.SCOPE_GAMES);
        }
        if ((this.mRequestedClients & 2) != 0) {
            builder.addApi(Plus.API, this.mPlusApiOptions);
            builder.addScope(Plus.SCOPE_PLUS_LOGIN);
        }
        if ((this.mRequestedClients & 4) != 0) {
            builder.addApi(AppStateManager.API);
            builder.addScope(AppStateManager.SCOPE_APP_STATE);
        }
        builder.setViewForPopups(this.mActivity.findViewById(16908290));
        this.mGoogleApiClientBuilder = builder;
        return builder;
    }

    void debugLog(String str) {
        if (this.mDebugLog) {
            Log.d(TAG, "GameHelper: " + str);
        }
    }

    public void disconnect() {
        if (!this.mGoogleApiClient.isConnected()) {
            Log.w(TAG, "disconnect() called when client was already disconnected.");
            return;
        }
        debugLog("Disconnecting client.");
        this.mGoogleApiClient.disconnect();
    }

    public void enableDebugLog(boolean z) {
        this.mDebugLog = z;
        if (z) {
            debugLog("Debug log enabled.");
        }
    }

    @Deprecated
    public void enableDebugLog(boolean z, String str) {
        Log.w(TAG, "GameHelper.enableDebugLog(boolean,String) is deprecated. Use GameHelper.enableDebugLog(boolean)");
        enableDebugLog(z);
    }

    public GoogleApiClient getApiClient() {
        GoogleApiClient googleApiClient = this.mGoogleApiClient;
        if (googleApiClient != null) {
            return googleApiClient;
        }
        throw new IllegalStateException("No GoogleApiClient. Did you call setup()?");
    }

    public Handler getHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        }
        return this.mHandler;
    }

    public Invitation getInvitation() {
        if (!this.mGoogleApiClient.isConnected()) {
            Log.w(TAG, "Warning: getInvitation() should only be called when signed in, that is, after getting onSignInSuceeded()");
        }
        return this.mInvitation;
    }

    public String getInvitationId() {
        if (!this.mGoogleApiClient.isConnected()) {
            Log.w(TAG, "Warning: getInvitationId() should only be called when signed in, that is, after getting onSignInSuceeded()");
        }
        Invitation invitation = this.mInvitation;
        if (invitation == null) {
            return null;
        }
        return invitation.getInvitationId();
    }

    public ArrayList<GameRequest> getRequests() {
        if (!this.mGoogleApiClient.isConnected()) {
            Log.w(TAG, "Warning: getRequests() should only be called when signed in, that is, after getting onSignInSuceeded()");
        }
        return this.mRequests;
    }

    int getSignInCancellations() {
        return this.mAppContext.getSharedPreferences("GAMEHELPER_SHARED_PREFS", 0).getInt("KEY_SIGN_IN_CANCELLATIONS", 0);
    }

    public SignInFailureReason getSignInError() {
        return this.mSignInFailureReason;
    }

    public TurnBasedMatch getTurnBasedMatch() {
        if (!this.mGoogleApiClient.isConnected()) {
            Log.w(TAG, "Warning: getTurnBasedMatch() should only be called when signed in, that is, after getting onSignInSuceeded()");
        }
        return this.mTurnBasedMatch;
    }

    void giveUp(SignInFailureReason signInFailureReason) {
        this.mConnectOnStart = false;
        disconnect();
        this.mSignInFailureReason = signInFailureReason;
        if (signInFailureReason.mActivityResultCode == 10004) {
            GameHelperUtils.printMisconfiguredDebugInfo(this.mAppContext);
        }
        showFailureDialog();
        this.mConnecting = false;
        notifyListener(false);
    }

    public boolean hasInvitation() {
        return this.mInvitation != null;
    }

    public boolean hasRequests() {
        return this.mRequests != null;
    }

    public boolean hasSignInError() {
        return this.mSignInFailureReason != null;
    }

    public boolean hasTurnBasedMatch() {
        return this.mTurnBasedMatch != null;
    }

    int incrementSignInCancellations() {
        int signInCancellations = getSignInCancellations();
        SharedPreferences.Editor edit = this.mAppContext.getSharedPreferences("GAMEHELPER_SHARED_PREFS", 0).edit();
        int i = signInCancellations + 1;
        edit.putInt("KEY_SIGN_IN_CANCELLATIONS", i);
        edit.commit();
        return i;
    }

    public boolean isConnecting() {
        return this.mConnecting;
    }

    public boolean isSignedIn() {
        boolean isAndroidConnected = isAndroidConnected();
        GoogleApiClient googleApiClient = this.mGoogleApiClient;
        boolean z = googleApiClient != null && googleApiClient.isConnected();
        debugLog("checking connection: " + this.mGoogleApiClient + " + " + this.mGoogleApiClient.isConnected() + " + " + isAndroidConnected);
        if (!isAndroidConnected && z) {
            disconnect();
        }
        return z && isAndroidConnected;
    }

    void logError(String str) {
        Log.e(TAG, "*** GameHelper ERROR: " + str);
    }

    void logWarn(String str) {
        Log.w(TAG, "!!! GameHelper WARNING: " + str);
    }

    public Dialog makeSimpleDialog(String str) {
        Activity activity = this.mActivity;
        if (activity == null) {
            logError("*** makeSimpleDialog failed: no current Activity!");
            return null;
        }
        return makeSimpleDialog(activity, str);
    }

    public Dialog makeSimpleDialog(String str, String str2) {
        Activity activity = this.mActivity;
        if (activity == null) {
            logError("*** makeSimpleDialog failed: no current Activity!");
            return null;
        }
        return makeSimpleDialog(activity, str, str2);
    }

    void notifyListener(boolean z) {
        debugLog("Notifying LISTENER of sign-in ".concat(z ? "SUCCESS" : this.mSignInFailureReason != null ? "FAILURE (error)" : "FAILURE (no error)"));
        GameHelperListener gameHelperListener = this.mListener;
        if (gameHelperListener != null) {
            if (z) {
                gameHelperListener.onSignInSucceeded();
            } else {
                gameHelperListener.onSignInFailed();
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        debugLog("onActivityResult: req=" + (i == RC_RESOLVE ? "RC_RESOLVE" : String.valueOf(i)) + ", resp=" + GameHelperUtils.activityResponseCodeToString(i2));
        if (i != RC_RESOLVE) {
            debugLog("onActivityResult: request code not meant for us. Ignoring.");
            return;
        }
        this.mExpectingResolution = false;
        if (!this.mConnecting) {
            debugLog("onActivityResult: ignoring because we are not connecting.");
        } else if (i2 == -1) {
            debugLog("onAR: Resolution was RESULT_OK, so connecting current client again.");
            connect();
        } else if (i2 == 10001) {
            debugLog("onAR: Resolution was RECONNECT_REQUIRED, so reconnecting.");
            connect();
        } else if (i2 != 0) {
            debugLog("onAR: responseCode=" + GameHelperUtils.activityResponseCodeToString(i2) + ", so giving up.");
            giveUp(new SignInFailureReason(this.mConnectionResult.getErrorCode(), i2));
        } else {
            debugLog("onAR: Got a cancellation result, so disconnecting.");
            this.mSignInCancelled = true;
            this.mConnectOnStart = false;
            this.mUserInitiatedSignIn = false;
            this.mSignInFailureReason = null;
            this.mConnecting = false;
            this.mGoogleApiClient.disconnect();
            debugLog("onAR: # of cancellations " + getSignInCancellations() + " --> " + incrementSignInCancellations() + ", max " + this.mMaxAutoSignInAttempts);
            notifyListener(false);
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public void onConnected(Bundle bundle) {
        debugLog("onConnected: connected!");
        if (!isAndroidConnected()) {
            debugLog("onConnected: Android connectivity reports unconnected so failing now.");
            this.mConnecting = false;
            notifyListener(false);
            return;
        }
        if (bundle != null) {
            debugLog("onConnected: connection hint provided. Checking for invite.");
            Invitation parcelable = bundle.getParcelable("invitation");
            if (parcelable != null && parcelable.getInvitationId() != null) {
                debugLog("onConnected: connection hint has a room invite!");
                this.mInvitation = parcelable;
                debugLog("Invitation ID: " + this.mInvitation.getInvitationId());
            }
            ArrayList<GameRequest> gameRequestsFromBundle = Games.Requests.getGameRequestsFromBundle(bundle);
            this.mRequests = gameRequestsFromBundle;
            if (!gameRequestsFromBundle.isEmpty()) {
                debugLog("onConnected: connection hint has " + this.mRequests.size() + " request(s)");
            }
            debugLog("onConnected: connection hint provided. Checking for TBMP game.");
            this.mTurnBasedMatch = bundle.getParcelable("turn_based_match");
        }
        succeedSignIn();
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult connectionResult) {
        String str;
        String str2;
        debugLog("onConnectionFailed");
        if (this.mActivity == null) {
            debugLog("aborting onConnectionFailed becaue mActivity == null (onStop called)");
            return;
        }
        this.mConnectionResult = connectionResult;
        debugLog("Connection failure:");
        debugLog("   - code: " + GameHelperUtils.errorCodeToString(this.mConnectionResult.getErrorCode()));
        debugLog("   - resolvable: " + this.mConnectionResult.hasResolution());
        debugLog("   - details: " + this.mConnectionResult.toString());
        int signInCancellations = getSignInCancellations();
        if (!this.mUserInitiatedSignIn) {
            if (this.mSignInCancelled) {
                str = "onConnectionFailed WILL NOT resolve (user already cancelled once).";
            } else if (signInCancellations < this.mMaxAutoSignInAttempts) {
                str2 = "onConnectionFailed: WILL resolve because we have below the max# of attempts, " + signInCancellations + " < " + this.mMaxAutoSignInAttempts;
            } else {
                str = "onConnectionFailed: Will NOT resolve; not user-initiated and max attempts reached: " + signInCancellations + " >= " + this.mMaxAutoSignInAttempts;
            }
            debugLog(str);
            debugLog("onConnectionFailed: since we won't resolve, failing now.");
            this.mConnectionResult = connectionResult;
            this.mConnecting = false;
            notifyListener(false);
            return;
        }
        str2 = "onConnectionFailed: WILL resolve because user initiated sign-in.";
        debugLog(str2);
        debugLog("onConnectionFailed: resolving problem...");
        resolveConnectionResult();
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
        debugLog("onConnectionSuspended, cause=" + i);
        disconnect();
        this.mSignInFailureReason = null;
        debugLog("Making extraordinary call to onSignInFailed callback");
        this.mConnecting = false;
        notifyListener(false);
    }

    public void onPause() {
    }

    public void onStart(Activity activity) {
        this.mActivity = activity;
        this.mAppContext = activity.getApplicationContext();
        debugLog("onStart with activity: " + String.valueOf(activity));
        assertConfigured("onStart");
        if (!this.mConnectOnStart) {
            debugLog("Not attempting to connect becase mConnectOnStart=false");
            debugLog("Instead, reporting a sign-in failure.");
            notifyListener(false);
        } else if (this.mGoogleApiClient.isConnected()) {
            Log.w(TAG, "GameHelper: client was already connected on onStart()");
        } else if (this.mExpectingResolution) {
            Log.w(TAG, "GameHelper: not connecting because we're expecting a resolution.");
        } else {
            debugLog("Connecting client.");
            this.mConnecting = true;
            this.mGoogleApiClient.connect();
        }
    }

    public void onStop() {
        assertConfigured("onStop");
        if (this.mGoogleApiClient.isConnected()) {
            debugLog("Disconnecting client due to onStop");
            this.mGoogleApiClient.disconnect();
        } else {
            debugLog("Client already disconnected when we got onStop.");
        }
        this.mConnecting = false;
        this.mActivity = null;
    }

    public void reconnectClient() {
        if (this.mGoogleApiClient.isConnected()) {
            debugLog("Reconnecting client.");
            this.mGoogleApiClient.reconnect();
            return;
        }
        Log.w(TAG, "reconnectClient() called when client is not connected.");
        connect();
    }

    void resetSignInCancellations() {
        SharedPreferences.Editor edit = this.mAppContext.getSharedPreferences("GAMEHELPER_SHARED_PREFS", 0).edit();
        edit.putInt("KEY_SIGN_IN_CANCELLATIONS", 0);
        edit.commit();
    }

    void resolveConnectionResult() {
        if (this.mExpectingResolution) {
            debugLog("We're already expecting the result of a previous resolution.");
            return;
        }
        debugLog("resolveConnectionResult: trying to resolve result: " + this.mConnectionResult);
        if (!this.mConnectionResult.hasResolution()) {
            debugLog("resolveConnectionResult: result has no resolution. Giving up.");
            giveUp(new SignInFailureReason(this.mConnectionResult.getErrorCode()));
            return;
        }
        debugLog("Result has resolution. Starting it.");
        boolean z = true;
        try {
            this.mExpectingResolution = true;
            StringBuilder sb = new StringBuilder("mActivity null? ");
            if (this.mActivity != null) {
                z = false;
            }
            debugLog(sb.append(String.valueOf(z)).toString());
            this.mConnectionResult.startResolutionForResult(this.mActivity, RC_RESOLVE);
        } catch (IntentSender.SendIntentException unused) {
            debugLog("SendIntentException, so connecting again.");
            connect();
        }
    }

    public void setConnectOnStart(boolean z) {
        debugLog("Forcing mConnectOnStart=" + z);
        this.mConnectOnStart = z;
    }

    public void setGamesApiOptions(Games.GamesOptions gamesOptions) {
        doApiOptionsPreCheck();
        this.mGamesApiOptions = gamesOptions;
    }

    public void setMaxAutoSignInAttempts(int i) {
        this.mMaxAutoSignInAttempts = i;
    }

    public void setPlusApiOptions(Plus.PlusOptions plusOptions) {
        doApiOptionsPreCheck();
        this.mPlusApiOptions = plusOptions;
    }

    public void setShowErrorDialogs(boolean z) {
        this.mShowErrorDialogs = z;
    }

    public void setup(GameHelperListener gameHelperListener) {
        if (this.mSetupDone) {
            logError("GameHelper: you cannot call GameHelper.setup() more than once!");
            throw new IllegalStateException("GameHelper: you cannot call GameHelper.setup() more than once!");
        }
        this.mListener = gameHelperListener;
        debugLog("Setup: requested clients: " + this.mRequestedClients);
        if (this.mGoogleApiClientBuilder == null) {
            createApiClientBuilder();
        }
        this.mGoogleApiClient = this.mGoogleApiClientBuilder.build();
        this.mGoogleApiClientBuilder = null;
        this.mSetupDone = true;
    }

    public void showFailureDialog() {
        SignInFailureReason signInFailureReason = this.mSignInFailureReason;
        if (signInFailureReason != null) {
            int serviceErrorCode = signInFailureReason.getServiceErrorCode();
            int activityResultCode = this.mSignInFailureReason.getActivityResultCode();
            if (this.mShowErrorDialogs) {
                showFailureDialog(this.mActivity, activityResultCode, serviceErrorCode);
            } else {
                debugLog("Not showing error dialog because mShowErrorDialogs==false. Error was: " + this.mSignInFailureReason);
            }
        }
    }

    public void signOut() {
        if (!this.mGoogleApiClient.isConnected()) {
            debugLog("signOut: was already disconnected, ignoring.");
            return;
        }
        if ((this.mRequestedClients & 2) != 0) {
            debugLog("Clearing default account on PlusClient.");
            Plus.AccountApi.clearDefaultAccount(this.mGoogleApiClient);
        }
        if ((this.mRequestedClients & 1) != 0) {
            debugLog("Signing out from GamesClient.");
            Games.signOut(this.mGoogleApiClient);
        }
        debugLog("Disconnecting client.");
        this.mConnectOnStart = false;
        this.mConnecting = false;
        this.mGoogleApiClient.disconnect();
    }

    void succeedSignIn() {
        debugLog("succeedSignIn");
        this.mSignInFailureReason = null;
        this.mConnectOnStart = true;
        this.mUserInitiatedSignIn = false;
        this.mConnecting = false;
        notifyListener(true);
    }
}
