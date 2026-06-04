package ru.mrlargha.feature.mobile.presentation.page.rent.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.common.utils.EasyAnimation;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.money.MoneyElementKt;
import ru.mrlargha.feature.mobile.R;
import ru.mrlargha.feature.mobile.databinding.MpArizonaRentAdItemBinding;
import ru.mrlargha.feature.mobile.presentation.page.rent.adapters.ArizonaRentAdAdapter;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentAdClickEvent;
import ru.mrlargha.feature.mobile.presentation.page.rent.models.ArizonaRentAdModel;
/* compiled from: ArizonaRentAdAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00192\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0018\u0019B?\u00126\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001c\u0010\u0015\u001a\u00020\u000b2\n\u0010\u0016\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0014H\u0016RA\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent/adapters/ArizonaRentAdAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentAdModel;", "Lru/mrlargha/feature/mobile/presentation/page/rent/adapters/ArizonaRentAdAdapter$AdViewHolder;", "onClick", "Lkotlin/Function2;", "Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentAdClickEvent;", "Lkotlin/ParameterName;", "name", NotificationCompat.CATEGORY_EVENT, CommonUrlParts.MODEL, "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "getOnClick", "()Lkotlin/jvm/functions/Function2;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "AdViewHolder", "Companion", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaRentAdAdapter extends ListAdapter<ArizonaRentAdModel, AdViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final ArizonaRentAdAdapter$Companion$diffUtilCallback$1 diffUtilCallback = new DiffUtil.ItemCallback<ArizonaRentAdModel>() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.adapters.ArizonaRentAdAdapter$Companion$diffUtilCallback$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(ArizonaRentAdModel oldItem, ArizonaRentAdModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getId() == newItem.getId();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(ArizonaRentAdModel oldItem, ArizonaRentAdModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };
    private final Function2<ArizonaRentAdClickEvent, ArizonaRentAdModel, Unit> onClick;

    public final Function2<ArizonaRentAdClickEvent, ArizonaRentAdModel, Unit> getOnClick() {
        return this.onClick;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ArizonaRentAdAdapter(Function2<? super ArizonaRentAdClickEvent, ? super ArizonaRentAdModel, Unit> onClick) {
        super(diffUtilCallback);
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
    }

    /* compiled from: ArizonaRentAdAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent/adapters/ArizonaRentAdAdapter$AdViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/feature/mobile/databinding/MpArizonaRentAdItemBinding;", "<init>", "(Lru/mrlargha/feature/mobile/presentation/page/rent/adapters/ArizonaRentAdAdapter;Lru/mrlargha/feature/mobile/databinding/MpArizonaRentAdItemBinding;)V", "getBinding", "()Lru/mrlargha/feature/mobile/databinding/MpArizonaRentAdItemBinding;", "onBind", "", CommonUrlParts.MODEL, "Lru/mrlargha/feature/mobile/presentation/page/rent/models/ArizonaRentAdModel;", "initialize", "checkIsMyAd", "isMy", "", "setupListeners", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class AdViewHolder extends RecyclerView.ViewHolder {
        private final MpArizonaRentAdItemBinding binding;
        final /* synthetic */ ArizonaRentAdAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AdViewHolder(ArizonaRentAdAdapter arizonaRentAdAdapter, MpArizonaRentAdItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = arizonaRentAdAdapter;
            this.binding = binding;
        }

        public final MpArizonaRentAdItemBinding getBinding() {
            return this.binding;
        }

        public final void onBind(ArizonaRentAdModel model) {
            Intrinsics.checkNotNullParameter(model, "model");
            initialize(model);
            setupListeners(model);
        }

        private final void initialize(ArizonaRentAdModel arizonaRentAdModel) {
            MpArizonaRentAdItemBinding mpArizonaRentAdItemBinding = this.binding;
            Context context = mpArizonaRentAdItemBinding.getRoot().getContext();
            mpArizonaRentAdItemBinding.tvAdNumber.setText(context.getString(R.string.number_i, Integer.valueOf(arizonaRentAdModel.getNumber())));
            CustomCardView basementContainer = mpArizonaRentAdItemBinding.basementContainer;
            Intrinsics.checkNotNullExpressionValue(basementContainer, "basementContainer");
            basementContainer.setVisibility(arizonaRentAdModel.isHaveBasement() ? 0 : 8);
            CustomCardView garageContainer = mpArizonaRentAdItemBinding.garageContainer;
            Intrinsics.checkNotNullExpressionValue(garageContainer, "garageContainer");
            garageContainer.setVisibility(arizonaRentAdModel.isHaveGarage() ? 0 : 8);
            String string = context.getString(arizonaRentAdModel.isHome() ? R.string.home : R.string.apartment);
            Intrinsics.checkNotNull(string);
            mpArizonaRentAdItemBinding.tvHomeNumber.setText(context.getString(R.string.i_number_i, Integer.valueOf(arizonaRentAdModel.getHouseNumber()), string));
            mpArizonaRentAdItemBinding.tvRealEstate.setText(context.getString(arizonaRentAdModel.isFully() ? R.string.fully : R.string.room));
            mpArizonaRentAdItemBinding.tvX.setText(context.getString(R.string.x_i, Integer.valueOf(arizonaRentAdModel.getXPayDay())));
            TextView tvX = mpArizonaRentAdItemBinding.tvX;
            Intrinsics.checkNotNullExpressionValue(tvX, "tvX");
            tvX.setVisibility(arizonaRentAdModel.getXPayDay() > 1 ? 0 : 8);
            mpArizonaRentAdItemBinding.tvMoney.setText(MoneyElementKt.toMoneyFormattedSpannable$default(arizonaRentAdModel.getCost(), false, null, null, null, 15, null));
            mpArizonaRentAdItemBinding.tvUserName.setText(context.getString(R.string.name_square_brackets, arizonaRentAdModel.getOwnerName(), String.valueOf(arizonaRentAdModel.getHouseOwnerId())));
            mpArizonaRentAdItemBinding.tvTime.setText(context.getString(arizonaRentAdModel.isFully() ? R.string.per_day : R.string.per_hour));
            TextView tvDesc = mpArizonaRentAdItemBinding.tvDesc;
            Intrinsics.checkNotNullExpressionValue(tvDesc, "tvDesc");
            UtilsKt.setColoredTextBeforeDot(tvDesc, context.getString(arizonaRentAdModel.isFully() ? R.string.from_i_to_i_days : R.string.from_i_to_i_hours, Integer.valueOf(arizonaRentAdModel.getStartRent()), Integer.valueOf(arizonaRentAdModel.getEndRent())) + " " + arizonaRentAdModel.getDesc(), Color.parseColor("#FFBF00"));
            Boolean online = arizonaRentAdModel.getOnline();
            if (online != null) {
                boolean booleanValue = online.booleanValue();
                CustomCardView online2 = mpArizonaRentAdItemBinding.online;
                Intrinsics.checkNotNullExpressionValue(online2, "online");
                online2.setVisibility(0);
                mpArizonaRentAdItemBinding.online.setBackground(Color.parseColor(booleanValue ? "#8BE475" : "#FF162D"));
            } else {
                CustomCardView online3 = mpArizonaRentAdItemBinding.online;
                Intrinsics.checkNotNullExpressionValue(online3, "online");
                online3.setVisibility(8);
            }
            Picasso.get().load(FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "systems/house_int/" + arizonaRentAdModel.getImage() + ".webp").into(mpArizonaRentAdItemBinding.ivHome);
            Intrinsics.checkNotNull(context);
            checkIsMyAd(arizonaRentAdModel.getIsMy(context));
        }

        private final void checkIsMyAd(boolean z) {
            MpArizonaRentAdItemBinding mpArizonaRentAdItemBinding = this.binding;
            CustomCardView myAdContainer = mpArizonaRentAdItemBinding.myAdContainer;
            Intrinsics.checkNotNullExpressionValue(myAdContainer, "myAdContainer");
            myAdContainer.setVisibility(z ? 0 : 8);
            CustomCardView btnRent = mpArizonaRentAdItemBinding.btnRent;
            Intrinsics.checkNotNullExpressionValue(btnRent, "btnRent");
            btnRent.setVisibility(!z ? 0 : 8);
            LinearLayout raiseListContainer = mpArizonaRentAdItemBinding.raiseListContainer;
            Intrinsics.checkNotNullExpressionValue(raiseListContainer, "raiseListContainer");
            raiseListContainer.setVisibility(z ? 0 : 8);
        }

        private final void setupListeners(final ArizonaRentAdModel arizonaRentAdModel) {
            MpArizonaRentAdItemBinding mpArizonaRentAdItemBinding = this.binding;
            final ArizonaRentAdAdapter arizonaRentAdAdapter = this.this$0;
            EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
            CustomCardView btnRent = mpArizonaRentAdItemBinding.btnRent;
            Intrinsics.checkNotNullExpressionValue(btnRent, "btnRent");
            EasyAnimation.animateClick$default(easyAnimation, btnRent, 0L, null, new Function0() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.adapters.ArizonaRentAdAdapter$AdViewHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = ArizonaRentAdAdapter.AdViewHolder.setupListeners$lambda$0$0(ArizonaRentAdAdapter.this, arizonaRentAdModel);
                    return unit;
                }
            }, 3, null);
            EasyAnimation easyAnimation2 = EasyAnimation.INSTANCE;
            CustomCardView btnRaiseList = mpArizonaRentAdItemBinding.btnRaiseList;
            Intrinsics.checkNotNullExpressionValue(btnRaiseList, "btnRaiseList");
            EasyAnimation.animateClick$default(easyAnimation2, btnRaiseList, 0L, null, new Function0() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.adapters.ArizonaRentAdAdapter$AdViewHolder$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = ArizonaRentAdAdapter.AdViewHolder.setupListeners$lambda$0$1(ArizonaRentAdAdapter.this, arizonaRentAdModel);
                    return unit;
                }
            }, 3, null);
            EasyAnimation easyAnimation3 = EasyAnimation.INSTANCE;
            CustomCardView btnDeleteAd = mpArizonaRentAdItemBinding.btnDeleteAd;
            Intrinsics.checkNotNullExpressionValue(btnDeleteAd, "btnDeleteAd");
            EasyAnimation.animateClick$default(easyAnimation3, btnDeleteAd, 0L, null, new Function0() { // from class: ru.mrlargha.feature.mobile.presentation.page.rent.adapters.ArizonaRentAdAdapter$AdViewHolder$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit unit;
                    unit = ArizonaRentAdAdapter.AdViewHolder.setupListeners$lambda$0$2(ArizonaRentAdAdapter.this, arizonaRentAdModel);
                    return unit;
                }
            }, 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setupListeners$lambda$0$0(ArizonaRentAdAdapter arizonaRentAdAdapter, ArizonaRentAdModel arizonaRentAdModel) {
            arizonaRentAdAdapter.getOnClick().invoke(ArizonaRentAdClickEvent.RENT, arizonaRentAdModel);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setupListeners$lambda$0$1(ArizonaRentAdAdapter arizonaRentAdAdapter, ArizonaRentAdModel arizonaRentAdModel) {
            arizonaRentAdAdapter.getOnClick().invoke(ArizonaRentAdClickEvent.RAISE, arizonaRentAdModel);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit setupListeners$lambda$0$2(ArizonaRentAdAdapter arizonaRentAdAdapter, ArizonaRentAdModel arizonaRentAdModel) {
            arizonaRentAdAdapter.getOnClick().invoke(ArizonaRentAdClickEvent.DELETE, arizonaRentAdModel);
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public AdViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        MpArizonaRentAdItemBinding inflate = MpArizonaRentAdItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new AdViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(AdViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ArizonaRentAdModel arizonaRentAdModel = getCurrentList().get(i);
        Intrinsics.checkNotNullExpressionValue(arizonaRentAdModel, "get(...)");
        holder.onBind(arizonaRentAdModel);
    }

    /* compiled from: ArizonaRentAdAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent/adapters/ArizonaRentAdAdapter$Companion;", "", "<init>", "()V", "diffUtilCallback", "ru/mrlargha/feature/mobile/presentation/page/rent/adapters/ArizonaRentAdAdapter$Companion$diffUtilCallback$1", "Lru/mrlargha/feature/mobile/presentation/page/rent/adapters/ArizonaRentAdAdapter$Companion$diffUtilCallback$1;", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
