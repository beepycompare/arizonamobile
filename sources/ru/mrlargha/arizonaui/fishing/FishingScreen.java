package ru.mrlargha.arizonaui.fishing;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.common.utils.EasyAnimation;
import com.arizona.common.utils.GridItemDecoration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.FishingLayoutBinding;
import ru.mrlargha.arizonaui.fishing.FishingAdapter;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: FishingScreen.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J\u0018\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lru/mrlargha/arizonaui/fishing/FishingScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", TtmlNode.TAG_LAYOUT, "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/arizonaui/databinding/FishingLayoutBinding;", "fishingAdapter", "Lru/mrlargha/arizonaui/fishing/FishingAdapter;", "totalFishCount", "successIds", "", "setItems", "", "info", "Lru/mrlargha/arizonaui/fishing/FishingScreen$Companion$ScreenInfo;", "getRandomTrashImage", "getRandomFishImage", "getRandomFactoryTrashImage", "getRandomFactoryDetailsImage", "getRandomFarmHayImage", "getRandomFarmTrashImage", "getRandomSearchDocsImage", "getRandomSearchDocsTrashImage", "getRandomRoadRepairImage", "getRandomRoadRepairTrashImage", "getRandomRanchImage", "getRandomRanchTrashImage", "onBackendMessage", "data", "", "subId", "Companion", "Spawner", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FishingScreen extends SAMPUIElement {
    public static final Companion Companion = new Companion(null);
    private static final String EMPTY_ELEMENT = "empty";
    private static final String RIGHT_ELEMENT = "fish";
    private static final String TRASH_ELEMENT = "trash";
    private final FishingLayoutBinding binding;
    private final FishingAdapter fishingAdapter;
    private final ConstraintLayout layout;
    private final Set<Integer> successIds;
    private int totalFishCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FishingScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.fishing_layout, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.layout = constraintLayout;
        FishingLayoutBinding bind = FishingLayoutBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        FishingAdapter fishingAdapter = new FishingAdapter();
        this.fishingAdapter = fishingAdapter;
        this.successIds = new LinkedHashSet();
        constraintLayout.setClickable(true);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        bind.fishingRc.setAdapter(fishingAdapter);
        bind.fishingRc.addItemDecoration(new GridItemDecoration(0.132f, 0.22566f, 0.0f, 0.0f, 0.026f));
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ImageView exitButton = bind.exitButton;
        Intrinsics.checkNotNullExpressionValue(exitButton, "exitButton");
        EasyAnimation.animateClick$default(easyAnimation, exitButton, 0L, new Function0() { // from class: ru.mrlargha.arizonaui.fishing.FishingScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FishingScreen.lambda$1$lambda$0(FishingScreen.this);
            }
        }, null, 5, null);
        fishingAdapter.setOnItemClickListener(new FishingAdapter.OnItemClickListener() { // from class: ru.mrlargha.arizonaui.fishing.FishingScreen$1$2
            @Override // ru.mrlargha.arizonaui.fishing.FishingAdapter.OnItemClickListener
            public void callback(int i2, String type, boolean z) {
                Set set;
                int i3;
                Set set2;
                Intrinsics.checkNotNullParameter(type, "type");
                if (Intrinsics.areEqual(type, "fish") && z) {
                    set2 = FishingScreen.this.successIds;
                    set2.add(Integer.valueOf(i2));
                }
                set = FishingScreen.this.successIds;
                int size = set.size();
                i3 = FishingScreen.this.totalFishCount;
                if (size == i3) {
                    SAMPUIElement.notifyClick$default(FishingScreen.this, 0, 0, null, 4, null);
                    Log.e("note", "callback: ");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$1$lambda$0(FishingScreen fishingScreen) {
        SAMPUIElement.notifyClick$default(fishingScreen, 0, 1, null, 4, null);
        return Unit.INSTANCE;
    }

    private final void setItems(Companion.ScreenInfo screenInfo) {
        int type = screenInfo.getType();
        if (type == Companion.FishingId.FISH.getId()) {
            this.binding.fishingLayout.setBackgroundResource(R.drawable.fishing_bg);
            this.binding.mainTitle.setText("Ловля рыбы");
            this.binding.description.setText("Нажмите на всех рыб, которые отображаются на экране");
        } else if (type == Companion.FishingId.FACTORY.getId()) {
            this.binding.fishingLayout.setBackgroundResource(R.drawable.fishing_factory_bg);
            this.binding.mainTitle.setText("Завод");
            this.binding.description.setText("Нажмите на все детали, которые отображаются на экране");
        } else if (type == Companion.FishingId.FARM.getId()) {
            this.binding.fishingLayout.setBackgroundResource(R.drawable.fishing_farm_bg);
            this.binding.mainTitle.setText("Ферма");
            this.binding.description.setText("Нажмите на всё сено, которые отображаются на экране");
        } else if (type == Companion.FishingId.SEARCH_DOCS.getId()) {
            this.binding.fishingLayout.setBackgroundResource(R.drawable.fishing_search_docs_bg);
            this.binding.mainTitle.setText("Поиск документов");
            this.binding.description.setText("Найди налоговые документы в конвертах");
        } else if (type == Companion.FishingId.ROAD_REPAIR.getId()) {
            this.binding.fishingLayout.setBackgroundResource(R.drawable.fishing_road_repair_bg);
            this.binding.mainTitle.setText("Дорожные работы");
            this.binding.description.setText("");
        } else if (type == Companion.FishingId.RANCH.getId()) {
            this.binding.fishingLayout.setBackgroundResource(R.drawable.fishing_ranch_bg);
            this.binding.mainTitle.setText("Ферма");
            this.binding.description.setText("Нажмите на всё сено, которые отображаются на экране");
        }
        this.successIds.clear();
        this.totalFishCount = screenInfo.getItemsCount();
        int itemsCount = (int) (screenInfo.getItemsCount() * 1.2f);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i != screenInfo.getItemsCount()) {
            int type2 = screenInfo.getType();
            if (type2 == Companion.FishingId.FISH.getId()) {
                arrayList.add(new Companion.FishInfo(i, RIGHT_ELEMENT, getRandomFishImage(), false));
            } else if (type2 == Companion.FishingId.FACTORY.getId()) {
                arrayList.add(new Companion.FishInfo(i, RIGHT_ELEMENT, getRandomFactoryDetailsImage(), false));
            } else if (type2 == Companion.FishingId.FARM.getId()) {
                arrayList.add(new Companion.FishInfo(i, RIGHT_ELEMENT, getRandomFarmHayImage(), false));
            } else if (type2 == Companion.FishingId.SEARCH_DOCS.getId()) {
                arrayList.add(new Companion.FishInfo(i, RIGHT_ELEMENT, getRandomSearchDocsImage(), false));
            } else if (type2 == Companion.FishingId.ROAD_REPAIR.getId()) {
                arrayList.add(new Companion.FishInfo(i, RIGHT_ELEMENT, getRandomRoadRepairImage(), false));
            } else if (type2 == Companion.FishingId.RANCH.getId()) {
                arrayList.add(new Companion.FishInfo(i, RIGHT_ELEMENT, getRandomRanchImage(), false));
            }
            i++;
        }
        int i2 = 0;
        while (i2 != itemsCount) {
            int type3 = screenInfo.getType();
            if (type3 == Companion.FishingId.FISH.getId()) {
                arrayList.add(new Companion.FishInfo(i, TRASH_ELEMENT, getRandomTrashImage(), false));
            } else if (type3 == Companion.FishingId.FACTORY.getId()) {
                arrayList.add(new Companion.FishInfo(i, TRASH_ELEMENT, getRandomFactoryTrashImage(), false));
            } else if (type3 == Companion.FishingId.FARM.getId()) {
                arrayList.add(new Companion.FishInfo(i, TRASH_ELEMENT, getRandomFarmTrashImage(), false));
            } else if (type3 == Companion.FishingId.SEARCH_DOCS.getId()) {
                arrayList.add(new Companion.FishInfo(i, TRASH_ELEMENT, getRandomSearchDocsTrashImage(), false));
            } else if (type3 == Companion.FishingId.ROAD_REPAIR.getId()) {
                arrayList.add(new Companion.FishInfo(i, TRASH_ELEMENT, getRandomRoadRepairTrashImage(), false));
            } else if (type3 == Companion.FishingId.RANCH.getId()) {
                arrayList.add(new Companion.FishInfo(i, TRASH_ELEMENT, getRandomRanchTrashImage(), false));
            }
            i2++;
            i++;
        }
        while (arrayList.size() < 28) {
            arrayList.add(new Companion.FishInfo(i, EMPTY_ELEMENT, 0, false));
            i++;
        }
        Collections.shuffle(arrayList);
        this.fishingAdapter.addItems(arrayList);
    }

    private final int getRandomTrashImage() {
        Integer[] numArr = {Integer.valueOf(R.drawable.fishing_trash_1), Integer.valueOf(R.drawable.fishing_trash_2), Integer.valueOf(R.drawable.fishing_trash_3), Integer.valueOf(R.drawable.fishing_trash_4), Integer.valueOf(R.drawable.fishing_trash_5)};
        return numArr[RangesKt.random(ArraysKt.getIndices(numArr), Random.Default)].intValue();
    }

    private final int getRandomFishImage() {
        Integer[] numArr = {Integer.valueOf(R.drawable.fishing_fish_1), Integer.valueOf(R.drawable.fishing_fish_2), Integer.valueOf(R.drawable.fishing_fish_3), Integer.valueOf(R.drawable.fishing_fish_4)};
        return numArr[RangesKt.random(ArraysKt.getIndices(numArr), Random.Default)].intValue();
    }

    private final int getRandomFactoryTrashImage() {
        Integer[] numArr = {Integer.valueOf(R.drawable.fishing_factory_trash_1), Integer.valueOf(R.drawable.fishing_factory_trash_2)};
        return numArr[RangesKt.random(ArraysKt.getIndices(numArr), Random.Default)].intValue();
    }

    private final int getRandomFactoryDetailsImage() {
        Integer[] numArr = {Integer.valueOf(R.drawable.fishing_factory_detail_1)};
        return numArr[RangesKt.random(ArraysKt.getIndices(numArr), Random.Default)].intValue();
    }

    private final int getRandomFarmHayImage() {
        Integer[] numArr = {Integer.valueOf(R.drawable.fishing_farm_hay_1)};
        return numArr[RangesKt.random(ArraysKt.getIndices(numArr), Random.Default)].intValue();
    }

    private final int getRandomFarmTrashImage() {
        Integer[] numArr = {Integer.valueOf(R.drawable.fishing_farm_trash_1), Integer.valueOf(R.drawable.fishing_farm_trash_2)};
        return numArr[RangesKt.random(ArraysKt.getIndices(numArr), Random.Default)].intValue();
    }

    private final int getRandomSearchDocsImage() {
        Integer[] numArr = {Integer.valueOf(R.drawable.fishing_search_docs)};
        return numArr[RangesKt.random(ArraysKt.getIndices(numArr), Random.Default)].intValue();
    }

    private final int getRandomSearchDocsTrashImage() {
        Integer[] numArr = {Integer.valueOf(R.drawable.fishing_search_docs_trash_1), Integer.valueOf(R.drawable.fishing_search_docs_trash_2)};
        return numArr[RangesKt.random(ArraysKt.getIndices(numArr), Random.Default)].intValue();
    }

    private final int getRandomRoadRepairImage() {
        Integer[] numArr = {Integer.valueOf(R.drawable.fishing_road_repair_trash)};
        return numArr[RangesKt.random(ArraysKt.getIndices(numArr), Random.Default)].intValue();
    }

    private final int getRandomRoadRepairTrashImage() {
        Integer[] numArr = {Integer.valueOf(R.drawable.fishing_road_repair)};
        return numArr[RangesKt.random(ArraysKt.getIndices(numArr), Random.Default)].intValue();
    }

    private final int getRandomRanchImage() {
        Integer[] numArr = {Integer.valueOf(R.drawable.fishing_ranch_1)};
        return numArr[RangesKt.random(ArraysKt.getIndices(numArr), Random.Default)].intValue();
    }

    private final int getRandomRanchTrashImage() {
        Integer[] numArr = {Integer.valueOf(R.drawable.fishing_ranch_trash_1), Integer.valueOf(R.drawable.fishing_ranch_trash_2)};
        return numArr[RangesKt.random(ArraysKt.getIndices(numArr), Random.Default)].intValue();
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            setItems((Companion.ScreenInfo) MapperKt.toModel(data, Companion.ScreenInfo.class));
        }
    }

    /* compiled from: FishingScreen.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0003\b\t\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/mrlargha/arizonaui/fishing/FishingScreen$Companion;", "", "<init>", "()V", "RIGHT_ELEMENT", "", "TRASH_ELEMENT", "EMPTY_ELEMENT", "FishingId", "FishInfo", "ScreenInfo", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        /* compiled from: FishingScreen.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lru/mrlargha/arizonaui/fishing/FishingScreen$Companion$FishingId;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "FISH", "FACTORY", "FARM", "SEARCH_DOCS", "ROAD_REPAIR", "RANCH", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class FishingId {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ FishingId[] $VALUES;
            private final int id;
            public static final FishingId FISH = new FishingId("FISH", 0, 0);
            public static final FishingId FACTORY = new FishingId("FACTORY", 1, 1);
            public static final FishingId FARM = new FishingId("FARM", 2, 2);
            public static final FishingId SEARCH_DOCS = new FishingId("SEARCH_DOCS", 3, 3);
            public static final FishingId ROAD_REPAIR = new FishingId("ROAD_REPAIR", 4, 4);
            public static final FishingId RANCH = new FishingId("RANCH", 5, 5);

            private static final /* synthetic */ FishingId[] $values() {
                return new FishingId[]{FISH, FACTORY, FARM, SEARCH_DOCS, ROAD_REPAIR, RANCH};
            }

            public static EnumEntries<FishingId> getEntries() {
                return $ENTRIES;
            }

            private FishingId(String str, int i, int i2) {
                this.id = i2;
            }

            public final int getId() {
                return this.id;
            }

            static {
                FishingId[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }

            public static FishingId valueOf(String str) {
                return (FishingId) Enum.valueOf(FishingId.class, str);
            }

            public static FishingId[] values() {
                return (FishingId[]) $VALUES.clone();
            }
        }

        /* compiled from: FishingScreen.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lru/mrlargha/arizonaui/fishing/FishingScreen$Companion$FishInfo;", "", "id", "", "type", "", "img", "isPressed", "", "<init>", "(ILjava/lang/String;IZ)V", "getId", "()I", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getImg", "setImg", "(I)V", "()Z", "setPressed", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class FishInfo {
            private final int id;
            private int img;
            private boolean isPressed;
            private String type;

            public static /* synthetic */ FishInfo copy$default(FishInfo fishInfo, int i, String str, int i2, boolean z, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = fishInfo.id;
                }
                if ((i3 & 2) != 0) {
                    str = fishInfo.type;
                }
                if ((i3 & 4) != 0) {
                    i2 = fishInfo.img;
                }
                if ((i3 & 8) != 0) {
                    z = fishInfo.isPressed;
                }
                return fishInfo.copy(i, str, i2, z);
            }

            public final int component1() {
                return this.id;
            }

            public final String component2() {
                return this.type;
            }

            public final int component3() {
                return this.img;
            }

            public final boolean component4() {
                return this.isPressed;
            }

            public final FishInfo copy(int i, String type, int i2, boolean z) {
                Intrinsics.checkNotNullParameter(type, "type");
                return new FishInfo(i, type, i2, z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof FishInfo) {
                    FishInfo fishInfo = (FishInfo) obj;
                    return this.id == fishInfo.id && Intrinsics.areEqual(this.type, fishInfo.type) && this.img == fishInfo.img && this.isPressed == fishInfo.isPressed;
                }
                return false;
            }

            public int hashCode() {
                return (((((Integer.hashCode(this.id) * 31) + this.type.hashCode()) * 31) + Integer.hashCode(this.img)) * 31) + Boolean.hashCode(this.isPressed);
            }

            public String toString() {
                int i = this.id;
                String str = this.type;
                int i2 = this.img;
                return "FishInfo(id=" + i + ", type=" + str + ", img=" + i2 + ", isPressed=" + this.isPressed + ")";
            }

            public FishInfo(int i, String type, int i2, boolean z) {
                Intrinsics.checkNotNullParameter(type, "type");
                this.id = i;
                this.type = type;
                this.img = i2;
                this.isPressed = z;
            }

            public /* synthetic */ FishInfo(int i, String str, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(i, str, i2, (i3 & 8) != 0 ? false : z);
            }

            public final int getId() {
                return this.id;
            }

            public final String getType() {
                return this.type;
            }

            public final void setType(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.type = str;
            }

            public final int getImg() {
                return this.img;
            }

            public final void setImg(int i) {
                this.img = i;
            }

            public final boolean isPressed() {
                return this.isPressed;
            }

            public final void setPressed(boolean z) {
                this.isPressed = z;
            }
        }

        /* compiled from: FishingScreen.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/arizonaui/fishing/FishingScreen$Companion$ScreenInfo;", "", "itemsCount", "", "type", "<init>", "(II)V", "getItemsCount", "()I", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class ScreenInfo {
            private final int itemsCount;
            private final int type;

            public static /* synthetic */ ScreenInfo copy$default(ScreenInfo screenInfo, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = screenInfo.itemsCount;
                }
                if ((i3 & 2) != 0) {
                    i2 = screenInfo.type;
                }
                return screenInfo.copy(i, i2);
            }

            public final int component1() {
                return this.itemsCount;
            }

            public final int component2() {
                return this.type;
            }

            public final ScreenInfo copy(int i, int i2) {
                return new ScreenInfo(i, i2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ScreenInfo) {
                    ScreenInfo screenInfo = (ScreenInfo) obj;
                    return this.itemsCount == screenInfo.itemsCount && this.type == screenInfo.type;
                }
                return false;
            }

            public int hashCode() {
                return (Integer.hashCode(this.itemsCount) * 31) + Integer.hashCode(this.type);
            }

            public String toString() {
                int i = this.itemsCount;
                return "ScreenInfo(itemsCount=" + i + ", type=" + this.type + ")";
            }

            public ScreenInfo(int i, int i2) {
                this.itemsCount = i;
                this.type = i2;
            }

            public final int getItemsCount() {
                return this.itemsCount;
            }

            public final int getType() {
                return this.type;
            }
        }
    }

    /* compiled from: FishingScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/fishing/FishingScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new FishingScreen(targetActivity, i);
        }
    }
}
