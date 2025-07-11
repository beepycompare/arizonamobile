package ru.mrlargha.commonui.elements.authorization.presentation.screen;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.GridLayoutManager;
import com.arizona.game.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.AuthorizationNewsBinding;
import ru.mrlargha.commonui.databinding.BackgroundVideoBinding;
import ru.mrlargha.commonui.elements.authorization.domain.controller.RegistrationInterfaceType;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceManager;
import ru.mrlargha.commonui.elements.authorization.presentation.adapter.NewsAdapter;
import ru.mrlargha.commonui.elements.authorization.presentation.api.NewsApi;
import ru.mrlargha.commonui.elements.authorization.presentation.api.obj.ProjectData;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
/* compiled from: News.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/screen/News;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "getTargetActivity", "()Landroid/app/Activity;", "getBackendID", "()I", "news", "Landroidx/constraintlayout/widget/ConstraintLayout;", "newsBinding", "Lru/mrlargha/commonui/databinding/AuthorizationNewsBinding;", "videoBinding", "Lru/mrlargha/commonui/databinding/BackgroundVideoBinding;", "adapter", "Lru/mrlargha/commonui/elements/authorization/presentation/adapter/NewsAdapter;", "offscreen", "", "retrofit", "Lretrofit2/Retrofit;", "api", "Lru/mrlargha/commonui/elements/authorization/presentation/api/NewsApi;", "kotlin.jvm.PlatformType", "setVisible", "", "visible", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class News implements InterfaceController {
    private final NewsAdapter adapter;
    private final NewsApi api;
    private final int backendID;
    private final ConstraintLayout news;
    private final AuthorizationNewsBinding newsBinding;
    private boolean offscreen;
    private Retrofit retrofit;
    private final Activity targetActivity;
    private BackgroundVideoBinding videoBinding;

    public News(Activity targetActivity, int i) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.targetActivity = targetActivity;
        this.backendID = i;
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.authorization_news, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.news = constraintLayout;
        final AuthorizationNewsBinding bind = AuthorizationNewsBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.newsBinding = bind;
        InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.VIDEO_BACKGROUND.getId(), targetActivity, i);
        Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationVideoBackground");
        this.videoBinding = ((RegistrationVideoBackground) orCreateInterface).getMainBinding();
        NewsAdapter newsAdapter = new NewsAdapter(targetActivity);
        this.adapter = newsAdapter;
        Retrofit build = new Retrofit.Builder().baseUrl(FirebaseConfigHelper.INSTANCE.getNewsAuthBaseUrl()).addConverterFactory(GsonConverterFactory.create()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        this.retrofit = build;
        NewsApi newsApi = (NewsApi) build.create(NewsApi.class);
        this.api = newsApi;
        this.videoBinding.video.addView(bind.authorizationNews, -1, -1);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.videoBinding.video);
        constraintSet.connect(bind.authorizationNews.getId(), 2, this.videoBinding.video.getId(), 2);
        constraintSet.connect(bind.authorizationNews.getId(), 3, this.videoBinding.video.getId(), 3);
        constraintSet.connect(bind.authorizationNews.getId(), 4, this.videoBinding.video.getId(), 4);
        constraintSet.applyTo(this.videoBinding.video);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.5f);
        scaleAnimation.setInterpolator(new BounceInterpolator());
        scaleAnimation.setDuration(2500L);
        bind.authorizationNews.startAnimation(scaleAnimation);
        bind.authorizationNews.setBackgroundColor(0);
        bind.authorizationNewsOpenButton.setVisibility(0);
        bind.authorizationNewsRc.setAdapter(newsAdapter);
        bind.authorizationNewsRc.setLayoutManager(new GridLayoutManager((Context) targetActivity, 2, 1, false));
        newsApi.getNews().enqueue((Callback) new Callback<List<? extends ProjectData>>() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.News$1$1
            @Override // retrofit2.Callback
            public void onResponse(Call<List<? extends ProjectData>> call, Response<List<? extends ProjectData>> response) {
                NewsAdapter newsAdapter2;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                List<? extends ProjectData> body = response.body();
                if (body != null) {
                    News news = News.this;
                    ArrayList<ProjectData> arrayList = new ArrayList();
                    for (Object obj : body) {
                        if (Intrinsics.areEqual(((ProjectData) obj).getGameId(), BuildConfig.FLAVOR)) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (ProjectData projectData : arrayList) {
                        CollectionsKt.addAll(arrayList2, projectData.getNews());
                    }
                    newsAdapter2 = news.adapter;
                    newsAdapter2.addNews(arrayList2);
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<List<? extends ProjectData>> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                Log.w("AuthorizationNews", "error get news");
            }
        });
        bind.authorizationNewsOpenButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.News$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                News.lambda$2$lambda$0(News.this, bind, view);
            }
        });
        bind.authorizationNewsCloseButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.News$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                News.lambda$2$lambda$1(News.this, bind, view);
            }
        });
    }

    public final int getBackendID() {
        return this.backendID;
    }

    public final Activity getTargetActivity() {
        return this.targetActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$2$lambda$0(News news, AuthorizationNewsBinding authorizationNewsBinding, View view) {
        news.offscreen = false;
        ConstraintLayout constraintLayout = authorizationNewsBinding.authorizationNewsContainer;
        Intrinsics.checkNotNull(constraintLayout, "null cannot be cast to non-null type android.view.View");
        ConstraintLayout constraintLayout2 = constraintLayout;
        int width = (int) (constraintLayout2.getWidth() * 0.8d);
        if (!news.offscreen) {
            width = 0;
        }
        ViewGroup.LayoutParams layoutParams = constraintLayout2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.setMargins(width * (-1), 0, width, 0);
        constraintLayout2.setLayoutParams(layoutParams2);
        authorizationNewsBinding.authorizationNewsOpenButton.setVisibility(8);
        authorizationNewsBinding.authorizationNewsCloseButton.setVisibility(0);
        authorizationNewsBinding.authorizationNewsContainer.setVisibility(0);
        authorizationNewsBinding.authorizationNews.setBackgroundColor(Color.parseColor("#0E0E0E"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$2$lambda$1(News news, AuthorizationNewsBinding authorizationNewsBinding, View view) {
        news.offscreen = true;
        ConstraintLayout constraintLayout = authorizationNewsBinding.authorizationNewsContainer;
        Intrinsics.checkNotNull(constraintLayout, "null cannot be cast to non-null type android.view.View");
        ConstraintLayout constraintLayout2 = constraintLayout;
        int width = (int) (constraintLayout2.getWidth() * 0.8d);
        if (!news.offscreen) {
            width = 0;
        }
        ViewGroup.LayoutParams layoutParams = constraintLayout2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.setMargins(width * (-1), 0, width, 0);
        constraintLayout2.setLayoutParams(layoutParams2);
        authorizationNewsBinding.authorizationNewsOpenButton.setVisibility(0);
        authorizationNewsBinding.authorizationNewsCloseButton.setVisibility(8);
        authorizationNewsBinding.authorizationNewsContainer.setVisibility(8);
        authorizationNewsBinding.authorizationNews.setBackgroundColor(0);
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.newsBinding.authorizationNews.setVisibility(z ? 0 : 8);
    }
}
