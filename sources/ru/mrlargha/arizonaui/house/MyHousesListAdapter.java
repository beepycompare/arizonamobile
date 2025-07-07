package ru.mrlargha.arizonaui.house;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.adjust.sdk.Constants;
import com.arizona.common.utils.EasyAnimation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.MyHousesItemBinding;
import ru.mrlargha.arizonaui.house.MyHouseScreen;
/* compiled from: MyHousesListAdapter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0014\u0010\u0016\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018J\u0006\u0010\u0019\u001a\u00020\fR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHousesListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/house/MyHousesListAdapter$ViewHolder;", "<init>", "()V", "houseItemInfoList", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/house/MyHouseScreen$Companion$HouseItemInfo;", "Lkotlin/collections/ArrayList;", "onHouseClickListener", "Lru/mrlargha/arizonaui/house/MyHousesListAdapter$OnHouseClickListener;", "setOnBizClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "addHouses", "infoList", "", "clearHouses", "OnHouseClickListener", "ViewHolder", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyHousesListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final ArrayList<MyHouseScreen.Companion.HouseItemInfo> houseItemInfoList = new ArrayList<>();
    private OnHouseClickListener onHouseClickListener;

    /* compiled from: MyHousesListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHousesListAdapter$OnHouseClickListener;", "", "callback", "", "id", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnHouseClickListener {
        void callback(int i);
    }

    public final void setOnBizClickListener(OnHouseClickListener onHouseClickListener) {
        Intrinsics.checkNotNullParameter(onHouseClickListener, "onHouseClickListener");
        this.onHouseClickListener = onHouseClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_houses_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MyHouseScreen.Companion.HouseItemInfo houseItemInfo = this.houseItemInfoList.get(i);
        Intrinsics.checkNotNullExpressionValue(houseItemInfo, "get(...)");
        final MyHouseScreen.Companion.HouseItemInfo houseItemInfo2 = houseItemInfo;
        MyHousesItemBinding binding = holder.getBinding();
        if (houseItemInfo2.getOpened() == 1) {
            binding.houseStatusContainer.setBackgroundResource(R.drawable.my_biz_status_close_ic);
            binding.houseStatus.setText("закрыт");
            binding.houseStatus.setTextColor(Color.parseColor("#EB4E66"));
        } else {
            binding.houseStatusContainer.setBackgroundResource(R.drawable.my_biz_status_open_ic);
            binding.houseStatus.setText("открыт");
            binding.houseStatus.setTextColor(Color.parseColor("#60CA5D"));
        }
        binding.houseName.setText(houseItemInfo2.getTitle());
        binding.houseNumber.setText("№" + houseItemInfo2.getId());
        binding.distance.setText(houseItemInfo2.getDistance() + " m");
        String status = houseItemInfo2.getStatus();
        switch (status.hashCode()) {
            case -1997688170:
                if (status.equals("rentedOut")) {
                    binding.firstValue.setText("Подселен");
                    break;
                }
                break;
            case -1039745817:
                if (status.equals(Constants.NORMAL)) {
                    binding.firstValue.setText("Спокойно");
                    break;
                }
                break;
            case -934576744:
                if (status.equals("rented")) {
                    binding.firstValue.setText("Арендован");
                    break;
                }
                break;
            case -925716324:
                if (status.equals("robbed")) {
                    binding.firstValue.setText("Ограблен");
                    break;
                }
                break;
        }
        int i2 = 0;
        for (Object obj : houseItemInfo2.getStats()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MyHouseScreen.Companion.HouseItemStatInfo houseItemStatInfo = (MyHouseScreen.Companion.HouseItemStatInfo) obj;
            if (i2 == 0) {
                binding.secondValue.setText(houseItemStatInfo.getValue());
                binding.secondTitle.setText(houseItemStatInfo.getTitle());
            } else if (i2 == 1) {
                binding.thirdValue.setText(houseItemStatInfo.getValue());
                binding.thirdTitle.setText(houseItemStatInfo.getTitle());
            } else if (i2 == 2) {
                binding.fourthValue.setText(houseItemStatInfo.getValue());
                binding.fourthTitle.setText(houseItemStatInfo.getTitle());
            }
            i2 = i3;
        }
        String type = houseItemInfo2.getType();
        int hashCode = type.hashCode();
        if (hashCode != -1067215565) {
            if (hashCode != -993141291) {
                if (hashCode == 1959548722 && type.equals("apartment")) {
                    binding.houseTypeIc.setImageResource(R.drawable.my_houses_apartment_ic);
                }
            } else if (type.equals("property")) {
                binding.houseTypeIc.setImageResource(R.drawable.my_houses_house_ic);
            }
        } else if (type.equals("trailer")) {
            binding.houseTypeIc.setImageResource(R.drawable.my_houses_trailer_ic);
        }
        EasyAnimation easyAnimation = EasyAnimation.INSTANCE;
        ConstraintLayout myHousesItem = binding.myHousesItem;
        Intrinsics.checkNotNullExpressionValue(myHousesItem, "myHousesItem");
        EasyAnimation.animateClick$default(easyAnimation, myHousesItem, 0L, null, new Function0() { // from class: ru.mrlargha.arizonaui.house.MyHousesListAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onBindViewHolder$lambda$2$lambda$1;
                onBindViewHolder$lambda$2$lambda$1 = MyHousesListAdapter.onBindViewHolder$lambda$2$lambda$1(MyHousesListAdapter.this, houseItemInfo2);
                return onBindViewHolder$lambda$2$lambda$1;
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$2$lambda$1(MyHousesListAdapter myHousesListAdapter, MyHouseScreen.Companion.HouseItemInfo houseItemInfo) {
        OnHouseClickListener onHouseClickListener = myHousesListAdapter.onHouseClickListener;
        if (onHouseClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onHouseClickListener");
            onHouseClickListener = null;
        }
        onHouseClickListener.callback(houseItemInfo.getId());
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.houseItemInfoList.size();
    }

    /* compiled from: MyHousesListAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lru/mrlargha/arizonaui/house/MyHousesListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "binding", "Lru/mrlargha/arizonaui/databinding/MyHousesItemBinding;", "getBinding", "()Lru/mrlargha/arizonaui/databinding/MyHousesItemBinding;", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final MyHousesItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            MyHousesItemBinding bind = MyHousesItemBinding.bind(view);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final MyHousesItemBinding getBinding() {
            return this.binding;
        }
    }

    public final void addHouses(List<MyHouseScreen.Companion.HouseItemInfo> infoList) {
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        this.houseItemInfoList.addAll(infoList);
        notifyDataSetChanged();
    }

    public final void clearHouses() {
        this.houseItemInfoList.clear();
        notifyDataSetChanged();
    }
}
