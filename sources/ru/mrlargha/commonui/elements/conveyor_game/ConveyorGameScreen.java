package ru.mrlargha.commonui.elements.conveyor_game;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.ConveyorGameScreenBinding;
import ru.mrlargha.commonui.elements.conveyor_game.ConveyorGameScreen;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: ConveyorGameScreen.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 K2\u00020\u0001:\u0002KLB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0018\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0005H\u0016J\u0010\u00101\u001a\u00020*2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00102\u001a\u00020*2\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020*H\u0002J\b\u00106\u001a\u00020*H\u0002J\u001c\u00107\u001a\u00020*2\b\b\u0002\u00108\u001a\u00020\u00052\b\b\u0002\u00109\u001a\u00020\u0005H\u0002J\b\u0010:\u001a\u00020*H\u0002J\u0010\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020*2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010?\u001a\u00020*2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010@\u001a\u00020*2\u0006\u0010A\u001a\u00020\u0017H\u0002J\u0010\u0010B\u001a\u00020*2\u0006\u0010A\u001a\u00020\u0017H\u0002J\b\u0010C\u001a\u00020*H\u0002J\b\u0010D\u001a\u00020*H\u0002J\u000e\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00170#H\u0002J\u0018\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00170#*\b\u0012\u0004\u0012\u00020\u00050#H\u0002J\u0010\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020\u0005H\u0002J\b\u0010I\u001a\u00020*H\u0002J\b\u0010J\u001a\u00020*H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lru/mrlargha/commonui/elements/conveyor_game/ConveyorGameScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendId", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/widget/FrameLayout;", "binding", "Lru/mrlargha/commonui/databinding/ConveyorGameScreenBinding;", "boxAdapter", "Lru/mrlargha/commonui/elements/conveyor_game/ConveyorGameItemAdapter;", "itemAdapter", "correctEggToBoxMap", "", "currentNeedItem", "scope", "Lkotlinx/coroutines/CoroutineScope;", "collectedEggsState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "selectItemImage", "Lru/mrlargha/commonui/elements/conveyor_game/ConveyorGameItemModel;", "soundPool", "Landroid/media/SoundPool;", "kotlin.jvm.PlatformType", "successSoundId", "failureSoundId", "clickEggSoundId", "mediaPlayer", "Landroid/media/MediaPlayer;", "animationScale", "", "itemEggList", "", "boxEggList", "itemDocumentList", "boxDocumentList", "itemImageList", "boxImageList", "setVisibility", "", "visible", "", "onBackendMessage", "data", "", "subId", "setCurrentNeedItem", "setGameType", "type", "Lru/mrlargha/commonui/elements/conveyor_game/ConveyorGameScreen$Companion$ConveyorType;", "initEggType", "initDocumentType", "updateLeftItem", "leftItem", "needItem", "openScreen", "checkIsHasAnimation", "view", "Landroid/view/View;", "showItems", "startInfiniteAnimation", "onBoxClick", "itemModel", "onItemClick", "refreshItems", "getCorrectEggToBoxMap", "getRandomItemImageList", "toConveyorItemModel", "playSound", "soundId", "startBackgroundMelody", "closeScreen", "Companion", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConveyorGameScreen extends SAMPUIElement {
    private static final float CONVEYOR_SPEED = 350.0f;
    private static final int CORRECT_ITEM = 0;
    public static final Companion Companion = new Companion(null);
    private static final int ITEM_COUNT_SIZE = 9;
    private static ObjectAnimator itemAnimator;
    private float animationScale;
    private final ConveyorGameScreenBinding binding;
    private final ConveyorGameItemAdapter boxAdapter;
    private final List<Integer> boxDocumentList;
    private final List<Integer> boxEggList;
    private List<Integer> boxImageList;
    private int clickEggSoundId;
    private final MutableStateFlow<Integer> collectedEggsState;
    private Map<Integer, Integer> correctEggToBoxMap;
    private int currentNeedItem;
    private int failureSoundId;
    private final ConveyorGameItemAdapter itemAdapter;
    private final List<Integer> itemDocumentList;
    private final List<Integer> itemEggList;
    private List<Integer> itemImageList;
    private MediaPlayer mediaPlayer;
    private final CoroutineScope scope;
    private final FrameLayout screen;
    private ConveyorGameItemModel selectItemImage;
    private final SoundPool soundPool;
    private int successSoundId;

    /* compiled from: ConveyorGameScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Companion.ConveyorType.values().length];
            try {
                iArr[Companion.ConveyorType.EGGS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Companion.ConveyorType.DOCUMENTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConveyorGameScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.conveyor_game_screen, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) inflate;
        this.screen = frameLayout;
        ConveyorGameScreenBinding bind = ConveyorGameScreenBinding.bind(frameLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.boxAdapter = new ConveyorGameItemAdapter(false, new ConveyorGameScreen$boxAdapter$1(this), null, 5, null);
        this.itemAdapter = new ConveyorGameItemAdapter(true, new ConveyorGameScreen$itemAdapter$1(this), new ConveyorGameScreen$itemAdapter$2(this));
        this.correctEggToBoxMap = new LinkedHashMap();
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.collectedEggsState = StateFlowKt.MutableStateFlow(0);
        SoundPool build = new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(new AudioAttributes.Builder().setContentType(4).setUsage(14).build()).build();
        this.soundPool = build;
        Activity activity = targetActivity;
        this.successSoundId = build.load(activity, R.raw.conveyor_game_success, 1);
        this.failureSoundId = build.load(activity, R.raw.conveyor_game_failure, 1);
        this.clickEggSoundId = build.load(activity, R.raw.conveyor_game_click_on_egg, 1);
        this.animationScale = 1.0f;
        this.itemEggList = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.conveyor_game_egg_green), Integer.valueOf(R.drawable.conveyor_game_egg_yellow), Integer.valueOf(R.drawable.conveyor_game_egg_orange), Integer.valueOf(R.drawable.conveyor_game_egg_red), Integer.valueOf(R.drawable.conveyor_game_egg_pink), Integer.valueOf(R.drawable.conveyor_game_egg_purple), Integer.valueOf(R.drawable.conveyor_game_egg_violet)});
        this.boxEggList = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.conveyor_game_box_green), Integer.valueOf(R.drawable.conveyor_game_box_yellow), Integer.valueOf(R.drawable.conveyor_game_box_orange), Integer.valueOf(R.drawable.conveyor_game_box_red), Integer.valueOf(R.drawable.conveyor_game_box_pink), Integer.valueOf(R.drawable.conveyor_game_box_purple), Integer.valueOf(R.drawable.conveyor_game_box_violet)});
        this.itemDocumentList = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.conveyor_game_document_item_green), Integer.valueOf(R.drawable.conveyor_game_document_item_yellow), Integer.valueOf(R.drawable.conveyor_game_document_item_orange), Integer.valueOf(R.drawable.conveyor_game_document_item_red), Integer.valueOf(R.drawable.conveyor_game_document_item_pink), Integer.valueOf(R.drawable.conveyor_game_document_item_violet), Integer.valueOf(R.drawable.conveyor_game_document_item_blue)});
        this.boxDocumentList = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.conveyor_game_document_box_green), Integer.valueOf(R.drawable.conveyor_game_document_box_yellow), Integer.valueOf(R.drawable.conveyor_game_document_box_orange), Integer.valueOf(R.drawable.conveyor_game_document_box_red), Integer.valueOf(R.drawable.conveyor_game_document_box_pink), Integer.valueOf(R.drawable.conveyor_game_document_box_violet), Integer.valueOf(R.drawable.conveyor_game_document_box_blue)});
        this.itemImageList = CollectionsKt.emptyList();
        this.boxImageList = CollectionsKt.emptyList();
        addViewToConstraintLayout(frameLayout, -1, -1);
        bind.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.conveyor_game.ConveyorGameScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConveyorGameScreen._init_$lambda$0(view);
            }
        });
        bind.btnCloseScreen.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.conveyor_game.ConveyorGameScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConveyorGameScreen._init_$lambda$1(ConveyorGameScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(ConveyorGameScreen conveyorGameScreen, View view) {
        conveyorGameScreen.getNotifier().clickedWrapper(conveyorGameScreen.getBackendID(), 0, Companion.ConveyorGameIds.CLOSE_SCREEN.getSubId());
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        super.setVisibility(z);
        if (z) {
            return;
        }
        closeScreen();
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Object obj;
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == Companion.ConveyorGameIds.GET_NEED_ITEMS.getSubId()) {
            setCurrentNeedItem(data);
        } else if (i == Companion.ConveyorGameIds.SET_GAME_TYPE.getSubId()) {
            Iterator<E> it = Companion.ConveyorType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((Companion.ConveyorType) obj).getType() == Integer.parseInt(data)) {
                    break;
                }
            }
            Companion.ConveyorType conveyorType = (Companion.ConveyorType) obj;
            if (conveyorType == null) {
                conveyorType = Companion.ConveyorType.EGGS;
            }
            setGameType(conveyorType);
        }
    }

    private final void setCurrentNeedItem(String str) {
        this.currentNeedItem = Integer.parseInt(str);
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new ConveyorGameScreen$setCurrentNeedItem$1(this, null), 3, null);
    }

    private final void setGameType(Companion.ConveyorType conveyorType) {
        int i = WhenMappings.$EnumSwitchMapping$0[conveyorType.ordinal()];
        if (i == 1) {
            initEggType();
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            initDocumentType();
        }
        openScreen();
    }

    private final void initEggType() {
        ConveyorGameScreenBinding conveyorGameScreenBinding = this.binding;
        conveyorGameScreenBinding.getRoot().setBackgroundResource(R.drawable.conveyor_game_bg);
        conveyorGameScreenBinding.gameTitle.setText("Сортировка пасхальных яиц");
        conveyorGameScreenBinding.leftContainer.setBackgroundResource(R.drawable.conveyor_game_left_container_bg);
        conveyorGameScreenBinding.leftItem.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        conveyorGameScreenBinding.tvHint.setText("Нажимайте на яйца и на нужную коробку по цветам");
        conveyorGameScreenBinding.ivDefaultItem.setImageResource(R.drawable.conveyor_game_egg_empty);
        this.itemImageList = this.itemEggList;
        this.boxImageList = this.boxEggList;
    }

    private final void initDocumentType() {
        ConveyorGameScreenBinding conveyorGameScreenBinding = this.binding;
        conveyorGameScreenBinding.getRoot().setBackgroundResource(R.drawable.conveyor_game_document_bg);
        conveyorGameScreenBinding.gameTitle.setText("Сортировка документации");
        conveyorGameScreenBinding.leftContainer.setBackgroundResource(R.drawable.conveyor_game_left_container_document_bg);
        conveyorGameScreenBinding.leftItem.setTextColor(-1);
        conveyorGameScreenBinding.tvHint.setText("Нажимайте на документ и на нужную коробку по цветам");
        conveyorGameScreenBinding.ivDefaultItem.setImageResource(R.drawable.conveyor_game_document_item);
        this.itemImageList = this.itemDocumentList;
        this.boxImageList = this.boxDocumentList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void updateLeftItem$default(ConveyorGameScreen conveyorGameScreen, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = conveyorGameScreen.currentNeedItem;
        }
        conveyorGameScreen.updateLeftItem(i, i2);
    }

    private final void updateLeftItem(int i, int i2) {
        this.binding.leftItem.setText(i + " / " + i2);
    }

    private final void openScreen() {
        this.binding.rvItems.setAdapter(this.itemAdapter);
        this.binding.rvBoxes.setAdapter(this.boxAdapter);
        RecyclerView rvItems = this.binding.rvItems;
        Intrinsics.checkNotNullExpressionValue(rvItems, "rvItems");
        checkIsHasAnimation(rvItems);
        this.boxAdapter.submitList(toConveyorItemModel(this.boxImageList));
        this.itemAdapter.submitList(getRandomItemImageList());
        getCorrectEggToBoxMap();
        startBackgroundMelody();
    }

    private final void checkIsHasAnimation(View view) {
        float animationScale = UtilsKt.getAnimationScale(getTargetActivity());
        this.animationScale = animationScale;
        boolean z = animationScale > 0.0f;
        this.itemAdapter.setIsHasAnimation(z);
        if (z) {
            startInfiniteAnimation(view);
        } else {
            showItems(view);
        }
    }

    private final void startInfiniteAnimation(final View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ru.mrlargha.commonui.elements.conveyor_game.ConveyorGameScreen$startInfiniteAnimation$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Activity targetActivity;
                float f;
                ConveyorGameScreenBinding conveyorGameScreenBinding;
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                targetActivity = this.getTargetActivity();
                float f2 = (-view.getWidth()) * 1.4f;
                float f3 = targetActivity.getResources().getDisplayMetrics().widthPixels * 1.1f;
                ConveyorGameScreen.Companion companion = ConveyorGameScreen.Companion;
                ConveyorGameScreen.itemAnimator = ObjectAnimator.ofFloat(view, "translationX", f2, f3);
                float f4 = ((f3 - f2) / 350.0f) * 1000;
                f = this.animationScale;
                long j = f4 / f;
                ObjectAnimator objectAnimator = ConveyorGameScreen.itemAnimator;
                if (objectAnimator != null) {
                    objectAnimator.setInterpolator(new LinearInterpolator());
                }
                ObjectAnimator objectAnimator2 = ConveyorGameScreen.itemAnimator;
                if (objectAnimator2 != null) {
                    objectAnimator2.setDuration(j);
                }
                ObjectAnimator objectAnimator3 = ConveyorGameScreen.itemAnimator;
                if (objectAnimator3 != null) {
                    final ConveyorGameScreen conveyorGameScreen = this;
                    objectAnimator3.addListener(new Animator.AnimatorListener() { // from class: ru.mrlargha.commonui.elements.conveyor_game.ConveyorGameScreen$startInfiniteAnimation$1$onGlobalLayout$1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            ConveyorGameItemAdapter conveyorGameItemAdapter;
                            List randomItemImageList;
                            ConveyorGameItemAdapter conveyorGameItemAdapter2;
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            conveyorGameItemAdapter = ConveyorGameScreen.this.itemAdapter;
                            randomItemImageList = ConveyorGameScreen.this.getRandomItemImageList();
                            conveyorGameItemAdapter.submitList(randomItemImageList);
                            conveyorGameItemAdapter2 = ConveyorGameScreen.this.itemAdapter;
                            conveyorGameItemAdapter2.startAnimation();
                        }
                    });
                }
                ObjectAnimator objectAnimator4 = ConveyorGameScreen.itemAnimator;
                if (objectAnimator4 != null) {
                    objectAnimator4.start();
                }
                conveyorGameScreenBinding = this.binding;
                RecyclerView rvItems = conveyorGameScreenBinding.rvItems;
                Intrinsics.checkNotNullExpressionValue(rvItems, "rvItems");
                rvItems.setVisibility(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBoxClick(ConveyorGameItemModel conveyorGameItemModel) {
        ConveyorGameItemModel conveyorGameItemModel2 = this.selectItemImage;
        if (conveyorGameItemModel2 == null) {
            return;
        }
        this.itemAdapter.correctSelectItem(new ConveyorGameItemModel(conveyorGameItemModel2.getId(), R.drawable.conveyor_game_empty));
        Integer num = this.correctEggToBoxMap.get(Integer.valueOf(conveyorGameItemModel2.getImage()));
        int image = conveyorGameItemModel.getImage();
        if (num != null && num.intValue() == image) {
            this.selectItemImage = null;
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new ConveyorGameScreen$onBoxClick$1(this, null), 3, null);
            getNotifier().clickedWrapper(getBackendID(), 0, Companion.ConveyorGameIds.SEND_CURRENT_ITEMS.getSubId());
            playSound(this.successSoundId);
            return;
        }
        playSound(this.failureSoundId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onItemClick(ConveyorGameItemModel conveyorGameItemModel) {
        this.selectItemImage = conveyorGameItemModel;
        this.soundPool.play(this.clickEggSoundId, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshItems() {
        this.itemAdapter.submitList(getRandomItemImageList());
    }

    private final void getCorrectEggToBoxMap() {
        this.correctEggToBoxMap = MapsKt.toMutableMap(MapsKt.toMap(CollectionsKt.zip(this.itemImageList, this.boxImageList)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ConveyorGameItemModel> getRandomItemImageList() {
        ArrayList arrayList = new ArrayList(10);
        for (int i = 0; i < 10; i++) {
            arrayList.add(new ConveyorGameItemModel(i, ((Number) CollectionsKt.random(this.itemImageList, Random.Default)).intValue()));
        }
        return arrayList;
    }

    private final List<ConveyorGameItemModel> toConveyorItemModel(List<Integer> list) {
        List<Integer> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        int i = 0;
        for (Object obj : list2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new ConveyorGameItemModel(i, ((Number) obj).intValue()));
            i = i2;
        }
        return arrayList;
    }

    private final void playSound(int i) {
        this.soundPool.play(i, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    private final void startBackgroundMelody() {
        MediaPlayer create = MediaPlayer.create(getTargetActivity(), R.raw.conveyor_game_background_melody);
        this.mediaPlayer = create;
        if (create != null) {
            create.setLooping(true);
        }
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    private final void closeScreen() {
        ObjectAnimator objectAnimator = itemAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new ConveyorGameScreen$closeScreen$1(this, null), 3, null);
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        this.mediaPlayer = null;
    }

    /* compiled from: ConveyorGameScreen.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\r\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/conveyor_game/ConveyorGameScreen$Companion;", "", "<init>", "()V", "CONVEYOR_SPEED", "", "ITEM_COUNT_SIZE", "", "CORRECT_ITEM", "itemAnimator", "Landroid/animation/ObjectAnimator;", "startAnimation", "", "ConveyorGameIds", "ConveyorType", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: ConveyorGameScreen.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/elements/conveyor_game/ConveyorGameScreen$Companion$ConveyorGameIds;", "", "subId", "", "<init>", "(Ljava/lang/String;II)V", "getSubId", "()I", "GET_NEED_ITEMS", "SET_GAME_TYPE", "CLOSE_SCREEN", "SEND_CURRENT_ITEMS", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class ConveyorGameIds {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ ConveyorGameIds[] $VALUES;
            private final int subId;
            public static final ConveyorGameIds GET_NEED_ITEMS = new ConveyorGameIds("GET_NEED_ITEMS", 0, 1);
            public static final ConveyorGameIds SET_GAME_TYPE = new ConveyorGameIds("SET_GAME_TYPE", 1, 2);
            public static final ConveyorGameIds CLOSE_SCREEN = new ConveyorGameIds("CLOSE_SCREEN", 2, 0);
            public static final ConveyorGameIds SEND_CURRENT_ITEMS = new ConveyorGameIds("SEND_CURRENT_ITEMS", 3, 1);

            private static final /* synthetic */ ConveyorGameIds[] $values() {
                return new ConveyorGameIds[]{GET_NEED_ITEMS, SET_GAME_TYPE, CLOSE_SCREEN, SEND_CURRENT_ITEMS};
            }

            public static EnumEntries<ConveyorGameIds> getEntries() {
                return $ENTRIES;
            }

            public static ConveyorGameIds valueOf(String str) {
                return (ConveyorGameIds) Enum.valueOf(ConveyorGameIds.class, str);
            }

            public static ConveyorGameIds[] values() {
                return (ConveyorGameIds[]) $VALUES.clone();
            }

            private ConveyorGameIds(String str, int i, int i2) {
                this.subId = i2;
            }

            public final int getSubId() {
                return this.subId;
            }

            static {
                ConveyorGameIds[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: ConveyorGameScreen.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/conveyor_game/ConveyorGameScreen$Companion$ConveyorType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "EGGS", "DOCUMENTS", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        private static final class ConveyorType {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ ConveyorType[] $VALUES;
            private final int type;
            public static final ConveyorType EGGS = new ConveyorType("EGGS", 0, 0);
            public static final ConveyorType DOCUMENTS = new ConveyorType("DOCUMENTS", 1, 1);

            private static final /* synthetic */ ConveyorType[] $values() {
                return new ConveyorType[]{EGGS, DOCUMENTS};
            }

            public static EnumEntries<ConveyorType> getEntries() {
                return $ENTRIES;
            }

            public static ConveyorType valueOf(String str) {
                return (ConveyorType) Enum.valueOf(ConveyorType.class, str);
            }

            public static ConveyorType[] values() {
                return (ConveyorType[]) $VALUES.clone();
            }

            private ConveyorType(String str, int i, int i2) {
                this.type = i2;
            }

            public final int getType() {
                return this.type;
            }

            static {
                ConveyorType[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }
        }

        public final void startAnimation() {
            ObjectAnimator objectAnimator = ConveyorGameScreen.itemAnimator;
            if (objectAnimator != null) {
                objectAnimator.start();
            }
        }
    }

    /* compiled from: ConveyorGameScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/conveyor_game/ConveyorGameScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new ConveyorGameScreen(targetActivity, i);
        }
    }

    private final void showItems(View view) {
        view.setVisibility(0);
    }
}
