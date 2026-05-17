package com.arizonagames.feature.minigames.conveyor;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.arizonagames.feature.minigames.conveyor.ConveyorGameScreen;
import com.arizonagames.feature.minigames.conveyor.databinding.ConveyorGameScreenBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
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
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: ConveyorGameScreen.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 V2\u00020\u0001:\u0002VWB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\u0018\u00103\u001a\u0002002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0005H\u0016J\u0010\u00107\u001a\u0002002\u0006\u00104\u001a\u000205H\u0002J\u0010\u00108\u001a\u0002002\u0006\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u000200H\u0002J\b\u0010<\u001a\u000200H\u0002J\b\u0010=\u001a\u000200H\u0002J\b\u0010>\u001a\u000200H\u0002J\b\u0010?\u001a\u000200H\u0002J\u001c\u0010@\u001a\u0002002\b\b\u0002\u0010A\u001a\u00020\u00052\b\b\u0002\u0010B\u001a\u00020\u0005H\u0002J\b\u0010C\u001a\u000200H\u0002J\b\u0010D\u001a\u000200H\u0002J\u0010\u0010E\u001a\u0002002\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010H\u001a\u0002002\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010I\u001a\u0002002\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010J\u001a\u0002002\u0006\u0010K\u001a\u00020\u0017H\u0002J\u0010\u0010L\u001a\u0002002\u0006\u0010K\u001a\u00020\u0017H\u0002J\b\u0010M\u001a\u000200H\u0002J\b\u0010N\u001a\u000200H\u0002J\u000e\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00170#H\u0002J\u0018\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00170#*\b\u0012\u0004\u0012\u00020\u00050#H\u0002J\u0010\u0010Q\u001a\u0002002\u0006\u0010R\u001a\u00020\u0005H\u0002J\u0010\u0010S\u001a\u0002002\u0006\u0010T\u001a\u00020\u0005H\u0002J\b\u0010U\u001a\u000200H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/arizonagames/feature/minigames/conveyor/ConveyorGameScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendId", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/widget/FrameLayout;", "binding", "Lcom/arizonagames/feature/minigames/conveyor/databinding/ConveyorGameScreenBinding;", "boxAdapter", "Lcom/arizonagames/feature/minigames/conveyor/ConveyorGameItemAdapter;", "itemAdapter", "correctEggToBoxMap", "", "currentNeedItem", "scope", "Lkotlinx/coroutines/CoroutineScope;", "collectedEggsState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "selectItemImage", "Lcom/arizonagames/feature/minigames/conveyor/ConveyorGameItemModel;", "soundPool", "Landroid/media/SoundPool;", "kotlin.jvm.PlatformType", "successSoundId", "failureSoundId", "clickEggSoundId", "mediaPlayer", "Landroid/media/MediaPlayer;", "animationScale", "", "itemEggList", "", "boxEggList", "itemDocumentList", "boxDocumentList", "itemCrystalList", "boxCrystalList", "itemHalloweenList", "boxHalloweenList", "itemNewYearList", "boxNewYearList", "itemImageList", "boxImageList", "setVisibility", "", "visible", "", "onBackendMessageHandled", "data", "", "subId", "setCurrentNeedItem", "setGameType", "type", "Lcom/arizonagames/feature/minigames/conveyor/ConveyorGameScreen$Companion$ConveyorType;", "initEggType", "initDocumentType", "initCrystalType", "initHalloweenType", "initNewYearType", "updateLeftItem", "leftItem", "needItem", "openAgeLabel", "openScreen", "checkIsHasAnimation", "view", "Landroid/view/View;", "showItems", "startInfiniteAnimation", "onBoxClick", "itemModel", "onItemClick", "refreshItems", "getCorrectEggToBoxMap", "getRandomItemImageList", "toConveyorItemModel", "playSound", "soundId", "startBackgroundMelody", "melodyId", "closeScreen", "Companion", "Spawner", "conveyor"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConveyorGameScreen extends SAMPUIElement {
    private static final float CONVEYOR_SPEED = 120.0f;
    private static final int CORRECT_ITEM = 0;
    public static final Companion Companion = new Companion(null);
    private static final int ITEM_COUNT_SIZE = 9;
    private static ObjectAnimator itemAnimator;
    private float animationScale;
    private final ConveyorGameScreenBinding binding;
    private final ConveyorGameItemAdapter boxAdapter;
    private final List<Integer> boxCrystalList;
    private final List<Integer> boxDocumentList;
    private final List<Integer> boxEggList;
    private final List<Integer> boxHalloweenList;
    private List<Integer> boxImageList;
    private final List<Integer> boxNewYearList;
    private int clickEggSoundId;
    private final MutableStateFlow<Integer> collectedEggsState;
    private Map<Integer, Integer> correctEggToBoxMap;
    private int currentNeedItem;
    private int failureSoundId;
    private final ConveyorGameItemAdapter itemAdapter;
    private final List<Integer> itemCrystalList;
    private final List<Integer> itemDocumentList;
    private final List<Integer> itemEggList;
    private final List<Integer> itemHalloweenList;
    private List<Integer> itemImageList;
    private final List<Integer> itemNewYearList;
    private MediaPlayer mediaPlayer;
    private final CoroutineScope scope;
    private final FrameLayout screen;
    private ConveyorGameItemModel selectItemImage;
    private final SoundPool soundPool;
    private int successSoundId;

    /* compiled from: ConveyorGameScreen.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
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
            try {
                iArr[Companion.ConveyorType.CRYSTAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Companion.ConveyorType.Halloween.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Companion.ConveyorType.NEW_YEAR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void openAgeLabel$lambda$0(View view) {
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
        this.successSoundId = build.load(activity, R.raw.conveyor_game_failure, 1);
        this.failureSoundId = build.load(activity, R.raw.conveyor_game_success, 1);
        this.clickEggSoundId = build.load(activity, R.raw.conveyor_game_click_on_egg, 1);
        this.animationScale = 1.0f;
        this.itemEggList = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.conveyor_game_egg_green), Integer.valueOf(R.drawable.conveyor_game_egg_yellow), Integer.valueOf(R.drawable.conveyor_game_egg_orange), Integer.valueOf(R.drawable.conveyor_game_egg_red), Integer.valueOf(R.drawable.conveyor_game_egg_pink), Integer.valueOf(R.drawable.conveyor_game_egg_purple), Integer.valueOf(R.drawable.conveyor_game_egg_violet)});
        this.boxEggList = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.conveyor_game_box_green), Integer.valueOf(R.drawable.conveyor_game_box_yellow), Integer.valueOf(R.drawable.conveyor_game_box_orange), Integer.valueOf(R.drawable.conveyor_game_box_red), Integer.valueOf(R.drawable.conveyor_game_box_pink), Integer.valueOf(R.drawable.conveyor_game_box_purple), Integer.valueOf(R.drawable.conveyor_game_box_violet)});
        this.itemDocumentList = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.conveyor_game_document_item_green), Integer.valueOf(R.drawable.conveyor_game_document_item_yellow), Integer.valueOf(R.drawable.conveyor_game_document_item_orange), Integer.valueOf(R.drawable.conveyor_game_document_item_red), Integer.valueOf(R.drawable.conveyor_game_document_item_pink), Integer.valueOf(R.drawable.conveyor_game_document_item_violet), Integer.valueOf(R.drawable.conveyor_game_document_item_blue)});
        this.boxDocumentList = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.conveyor_game_document_box_green), Integer.valueOf(R.drawable.conveyor_game_document_box_yellow), Integer.valueOf(R.drawable.conveyor_game_document_box_orange), Integer.valueOf(R.drawable.conveyor_game_document_box_red), Integer.valueOf(R.drawable.conveyor_game_document_box_pink), Integer.valueOf(R.drawable.conveyor_game_document_box_violet), Integer.valueOf(R.drawable.conveyor_game_document_box_blue)});
        this.itemCrystalList = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.conveyor_game_crystal_item_green), Integer.valueOf(R.drawable.conveyor_game_crystal_item_yellow), Integer.valueOf(R.drawable.conveyor_game_crystal_item_orange), Integer.valueOf(R.drawable.conveyor_game_crystal_item_red), Integer.valueOf(R.drawable.conveyor_game_crystal_item_pink), Integer.valueOf(R.drawable.conveyor_game_crystal_item_violet), Integer.valueOf(R.drawable.conveyor_game_crystal_item_blue)});
        this.boxCrystalList = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.conveyor_game_crystal_box_green), Integer.valueOf(R.drawable.conveyor_game_crystal_box_yellow), Integer.valueOf(R.drawable.conveyor_game_crystal_box_orange), Integer.valueOf(R.drawable.conveyor_game_crystal_box_red), Integer.valueOf(R.drawable.conveyor_game_crystal_box_pink), Integer.valueOf(R.drawable.conveyor_game_crystal_box_violet), Integer.valueOf(R.drawable.conveyor_game_crystal_box_blue)});
        this.itemHalloweenList = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.conveyor_game_helloween_item_1), Integer.valueOf(R.drawable.conveyor_game_helloween_item_2), Integer.valueOf(R.drawable.conveyor_game_helloween_item_3), Integer.valueOf(R.drawable.conveyor_game_helloween_item_4), Integer.valueOf(R.drawable.conveyor_game_helloween_item_5), Integer.valueOf(R.drawable.conveyor_game_helloween_item_6), Integer.valueOf(R.drawable.conveyor_game_helloween_item_7)});
        this.boxHalloweenList = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.conveyor_game_helloween_box_1), Integer.valueOf(R.drawable.conveyor_game_helloween_box_2), Integer.valueOf(R.drawable.conveyor_game_helloween_box_3), Integer.valueOf(R.drawable.conveyor_game_helloween_box_4), Integer.valueOf(R.drawable.conveyor_game_helloween_box_5), Integer.valueOf(R.drawable.conveyor_game_helloween_box_6), Integer.valueOf(R.drawable.conveyor_game_helloween_box_7)});
        this.itemNewYearList = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.conveyor_game_new_year_red), Integer.valueOf(R.drawable.conveyor_game_new_year_pink), Integer.valueOf(R.drawable.conveyor_game_new_year_blue), Integer.valueOf(R.drawable.conveyor_game_new_year_dark_blue), Integer.valueOf(R.drawable.conveyor_game_new_year_violet), Integer.valueOf(R.drawable.conveyor_game_new_year_green), Integer.valueOf(R.drawable.conveyor_game_new_year_yeallow)});
        this.boxNewYearList = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.conveyor_game_new_year_box_red), Integer.valueOf(R.drawable.conveyor_game_new_year_box_pink), Integer.valueOf(R.drawable.conveyor_game_new_year_box_blue), Integer.valueOf(R.drawable.conveyor_game_new_year_box_dark_blue), Integer.valueOf(R.drawable.conveyor_game_new_year_box_violet), Integer.valueOf(R.drawable.conveyor_game_new_year_box_green), Integer.valueOf(R.drawable.conveyor_game_new_year_box_yeallow)});
        this.itemImageList = CollectionsKt.emptyList();
        this.boxImageList = CollectionsKt.emptyList();
        addViewToConstraintLayout(frameLayout, -1, -1);
        bind.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.minigames.conveyor.ConveyorGameScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConveyorGameScreen._init_$lambda$0(view);
            }
        });
        bind.btnCloseScreen.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.minigames.conveyor.ConveyorGameScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r0.getNotifier().clickedWrapper(ConveyorGameScreen.this.getBackendID(), 0, ConveyorGameScreen.Companion.ConveyorGameIds.CLOSE_SCREEN.getSubId());
            }
        });
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
    public void onBackendMessageHandled(String data, int i) {
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
        this.binding.ageLabel.setVisibility(8);
        int i = WhenMappings.$EnumSwitchMapping$0[conveyorType.ordinal()];
        if (i == 1) {
            initEggType();
            openScreen();
        } else if (i == 2) {
            initDocumentType();
            openScreen();
        } else if (i == 3) {
            initCrystalType();
            openScreen();
        } else if (i == 4) {
            initHalloweenType();
            openAgeLabel();
        } else if (i != 5) {
            throw new NoWhenBranchMatchedException();
        } else {
            initNewYearType();
            openScreen();
        }
    }

    private final void initEggType() {
        ConveyorGameScreenBinding conveyorGameScreenBinding = this.binding;
        conveyorGameScreenBinding.getRoot().setBackgroundResource(R.drawable.conveyor_game_bg);
        conveyorGameScreenBinding.gameTitle.setText("Сортировка пасхальных яиц");
        conveyorGameScreenBinding.leftContainer.setBackgroundResource(R.drawable.conveyor_game_left_container_bg);
        conveyorGameScreenBinding.leftItem.setTextColor(-16777216);
        conveyorGameScreenBinding.tvHint.setText("Нажимайте на яйца и на нужную коробку по цветам");
        conveyorGameScreenBinding.ivDefaultItem.setImageResource(R.drawable.conveyor_game_egg_empty);
        this.itemImageList = this.itemEggList;
        this.boxImageList = this.boxEggList;
    }

    private final void initDocumentType() {
        ConveyorGameScreenBinding conveyorGameScreenBinding = this.binding;
        conveyorGameScreenBinding.getRoot().setBackgroundResource(R.drawable.conveyor_game_document_bg);
        conveyorGameScreenBinding.gameTitle.setText("Сортировка документации");
        CustomCardView leftContainer = conveyorGameScreenBinding.leftContainer;
        Intrinsics.checkNotNullExpressionValue(leftContainer, "leftContainer");
        CustomCardView.setBackground$default(leftContainer, Color.parseColor("#FA6E0A"), Color.parseColor("#FFDB0D"), null, null, 12, null);
        conveyorGameScreenBinding.leftItem.setTextColor(-1);
        conveyorGameScreenBinding.tvHint.setText("Нажимайте на документ и на нужную коробку по цветам");
        conveyorGameScreenBinding.ivDefaultItem.setImageResource(R.drawable.conveyor_game_document_item);
        this.itemImageList = this.itemDocumentList;
        this.boxImageList = this.boxDocumentList;
    }

    private final void initCrystalType() {
        ConveyorGameScreenBinding conveyorGameScreenBinding = this.binding;
        conveyorGameScreenBinding.getRoot().setBackgroundResource(R.drawable.conveyor_game_crystal_bg);
        conveyorGameScreenBinding.gameTitle.setText("Сортировка космических артефактов");
        CustomCardView leftContainer = conveyorGameScreenBinding.leftContainer;
        Intrinsics.checkNotNullExpressionValue(leftContainer, "leftContainer");
        CustomCardView.setBackground$default(leftContainer, Color.parseColor("#009DFF"), 0, null, CustomCardView.GradientType.RADIAL, 4, null);
        conveyorGameScreenBinding.leftItem.setTextColor(-1);
        conveyorGameScreenBinding.tvHint.setText("Перенестие артефакты по цветам в нужный кейс");
        conveyorGameScreenBinding.ivDefaultItem.setImageResource(R.drawable.conveyor_game_crystal_item_empty);
        this.itemImageList = this.itemCrystalList;
        this.boxImageList = this.boxCrystalList;
    }

    private final void initHalloweenType() {
        ConveyorGameScreenBinding conveyorGameScreenBinding = this.binding;
        conveyorGameScreenBinding.getRoot().setBackgroundResource(R.drawable.conveyor_game_helloween_bg);
        conveyorGameScreenBinding.gameTitle.setText("Сортировка частей тела");
        CustomCardView leftContainer = conveyorGameScreenBinding.leftContainer;
        Intrinsics.checkNotNullExpressionValue(leftContainer, "leftContainer");
        CustomCardView.setBackground$default(leftContainer, Color.parseColor("#FF0D0D"), Color.parseColor("#700000"), null, CustomCardView.GradientType.LINEAR, 4, null);
        conveyorGameScreenBinding.leftItem.setTextColor(-1);
        conveyorGameScreenBinding.tvHint.setText("Перенестие части тела в нужную коробку по цветам");
        conveyorGameScreenBinding.ivDefaultItem.setImageResource(R.drawable.conveyor_game_helloween_item_empty);
        this.itemImageList = this.itemHalloweenList;
        this.boxImageList = this.boxHalloweenList;
        conveyorGameScreenBinding.ageLabel.setVisibility(0);
        startBackgroundMelody(R.raw.conveyor_game_background_melody);
    }

    private final void initNewYearType() {
        ConveyorGameScreenBinding conveyorGameScreenBinding = this.binding;
        conveyorGameScreenBinding.getRoot().setBackgroundResource(R.drawable.conveyor_new_years_bg);
        conveyorGameScreenBinding.gameTitle.setText("Сортировка подарков");
        CustomCardView leftContainer = conveyorGameScreenBinding.leftContainer;
        Intrinsics.checkNotNullExpressionValue(leftContainer, "leftContainer");
        CustomCardView.setBackground$default(leftContainer, Color.parseColor("#FF0D0D"), Color.parseColor("#FA0A9A"), null, CustomCardView.GradientType.LINEAR, 4, null);
        conveyorGameScreenBinding.leftItem.setTextColor(-1);
        conveyorGameScreenBinding.tvHint.setText("Нажмите на игрушку, а затем на соответствующую подарочную коробку");
        conveyorGameScreenBinding.ivDefaultItem.setImageResource(R.drawable.conveyor_game_new_year_item_empty);
        this.itemImageList = this.itemNewYearList;
        this.boxImageList = this.boxNewYearList;
        startBackgroundMelody(R.raw.conveyor_game_new_year_background_melody);
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

    private final void openAgeLabel() {
        this.binding.counterContainer.setVisibility(8);
        this.binding.ageLocker.setVisibility(0);
        this.binding.ageLocker.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.minigames.conveyor.ConveyorGameScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConveyorGameScreen.openAgeLabel$lambda$0(view);
            }
        });
        this.binding.buttonPlay.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.minigames.conveyor.ConveyorGameScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConveyorGameScreen.openAgeLabel$lambda$1(ConveyorGameScreen.this, view);
            }
        });
        this.binding.buttonClose.setOnClickListener(new View.OnClickListener() { // from class: com.arizonagames.feature.minigames.conveyor.ConveyorGameScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConveyorGameScreen.openAgeLabel$lambda$2(ConveyorGameScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void openAgeLabel$lambda$1(ConveyorGameScreen conveyorGameScreen, View view) {
        conveyorGameScreen.binding.counterContainer.setVisibility(0);
        conveyorGameScreen.binding.ageLocker.setVisibility(8);
        conveyorGameScreen.openScreen();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void openAgeLabel$lambda$2(ConveyorGameScreen conveyorGameScreen, View view) {
        conveyorGameScreen.binding.counterContainer.setVisibility(0);
        conveyorGameScreen.binding.ageLocker.setVisibility(8);
        conveyorGameScreen.closeScreen();
        conveyorGameScreen.getNotifier().clickedWrapper(conveyorGameScreen.getBackendID(), 0, Companion.ConveyorGameIds.CLOSE_SCREEN.getSubId());
    }

    private final void openScreen() {
        this.binding.counterContainer.setVisibility(0);
        this.binding.rvItems.setAdapter(this.itemAdapter);
        this.binding.rvBoxes.setAdapter(this.boxAdapter);
        RecyclerView rvItems = this.binding.rvItems;
        Intrinsics.checkNotNullExpressionValue(rvItems, "rvItems");
        checkIsHasAnimation(rvItems);
        this.boxAdapter.submitList(toConveyorItemModel(this.boxImageList));
        this.itemAdapter.submitList(getRandomItemImageList());
        getCorrectEggToBoxMap();
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
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.arizonagames.feature.minigames.conveyor.ConveyorGameScreen$startInfiniteAnimation$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Activity targetActivity;
                Activity targetActivity2;
                float f;
                ConveyorGameScreenBinding conveyorGameScreenBinding;
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                view.setLayerType(2, null);
                targetActivity = this.getTargetActivity();
                float f2 = (-view.getWidth()) * 1.4f;
                float f3 = targetActivity.getResources().getDisplayMetrics().widthPixels * 1.1f;
                ConveyorGameScreen.Companion companion = ConveyorGameScreen.Companion;
                ConveyorGameScreen.itemAnimator = ObjectAnimator.ofFloat(view, "translationX", f2, f3);
                float f4 = f3 - f2;
                targetActivity2 = this.getTargetActivity();
                f = this.animationScale;
                long j = (((f4 / targetActivity2.getResources().getDisplayMetrics().density) * 1000.0f) / 120.0f) / f;
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
                    objectAnimator3.addListener(new ConveyorGameScreen$startInfiniteAnimation$1$onGlobalLayout$1(this));
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

    private final void startBackgroundMelody(int i) {
        MediaPlayer create = MediaPlayer.create(getTargetActivity(), i);
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
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\r\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/arizonagames/feature/minigames/conveyor/ConveyorGameScreen$Companion;", "", "<init>", "()V", "CONVEYOR_SPEED", "", "ITEM_COUNT_SIZE", "", "CORRECT_ITEM", "itemAnimator", "Landroid/animation/ObjectAnimator;", "startAnimation", "", "ConveyorGameIds", "ConveyorType", "conveyor"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
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
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/arizonagames/feature/minigames/conveyor/ConveyorGameScreen$Companion$ConveyorGameIds;", "", "subId", "", "<init>", "(Ljava/lang/String;II)V", "getSubId", "()I", "GET_NEED_ITEMS", "SET_GAME_TYPE", "CLOSE_SCREEN", "SEND_CURRENT_ITEMS", "conveyor"}, k = 1, mv = {2, 3, 0}, xi = 48)
        /* loaded from: classes3.dex */
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
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/arizonagames/feature/minigames/conveyor/ConveyorGameScreen$Companion$ConveyorType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "EGGS", "DOCUMENTS", "CRYSTAL", "Halloween", "NEW_YEAR", "conveyor"}, k = 1, mv = {2, 3, 0}, xi = 48)
        /* loaded from: classes3.dex */
        private static final class ConveyorType {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ ConveyorType[] $VALUES;
            private final int type;
            public static final ConveyorType EGGS = new ConveyorType("EGGS", 0, 0);
            public static final ConveyorType DOCUMENTS = new ConveyorType("DOCUMENTS", 1, 1);
            public static final ConveyorType CRYSTAL = new ConveyorType("CRYSTAL", 2, 2);
            public static final ConveyorType Halloween = new ConveyorType("Halloween", 3, 3);
            public static final ConveyorType NEW_YEAR = new ConveyorType("NEW_YEAR", 4, 4);

            private static final /* synthetic */ ConveyorType[] $values() {
                return new ConveyorType[]{EGGS, DOCUMENTS, CRYSTAL, Halloween, NEW_YEAR};
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
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/arizonagames/feature/minigames/conveyor/ConveyorGameScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "conveyor"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.CONVEYOR_GAME);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new ConveyorGameScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }

    private final void showItems(View view) {
        view.setVisibility(0);
    }
}
