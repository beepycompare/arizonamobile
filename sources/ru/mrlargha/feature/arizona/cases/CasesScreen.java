package ru.mrlargha.feature.arizona.cases;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;
import com.google.common.net.HttpHeaders;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.feature.arizona.cases.data.local.CasesSharedPreference;
import ru.mrlargha.feature.arizona.cases.data.remote.models.CasesModel;
import ru.mrlargha.feature.arizona.cases.databinding.ArizonaCasesMainPageBinding;
import ru.mrlargha.feature.arizona.cases.databinding.ArizonaCasesOpenPageBinding;
import ru.mrlargha.feature.arizona.cases.databinding.ArizonaCasesScreenBinding;
import ru.mrlargha.feature.arizona.cases.pages.CasesBasePage;
import ru.mrlargha.feature.arizona.cases.pages.CasesMainPage;
import ru.mrlargha.feature.arizona.cases.pages.CasesOpenPage;
/* compiled from: CasesScreen.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001CB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0005H\u0016J\u0010\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020%H\u0002J\b\u0010,\u001a\u00020#H\u0002J\b\u0010-\u001a\u00020#H\u0002J\b\u0010.\u001a\u00020%H\u0002J\u0010\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020\u0014H\u0002J\u0016\u00101\u001a\u00020#2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030\u0016H\u0002J\u0010\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020\u000bH\u0002J\"\u00106\u001a\u00020#2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00052\b\b\u0002\u00105\u001a\u00020\u000bH\u0002J\"\u00107\u001a\u00020#2\b\u00108\u001a\u0004\u0018\u0001092\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020#0;H\u0002J\b\u0010<\u001a\u00020#H\u0002J\n\u0010=\u001a\u0004\u0018\u00010(H\u0002J\u0012\u0010>\u001a\u0004\u0018\u0001092\u0006\u0010?\u001a\u00020(H\u0002J\u0010\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020(H\u0002J\b\u0010B\u001a\u00020#H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lru/mrlargha/feature/arizona/cases/CasesScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendId", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "currentPage", "Lru/mrlargha/feature/arizona/cases/CasesPages;", "casesBinding", "Lru/mrlargha/feature/arizona/cases/databinding/ArizonaCasesScreenBinding;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "initMainPageJob", "Lkotlinx/coroutines/Job;", "infoState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lru/mrlargha/feature/arizona/cases/CasesInfoModel;", "casesState", "", "Lru/mrlargha/feature/arizona/cases/data/remote/models/CasesModel;", "prizesList", "Lru/mrlargha/feature/arizona/cases/CasesGuaranteedPrizeModel;", "casesSharedPreference", "Lru/mrlargha/feature/arizona/cases/data/local/CasesSharedPreference;", "exoPlayer", "Landroidx/media3/exoplayer/ExoPlayer;", "videoPlayingType", "pagesMap", "", "Lru/mrlargha/feature/arizona/cases/pages/CasesBasePage;", "setVisibility", "", "visible", "", "onBackendMessage", "data", "", "subId", "setLoadingScreen", "isLoadingScreen", "setupListeners", "setCollectors", "startGoldBoxAnimation", "initInfo", CommonUrlParts.MODEL, "setWinnerPrize", "prizeIds", "Lru/mrlargha/feature/arizona/cases/CasesWinItemModel;", "changePage", "page", "sendEventToPage", "playVideo", "videoFile", "Ljava/io/File;", "onEnded", "Lkotlin/Function0;", "releasePlayer", "getSAMPPath", "getVideoFile", "videoName", "showToast", "message", "onQuality", "Spawner", "cases_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesScreen extends SAMPUIElement {
    private final ArizonaCasesScreenBinding casesBinding;
    private final CasesSharedPreference casesSharedPreference;
    private final MutableStateFlow<List<CasesModel>> casesState;
    private CasesPages currentPage;
    private ExoPlayer exoPlayer;
    private final MutableStateFlow<CasesInfoModel> infoState;
    private Job initMainPageJob;
    private final Map<CasesPages, CasesBasePage> pagesMap;
    private List<CasesGuaranteedPrizeModel> prizesList;
    private final CoroutineScope scope;
    private final ConstraintLayout screen;
    private CasesPages videoPlayingType;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$1(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$2(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CasesScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.arizona_cases_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.screen = constraintLayout;
        this.currentPage = CasesPages.LOADING;
        ArizonaCasesScreenBinding bind = ArizonaCasesScreenBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.casesBinding = bind;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.infoState = StateFlowKt.MutableStateFlow(null);
        this.casesState = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this.prizesList = CollectionsKt.emptyList();
        this.casesSharedPreference = new CasesSharedPreference(targetActivity);
        this.videoPlayingType = CasesPages.MAIN;
        CasesPages casesPages = CasesPages.MAIN;
        ArizonaCasesMainPageBinding mainPage = bind.mainPage;
        Intrinsics.checkNotNullExpressionValue(mainPage, "mainPage");
        CasesPages casesPages2 = CasesPages.OPEN;
        ArizonaCasesOpenPageBinding openPage = bind.openPage;
        Intrinsics.checkNotNullExpressionValue(openPage, "openPage");
        this.pagesMap = MapsKt.mapOf(TuplesKt.to(casesPages, new CasesMainPage(targetActivity, mainPage, getNotifier(), new Function0() { // from class: ru.mrlargha.feature.arizona.cases.CasesScreen$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit pagesMap$lambda$0;
                pagesMap$lambda$0 = CasesScreen.pagesMap$lambda$0(CasesScreen.this);
                return pagesMap$lambda$0;
            }
        })), TuplesKt.to(casesPages2, new CasesOpenPage(targetActivity, openPage, getNotifier())));
        addViewToConstraintLayout(constraintLayout, -1, -1);
        setupListeners();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pagesMap$lambda$0(CasesScreen casesScreen) {
        casesScreen.onQuality();
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        super.setVisibility(z);
        if (z) {
            setCollectors();
        } else {
            setLoadingScreen(true);
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == CasesId.MAIN_PAGE_INIT.getSubId()) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new CasesScreen$onBackendMessage$1(data, this, null), 3, null);
        } else if (i == CasesId.SET_WIN_CASES.getSubId()) {
            try {
                setWinnerPrize(MapperKt.toListModel(data, CasesWinItemModel.class));
                LinearLayout backContainer = this.casesBinding.backContainer;
                Intrinsics.checkNotNullExpressionValue(backContainer, "backContainer");
                backContainer.setVisibility(8);
                LinearLayout btnClose = this.casesBinding.btnClose;
                Intrinsics.checkNotNullExpressionValue(btnClose, "btnClose");
                btnClose.setVisibility(8);
            } catch (Exception unused) {
                Toast.makeText(getTargetActivity(), "Ошибка в интерфейсе : " + getBackendID(), 1).show();
            }
        } else if (i == CasesId.UPDATE_DIAMOND_COUNT.getSubId()) {
            this.casesBinding.diamondProgress.setProgress(Integer.parseInt(data));
            CharSequence text = this.casesBinding.tvDiamondProgress.getText();
            Intrinsics.checkNotNull(text);
            List split$default = StringsKt.split$default(text, new String[]{"/"}, false, 0, 6, (Object) null);
            if (split$default.size() == 2) {
                this.casesBinding.tvDiamondProgress.setText(data + " / " + split$default.get(1));
            }
            sendEventToPage(data, CasesId.UPDATE_DIAMOND_COUNT.getSubId(), CasesPages.OPEN);
        } else if (i == CasesId.SHOW_SPECIAL_VIDEO.getSubId()) {
            this.videoPlayingType = CasesPages.MAIN;
            this.casesSharedPreference.setHaveSpecialCase(true);
            playVideo(getVideoFile(StringsKt.replace$default(data, "\"", "", false, 4, (Object) null)), new Function0() { // from class: ru.mrlargha.feature.arizona.cases.CasesScreen$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit onBackendMessage$lambda$0;
                    onBackendMessage$lambda$0 = CasesScreen.onBackendMessage$lambda$0(CasesScreen.this);
                    return onBackendMessage$lambda$0;
                }
            });
        } else if (i == CasesId.SHOW_OPEN_CASE_VIDEO.getSubId()) {
            this.videoPlayingType = CasesPages.OPEN;
            playVideo(getVideoFile(StringsKt.replace$default(data, "\"", "", false, 4, (Object) null)), new Function0() { // from class: ru.mrlargha.feature.arizona.cases.CasesScreen$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit onBackendMessage$lambda$1;
                    onBackendMessage$lambda$1 = CasesScreen.onBackendMessage$lambda$1(CasesScreen.this);
                    return onBackendMessage$lambda$1;
                }
            });
        } else if (i == CasesId.SET_PRIZE_PROGRESS.getSubId()) {
            sendEventToPage(data, CasesId.SET_PRIZE_PROGRESS.getSubId(), CasesPages.MAIN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBackendMessage$lambda$0(CasesScreen casesScreen) {
        casesScreen.changePage(CasesPages.MAIN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBackendMessage$lambda$1(CasesScreen casesScreen) {
        casesScreen.changePage(CasesPages.OPEN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLoadingScreen(boolean z) {
        ArizonaCasesScreenBinding arizonaCasesScreenBinding = this.casesBinding;
        ProgressBar progressBar = arizonaCasesScreenBinding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(!z ? 8 : 0);
        FrameLayout content = arizonaCasesScreenBinding.content;
        Intrinsics.checkNotNullExpressionValue(content, "content");
        content.setVisibility(z ? 4 : 0);
        if (z) {
            return;
        }
        changePage(CasesPages.MAIN);
    }

    private final void setupListeners() {
        final ArizonaCasesScreenBinding arizonaCasesScreenBinding = this.casesBinding;
        arizonaCasesScreenBinding.overlay.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.CasesScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CasesScreen.setupListeners$lambda$0$0(CasesScreen.this, view);
            }
        });
        arizonaCasesScreenBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.CasesScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CasesScreen.setupListeners$lambda$0$1(view);
            }
        });
        arizonaCasesScreenBinding.videoAdviceBg.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.CasesScreen$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CasesScreen.setupListeners$lambda$0$2(view);
            }
        });
        arizonaCasesScreenBinding.ivBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.CasesScreen$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CasesScreen.setupListeners$lambda$0$3(CasesScreen.this, view);
            }
        });
        arizonaCasesScreenBinding.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.CasesScreen$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CasesScreen.setupListeners$lambda$0$4(CasesScreen.this, view);
            }
        });
        arizonaCasesScreenBinding.goldBox.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.CasesScreen$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CasesScreen.setupListeners$lambda$0$5(CasesScreen.this, view);
            }
        });
        arizonaCasesScreenBinding.skipVideo.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.arizona.cases.CasesScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CasesScreen.setupListeners$lambda$0$6(CasesScreen.this, arizonaCasesScreenBinding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$0(CasesScreen casesScreen, View view) {
        casesScreen.casesBinding.overlay.setVisibility(8);
        casesScreen.casesBinding.cardInfo.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$3(CasesScreen casesScreen, View view) {
        casesScreen.getNotifier().clickedWrapper(casesScreen.getBackendID(), 0, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$4(CasesScreen casesScreen, View view) {
        casesScreen.getNotifier().clickedWrapper(casesScreen.getBackendID(), 0, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$5(CasesScreen casesScreen, View view) {
        casesScreen.getNotifier().clickedWrapper(casesScreen.getBackendID(), 0, 6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$6(CasesScreen casesScreen, ArizonaCasesScreenBinding arizonaCasesScreenBinding, View view) {
        casesScreen.releasePlayer();
        PlayerView videoAdviceBg = arizonaCasesScreenBinding.videoAdviceBg;
        Intrinsics.checkNotNullExpressionValue(videoAdviceBg, "videoAdviceBg");
        videoAdviceBg.setVisibility(8);
        LinearLayout skipVideo = arizonaCasesScreenBinding.skipVideo;
        Intrinsics.checkNotNullExpressionValue(skipVideo, "skipVideo");
        skipVideo.setVisibility(8);
    }

    private final void setCollectors() {
        Job launch$default;
        this.casesBinding.mainPage.animateContainer.setVisibility(4);
        this.casesBinding.goldBox.setVisibility(4);
        Job job = this.initMainPageJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new CasesScreen$setCollectors$1(this, null), 3, null);
        this.initMainPageJob = launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean startGoldBoxAnimation() {
        final FrameLayout frameLayout = this.casesBinding.goldBox;
        return frameLayout.post(new Runnable() { // from class: ru.mrlargha.feature.arizona.cases.CasesScreen$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CasesScreen.startGoldBoxAnimation$lambda$0$0(frameLayout);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startGoldBoxAnimation$lambda$0$0(FrameLayout frameLayout) {
        frameLayout.setTranslationY(-200.0f);
        frameLayout.setAlpha(0.0f);
        frameLayout.setVisibility(0);
        frameLayout.animate().translationY(0.0f).alpha(1.0f).setDuration(400L).setInterpolator(new DecelerateInterpolator()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initInfo(CasesInfoModel casesInfoModel) {
        ArizonaCasesScreenBinding arizonaCasesScreenBinding = this.casesBinding;
        arizonaCasesScreenBinding.diamondProgress.setMax(casesInfoModel.getMaxDiamond());
        arizonaCasesScreenBinding.diamondProgress.setProgress(casesInfoModel.getHaveDiamond());
        arizonaCasesScreenBinding.tvDiamondProgress.setText(casesInfoModel.getProgress());
    }

    private final void setWinnerPrize(List<CasesWinItemModel> list) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (CasesWinItemModel casesWinItemModel : list) {
            Iterator<T> it = this.prizesList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                CasesGuaranteedPrizeModel casesGuaranteedPrizeModel = (CasesGuaranteedPrizeModel) obj;
                if (casesGuaranteedPrizeModel.getItem() == casesWinItemModel.getItem() && casesGuaranteedPrizeModel.getCount() == casesWinItemModel.getCount()) {
                    break;
                }
            }
            CasesGuaranteedPrizeModel casesGuaranteedPrizeModel2 = (CasesGuaranteedPrizeModel) obj;
            if (casesGuaranteedPrizeModel2 != null) {
                arrayList.add(casesGuaranteedPrizeModel2);
            }
            sendEventToPage(StringKt.toStringJson(arrayList), CasesId.SET_WIN_CASES.getSubId(), CasesPages.OPEN);
        }
    }

    private final void changePage(CasesPages casesPages) {
        if (!this.pagesMap.keySet().contains(casesPages) || casesPages == this.currentPage) {
            return;
        }
        Log.d(CasesResponseKt.CASES_TAG, "changePage: " + casesPages);
        for (Map.Entry<CasesPages, CasesBasePage> entry : this.pagesMap.entrySet()) {
            if (entry.getKey() != casesPages && this.currentPage == entry.getKey()) {
                entry.getValue().destroyPage();
            } else {
                entry.getValue().createPage();
            }
        }
        this.currentPage = casesPages;
        FrameLayout root = this.casesBinding.mainPage.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(casesPages != CasesPages.MAIN ? 8 : 0);
        LinearLayout root2 = this.casesBinding.openPage.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        root2.setVisibility(casesPages != CasesPages.OPEN ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void sendEventToPage$default(CasesScreen casesScreen, String str, int i, CasesPages casesPages, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            casesPages = casesScreen.currentPage;
        }
        casesScreen.sendEventToPage(str, i, casesPages);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendEventToPage(String str, int i, CasesPages casesPages) {
        CasesBasePage casesBasePage = this.pagesMap.get(casesPages);
        if (casesBasePage != null) {
            casesBasePage.sendEvent(str, i);
        }
    }

    private final void playVideo(File file, final Function0<Unit> function0) {
        final ArizonaCasesScreenBinding arizonaCasesScreenBinding = this.casesBinding;
        if (file == null || !file.exists()) {
            showToast("Видео не найдено");
            function0.invoke();
            return;
        }
        ExoPlayer build = new ExoPlayer.Builder(getTargetActivity()).build();
        build.setMediaItem(MediaItem.fromUri(FileProvider.getUriForFile(getTargetActivity(), getTargetActivity().getPackageName() + ".fileprovider", file)));
        build.prepare();
        build.setPlayWhenReady(true);
        build.addListener(new Player.Listener() { // from class: ru.mrlargha.feature.arizona.cases.CasesScreen$playVideo$2$1$1
            @Override // androidx.media3.common.Player.Listener
            public void onPlaybackStateChanged(int i) {
                if (i == 3) {
                    PlayerView videoAdviceBg = ArizonaCasesScreenBinding.this.videoAdviceBg;
                    Intrinsics.checkNotNullExpressionValue(videoAdviceBg, "videoAdviceBg");
                    videoAdviceBg.setVisibility(0);
                    LinearLayout skipVideo = ArizonaCasesScreenBinding.this.skipVideo;
                    Intrinsics.checkNotNullExpressionValue(skipVideo, "skipVideo");
                    skipVideo.setVisibility(0);
                } else if (i != 4) {
                } else {
                    PlayerView videoAdviceBg2 = ArizonaCasesScreenBinding.this.videoAdviceBg;
                    Intrinsics.checkNotNullExpressionValue(videoAdviceBg2, "videoAdviceBg");
                    videoAdviceBg2.setVisibility(8);
                    LinearLayout skipVideo2 = ArizonaCasesScreenBinding.this.skipVideo;
                    Intrinsics.checkNotNullExpressionValue(skipVideo2, "skipVideo");
                    skipVideo2.setVisibility(8);
                    this.releasePlayer();
                    function0.invoke();
                    Log.e("case", "onPlaybackStateChanged:");
                }
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPlayerError(PlaybackException error) {
                Intrinsics.checkNotNullParameter(error, "error");
                this.showToast("Ошибка воспроизведения " + error.getMessage());
                this.releasePlayer();
            }
        });
        this.exoPlayer = build;
        arizonaCasesScreenBinding.videoAdviceBg.setPlayer(this.exoPlayer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void playVideo$default(CasesScreen casesScreen, File file, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: ru.mrlargha.feature.arizona.cases.CasesScreen$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        casesScreen.playVideo(file, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releasePlayer() {
        changePage(this.videoPlayingType);
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.release();
        }
        this.exoPlayer = null;
    }

    private final String getSAMPPath() {
        String substringAfter$default;
        try {
            ApplicationInfo applicationInfo = getTargetActivity().getPackageManager().getPackageInfo(getTargetActivity().getPackageName(), 0).applicationInfo;
            String str = applicationInfo != null ? applicationInfo.dataDir : null;
            if (str == null || (substringAfter$default = StringsKt.substringAfter$default(str, "/0/", (String) null, 2, (Object) null)) == null) {
                return null;
            }
            return "Android/data/" + substringAfter$default + "/files/SAMP/";
        } catch (PackageManager.NameNotFoundException e) {
            Log.w(HttpHeaders.AUTHORIZATION, "Error Package name not found", e);
            return null;
        }
    }

    private final File getVideoFile(String str) {
        String sAMPPath = getSAMPPath();
        if (sAMPPath == null) {
            return null;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        Intrinsics.checkNotNullExpressionValue(externalStorageDirectory, "getExternalStorageDirectory(...)");
        File resolve = FilesKt.resolve(externalStorageDirectory, sAMPPath + str + ".webm");
        if (resolve.exists()) {
            return resolve;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String str) {
        Toast.makeText(getTargetActivity().getApplicationContext(), str, 1).show();
    }

    private final void onQuality() {
        this.casesBinding.textBonus.setText("Качество будет определено при открытии сертификата.\nВы можете получить:\n- Хлам\n- Обычное\n- Идеальное");
        this.casesBinding.overlay.setVisibility(0);
        this.casesBinding.cardInfo.setVisibility(0);
    }

    /* compiled from: CasesScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/feature/arizona/cases/CasesScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "cases_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.CASES);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new CasesScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
