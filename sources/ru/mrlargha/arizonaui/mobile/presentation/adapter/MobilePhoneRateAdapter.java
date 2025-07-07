package ru.mrlargha.arizonaui.mobile.presentation.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.mobile.domain.obj.MobilePhoneRate;
/* compiled from: MobilePhoneRateAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneRateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneRateViewHolder;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "rates", "", "Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneRate;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePhoneRateAdapter extends RecyclerView.Adapter<MobilePhoneRateViewHolder> {
    private final Activity activity;
    private final List<MobilePhoneRate> rates;

    public MobilePhoneRateAdapter(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.rates = CollectionsKt.listOf((Object[]) new MobilePhoneRate[]{new MobilePhoneRate("1", true), new MobilePhoneRate(ExifInterface.GPS_MEASUREMENT_2D, true), new MobilePhoneRate(ExifInterface.GPS_MEASUREMENT_3D, true), new MobilePhoneRate("4", false), new MobilePhoneRate("5", false)});
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MobilePhoneRateViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.mobile_phone_uber_rate_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new MobilePhoneRateViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MobilePhoneRateViewHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (this.rates.get(i).isActive()) {
            holder.getUberRate().mpUberRateItem.setBackground(ContextCompat.getDrawable(this.activity, R.drawable.ic_star_active));
        } else {
            holder.getUberRate().mpUberRateItem.setBackground(ContextCompat.getDrawable(this.activity, R.drawable.ic_star_disable));
        }
        holder.getUberRate().mpUberRateItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneRateAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobilePhoneRateAdapter.onBindViewHolder$lambda$2(MobilePhoneRateAdapter.this, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(MobilePhoneRateAdapter mobilePhoneRateAdapter, int i, View view) {
        int i2;
        Iterator<T> it = mobilePhoneRateAdapter.rates.iterator();
        while (true) {
            i2 = 0;
            if (!it.hasNext()) {
                break;
            }
            ((MobilePhoneRate) it.next()).setActive(false);
        }
        for (Object obj : mobilePhoneRateAdapter.rates) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MobilePhoneRate mobilePhoneRate = (MobilePhoneRate) obj;
            if (i2 == i) {
                mobilePhoneRate.setActive(true);
                mobilePhoneRateAdapter.notifyDataSetChanged();
                return;
            }
            mobilePhoneRate.setActive(true);
            i2 = i3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.rates.size();
    }
}
