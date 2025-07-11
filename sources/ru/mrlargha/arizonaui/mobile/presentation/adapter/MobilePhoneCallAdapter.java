package ru.mrlargha.arizonaui.mobile.presentation.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
/* compiled from: MobilePhoneCallAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneCallAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneCallHolder;", "targetActivity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getTargetActivity", "()Landroid/app/Activity;", "listButtons", "", "", "onCallButtonClickListener", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneCallAdapter$OnCallButtonClickListener;", "setOnCallButtonClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "OnCallButtonClickListener", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePhoneCallAdapter extends RecyclerView.Adapter<MobilePhoneCallHolder> {
    private final List<String> listButtons;
    private OnCallButtonClickListener onCallButtonClickListener;
    private final Activity targetActivity;

    /* compiled from: MobilePhoneCallAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneCallAdapter$OnCallButtonClickListener;", "", "callback", "", "number", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnCallButtonClickListener {
        void callback(String str);
    }

    public final Activity getTargetActivity() {
        return this.targetActivity;
    }

    public MobilePhoneCallAdapter(Activity targetActivity) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.targetActivity = targetActivity;
        this.listButtons = CollectionsKt.listOf((Object[]) new String[]{"1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", NotificationCompat.CATEGORY_CALL, "0", "decline"});
    }

    public final void setOnCallButtonClickListener(OnCallButtonClickListener onCallButtonClickListener) {
        Intrinsics.checkNotNullParameter(onCallButtonClickListener, "onCallButtonClickListener");
        this.onCallButtonClickListener = onCallButtonClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MobilePhoneCallHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.phone_call_menu, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new MobilePhoneCallHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MobilePhoneCallHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getPhoneCallMenuBinding().mpCallMenuNumber.setText(this.listButtons.get(i));
        if (Intrinsics.areEqual(this.listButtons.get(i), NotificationCompat.CATEGORY_CALL)) {
            holder.getPhoneCallMenuBinding().mpCallMenu.setBackground(ContextCompat.getDrawable(this.targetActivity, R.drawable.mp_call_button));
            holder.getPhoneCallMenuBinding().mpCallMenuNumber.setText("");
        }
        if (Intrinsics.areEqual(this.listButtons.get(i), "decline")) {
            holder.getPhoneCallMenuBinding().mpCallMenu.setBackground(ContextCompat.getDrawable(this.targetActivity, R.drawable.mp_decline_call_button));
            holder.getPhoneCallMenuBinding().mpCallMenuNumber.setText("");
        }
        holder.getPhoneCallMenuBinding().mpCallMenu.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneCallAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobilePhoneCallAdapter.onBindViewHolder$lambda$0(MobilePhoneCallAdapter.this, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(MobilePhoneCallAdapter mobilePhoneCallAdapter, int i, View view) {
        OnCallButtonClickListener onCallButtonClickListener = mobilePhoneCallAdapter.onCallButtonClickListener;
        if (onCallButtonClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onCallButtonClickListener");
            onCallButtonClickListener = null;
        }
        onCallButtonClickListener.callback(mobilePhoneCallAdapter.listButtons.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.listButtons.size();
    }
}
