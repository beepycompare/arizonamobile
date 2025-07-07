package ru.mrlargha.arizonaui.mobile.presentation.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.mobile.domain.obj.MobilePhoneMenu;
/* compiled from: MobilePhoneAdapter.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u0014\u0010\u001a\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001bJ\u0006\u0010\u001c\u001a\u00020\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneHolder;", "targetActivity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getTargetActivity", "()Landroid/app/Activity;", "mobileMenu", "Ljava/util/ArrayList;", "Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneMenu;", "Lkotlin/collections/ArrayList;", "onApplicationClickListener", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneAdapter$OnApplicationClickListener;", "setOnApplicationClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "addToList", "", "cleanMenu", "OnApplicationClickListener", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePhoneAdapter extends RecyclerView.Adapter<MobilePhoneHolder> {
    private final ArrayList<MobilePhoneMenu> mobileMenu;
    private OnApplicationClickListener onApplicationClickListener;
    private final Activity targetActivity;

    /* compiled from: MobilePhoneAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneAdapter$OnApplicationClickListener;", "", "callback", "", "applicationName", "", "position", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnApplicationClickListener {
        void callback(String str, int i);
    }

    public MobilePhoneAdapter(Activity targetActivity) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.targetActivity = targetActivity;
        this.mobileMenu = new ArrayList<>();
    }

    public final Activity getTargetActivity() {
        return this.targetActivity;
    }

    public final void setOnApplicationClickListener(OnApplicationClickListener onApplicationClickListener) {
        Intrinsics.checkNotNullParameter(onApplicationClickListener, "onApplicationClickListener");
        this.onApplicationClickListener = onApplicationClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MobilePhoneHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.phone_application, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new MobilePhoneHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final MobilePhoneHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getPhoneApplicationBinding().phoneApplicationContainer.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobilePhoneAdapter.onBindViewHolder$lambda$0(MobilePhoneAdapter.this, i, view);
            }
        });
        holder.getPhoneApplicationBinding().mobilePhoneTittle.setText(this.mobileMenu.get(i).getTitle());
        this.targetActivity.runOnUiThread(new Runnable() { // from class: ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneAdapter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                MobilePhoneAdapter.onBindViewHolder$lambda$1(MobilePhoneHolder.this, this, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(MobilePhoneAdapter mobilePhoneAdapter, int i, View view) {
        OnApplicationClickListener onApplicationClickListener = mobilePhoneAdapter.onApplicationClickListener;
        if (onApplicationClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onApplicationClickListener");
            onApplicationClickListener = null;
        }
        onApplicationClickListener.callback(mobilePhoneAdapter.mobileMenu.get(i).getTitle(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(MobilePhoneHolder mobilePhoneHolder, MobilePhoneAdapter mobilePhoneAdapter, int i) {
        mobilePhoneHolder.getPhoneApplicationBinding().mobilePhoneIcon.setImageDrawable(ContextCompat.getDrawable(mobilePhoneAdapter.targetActivity, mobilePhoneAdapter.mobileMenu.get(i).getImage()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mobileMenu.size();
    }

    public final void addToList(List<MobilePhoneMenu> mobileMenu) {
        Intrinsics.checkNotNullParameter(mobileMenu, "mobileMenu");
        this.mobileMenu.addAll(mobileMenu);
    }

    public final void cleanMenu() {
        this.mobileMenu.clear();
    }
}
