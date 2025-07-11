package ru.mrlargha.arizonaui.mobile.presentation.adapter;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.mobile.domain.obj.MobilePhoneAvailableCar;
/* compiled from: MobilePhoneCarsAdapter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0014\u0010\u0016\u001a\u00020\f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneCarsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneCarsViewHolder;", "<init>", "()V", "cars", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneAvailableCar;", "Lkotlin/collections/ArrayList;", "onChoseCarClickListener", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneCarsAdapter$OnChoseCarClickListener;", "setOnChoseCarClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "addAdapterCars", "", "OnChoseCarClickListener", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePhoneCarsAdapter extends RecyclerView.Adapter<MobilePhoneCarsViewHolder> {
    private final ArrayList<MobilePhoneAvailableCar> cars = new ArrayList<>();
    private OnChoseCarClickListener onChoseCarClickListener;

    /* compiled from: MobilePhoneCarsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneCarsAdapter$OnChoseCarClickListener;", "", "callback", "", "position", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnChoseCarClickListener {
        void callback(int i);
    }

    public final void setOnChoseCarClickListener(OnChoseCarClickListener onChoseCarClickListener) {
        Intrinsics.checkNotNullParameter(onChoseCarClickListener, "onChoseCarClickListener");
        this.onChoseCarClickListener = onChoseCarClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MobilePhoneCarsViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.mobile_phone_arizonamobil_car, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new MobilePhoneCarsViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MobilePhoneCarsViewHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Drawable mutate = holder.getMpCarBinding().mpArizonamobileCarItem.getBackground().mutate();
        Intrinsics.checkNotNull(mutate, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) mutate).setColor(Color.parseColor("#343434"));
        holder.getMpCarBinding().mpArizonamobileCarName.setText(StringsKt.substringBefore$default(this.cars.get(i).getName(), " - arizonamobil", (String) null, 2, (Object) null));
        holder.getMpCarBinding().mpArizonamobileDistance.setText(this.cars.get(i).getDistance() + " м");
        holder.getMpCarBinding().mpArizonamobileCarItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneCarsAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobilePhoneCarsAdapter.onBindViewHolder$lambda$0(MobilePhoneCarsAdapter.this, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(MobilePhoneCarsAdapter mobilePhoneCarsAdapter, int i, View view) {
        OnChoseCarClickListener onChoseCarClickListener = mobilePhoneCarsAdapter.onChoseCarClickListener;
        if (onChoseCarClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onChoseCarClickListener");
            onChoseCarClickListener = null;
        }
        onChoseCarClickListener.callback(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cars.size();
    }

    public final void addAdapterCars(List<MobilePhoneAvailableCar> cars) {
        Intrinsics.checkNotNullParameter(cars, "cars");
        this.cars.clear();
        this.cars.addAll(cars);
        notifyDataSetChanged();
    }
}
