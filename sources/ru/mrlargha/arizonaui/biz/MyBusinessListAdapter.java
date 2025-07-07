package ru.mrlargha.arizonaui.biz;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.RecyclerView;
import com.arizona.common.utils.EasyAnimation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.biz.MyBusinessScreen;
import ru.mrlargha.arizonaui.databinding.MyBusinessItemBinding;
/* compiled from: MyBusinessListAdapter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0014\u0010\u0016\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018J\u0006\u0010\u0019\u001a\u00020\fR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/biz/MyBusinessListAdapter$BusinessViewHolder;", "<init>", "()V", "businessItemInfoList", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/biz/MyBusinessScreen$Companion$BusinessItemInfo;", "Lkotlin/collections/ArrayList;", "onBizClickListener", "Lru/mrlargha/arizonaui/biz/MyBusinessListAdapter$OnBizClickListener;", "setOnBizClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "addBusinesses", "infoList", "", "clearBusinesses", "OnBizClickListener", "BusinessViewHolder", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyBusinessListAdapter extends RecyclerView.Adapter<BusinessViewHolder> {
    private final ArrayList<MyBusinessScreen.Companion.BusinessItemInfo> businessItemInfoList = new ArrayList<>();
    private OnBizClickListener onBizClickListener;

    /* compiled from: MyBusinessListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessListAdapter$OnBizClickListener;", "", "callback", "", "id", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnBizClickListener {
        void callback(int i);
    }

    public final void setOnBizClickListener(OnBizClickListener onBizClickListener) {
        Intrinsics.checkNotNullParameter(onBizClickListener, "onBizClickListener");
        this.onBizClickListener = onBizClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BusinessViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_business_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new BusinessViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BusinessViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MyBusinessScreen.Companion.BusinessItemInfo businessItemInfo = this.businessItemInfoList.get(i);
        Intrinsics.checkNotNullExpressionValue(businessItemInfo, "get(...)");
        final MyBusinessScreen.Companion.BusinessItemInfo businessItemInfo2 = businessItemInfo;
        MyBusinessItemBinding binding = holder.getBinding();
        if (businessItemInfo2.getOpened() == 1) {
            binding.bizStatusContainer.setBackgroundResource(R.drawable.my_biz_status_close_ic);
            binding.bizStatus.setText("закрыт");
            binding.bizStatus.setTextColor(Color.parseColor("#EB4E66"));
        } else {
            binding.bizStatusContainer.setBackgroundResource(R.drawable.my_biz_status_open_ic);
            binding.bizStatus.setText("открыт");
            binding.bizStatus.setTextColor(Color.parseColor("#60CA5D"));
        }
        binding.bizName.setText(businessItemInfo2.getTitle());
        binding.bizNumber.setText("№" + businessItemInfo2.getId());
        int i2 = 0;
        for (Object obj : businessItemInfo2.getStats()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MyBusinessScreen.Companion.BusinessItemStatInfo businessItemStatInfo = (MyBusinessScreen.Companion.BusinessItemStatInfo) obj;
            if (i2 == 0) {
                binding.firstValue.setText(businessItemStatInfo.getValue());
                binding.firstTitle.setText(businessItemStatInfo.getTitle());
            } else if (i2 == 1) {
                binding.secondValue.setText(businessItemStatInfo.getValue());
                binding.secondTitle.setText(businessItemStatInfo.getTitle());
            } else if (i2 == 2) {
                binding.thirdValue.setText(businessItemStatInfo.getValue());
                binding.thirdTitle.setText(businessItemStatInfo.getTitle());
            }
            i2 = i3;
        }
        String type = businessItemInfo2.getType();
        switch (type.hashCode()) {
            case -1884476133:
                if (type.equals("pawn-shop")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_pawn_shop_ic);
                    break;
                }
                break;
            case -1870138379:
                if (type.equals("phone-shop")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_phone_shop_ic);
                    break;
                }
                break;
            case -1568935349:
                if (type.equals("strip-club")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_strip_club_ic);
                    break;
                }
                break;
            case -1495947919:
                if (type.equals("food-stall")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_food_stall_ic);
                    break;
                }
                break;
            case -1494830709:
                if (type.equals("convenience-store")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_convience_shop_ic);
                    break;
                }
                break;
            case -1459051883:
                if (type.equals("oil-rig")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_oil_rig_ic);
                    break;
                }
                break;
            case -1370098047:
                if (type.equals("sport-palace")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_sport_palace_ic);
                    break;
                }
                break;
            case -1360334095:
                if (type.equals("cinema")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_cinema_ic);
                    break;
                }
                break;
            case -1155432426:
                if (type.equals("ad-banner")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_ad_banner_ic);
                    break;
                }
                break;
            case -868067634:
                if (type.equals("dance-school")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_dance_school_ic);
                    break;
                }
                break;
            case -593039331:
                if (type.equals("fuel-station")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_fuel_station_ic);
                    break;
                }
                break;
            case -486648565:
                if (type.equals("electronics-store")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_electronic_store_ic);
                    break;
                }
                break;
            case -410956671:
                if (type.equals(TtmlNode.RUBY_CONTAINER)) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_container_ic);
                    break;
                }
                break;
            case -353700040:
                if (type.equals("car-service-ls")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_car_service_ls_ic);
                    break;
                }
                break;
            case -353700037:
                if (type.equals("car-service-lv")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_car_service_lv_ic);
                    break;
                }
                break;
            case -353699836:
                if (type.equals("car-service-sf")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_car_service_sf_ic);
                    break;
                }
                break;
            case -190855083:
                if (type.equals("car-market")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_car_market_ic);
                    break;
                }
                break;
            case -58146414:
                if (type.equals("car-rent")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_car_rent_ic);
                    break;
                }
                break;
            case 97299:
                if (type.equals("bar")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_bar_ic);
                    break;
                }
                break;
            case 2997966:
                if (type.equals("ammo")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_gun_shop_ic);
                    break;
                }
                break;
            case 3135542:
                if (type.equals("farm")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_farm_ic);
                    break;
                }
                break;
            case 3351635:
                if (type.equals("mine")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_mine_ic);
                    break;
                }
                break;
            case 9905691:
                if (type.equals("clothing-shop")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_clothing_shop_ic);
                    break;
                }
                break;
            case 216982060:
                if (type.equals("clothing-workshop")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_clothing_workshop_ic);
                    break;
                }
                break;
            case 528422772:
                if (type.equals("plane-bike-rent")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_plane_bike_rent_ic);
                    break;
                }
                break;
            case 577622612:
                if (type.equals("info-center")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_info_center_ic);
                    break;
                }
                break;
            case 589562686:
                if (type.equals("horse-racing")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_horse_racing_ic);
                    break;
                }
                break;
            case 605823065:
                if (type.equals("fishing-shop")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_fishing_shop_ic);
                    break;
                }
                break;
            case 611988801:
                if (type.equals("econom-car-shop")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_econom_car_shop_ic);
                    break;
                }
                break;
            case 702603170:
                if (type.equals("concert-room")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_concert_room_ic);
                    break;
                }
                break;
            case 723062322:
                if (type.equals("tunning-shop-ls")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_tuning_shop_ls_ic);
                    break;
                }
                break;
            case 723062325:
                if (type.equals("tunning-shop-lv")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_tuning_shop_lv_ic);
                    break;
                }
                break;
            case 723062526:
                if (type.equals("tunning-shop-sf")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_tuning_shop_sf_ic);
                    break;
                }
                break;
            case 1225089391:
                if (type.equals("mechanics")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_mechanics_ic);
                    break;
                }
                break;
            case 1547010822:
                if (type.equals("luxe-car-shop")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_luxe_car_shop_ic);
                    break;
                }
                break;
            case 1871089144:
                if (type.equals("cotton-farm")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_cotton_farm_ic);
                    break;
                }
                break;
            case 1981773567:
                if (type.equals("average-car-shop")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_average_car_shop_ic);
                    break;
                }
                break;
            case 2037180155:
                if (type.equals("bookmaker")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_bookmaker_ic);
                    break;
                }
                break;
            case 2085719044:
                if (type.equals("accessories-store")) {
                    binding.bizTypeIc.setImageResource(R.drawable.my_biz_accessories_shop_ic);
                    break;
                }
                break;
        }
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ConstraintLayout myBusinessItem = binding.myBusinessItem;
        Intrinsics.checkNotNullExpressionValue(myBusinessItem, "myBusinessItem");
        EasyAnimation.animateClick$default(easyAnimation, myBusinessItem, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.biz.MyBusinessListAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onBindViewHolder$lambda$2$lambda$1;
                onBindViewHolder$lambda$2$lambda$1 = MyBusinessListAdapter.onBindViewHolder$lambda$2$lambda$1(MyBusinessListAdapter.this, businessItemInfo2);
                return onBindViewHolder$lambda$2$lambda$1;
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$2$lambda$1(MyBusinessListAdapter myBusinessListAdapter, MyBusinessScreen.Companion.BusinessItemInfo businessItemInfo) {
        OnBizClickListener onBizClickListener = myBusinessListAdapter.onBizClickListener;
        if (onBizClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onBizClickListener");
            onBizClickListener = null;
        }
        onBizClickListener.callback(businessItemInfo.getId());
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.businessItemInfoList.size();
    }

    /* compiled from: MyBusinessListAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/biz/MyBusinessListAdapter$BusinessViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/arizonaui/databinding/MyBusinessItemBinding;", "getBinding", "()Lru/mrlargha/arizonaui/databinding/MyBusinessItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class BusinessViewHolder extends RecyclerView.ViewHolder {
        private final MyBusinessItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BusinessViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            MyBusinessItemBinding bind = MyBusinessItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final MyBusinessItemBinding getBinding() {
            return this.binding;
        }
    }

    public final void addBusinesses(List<MyBusinessScreen.Companion.BusinessItemInfo> infoList) {
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        this.businessItemInfoList.addAll(infoList);
        notifyDataSetChanged();
    }

    public final void clearBusinesses() {
        this.businessItemInfoList.clear();
        notifyDataSetChanged();
    }
}
