package ru.mrlargha.arizonaui.family.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.databinding.FamilyTerritoriesItemBinding;
import ru.mrlargha.arizonaui.family.data.FrameMapData;
import ru.mrlargha.arizonaui.family.data.GangZoneItem;
import ru.mrlargha.arizonaui.family.data.UniqCellItem;
/* compiled from: TerritoryAdapter.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\u0014\u0010\u001d\u001a\u00020\u00062\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u0014\u0010\u001f\u001a\u00020\u00062\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0012J\u0006\u0010!\u001a\u00020\u0006J\u0006\u0010\"\u001a\u00020\u0006J\u0006\u0010#\u001a\u00020\u0006J\u0006\u0010$\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lru/mrlargha/arizonaui/family/adapters/TerritoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/family/adapters/TerritoriesItemViewHolder;", "onClick", "Lkotlin/Function1;", "Lru/mrlargha/arizonaui/family/data/FrameMapData;", "", "onGPS", "Lru/mrlargha/arizonaui/family/data/GangZoneItem;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "itemsList", "", "getItemsList", "()Ljava/util/List;", "isRequestSend", "", "uniqData", "", "Lru/mrlargha/arizonaui/family/data/UniqCellItem;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "addUniq", "data", "addAllItems", FirebaseAnalytics.Param.ITEMS, "sort1", "sort2", "sort3", "clearList", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TerritoryAdapter extends RecyclerView.Adapter<TerritoriesItemViewHolder> {
    private boolean isRequestSend;
    private final List<GangZoneItem> itemsList;
    private final Function1<FrameMapData, Unit> onClick;
    private final Function1<GangZoneItem, Unit> onGPS;
    private List<UniqCellItem> uniqData;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$5$lambda$0(View view) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TerritoryAdapter(Function1<? super FrameMapData, Unit> onClick, Function1<? super GangZoneItem, Unit> onGPS) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onGPS, "onGPS");
        this.onClick = onClick;
        this.onGPS = onGPS;
        this.itemsList = new ArrayList();
        this.uniqData = CollectionsKt.emptyList();
    }

    public final List<GangZoneItem> getItemsList() {
        return this.itemsList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TerritoriesItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.family_territories_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new TerritoriesItemViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TerritoriesItemViewHolder holder, int i) {
        Object obj;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final GangZoneItem gangZoneItem = (GangZoneItem) CollectionsKt.getOrNull(this.itemsList, i);
        if (gangZoneItem == null) {
            gangZoneItem = (GangZoneItem) CollectionsKt.first((List<? extends Object>) this.itemsList);
        }
        FamilyTerritoriesItemBinding binding = holder.getBinding();
        binding.uniq.setVisibility(4);
        binding.infoBtn.setVisibility(4);
        binding.infoBtn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.adapters.TerritoryAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TerritoryAdapter.onBindViewHolder$lambda$5$lambda$0(view);
            }
        });
        Iterator<T> it = this.uniqData.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((UniqCellItem) obj).getId() == gangZoneItem.getId()) {
                break;
            }
        }
        final UniqCellItem uniqCellItem = (UniqCellItem) obj;
        if (uniqCellItem != null) {
            binding.uniq.setVisibility(0);
            binding.infoBtn.setVisibility(0);
            binding.infoBtn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.adapters.TerritoryAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TerritoryAdapter.onBindViewHolder$lambda$5$lambda$3$lambda$2(GangZoneItem.this, uniqCellItem, this, view);
                }
            });
        }
        binding.title.setText("№ " + gangZoneItem.getId());
        binding.coins.setText(String.valueOf(gangZoneItem.getFamily_moneta()));
        binding.money.setText(gangZoneItem.getFamily_money() + " $");
        binding.gpsButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.adapters.TerritoryAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TerritoryAdapter.onBindViewHolder$lambda$5$lambda$4(TerritoryAdapter.this, gangZoneItem, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$5$lambda$3$lambda$2(GangZoneItem gangZoneItem, UniqCellItem uniqCellItem, TerritoryAdapter territoryAdapter, View view) {
        territoryAdapter.onClick.invoke(new FrameMapData(gangZoneItem.getId(), gangZoneItem != null ? gangZoneItem.getFamily_name() : null, gangZoneItem != null ? Integer.valueOf(gangZoneItem.getFamily_flag()) : null, gangZoneItem != null ? Integer.valueOf(gangZoneItem.getFamily_logo()) : null, gangZoneItem != null ? Integer.valueOf(gangZoneItem.getFamily_money()) : null, gangZoneItem != null ? Integer.valueOf(gangZoneItem.getFamily_moneta()) : null, uniqCellItem != null ? uniqCellItem.getName() : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$5$lambda$4(TerritoryAdapter territoryAdapter, GangZoneItem gangZoneItem, View view) {
        territoryAdapter.onGPS.invoke(gangZoneItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    public final void addUniq(List<UniqCellItem> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.uniqData = data;
        notifyDataSetChanged();
    }

    public final void addAllItems(List<GangZoneItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.isRequestSend = false;
        if (Intrinsics.areEqual(this.itemsList, items)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new TerritoryAdapter$addAllItems$1(this, items, null), 3, null);
    }

    public final void sort1() {
        List<GangZoneItem> list = this.itemsList;
        if (list.size() > 1) {
            CollectionsKt.sortWith(list, new Comparator() { // from class: ru.mrlargha.arizonaui.family.adapters.TerritoryAdapter$sort1$$inlined$sortBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((GangZoneItem) t).getId()), Integer.valueOf(((GangZoneItem) t2).getId()));
                }
            });
        }
        notifyDataSetChanged();
    }

    public final void sort2() {
        List<GangZoneItem> list = this.itemsList;
        if (list.size() > 1) {
            CollectionsKt.sortWith(list, new Comparator() { // from class: ru.mrlargha.arizonaui.family.adapters.TerritoryAdapter$sort2$$inlined$sortByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((GangZoneItem) t2).getFamily_moneta()), Integer.valueOf(((GangZoneItem) t).getFamily_moneta()));
                }
            });
        }
        notifyDataSetChanged();
    }

    public final void sort3() {
        List<GangZoneItem> list = this.itemsList;
        if (list.size() > 1) {
            CollectionsKt.sortWith(list, new Comparator() { // from class: ru.mrlargha.arizonaui.family.adapters.TerritoryAdapter$sort3$$inlined$sortByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((GangZoneItem) t2).getFamily_money()), Integer.valueOf(((GangZoneItem) t).getFamily_money()));
                }
            });
        }
        notifyDataSetChanged();
    }

    public final void clearList() {
        this.isRequestSend = false;
        this.itemsList.clear();
        notifyDataSetChanged();
    }
}
