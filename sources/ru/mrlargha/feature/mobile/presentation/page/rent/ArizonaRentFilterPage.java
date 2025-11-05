package ru.mrlargha.feature.mobile.presentation.page.rent;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.mobile.R;
import ru.mrlargha.feature.mobile.databinding.MpArizonaRentFilterBinding;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentFilterModel;
/* compiled from: ArizonaRentFilterPage.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J`\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f2<\b\u0002\u0010\u0015\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0016J\u0012\u0010\u001a\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0002J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010\u001cJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010\u001cJM\u0010\u001e\u001a\u0004\u0018\u00010\u00112<\b\u0002\u0010\u0015\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J(\u0010&\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0002J(\u0010,\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0002J(\u0010-\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0002J(\u0010.\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0002J(\u0010/\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent/ArizonaRentFilterPage;", "", "<init>", "()V", "binding", "Lru/mrlargha/feature/mobile/databinding/MpArizonaRentFilterBinding;", "getBinding", "()Lru/mrlargha/feature/mobile/databinding/MpArizonaRentFilterBinding;", "setBinding", "(Lru/mrlargha/feature/mobile/databinding/MpArizonaRentFilterBinding;)V", "isCostSortUp", "", "Ljava/lang/Boolean;", "isRatingSortUp", "currentFilter", "Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentFilterModel;", "setDefault", "", "setVisibleFilter", "isVisible", "filterModel", "close", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isFind", "setDefaultFilter", "showFilter", "()Lkotlin/Unit;", "hideFilter", "setupListeners", "(Lkotlin/jvm/functions/Function2;)Lkotlin/Unit;", "setSelectedSwitch", "customCardView", "Lru/mrlargha/commonui/utils/ui/CustomCardView;", "switch", "Landroidx/appcompat/widget/SwitchCompat;", "setUnselectedSwitch", "checkCostSelected", "tv", "Landroid/widget/TextView;", "arrowUp", "Landroid/widget/ImageView;", "arrowDown", "checkRatingSelected", "setSelectUp", "setSelectDown", "setUnselect", "mobile_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaRentFilterPage {
    public static final ArizonaRentFilterPage INSTANCE = new ArizonaRentFilterPage();
    private static MpArizonaRentFilterBinding binding;
    private static ArizonaRentFilterModel currentFilter;
    private static Boolean isCostSortUp;
    private static Boolean isRatingSortUp;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$0(View view) {
    }

    private ArizonaRentFilterPage() {
    }

    public final MpArizonaRentFilterBinding getBinding() {
        return binding;
    }

    public final void setBinding(MpArizonaRentFilterBinding mpArizonaRentFilterBinding) {
        binding = mpArizonaRentFilterBinding;
    }

    public final void setDefault() {
        isCostSortUp = null;
        isRatingSortUp = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setVisibleFilter$default(ArizonaRentFilterPage arizonaRentFilterPage, boolean z, MpArizonaRentFilterBinding mpArizonaRentFilterBinding, ArizonaRentFilterModel arizonaRentFilterModel, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            arizonaRentFilterModel = null;
        }
        if ((i & 8) != 0) {
            function2 = null;
        }
        arizonaRentFilterPage.setVisibleFilter(z, mpArizonaRentFilterBinding, arizonaRentFilterModel, function2);
    }

    public final void setVisibleFilter(boolean z, MpArizonaRentFilterBinding binding2, ArizonaRentFilterModel arizonaRentFilterModel, Function2<? super Boolean, ? super ArizonaRentFilterModel, Unit> function2) {
        Intrinsics.checkNotNullParameter(binding2, "binding");
        binding = binding2;
        Log.i("arizona_rent", "filter: " + arizonaRentFilterModel + " ");
        if (z) {
            setDefaultFilter(arizonaRentFilterModel);
            showFilter();
            setupListeners(function2);
            return;
        }
        hideFilter();
    }

    private final void setDefaultFilter(ArizonaRentFilterModel arizonaRentFilterModel) {
        EditText editText;
        SwitchCompat switchCompat;
        SwitchCompat switchCompat2;
        MpArizonaRentFilterBinding mpArizonaRentFilterBinding;
        EditText editText2;
        SwitchCompat switchCompat3;
        SwitchCompat switchCompat4;
        currentFilter = arizonaRentFilterModel;
        if (arizonaRentFilterModel != null) {
            isCostSortUp = arizonaRentFilterModel.isCostSortUp();
            isRatingSortUp = arizonaRentFilterModel.isRatingSortUp();
            MpArizonaRentFilterBinding mpArizonaRentFilterBinding2 = binding;
            if (mpArizonaRentFilterBinding2 != null && (switchCompat4 = mpArizonaRentFilterBinding2.switchBasement) != null) {
                switchCompat4.setChecked(arizonaRentFilterModel.isHaveBasement());
            }
            MpArizonaRentFilterBinding mpArizonaRentFilterBinding3 = binding;
            if (mpArizonaRentFilterBinding3 != null && (switchCompat3 = mpArizonaRentFilterBinding3.switchGarage) != null) {
                switchCompat3.setChecked(arizonaRentFilterModel.isHaveGarage());
            }
            if (arizonaRentFilterModel.getSearchId() <= 0 || (mpArizonaRentFilterBinding = binding) == null || (editText2 = mpArizonaRentFilterBinding.etSearchByNumber) == null) {
                return;
            }
            editText2.setText(String.valueOf(arizonaRentFilterModel.getSearchId()));
            return;
        }
        setDefault();
        MpArizonaRentFilterBinding mpArizonaRentFilterBinding4 = binding;
        if (mpArizonaRentFilterBinding4 != null && (switchCompat2 = mpArizonaRentFilterBinding4.switchBasement) != null) {
            switchCompat2.setChecked(false);
        }
        MpArizonaRentFilterBinding mpArizonaRentFilterBinding5 = binding;
        if (mpArizonaRentFilterBinding5 != null && (switchCompat = mpArizonaRentFilterBinding5.switchGarage) != null) {
            switchCompat.setChecked(false);
        }
        MpArizonaRentFilterBinding mpArizonaRentFilterBinding6 = binding;
        if (mpArizonaRentFilterBinding6 == null || (editText = mpArizonaRentFilterBinding6.etSearchByNumber) == null) {
            return;
        }
        editText.setText((CharSequence) null);
    }

    private final Unit showFilter() {
        MpArizonaRentFilterBinding mpArizonaRentFilterBinding = binding;
        if (mpArizonaRentFilterBinding != null) {
            ArizonaRentFilterPage arizonaRentFilterPage = INSTANCE;
            CustomCardView btnCost = mpArizonaRentFilterBinding.btnCost;
            Intrinsics.checkNotNullExpressionValue(btnCost, "btnCost");
            TextView tvCost = mpArizonaRentFilterBinding.tvCost;
            Intrinsics.checkNotNullExpressionValue(tvCost, "tvCost");
            ImageView costArrowUp = mpArizonaRentFilterBinding.costArrowUp;
            Intrinsics.checkNotNullExpressionValue(costArrowUp, "costArrowUp");
            ImageView costArrowDown = mpArizonaRentFilterBinding.costArrowDown;
            Intrinsics.checkNotNullExpressionValue(costArrowDown, "costArrowDown");
            arizonaRentFilterPage.checkCostSelected(btnCost, tvCost, costArrowUp, costArrowDown);
            CustomCardView btnRating = mpArizonaRentFilterBinding.btnRating;
            Intrinsics.checkNotNullExpressionValue(btnRating, "btnRating");
            TextView tvRating = mpArizonaRentFilterBinding.tvRating;
            Intrinsics.checkNotNullExpressionValue(tvRating, "tvRating");
            ImageView ratingArrowUp = mpArizonaRentFilterBinding.ratingArrowUp;
            Intrinsics.checkNotNullExpressionValue(ratingArrowUp, "ratingArrowUp");
            ImageView ratingArrowDown = mpArizonaRentFilterBinding.ratingArrowDown;
            Intrinsics.checkNotNullExpressionValue(ratingArrowDown, "ratingArrowDown");
            arizonaRentFilterPage.checkRatingSelected(btnRating, tvRating, ratingArrowUp, ratingArrowDown);
            FrameLayout root = mpArizonaRentFilterBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            root.setVisibility(0);
            mpArizonaRentFilterBinding.getRoot().startAnimation(AnimationUtils.loadAnimation(mpArizonaRentFilterBinding.getRoot().getContext(), R.anim.slide_up_vertical));
            return Unit.INSTANCE;
        }
        return null;
    }

    private final Unit hideFilter() {
        MpArizonaRentFilterBinding mpArizonaRentFilterBinding = binding;
        if (mpArizonaRentFilterBinding != null) {
            mpArizonaRentFilterBinding.getRoot().startAnimation(AnimationUtils.loadAnimation(mpArizonaRentFilterBinding.getRoot().getContext(), R.anim.slide_down_vertical));
            FrameLayout root = mpArizonaRentFilterBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            root.setVisibility(8);
            return Unit.INSTANCE;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Unit setupListeners$default(ArizonaRentFilterPage arizonaRentFilterPage, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = null;
        }
        return arizonaRentFilterPage.setupListeners(function2);
    }

    private final Unit setupListeners(final Function2<? super Boolean, ? super ArizonaRentFilterModel, Unit> function2) {
        final MpArizonaRentFilterBinding mpArizonaRentFilterBinding = binding;
        if (mpArizonaRentFilterBinding != null) {
            mpArizonaRentFilterBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentFilterPage$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ArizonaRentFilterPage.setupListeners$lambda$0$0(view);
                }
            });
            mpArizonaRentFilterBinding.btnFind.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentFilterPage$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ArizonaRentFilterPage.setupListeners$lambda$0$1(MpArizonaRentFilterBinding.this, function2, view);
                }
            });
            mpArizonaRentFilterBinding.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentFilterPage$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ArizonaRentFilterPage.setupListeners$lambda$0$2(Function2.this, view);
                }
            });
            mpArizonaRentFilterBinding.btnCost.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentFilterPage$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ArizonaRentFilterPage.setupListeners$lambda$0$3(MpArizonaRentFilterBinding.this, view);
                }
            });
            mpArizonaRentFilterBinding.btnRating.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentFilterPage$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ArizonaRentFilterPage.setupListeners$lambda$0$4(MpArizonaRentFilterBinding.this, view);
                }
            });
            mpArizonaRentFilterBinding.switchGarage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentFilterPage$$ExternalSyntheticLambda5
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    ArizonaRentFilterPage.setupListeners$lambda$0$5(MpArizonaRentFilterBinding.this, compoundButton, z);
                }
            });
            mpArizonaRentFilterBinding.switchBasement.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.ArizonaRentFilterPage$$ExternalSyntheticLambda6
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    ArizonaRentFilterPage.setupListeners$lambda$0$6(MpArizonaRentFilterBinding.this, compoundButton, z);
                }
            });
            return Unit.INSTANCE;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$1(MpArizonaRentFilterBinding mpArizonaRentFilterBinding, Function2 function2, View view) {
        String obj = mpArizonaRentFilterBinding.etSearchByNumber.getText().toString();
        ArizonaRentFilterModel arizonaRentFilterModel = new ArizonaRentFilterModel(obj.length() == 0 ? -1 : Integer.parseInt(obj), mpArizonaRentFilterBinding.switchGarage.isChecked(), mpArizonaRentFilterBinding.switchBasement.isChecked(), isCostSortUp, isRatingSortUp);
        if (arizonaRentFilterModel.isDefault()) {
            if (function2 != null) {
                function2.invoke(true, null);
            }
        } else if (function2 != null) {
            function2.invoke(true, arizonaRentFilterModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$2(Function2 function2, View view) {
        if (function2 != null) {
            function2.invoke(false, currentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$3(MpArizonaRentFilterBinding mpArizonaRentFilterBinding, View view) {
        Boolean bool = isCostSortUp;
        Boolean bool2 = null;
        if (bool == null) {
            isRatingSortUp = null;
            bool2 = true;
        } else {
            if (bool != null ? bool.booleanValue() : true) {
                bool2 = false;
            }
        }
        isCostSortUp = bool2;
        ArizonaRentFilterPage arizonaRentFilterPage = INSTANCE;
        CustomCardView btnCost = mpArizonaRentFilterBinding.btnCost;
        Intrinsics.checkNotNullExpressionValue(btnCost, "btnCost");
        TextView tvCost = mpArizonaRentFilterBinding.tvCost;
        Intrinsics.checkNotNullExpressionValue(tvCost, "tvCost");
        ImageView costArrowUp = mpArizonaRentFilterBinding.costArrowUp;
        Intrinsics.checkNotNullExpressionValue(costArrowUp, "costArrowUp");
        ImageView costArrowDown = mpArizonaRentFilterBinding.costArrowDown;
        Intrinsics.checkNotNullExpressionValue(costArrowDown, "costArrowDown");
        arizonaRentFilterPage.checkCostSelected(btnCost, tvCost, costArrowUp, costArrowDown);
        CustomCardView btnRating = mpArizonaRentFilterBinding.btnRating;
        Intrinsics.checkNotNullExpressionValue(btnRating, "btnRating");
        TextView tvRating = mpArizonaRentFilterBinding.tvRating;
        Intrinsics.checkNotNullExpressionValue(tvRating, "tvRating");
        ImageView ratingArrowUp = mpArizonaRentFilterBinding.ratingArrowUp;
        Intrinsics.checkNotNullExpressionValue(ratingArrowUp, "ratingArrowUp");
        ImageView ratingArrowDown = mpArizonaRentFilterBinding.ratingArrowDown;
        Intrinsics.checkNotNullExpressionValue(ratingArrowDown, "ratingArrowDown");
        arizonaRentFilterPage.checkRatingSelected(btnRating, tvRating, ratingArrowUp, ratingArrowDown);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$4(MpArizonaRentFilterBinding mpArizonaRentFilterBinding, View view) {
        Boolean bool = isRatingSortUp;
        Boolean bool2 = null;
        if (bool == null) {
            isCostSortUp = null;
            bool2 = true;
        } else {
            if (bool != null ? bool.booleanValue() : true) {
                bool2 = false;
            }
        }
        isRatingSortUp = bool2;
        ArizonaRentFilterPage arizonaRentFilterPage = INSTANCE;
        CustomCardView btnCost = mpArizonaRentFilterBinding.btnCost;
        Intrinsics.checkNotNullExpressionValue(btnCost, "btnCost");
        TextView tvCost = mpArizonaRentFilterBinding.tvCost;
        Intrinsics.checkNotNullExpressionValue(tvCost, "tvCost");
        ImageView costArrowUp = mpArizonaRentFilterBinding.costArrowUp;
        Intrinsics.checkNotNullExpressionValue(costArrowUp, "costArrowUp");
        ImageView costArrowDown = mpArizonaRentFilterBinding.costArrowDown;
        Intrinsics.checkNotNullExpressionValue(costArrowDown, "costArrowDown");
        arizonaRentFilterPage.checkCostSelected(btnCost, tvCost, costArrowUp, costArrowDown);
        CustomCardView btnRating = mpArizonaRentFilterBinding.btnRating;
        Intrinsics.checkNotNullExpressionValue(btnRating, "btnRating");
        TextView tvRating = mpArizonaRentFilterBinding.tvRating;
        Intrinsics.checkNotNullExpressionValue(tvRating, "tvRating");
        ImageView ratingArrowUp = mpArizonaRentFilterBinding.ratingArrowUp;
        Intrinsics.checkNotNullExpressionValue(ratingArrowUp, "ratingArrowUp");
        ImageView ratingArrowDown = mpArizonaRentFilterBinding.ratingArrowDown;
        Intrinsics.checkNotNullExpressionValue(ratingArrowDown, "ratingArrowDown");
        arizonaRentFilterPage.checkRatingSelected(btnRating, tvRating, ratingArrowUp, ratingArrowDown);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$5(MpArizonaRentFilterBinding mpArizonaRentFilterBinding, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (z) {
            ArizonaRentFilterPage arizonaRentFilterPage = INSTANCE;
            CustomCardView switchGarageBg = mpArizonaRentFilterBinding.switchGarageBg;
            Intrinsics.checkNotNullExpressionValue(switchGarageBg, "switchGarageBg");
            SwitchCompat switchGarage = mpArizonaRentFilterBinding.switchGarage;
            Intrinsics.checkNotNullExpressionValue(switchGarage, "switchGarage");
            arizonaRentFilterPage.setSelectedSwitch(switchGarageBg, switchGarage);
            return;
        }
        ArizonaRentFilterPage arizonaRentFilterPage2 = INSTANCE;
        CustomCardView switchGarageBg2 = mpArizonaRentFilterBinding.switchGarageBg;
        Intrinsics.checkNotNullExpressionValue(switchGarageBg2, "switchGarageBg");
        SwitchCompat switchGarage2 = mpArizonaRentFilterBinding.switchGarage;
        Intrinsics.checkNotNullExpressionValue(switchGarage2, "switchGarage");
        arizonaRentFilterPage2.setUnselectedSwitch(switchGarageBg2, switchGarage2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$0$6(MpArizonaRentFilterBinding mpArizonaRentFilterBinding, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (z) {
            ArizonaRentFilterPage arizonaRentFilterPage = INSTANCE;
            CustomCardView swithcBasementBg = mpArizonaRentFilterBinding.swithcBasementBg;
            Intrinsics.checkNotNullExpressionValue(swithcBasementBg, "swithcBasementBg");
            SwitchCompat switchBasement = mpArizonaRentFilterBinding.switchBasement;
            Intrinsics.checkNotNullExpressionValue(switchBasement, "switchBasement");
            arizonaRentFilterPage.setSelectedSwitch(swithcBasementBg, switchBasement);
            return;
        }
        ArizonaRentFilterPage arizonaRentFilterPage2 = INSTANCE;
        CustomCardView swithcBasementBg2 = mpArizonaRentFilterBinding.swithcBasementBg;
        Intrinsics.checkNotNullExpressionValue(swithcBasementBg2, "swithcBasementBg");
        SwitchCompat switchBasement2 = mpArizonaRentFilterBinding.switchBasement;
        Intrinsics.checkNotNullExpressionValue(switchBasement2, "switchBasement");
        arizonaRentFilterPage2.setUnselectedSwitch(swithcBasementBg2, switchBasement2);
    }

    private final void setSelectedSwitch(CustomCardView customCardView, SwitchCompat switchCompat) {
        customCardView.setBackground(-16711936);
        customCardView.setBackgroundAlpha(60);
        customCardView.setBorderAlpha(0);
        switchCompat.setThumbTintList(ColorStateList.valueOf(-1));
    }

    private final void setUnselectedSwitch(CustomCardView customCardView, SwitchCompat switchCompat) {
        customCardView.setBackground(0);
        customCardView.setBorderAlpha(100);
        switchCompat.setThumbTintList(ColorStateList.valueOf(Color.parseColor("#4DFFFFFF")));
    }

    private final void checkCostSelected(CustomCardView customCardView, TextView textView, ImageView imageView, ImageView imageView2) {
        Boolean bool = isCostSortUp;
        if (bool == null) {
            setUnselect(customCardView, textView, imageView, imageView2);
            return;
        }
        if (bool != null ? bool.booleanValue() : true) {
            setSelectUp(customCardView, textView, imageView, imageView2);
        } else {
            setSelectDown(customCardView, textView, imageView, imageView2);
        }
    }

    private final void checkRatingSelected(CustomCardView customCardView, TextView textView, ImageView imageView, ImageView imageView2) {
        Boolean bool = isRatingSortUp;
        if (bool == null) {
            setUnselect(customCardView, textView, imageView, imageView2);
            return;
        }
        if (bool != null ? bool.booleanValue() : true) {
            setSelectUp(customCardView, textView, imageView, imageView2);
        } else {
            setSelectDown(customCardView, textView, imageView, imageView2);
        }
    }

    private final void setSelectUp(CustomCardView customCardView, TextView textView, ImageView imageView, ImageView imageView2) {
        customCardView.setBorder(-1);
        textView.setTextColor(-1);
        imageView.setAlpha(1.0f);
        imageView2.setAlpha(0.5f);
    }

    private final void setSelectDown(CustomCardView customCardView, TextView textView, ImageView imageView, ImageView imageView2) {
        customCardView.setBorder(-1);
        textView.setTextColor(-1);
        imageView.setAlpha(0.5f);
        imageView2.setAlpha(1.0f);
    }

    private final void setUnselect(CustomCardView customCardView, TextView textView, ImageView imageView, ImageView imageView2) {
        customCardView.setBorder(Color.parseColor("#33FFFFFF"));
        textView.setTextColor(Color.parseColor("#33FFFFFF"));
        imageView.setAlpha(0.5f);
        imageView2.setAlpha(0.5f);
    }
}
