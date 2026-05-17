package ru.mrlargha.arizona.rating;

import android.app.Activity;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.elements.items3d.ItemScene;
import ru.mrlargha.commonui.elements.items3d.ModelRotationTouchListener;
import ru.mrlargha.commonui.utils.ui.ArizonaRetrofit;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.UtilsKt;
import ru.mrlargha.feature.arizona.item.rating.R;
import ru.mrlargha.feature.arizona.item.rating.databinding.RatingFullscreenItemBinding;
import ru.mrlargha.feature.arizona.item.rating.databinding.RatingScreenBinding;
import ru.mrlargha.feature.arizona.item.rating.databinding.RatingTopbarBinding;
/* compiled from: ItemRatingScreen.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002FGB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001fH\u0016J\u0018\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u0005H\u0016J\b\u00104\u001a\u00020/H\u0002J\u0010\u00105\u001a\u00020/2\u0006\u00106\u001a\u00020\u001dH\u0002J\b\u00107\u001a\u00020/H\u0002J\b\u00108\u001a\u00020/H\u0002J\u0016\u00109\u001a\u00020/2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0016H\u0002J\b\u0010:\u001a\u00020/H\u0002J\b\u0010;\u001a\u00020/H\u0002J\u0010\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020\u0005H\u0002J\u0010\u0010>\u001a\u00020/2\u0006\u0010=\u001a\u00020\u0005H\u0002J\u0010\u0010?\u001a\u00020/2\u0006\u0010@\u001a\u00020\u001bH\u0002J\u0010\u0010A\u001a\u00020/2\u0006\u0010B\u001a\u00020\u0005H\u0002J\u0010\u0010C\u001a\u00020/2\u0006\u0010D\u001a\u00020EH\u0002R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0011\u0010%\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lru/mrlargha/arizona/rating/ItemRatingScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "scene", "Lru/mrlargha/commonui/elements/items3d/ItemScene;", "getScene", "()Lru/mrlargha/commonui/elements/items3d/ItemScene;", "client", "Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "getClient", "()Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "api", "Lru/mrlargha/arizona/rating/RatingApi;", "qualityTypeList", "", "Lru/mrlargha/arizona/rating/QualityType;", "bonusType", "Lru/mrlargha/arizona/rating/BonusType;", "apiData", "Lru/mrlargha/arizona/rating/RatingItem;", "topbarState", "", "sortOrder", "", "colorCard", "getColorCard", "()I", "gradientColor1", "getGradientColor1", "gradientColor2", "getGradientColor2", "binding", "Lru/mrlargha/feature/arizona/item/rating/databinding/RatingScreenBinding;", "itemsAdapter", "Lru/mrlargha/arizona/rating/ItemsAdapter;", "zoomMultipler", "", "isCars", "setVisibility", "", "visible", "onBackendMessageHandled", "data", "subId", "setupNavigation", FirebaseAnalytics.Event.SEARCH, "text", "setupAdapters", "clearAdapters", "addData", "loadCars", "loadAccs", "topbarNavigation", "id", "setTopbarState", "setFullscreenItem", "item", "loadNextPage", "page", "navigateTo", "nav", "Lru/mrlargha/arizona/rating/ItemRatingScreen$Navigation;", "Navigation", "Spawner", "item-rating"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ItemRatingScreen extends SAMPUIElement {
    private final RatingApi api;
    private List<RatingItem> apiData;
    private final RatingScreenBinding binding;
    private List<BonusType> bonusType;
    private final ArizonaRetrofit client;
    private final int colorCard;
    private final int gradientColor1;
    private final int gradientColor2;
    private boolean isCars;
    private final ItemsAdapter itemsAdapter;
    private List<QualityType> qualityTypeList;
    private final ItemScene scene;
    private final View screen;
    private boolean sortOrder;
    private String topbarState;
    private float zoomMultipler;

    /* compiled from: ItemRatingScreen.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Navigation.values().length];
            try {
                iArr[Navigation.FullScreen.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Navigation.List.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$0(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemRatingScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View screen = targetActivity.getLayoutInflater().inflate(R.layout.rating_screen, (ViewGroup) null);
        this.screen = screen;
        this.scene = (ItemScene) targetActivity;
        ArizonaRetrofit arizonaRetrofit = new ArizonaRetrofit(targetActivity, i);
        this.client = arizonaRetrofit;
        this.api = (RatingApi) ArizonaRetrofit.create$default(arizonaRetrofit, RatingApi.class, false, null, null, 14, null);
        this.qualityTypeList = CollectionsKt.emptyList();
        this.bonusType = CollectionsKt.emptyList();
        this.apiData = CollectionsKt.emptyList();
        this.topbarState = "0";
        this.sortOrder = true;
        this.colorCard = Color.parseColor("#292929");
        this.gradientColor1 = -1;
        this.gradientColor2 = Color.parseColor("#BCBCBC");
        RatingScreenBinding bind = RatingScreenBinding.bind(screen);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.itemsAdapter = new ItemsAdapter(new Function1() { // from class: ru.mrlargha.arizona.rating.ItemRatingScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ItemRatingScreen.itemsAdapter$lambda$0(ItemRatingScreen.this, (RatingItem) obj);
            }
        }, new Function1() { // from class: ru.mrlargha.arizona.rating.ItemRatingScreen$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ItemRatingScreen.itemsAdapter$lambda$1(ItemRatingScreen.this, ((Integer) obj).intValue());
            }
        });
        this.zoomMultipler = 1.0f;
        this.isCars = true;
        Intrinsics.checkNotNullExpressionValue(screen, "screen");
        addViewToConstraintLayout(screen, -1, -1);
        setupAdapters();
        setupNavigation();
    }

    public final ItemScene getScene() {
        return this.scene;
    }

    public final ArizonaRetrofit getClient() {
        return this.client;
    }

    public final int getColorCard() {
        return this.colorCard;
    }

    public final int getGradientColor1() {
        return this.gradientColor1;
    }

    public final int getGradientColor2() {
        return this.gradientColor2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit itemsAdapter$lambda$0(ItemRatingScreen itemRatingScreen, RatingItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        itemRatingScreen.setFullscreenItem(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit itemsAdapter$lambda$1(ItemRatingScreen itemRatingScreen, int i) {
        itemRatingScreen.loadNextPage(i);
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        this.binding.list.topbar.editText.setText("");
        super.setVisibility(z);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            if (Intrinsics.areEqual(data, "0")) {
                loadCars();
            } else if (Intrinsics.areEqual(data, "1")) {
                loadAccs();
            }
        }
    }

    private final void setupNavigation() {
        final RatingScreenBinding ratingScreenBinding = this.binding;
        ratingScreenBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.rating.ItemRatingScreen$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.setupNavigation$lambda$0$0(view);
            }
        });
        final RatingTopbarBinding ratingTopbarBinding = ratingScreenBinding.list.topbar;
        ratingTopbarBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.rating.ItemRatingScreen$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.setupNavigation$lambda$0$1$0(RatingTopbarBinding.this, view);
            }
        });
        ratingScreenBinding.filterOverlay.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.rating.ItemRatingScreen$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.setupNavigation$lambda$0$1$1(RatingScreenBinding.this, view);
            }
        });
        ratingTopbarBinding.filter.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.rating.ItemRatingScreen$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.setupNavigation$lambda$0$1$2(RatingScreenBinding.this, view);
            }
        });
        ratingScreenBinding.filter1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.rating.ItemRatingScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.setupNavigation$lambda$0$1$3(ItemRatingScreen.this, ratingScreenBinding, view);
            }
        });
        ratingScreenBinding.filter2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.rating.ItemRatingScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.setupNavigation$lambda$0$1$4(ItemRatingScreen.this, ratingScreenBinding, view);
            }
        });
        ratingTopbarBinding.card1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.rating.ItemRatingScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.this.topbarNavigation(0);
            }
        });
        ratingTopbarBinding.card2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.rating.ItemRatingScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.this.topbarNavigation(1);
            }
        });
        ratingTopbarBinding.card3.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.rating.ItemRatingScreen$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.this.topbarNavigation(2);
            }
        });
        ratingTopbarBinding.card4.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.rating.ItemRatingScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.this.topbarNavigation(3);
            }
        });
        ratingTopbarBinding.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.arizona.rating.ItemRatingScreen$$ExternalSyntheticLambda11
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean z;
                z = ItemRatingScreen.setupNavigation$lambda$0$1$9(ItemRatingScreen.this, ratingTopbarBinding, textView, i, keyEvent);
                return z;
            }
        });
        ratingTopbarBinding.search.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.rating.ItemRatingScreen$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.setupNavigation$lambda$0$1$10(RatingTopbarBinding.this, this, view);
            }
        });
        ratingTopbarBinding.editText.addTextChangedListener(new TextWatcher() { // from class: ru.mrlargha.arizona.rating.ItemRatingScreen$setupNavigation$1$2$12
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                Editable editable2 = editable;
                if (editable2 == null || editable2.length() == 0) {
                    RatingTopbarBinding.this.search.performClick();
                }
            }
        });
        final RatingFullscreenItemBinding ratingFullscreenItemBinding = ratingScreenBinding.fullscreen;
        ratingFullscreenItemBinding.qualityButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.rating.ItemRatingScreen$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.setupNavigation$lambda$0$2$0(RatingFullscreenItemBinding.this, view);
            }
        });
        ratingFullscreenItemBinding.overlay.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.rating.ItemRatingScreen$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.setupNavigation$lambda$0$2$1(RatingFullscreenItemBinding.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$1$0(RatingTopbarBinding ratingTopbarBinding, View view) {
        ratingTopbarBinding.editText.clearFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$1$1(RatingScreenBinding ratingScreenBinding, View view) {
        ratingScreenBinding.filterLayout.setVisibility(8);
        ratingScreenBinding.filterOverlay.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$1$2(RatingScreenBinding ratingScreenBinding, View view) {
        ratingScreenBinding.filterLayout.setVisibility(0);
        ratingScreenBinding.filterOverlay.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$1$3(ItemRatingScreen itemRatingScreen, RatingScreenBinding ratingScreenBinding, View view) {
        itemRatingScreen.clearAdapters();
        ratingScreenBinding.filter1ic.setImageResource(R.drawable.rating_ic_filter2);
        ratingScreenBinding.filter2ic.setImageResource(R.drawable.rating_ic_filter1);
        itemRatingScreen.sortOrder = false;
        itemRatingScreen.loadNextPage(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$1$4(ItemRatingScreen itemRatingScreen, RatingScreenBinding ratingScreenBinding, View view) {
        itemRatingScreen.clearAdapters();
        ratingScreenBinding.filter1ic.setImageResource(R.drawable.rating_ic_filter1);
        ratingScreenBinding.filter2ic.setImageResource(R.drawable.rating_ic_filter2);
        itemRatingScreen.sortOrder = true;
        itemRatingScreen.loadNextPage(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupNavigation$lambda$0$1$9(ItemRatingScreen itemRatingScreen, RatingTopbarBinding ratingTopbarBinding, TextView textView, int i, KeyEvent keyEvent) {
        Object systemService = itemRatingScreen.getTargetActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(ratingTopbarBinding.editText.getWindowToken(), 0);
        ratingTopbarBinding.editText.clearFocus();
        itemRatingScreen.clearAdapters();
        itemRatingScreen.search(StringsKt.trim((CharSequence) ratingTopbarBinding.editText.getText().toString()).toString());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$1$10(RatingTopbarBinding ratingTopbarBinding, ItemRatingScreen itemRatingScreen, View view) {
        String obj = ratingTopbarBinding.editText.getText().toString();
        if (obj.length() > 0) {
            Object systemService = itemRatingScreen.getTargetActivity().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(ratingTopbarBinding.editText.getWindowToken(), 0);
            ratingTopbarBinding.editText.clearFocus();
            itemRatingScreen.search(StringsKt.trim((CharSequence) obj).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$2$0(RatingFullscreenItemBinding ratingFullscreenItemBinding, View view) {
        ratingFullscreenItemBinding.cardInfo.setVisibility(0);
        ratingFullscreenItemBinding.overlay.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$2$1(RatingFullscreenItemBinding ratingFullscreenItemBinding, View view) {
        ratingFullscreenItemBinding.cardInfo.setVisibility(8);
        ratingFullscreenItemBinding.overlay.setVisibility(8);
    }

    private final void search(String str) {
        Integer intOrNull = StringsKt.toIntOrNull(this.topbarState);
        int intValue = intOrNull != null ? intOrNull.intValue() : 0;
        this.binding.searchNotFound.setVisibility(8);
        this.binding.loaderBar.setVisibility(0);
        boolean isCars = this.itemsAdapter.isCars();
        ArizonaRetrofit arizonaRetrofit = this.client;
        if (isCars) {
            BuildersKt__Builders_commonKt.launch$default(arizonaRetrofit.getScope(), null, null, new ItemRatingScreen$search$1(this, intValue, str, null), 3, null);
        } else {
            BuildersKt__Builders_commonKt.launch$default(arizonaRetrofit.getScope(), null, null, new ItemRatingScreen$search$2(this, intValue, str, null), 3, null);
        }
    }

    private final void setupAdapters() {
        this.binding.list.itemsRv.setAdapter(this.itemsAdapter);
    }

    private final void clearAdapters() {
        this.binding.loaderBar.setVisibility(0);
        this.itemsAdapter.clearList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addData(List<RatingItem> list) {
        this.binding.loaderBar.setVisibility(8);
        if (list.isEmpty()) {
            return;
        }
        this.itemsAdapter.addAllItems(list);
    }

    private final void loadCars() {
        this.isCars = true;
        this.binding.filter1ic.setImageResource(R.drawable.rating_ic_filter1);
        this.binding.filter2ic.setImageResource(R.drawable.rating_ic_filter2);
        this.sortOrder = true;
        setTopbarState(0);
        this.binding.searchNotFound.setVisibility(8);
        this.itemsAdapter.setType(true);
        this.zoomMultipler = 1.0f;
        clearAdapters();
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), null, null, new ItemRatingScreen$loadCars$1(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), null, null, new ItemRatingScreen$loadCars$2(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), null, null, new ItemRatingScreen$loadCars$3(this, null), 3, null);
        this.binding.title.setText(getTargetActivity().getString(R.string.rating_cars_title));
        navigateTo(Navigation.List);
    }

    private final void loadAccs() {
        this.isCars = false;
        this.binding.filter1ic.setImageResource(R.drawable.rating_ic_filter1);
        this.binding.filter2ic.setImageResource(R.drawable.rating_ic_filter2);
        this.sortOrder = true;
        setTopbarState(0);
        this.binding.searchNotFound.setVisibility(8);
        this.itemsAdapter.setType(false);
        this.zoomMultipler = 2.0f;
        clearAdapters();
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), null, null, new ItemRatingScreen$loadAccs$1(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), null, null, new ItemRatingScreen$loadAccs$2(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), null, null, new ItemRatingScreen$loadAccs$3(this, null), 3, null);
        this.binding.title.setText(getTargetActivity().getString(R.string.rating_accessories_title));
        navigateTo(Navigation.List);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void topbarNavigation(int i) {
        clearAdapters();
        this.topbarState = String.valueOf(i);
        loadNextPage(1);
        setTopbarState(i);
    }

    private final void setTopbarState(int i) {
        this.topbarState = String.valueOf(i);
        RatingTopbarBinding ratingTopbarBinding = this.binding.list.topbar;
        ratingTopbarBinding.card1.setBackground(this.colorCard);
        ratingTopbarBinding.card2.setBackground(this.colorCard);
        ratingTopbarBinding.card3.setBackground(this.colorCard);
        ratingTopbarBinding.card4.setBackground(this.colorCard);
        ratingTopbarBinding.text1.setTextColor(-1);
        ratingTopbarBinding.text2.setTextColor(-1);
        ratingTopbarBinding.text3.setTextColor(-1);
        ratingTopbarBinding.text4.setTextColor(-1);
        if (i == 0) {
            CustomCardView card1 = ratingTopbarBinding.card1;
            Intrinsics.checkNotNullExpressionValue(card1, "card1");
            CustomCardView.setBackground$default(card1, this.gradientColor1, this.gradientColor2, null, null, 12, null);
            ratingTopbarBinding.text1.setTextColor(-16777216);
        } else if (i == 1) {
            CustomCardView card2 = ratingTopbarBinding.card2;
            Intrinsics.checkNotNullExpressionValue(card2, "card2");
            CustomCardView.setBackground$default(card2, this.gradientColor1, this.gradientColor2, null, null, 12, null);
            ratingTopbarBinding.text2.setTextColor(-16777216);
        } else if (i == 2) {
            CustomCardView card3 = ratingTopbarBinding.card3;
            Intrinsics.checkNotNullExpressionValue(card3, "card3");
            CustomCardView.setBackground$default(card3, this.gradientColor1, this.gradientColor2, null, null, 12, null);
            ratingTopbarBinding.text3.setTextColor(-16777216);
        } else if (i != 3) {
        } else {
            CustomCardView card4 = ratingTopbarBinding.card4;
            Intrinsics.checkNotNullExpressionValue(card4, "card4");
            CustomCardView.setBackground$default(card4, this.gradientColor1, this.gradientColor2, null, null, 12, null);
            ratingTopbarBinding.text4.setTextColor(-16777216);
        }
    }

    private final void setFullscreenItem(RatingItem ratingItem) {
        Object obj;
        Object obj2;
        List<String> colors;
        Object obj3;
        try {
            int qualityType = ratingItem.getQualityType();
            String str = "rating_bg1";
            if (qualityType != 1) {
                if (qualityType == 2) {
                    str = "rating_bg2";
                } else if (qualityType == 3) {
                    str = "rating_bg3";
                }
            }
            String str2 = str;
            ConstraintLayout root = this.binding.fullscreen.getRoot();
            int id = ratingItem.getObjectViewer().getObjectModel().getId();
            ItemScene itemScene = this.scene;
            float zoom = ratingItem.getObjectViewer().getObjectModel().getZoom() * this.zoomMultipler;
            float x = ratingItem.getObjectViewer().getObjectModel().getRotation().getX();
            float y = ratingItem.getObjectViewer().getObjectModel().getRotation().getY();
            float z = ratingItem.getObjectViewer().getObjectModel().getRotation().getZ();
            String rotationAxis = ratingItem.getObjectViewer().getObjectModel().getRotationAxis();
            if (rotationAxis == null) {
                rotationAxis = "y";
            }
            root.setOnTouchListener(new ModelRotationTouchListener(id, 0.0f, 0.0f, itemScene, x, y, z, zoom, rotationAxis, 6, null));
            this.scene.setupScene();
            this.scene.setCarModel(ratingItem.getObjectViewer().getObjectModel().getId(), ratingItem.getObjectViewer().getObjectModel().getSimple_model(), str2, ratingItem.getObjectViewer().getObjectProperties().getMain_color(), ratingItem.getObjectViewer().getObjectProperties().getSec_color(), "hud", ratingItem.getObjectViewer().getObjectProperties().getWear(), this.isCars);
            List<ObjectComponent> objectComponents = ratingItem.getObjectViewer().getObjectComponents();
            if (objectComponents != null) {
                for (ObjectComponent objectComponent : objectComponents) {
                    this.scene.setCarModule(ratingItem.getObjectViewer().getObjectModel().getId(), objectComponent.getId(), objectComponent.getSimple_model());
                }
            }
            this.scene.rotateModel(ratingItem.getObjectViewer().getObjectModel().getId(), ratingItem.getObjectViewer().getObjectModel().getRotation().getX(), ratingItem.getObjectViewer().getObjectModel().getRotation().getY(), ratingItem.getObjectViewer().getObjectModel().getRotation().getZ());
            this.scene.scaleModel(ratingItem.getObjectViewer().getObjectModel().getId(), ratingItem.getObjectViewer().getObjectModel().getZoom() * 1.5f * this.zoomMultipler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.binding.title.setText(ratingItem.getName());
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.rating.ItemRatingScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.setFullscreenItem$lambda$1(ItemRatingScreen.this, view);
            }
        });
        RatingFullscreenItemBinding ratingFullscreenItemBinding = this.binding.fullscreen;
        ratingFullscreenItemBinding.top.setText(getTargetActivity().getString(R.string.rating_place, new Object[]{Integer.valueOf(ratingItem.getRating())}));
        ratingFullscreenItemBinding.nick.setText(ratingItem.getSubName());
        Iterator<T> it = this.qualityTypeList.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (((QualityType) obj2).getId() == ratingItem.getQualityType()) {
                break;
            }
        }
        QualityType qualityType2 = (QualityType) obj2;
        if (qualityType2 != null) {
            CustomCardView labelBg = ratingFullscreenItemBinding.labelBg;
            Intrinsics.checkNotNullExpressionValue(labelBg, "labelBg");
            String str3 = (String) CollectionsKt.getOrNull(qualityType2.getColors(), 0);
            if (str3 != null) {
                int parseColor = Color.parseColor(str3);
                String str4 = (String) CollectionsKt.getOrNull(qualityType2.getColors(), 1);
                if (str4 != null) {
                    CustomCardView.setBackground$default(labelBg, parseColor, Color.parseColor(str4), null, null, 12, null);
                    ratingFullscreenItemBinding.labelText.setText(qualityType2.getName() + " (" + ratingItem.getQualityValue() + ")");
                }
            }
        }
        navigateTo(Navigation.FullScreen);
        ArrayList arrayList = new ArrayList();
        for (ItemBonus itemBonus : ratingItem.getBonuses()) {
            Iterator<T> it2 = this.bonusType.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj3 = null;
                    break;
                }
                obj3 = it2.next();
                if (((BonusType) obj3).getId() == itemBonus.getId()) {
                    break;
                }
            }
            BonusType bonusType = (BonusType) obj3;
            String str5 = (bonusType == null || (str5 = bonusType.getName()) == null) ? "" : "";
            String valueString = itemBonus.getValueString();
            if (valueString == null || valueString.length() == 0) {
                arrayList.add(str5);
            } else {
                arrayList.add(str5 + " <span>" + itemBonus.getValueString() + "</span>");
            }
        }
        Log.d("setBonuses", "setBonuses: " + ratingItem.getBonuses());
        Log.d("setBonuses", "setBonuses: " + arrayList);
        Iterator<T> it3 = this.qualityTypeList.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next = it3.next();
            if (((QualityType) next).getId() == ratingItem.getQualityType()) {
                obj = next;
                break;
            }
        }
        QualityType qualityType3 = (QualityType) obj;
        this.binding.fullscreen.textBonus.setText(UtilsKt.buildSpannableList(CollectionsKt.toList(arrayList), -16777216, true, Integer.valueOf(Color.parseColor((qualityType3 == null || (colors = qualityType3.getColors()) == null || (r3 = (String) CollectionsKt.getOrNull(colors, 0)) == null) ? "#9A9A9A" : "#9A9A9A")), true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setFullscreenItem$lambda$1(ItemRatingScreen itemRatingScreen, View view) {
        itemRatingScreen.scene.closeScene();
        itemRatingScreen.navigateTo(Navigation.List);
    }

    private final void loadNextPage(int i) {
        this.binding.list.topbar.editText.setText("");
        this.binding.searchNotFound.setVisibility(8);
        Integer intOrNull = StringsKt.toIntOrNull(this.topbarState);
        int intValue = intOrNull != null ? intOrNull.intValue() : 0;
        boolean isCars = this.itemsAdapter.isCars();
        ArizonaRetrofit arizonaRetrofit = this.client;
        if (isCars) {
            BuildersKt__Builders_commonKt.launch$default(arizonaRetrofit.getScope(), null, null, new ItemRatingScreen$loadNextPage$1(this, i, intValue, null), 3, null);
        } else {
            BuildersKt__Builders_commonKt.launch$default(arizonaRetrofit.getScope(), null, null, new ItemRatingScreen$loadNextPage$2(this, i, intValue, null), 3, null);
        }
    }

    private final void navigateTo(Navigation navigation) {
        this.binding.list.getRoot().setVisibility(8);
        this.binding.fullscreen.getRoot().setVisibility(8);
        this.binding.filterLayout.setVisibility(8);
        int i = WhenMappings.$EnumSwitchMapping$0[navigation.ordinal()];
        if (i == 1) {
            this.binding.fullscreen.getRoot().setVisibility(0);
            this.binding.bg.animate().alpha(0.0f).setStartDelay(400L).setDuration(600L).start();
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            this.binding.bg.setAlpha(1.0f);
            this.binding.bg.animate().alpha(1.0f).setStartDelay(400L).setDuration(600L).start();
            this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizona.rating.ItemRatingScreen$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r0.getNotifier().setUIElementVisible(ItemRatingScreen.this.getBackendID(), false);
                }
            });
            this.binding.list.getRoot().setVisibility(0);
            boolean isCars = this.itemsAdapter.isCars();
            RatingScreenBinding ratingScreenBinding = this.binding;
            if (isCars) {
                ratingScreenBinding.title.setText(getTargetActivity().getString(R.string.rating_cars_title));
            } else {
                ratingScreenBinding.title.setText(getTargetActivity().getString(R.string.rating_accessories_title));
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: ItemRatingScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/mrlargha/arizona/rating/ItemRatingScreen$Navigation;", "", "<init>", "(Ljava/lang/String;I)V", "FullScreen", "List", "item-rating"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Navigation {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Navigation[] $VALUES;
        public static final Navigation FullScreen = new Navigation("FullScreen", 0);
        public static final Navigation List = new Navigation("List", 1);

        private static final /* synthetic */ Navigation[] $values() {
            return new Navigation[]{FullScreen, List};
        }

        public static EnumEntries<Navigation> getEntries() {
            return $ENTRIES;
        }

        public static Navigation valueOf(String str) {
            return (Navigation) Enum.valueOf(Navigation.class, str);
        }

        public static Navigation[] values() {
            return (Navigation[]) $VALUES.clone();
        }

        private Navigation(String str, int i) {
        }

        static {
            Navigation[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* compiled from: ItemRatingScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/arizona/rating/ItemRatingScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "item-rating"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.ARIZONA_RATING);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new ItemRatingScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
