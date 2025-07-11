package ru.mrlargha.arizonaui.mobile.presentation.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.mobile.domain.obj.MobilePhoneCarousel;
import ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneAdapter;
import ru.mrlargha.arizonaui.mobile.presentation.adapter.ViewPageAdapter;
/* compiled from: ViewPageAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0006\u0010\u001a\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/adapter/ViewPageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/Pager2ViewHolder;", "targetActivity", "Landroid/app/Activity;", "list", "", "Lru/mrlargha/arizonaui/mobile/domain/obj/MobilePhoneCarousel;", "<init>", "(Landroid/app/Activity;Ljava/util/List;)V", "onApplicationClickListener", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/ViewPageAdapter$OnApplicationClickListener;", "adapterController", "", "", "Lru/mrlargha/arizonaui/mobile/presentation/adapter/MobilePhoneAdapter;", "setOnApplicationClickListener", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "cleanMenu", "OnApplicationClickListener", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewPageAdapter extends RecyclerView.Adapter<Pager2ViewHolder> {
    private final Map<Integer, MobilePhoneAdapter> adapterController;
    private final List<MobilePhoneCarousel> list;
    private OnApplicationClickListener onApplicationClickListener;
    private final Activity targetActivity;

    /* compiled from: ViewPageAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/adapter/ViewPageAdapter$OnApplicationClickListener;", "", "callback", "", "applicationName", "", "position", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnApplicationClickListener {
        void callback(String str, int i);
    }

    public ViewPageAdapter(Activity targetActivity, List<MobilePhoneCarousel> list) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        Intrinsics.checkNotNullParameter(list, "list");
        this.targetActivity = targetActivity;
        this.list = list;
        this.adapterController = new LinkedHashMap();
    }

    public final void setOnApplicationClickListener(OnApplicationClickListener onApplicationClickListener) {
        Intrinsics.checkNotNullParameter(onApplicationClickListener, "onApplicationClickListener");
        this.onApplicationClickListener = onApplicationClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public Pager2ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.mobile_phone_main_applications, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new Pager2ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(Pager2ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MobilePhoneAdapter mobilePhoneAdapter = new MobilePhoneAdapter(this.targetActivity);
        this.adapterController.put(Integer.valueOf(i), mobilePhoneAdapter);
        holder.getMobilePhoneMainApplicationsBinding().phoneApplicationList.setAdapter(mobilePhoneAdapter);
        RecyclerView recyclerView = holder.getMobilePhoneMainApplicationsBinding().phoneApplicationList;
        final Activity activity = this.targetActivity;
        recyclerView.setLayoutManager(new GridLayoutManager(activity) { // from class: ru.mrlargha.arizonaui.mobile.presentation.adapter.ViewPageAdapter$onBindViewHolder$1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        });
        mobilePhoneAdapter.addToList(this.list.get(i).getMobilePhoneMenu());
        mobilePhoneAdapter.setOnApplicationClickListener(new MobilePhoneAdapter.OnApplicationClickListener() { // from class: ru.mrlargha.arizonaui.mobile.presentation.adapter.ViewPageAdapter$onBindViewHolder$2
            @Override // ru.mrlargha.arizonaui.mobile.presentation.adapter.MobilePhoneAdapter.OnApplicationClickListener
            public void callback(String applicationName, int i2) {
                ViewPageAdapter.OnApplicationClickListener onApplicationClickListener;
                Intrinsics.checkNotNullParameter(applicationName, "applicationName");
                onApplicationClickListener = ViewPageAdapter.this.onApplicationClickListener;
                if (onApplicationClickListener == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("onApplicationClickListener");
                    onApplicationClickListener = null;
                }
                onApplicationClickListener.callback(applicationName, i2);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.list.size();
    }

    public final void cleanMenu() {
        for (MobilePhoneAdapter mobilePhoneAdapter : this.adapterController.values()) {
            mobilePhoneAdapter.cleanMenu();
        }
        this.adapterController.clear();
    }
}
