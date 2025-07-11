package ru.mrlargha.arizonaui.family.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.FamilyMeetingsItemBinding;
import ru.mrlargha.arizonaui.family.data.CapturesItem;
/* compiled from: MeetingsAdapter.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\u0014\u0010\u0018\u001a\u00020\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u001aJ\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u0014R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006!"}, d2 = {"Lru/mrlargha/arizonaui/family/adapters/MeetingsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/family/adapters/MeetingsItemViewHolder;", "<init>", "()V", "itemsList", "", "Lru/mrlargha/arizonaui/family/data/CapturesItem;", "getItemsList", "()Ljava/util/List;", "currentZone", "", "getCurrentZone", "()Ljava/lang/String;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "addAllItems", FirebaseAnalytics.Param.ITEMS, "", "sort1", RemoteConfigConstants.ResponseFieldKey.STATE, "", "sort2", "sort3", "clearList", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MeetingsAdapter extends RecyclerView.Adapter<MeetingsItemViewHolder> {
    private final List<CapturesItem> itemsList = new ArrayList();
    private final String currentZone = "Europe/Moscow";

    public final List<CapturesItem> getItemsList() {
        return this.itemsList;
    }

    public final String getCurrentZone() {
        return this.currentZone;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MeetingsItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.family_meetings_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new MeetingsItemViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MeetingsItemViewHolder holder, int i) {
        Pair formatUnixTime;
        Intrinsics.checkNotNullParameter(holder, "holder");
        CapturesItem capturesItem = (CapturesItem) CollectionsKt.getOrNull(this.itemsList, i);
        if (capturesItem == null) {
            capturesItem = (CapturesItem) CollectionsKt.first((List<? extends Object>) this.itemsList);
        }
        FamilyMeetingsItemBinding binding = holder.getBinding();
        formatUnixTime = MeetingsAdapterKt.formatUnixTime(capturesItem.getDate_attack_unix(), this.currentZone);
        binding.data.setText((CharSequence) formatUnixTime.getFirst());
        binding.time.setText((CharSequence) formatUnixTime.getSecond());
        binding.territory.setText("№ " + capturesItem.getCapture_id_zone());
        binding.deffence1.setText(capturesItem.getFamily_name());
        binding.attack1.setText(capturesItem.getAttack_family_name());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    public final void addAllItems(List<CapturesItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        if (Intrinsics.areEqual(this.itemsList, items)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new MeetingsAdapter$addAllItems$1(this, items, null), 3, null);
    }

    public final void sort1(boolean z) {
        if (z) {
            List<CapturesItem> list = this.itemsList;
            if (list.size() > 1) {
                CollectionsKt.sortWith(list, new Comparator() { // from class: ru.mrlargha.arizonaui.family.adapters.MeetingsAdapter$sort1$$inlined$sortBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Long.valueOf(((CapturesItem) t).getDate_attack_unix()), Long.valueOf(((CapturesItem) t2).getDate_attack_unix()));
                    }
                });
            }
        } else {
            List<CapturesItem> list2 = this.itemsList;
            if (list2.size() > 1) {
                CollectionsKt.sortWith(list2, new Comparator() { // from class: ru.mrlargha.arizonaui.family.adapters.MeetingsAdapter$sort1$$inlined$sortByDescending$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Long.valueOf(((CapturesItem) t2).getDate_attack_unix()), Long.valueOf(((CapturesItem) t).getDate_attack_unix()));
                    }
                });
            }
        }
        notifyDataSetChanged();
    }

    public final void sort2(boolean z) {
        if (z) {
            List<CapturesItem> list = this.itemsList;
            if (list.size() > 1) {
                CollectionsKt.sortWith(list, new Comparator() { // from class: ru.mrlargha.arizonaui.family.adapters.MeetingsAdapter$sort2$$inlined$sortByDescending$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(((CapturesItem) t2).getCapture_id_zone()), Integer.valueOf(((CapturesItem) t).getCapture_id_zone()));
                    }
                });
            }
        } else {
            List<CapturesItem> list2 = this.itemsList;
            if (list2.size() > 1) {
                CollectionsKt.sortWith(list2, new Comparator() { // from class: ru.mrlargha.arizonaui.family.adapters.MeetingsAdapter$sort2$$inlined$sortBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(((CapturesItem) t).getCapture_id_zone()), Integer.valueOf(((CapturesItem) t2).getCapture_id_zone()));
                    }
                });
            }
        }
        notifyDataSetChanged();
    }

    public final void sort3(boolean z) {
        if (z) {
            List<CapturesItem> list = this.itemsList;
            if (list.size() > 1) {
                CollectionsKt.sortWith(list, new Comparator() { // from class: ru.mrlargha.arizonaui.family.adapters.MeetingsAdapter$sort3$$inlined$sortByDescending$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((CapturesItem) t2).getFamily_name(), ((CapturesItem) t).getFamily_name());
                    }
                });
            }
        } else {
            List<CapturesItem> list2 = this.itemsList;
            if (list2.size() > 1) {
                CollectionsKt.sortWith(list2, new Comparator() { // from class: ru.mrlargha.arizonaui.family.adapters.MeetingsAdapter$sort3$$inlined$sortBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((CapturesItem) t).getFamily_name(), ((CapturesItem) t2).getFamily_name());
                    }
                });
            }
        }
        notifyDataSetChanged();
    }

    public final void clearList() {
        this.itemsList.clear();
        notifyDataSetChanged();
    }
}
