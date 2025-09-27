package ru.mrlargha.transport;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.items3d.ItemScene;
import ru.mrlargha.commonui.elements.items3d.ModelRotationTouchListener;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.item.rating.R;
import ru.mrlargha.feature.item.rating.databinding.RatingFullscreenItemBinding;
import ru.mrlargha.feature.item.rating.databinding.RatingScreenBinding;
import ru.mrlargha.feature.item.rating.databinding.RatingTopbarBinding;
import ru.mrlargha.rating.ItemsAdapter;
import ru.mrlargha.rating.RatingItem;
/* compiled from: ItemRatingScreen.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u000201B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0006H\u0016J\b\u0010#\u001a\u00020\u001cH\u0002J\b\u0010$\u001a\u00020\u001cH\u0002J\b\u0010%\u001a\u00020\u001cH\u0002J\u0016\u0010&\u001a\u00020\u001c2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020(0'H\u0002J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u0006H\u0002J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020(H\u0002J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/H\u0002R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lru/mrlargha/transport/ItemRatingScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "scene", "Lru/mrlargha/commonui/elements/items3d/ItemScene;", "getScene", "()Lru/mrlargha/commonui/elements/items3d/ItemScene;", "colorCard", "getColorCard", "()I", "gradientColor1", "getGradientColor1", "gradientColor2", "getGradientColor2", "binding", "Lru/mrlargha/feature/item/rating/databinding/RatingScreenBinding;", "itemsAdapter", "Lru/mrlargha/rating/ItemsAdapter;", "setVisible", "", "visible", "", "onBackendMessage", "data", "", "subId", "setupNavigation", "setupAdapters", "clearAdapters", "setItems", "", "Lru/mrlargha/rating/RatingItem;", "topbarNavigation", "id", "setFullscreenItem", "item", "navigateTo", "nav", "Lru/mrlargha/transport/ItemRatingScreen$Navigation;", "Navigation", "Spawner", "item-rating_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ItemRatingScreen extends SAMPUIElement implements InterfaceController {
    private final RatingScreenBinding binding;
    private final int colorCard;
    private final int gradientColor1;
    private final int gradientColor2;
    private final ItemsAdapter itemsAdapter;
    private final ItemScene scene;
    private final View screen;

    /* compiled from: ItemRatingScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
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
        this.colorCard = Color.parseColor("#0D1011");
        this.gradientColor1 = Color.parseColor("#FD0E42");
        this.gradientColor2 = Color.parseColor("#AA0022");
        RatingScreenBinding bind = RatingScreenBinding.bind(screen);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.itemsAdapter = new ItemsAdapter(new Function1() { // from class: ru.mrlargha.transport.ItemRatingScreen$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit itemsAdapter$lambda$0;
                itemsAdapter$lambda$0 = ItemRatingScreen.itemsAdapter$lambda$0(ItemRatingScreen.this, (RatingItem) obj);
                return itemsAdapter$lambda$0;
            }
        }, new Function1() { // from class: ru.mrlargha.transport.ItemRatingScreen$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit itemsAdapter$lambda$1;
                itemsAdapter$lambda$1 = ItemRatingScreen.itemsAdapter$lambda$1(ItemRatingScreen.this, ((Integer) obj).intValue());
                return itemsAdapter$lambda$1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(screen, "screen");
        addViewToConstraintLayout(screen, -1, -1);
        setupAdapters();
        setupNavigation();
        navigateTo(Navigation.List);
    }

    public final ItemScene getScene() {
        return this.scene;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit itemsAdapter$lambda$0(ItemRatingScreen itemRatingScreen, RatingItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        itemRatingScreen.setFullscreenItem(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit itemsAdapter$lambda$1(ItemRatingScreen itemRatingScreen, int i) {
        SAMPUIElement.notifyClick$default(itemRatingScreen, 0, 0, null, 4, null);
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        clearAdapters();
        this.binding.getRoot().setVisibility(z ? 0 : 8);
        navigateTo(Navigation.List);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 0) {
            try {
                setItems(MapperKt.toListModel(data, RatingItem.class));
            } catch (Exception e) {
                Log.d("rating", data + "  " + e.getMessage());
                e.printStackTrace();
                Toast.makeText(getTargetActivity().getApplicationContext(), "Ошибка в интерфейсе : " + getBackendID(), 1).show();
            }
        }
    }

    private final void setupNavigation() {
        final RatingScreenBinding ratingScreenBinding = this.binding;
        ratingScreenBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.transport.ItemRatingScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.setupNavigation$lambda$0$0(view);
            }
        });
        final RatingTopbarBinding ratingTopbarBinding = ratingScreenBinding.list.topbar;
        ratingTopbarBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.transport.ItemRatingScreen$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.setupNavigation$lambda$0$1$0(RatingTopbarBinding.this, view);
            }
        });
        ratingScreenBinding.filterOverlay.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.transport.ItemRatingScreen$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.setupNavigation$lambda$0$1$1(RatingScreenBinding.this, view);
            }
        });
        ratingTopbarBinding.filter.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.transport.ItemRatingScreen$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.setupNavigation$lambda$0$1$2(RatingScreenBinding.this, view);
            }
        });
        ratingScreenBinding.filter1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.transport.ItemRatingScreen$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.setupNavigation$lambda$0$1$3(ItemRatingScreen.this, ratingScreenBinding, view);
            }
        });
        ratingScreenBinding.filter2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.transport.ItemRatingScreen$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.setupNavigation$lambda$0$1$4(ItemRatingScreen.this, ratingScreenBinding, view);
            }
        });
        ratingTopbarBinding.card1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.transport.ItemRatingScreen$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.setupNavigation$lambda$0$1$5(ItemRatingScreen.this, view);
            }
        });
        ratingTopbarBinding.card2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.transport.ItemRatingScreen$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.setupNavigation$lambda$0$1$6(ItemRatingScreen.this, view);
            }
        });
        ratingTopbarBinding.card3.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.transport.ItemRatingScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.setupNavigation$lambda$0$1$7(ItemRatingScreen.this, view);
            }
        });
        ratingTopbarBinding.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ru.mrlargha.transport.ItemRatingScreen$$ExternalSyntheticLambda2
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean z;
                z = ItemRatingScreen.setupNavigation$lambda$0$1$8(ItemRatingScreen.this, ratingTopbarBinding, textView, i, keyEvent);
                return z;
            }
        });
        ratingTopbarBinding.search.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.transport.ItemRatingScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.setupNavigation$lambda$0$1$9(RatingTopbarBinding.this, this, view);
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
        SAMPUIElement.notifyClick$default(itemRatingScreen, 3, 0, null, 4, null);
        ratingScreenBinding.filter1ic.setImageResource(R.drawable.rating_ic_filter2);
        ratingScreenBinding.filter2ic.setImageResource(R.drawable.rating_ic_filter1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$1$4(ItemRatingScreen itemRatingScreen, RatingScreenBinding ratingScreenBinding, View view) {
        itemRatingScreen.clearAdapters();
        SAMPUIElement.notifyClick$default(itemRatingScreen, 3, 1, null, 4, null);
        ratingScreenBinding.filter1ic.setImageResource(R.drawable.rating_ic_filter1);
        ratingScreenBinding.filter2ic.setImageResource(R.drawable.rating_ic_filter2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$1$5(ItemRatingScreen itemRatingScreen, View view) {
        itemRatingScreen.topbarNavigation(0);
        SAMPUIElement.notifyClick$default(itemRatingScreen, 1, 0, null, 4, null);
        itemRatingScreen.clearAdapters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$1$6(ItemRatingScreen itemRatingScreen, View view) {
        itemRatingScreen.topbarNavigation(1);
        SAMPUIElement.notifyClick$default(itemRatingScreen, 1, 2, null, 4, null);
        itemRatingScreen.clearAdapters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$1$7(ItemRatingScreen itemRatingScreen, View view) {
        itemRatingScreen.topbarNavigation(2);
        SAMPUIElement.notifyClick$default(itemRatingScreen, 1, 1, null, 4, null);
        itemRatingScreen.clearAdapters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupNavigation$lambda$0$1$8(ItemRatingScreen itemRatingScreen, RatingTopbarBinding ratingTopbarBinding, TextView textView, int i, KeyEvent keyEvent) {
        itemRatingScreen.notifyClick(1, 3, String.valueOf(ratingTopbarBinding.editText.getText()));
        Object systemService = itemRatingScreen.getTargetActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(ratingTopbarBinding.editText.getWindowToken(), 0);
        ratingTopbarBinding.editText.clearFocus();
        itemRatingScreen.clearAdapters();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$1$9(RatingTopbarBinding ratingTopbarBinding, ItemRatingScreen itemRatingScreen, View view) {
        if (String.valueOf(ratingTopbarBinding.editText.getText()).length() > 0) {
            itemRatingScreen.notifyClick(1, 3, String.valueOf(ratingTopbarBinding.editText.getText()));
            Object systemService = itemRatingScreen.getTargetActivity().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(ratingTopbarBinding.editText.getWindowToken(), 0);
            ratingTopbarBinding.editText.clearFocus();
            itemRatingScreen.clearAdapters();
        }
    }

    private final void setupAdapters() {
        this.binding.list.itemsRv.setAdapter(this.itemsAdapter);
    }

    private final void clearAdapters() {
        this.itemsAdapter.clearList();
    }

    private final void setItems(List<RatingItem> list) {
        this.itemsAdapter.addAllItems(list);
    }

    private final void topbarNavigation(int i) {
        RatingTopbarBinding ratingTopbarBinding = this.binding.list.topbar;
        ratingTopbarBinding.card1.setBackground(this.colorCard);
        ratingTopbarBinding.card2.setBackground(this.colorCard);
        ratingTopbarBinding.card3.setBackground(this.colorCard);
        if (i == 0) {
            CustomCardView card1 = ratingTopbarBinding.card1;
            Intrinsics.checkNotNullExpressionValue(card1, "card1");
            CustomCardView.setBackground$default(card1, this.gradientColor1, this.gradientColor2, null, null, 12, null);
        } else if (i == 1) {
            CustomCardView card2 = ratingTopbarBinding.card2;
            Intrinsics.checkNotNullExpressionValue(card2, "card2");
            CustomCardView.setBackground$default(card2, this.gradientColor1, this.gradientColor2, null, null, 12, null);
        } else if (i != 2) {
        } else {
            CustomCardView card3 = ratingTopbarBinding.card3;
            Intrinsics.checkNotNullExpressionValue(card3, "card3");
            CustomCardView.setBackground$default(card3, this.gradientColor1, this.gradientColor2, null, null, 12, null);
        }
    }

    private final void setFullscreenItem(RatingItem ratingItem) {
        try {
            Log.d("setCarModel", "id: " + ratingItem.getVehicleId() + " ");
            this.scene.setupScene();
            this.scene.setCarModel(ratingItem.getVehicleId(), "rating_bg");
            List<Integer> vehicleComponents = ratingItem.getVehicleComponents();
            if (vehicleComponents != null) {
                for (Number number : vehicleComponents) {
                    int intValue = number.intValue();
                    Log.d("setCarModel", "id: " + intValue + " ");
                    this.scene.setCarModule(ratingItem.getVehicleId(), intValue);
                }
            }
            this.binding.fullscreen.getRoot().setOnTouchListener(new ModelRotationTouchListener(ratingItem.getVehicleId(), 0.0f, 0.0f, this.scene, 6, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.binding.title.setText(ratingItem.getCarName());
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.transport.ItemRatingScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ItemRatingScreen.setFullscreenItem$lambda$1(ItemRatingScreen.this, view);
            }
        });
        RatingFullscreenItemBinding ratingFullscreenItemBinding = this.binding.fullscreen;
        ratingFullscreenItemBinding.top.setText(ratingItem.getId() + " место");
        ratingFullscreenItemBinding.nick.setText(ratingItem.getPlayerName());
        int rarity = ratingItem.getRarity();
        if (rarity == 1) {
            ratingFullscreenItemBinding.labelText.setText("Хлам (" + ratingItem.getRarityLevel() + ")");
            CustomCardView labelBg = ratingFullscreenItemBinding.labelBg;
            Intrinsics.checkNotNullExpressionValue(labelBg, "labelBg");
            CustomCardView.setBackground$default(labelBg, Color.parseColor("#E5E5E5"), Color.parseColor("#00787878"), null, null, 12, null);
            ratingFullscreenItemBinding.labelText.setTextColor(Color.parseColor("#000000"));
        } else if (rarity == 2) {
            ratingFullscreenItemBinding.labelText.setText("Обычное (" + ratingItem.getRarityLevel() + ")");
            CustomCardView labelBg2 = ratingFullscreenItemBinding.labelBg;
            Intrinsics.checkNotNullExpressionValue(labelBg2, "labelBg");
            CustomCardView.setBackground$default(labelBg2, Color.parseColor("#00FFFF"), Color.parseColor("#00003636"), null, null, 12, null);
            ratingFullscreenItemBinding.labelText.setTextColor(Color.parseColor("#004D4D"));
        } else if (rarity == 4) {
            CustomCardView labelBg3 = ratingFullscreenItemBinding.labelBg;
            Intrinsics.checkNotNullExpressionValue(labelBg3, "labelBg");
            CustomCardView.setBackground$default(labelBg3, Color.parseColor("#FFCC00"), Color.parseColor("#00FFCC00"), null, null, 12, null);
            ratingFullscreenItemBinding.labelText.setText("Идеальное (" + ratingItem.getRarityLevel() + ")");
            ratingFullscreenItemBinding.labelText.setTextColor(Color.parseColor("#672400"));
        }
        navigateTo(Navigation.FullScreen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFullscreenItem$lambda$1(ItemRatingScreen itemRatingScreen, View view) {
        itemRatingScreen.scene.closeScene();
        itemRatingScreen.navigateTo(Navigation.List);
    }

    private final void navigateTo(Navigation navigation) {
        this.binding.list.getRoot().setVisibility(8);
        this.binding.fullscreen.getRoot().setVisibility(8);
        this.binding.filterLayout.setVisibility(8);
        int i = WhenMappings.$EnumSwitchMapping$0[navigation.ordinal()];
        if (i == 1) {
            this.binding.fullscreen.getRoot().setVisibility(0);
            this.binding.getRoot().setBackground(null);
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            this.binding.getRoot().setBackgroundResource(ru.mrlargha.commonui.R.drawable.rodina_feature_bg);
            this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.transport.ItemRatingScreen$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ItemRatingScreen.navigateTo$lambda$0(ItemRatingScreen.this, view);
                }
            });
            this.binding.list.getRoot().setVisibility(0);
            this.binding.title.setText("Рейтинг автомобилей");
            topbarNavigation(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateTo$lambda$0(ItemRatingScreen itemRatingScreen, View view) {
        SAMPUIElement.notifyClick$default(itemRatingScreen, 2, 0, null, 4, null);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: ItemRatingScreen.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/mrlargha/transport/ItemRatingScreen$Navigation;", "", "<init>", "(Ljava/lang/String;I)V", "FullScreen", "List", "item-rating_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
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
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/transport/ItemRatingScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "item-rating_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.RATING);

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
