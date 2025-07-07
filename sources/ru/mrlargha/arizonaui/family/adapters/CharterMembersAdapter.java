package ru.mrlargha.arizonaui.family.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Comparator;
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
import ru.mrlargha.arizonaui.databinding.FamilyCharterMembersItemBinding;
import ru.mrlargha.arizonaui.family.data.CharterItem;
/* compiled from: CharterMembersAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\u0014\u0010\u001a\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001cJ\u000e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0010J\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0010J\u000e\u0010 \u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0010J\u000e\u0010!\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0010J\u0006\u0010\"\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lru/mrlargha/arizonaui/family/adapters/CharterMembersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/family/adapters/CharterMembersViewHolder;", "onClick", "Lkotlin/Function1;", "Lru/mrlargha/arizonaui/family/data/CharterItem;", "", "onScrollFinish", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "itemsList", "", "getItemsList", "()Ljava/util/List;", "isRequestSend", "", "page", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "addAllItems", FirebaseAnalytics.Param.ITEMS, "", "sort1", RemoteConfigConstants.ResponseFieldKey.STATE, "sort2", "sort3", "sort4", "clearList", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CharterMembersAdapter extends RecyclerView.Adapter<CharterMembersViewHolder> {
    private boolean isRequestSend;
    private final List<CharterItem> itemsList;
    private final Function1<CharterItem, Unit> onClick;
    private final Function1<Integer, Unit> onScrollFinish;
    private int page;

    /* JADX WARN: Multi-variable type inference failed */
    public CharterMembersAdapter(Function1<? super CharterItem, Unit> onClick, Function1<? super Integer, Unit> onScrollFinish) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onScrollFinish, "onScrollFinish");
        this.onClick = onClick;
        this.onScrollFinish = onScrollFinish;
        this.itemsList = new ArrayList();
        this.page = 1;
    }

    public final List<CharterItem> getItemsList() {
        return this.itemsList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CharterMembersViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.family_charter_members_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new CharterMembersViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CharterMembersViewHolder holder, int i) {
        int i2;
        String str;
        ImageView imageView;
        int i3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final CharterItem charterItem = (CharterItem) CollectionsKt.getOrNull(this.itemsList, i);
        if (charterItem == null) {
            charterItem = (CharterItem) CollectionsKt.first((List<? extends Object>) this.itemsList);
        }
        FamilyCharterMembersItemBinding binding = holder.getBinding();
        if (charterItem.getOnline() == 1001) {
            i2 = R.drawable.family_offline_ic;
        } else {
            i2 = R.drawable.family_online_ic;
        }
        binding.onlineImage.setImageResource(i2);
        binding.memberName.setText(charterItem.getName());
        TextView textView = binding.memberRole;
        if (!charterItem.isLeader()) {
            str = charterItem.isDeputy() ? "Заместитель" : "";
        }
        textView.setText(str);
        if (charterItem.isPaidRank()) {
            imageView = binding.isPaid;
            i3 = 0;
        } else {
            imageView = binding.isPaid;
            i3 = 4;
        }
        imageView.setVisibility(i3);
        binding.rank.setText(String.valueOf(charterItem.getFractionRank()));
        binding.time.setText(String.valueOf(charterItem.getFractionDays()));
        binding.button.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.adapters.CharterMembersAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CharterMembersAdapter.onBindViewHolder$lambda$1$lambda$0(CharterMembersAdapter.this, charterItem, view);
            }
        });
        if (i + 1 != this.itemsList.size() || this.isRequestSend || i <= 20) {
            return;
        }
        this.isRequestSend = true;
        int i4 = this.page + 1;
        this.page = i4;
        this.onScrollFinish.invoke(Integer.valueOf(i4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(CharterMembersAdapter charterMembersAdapter, CharterItem charterItem, View view) {
        charterMembersAdapter.onClick.invoke(charterItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    public final void addAllItems(List<CharterItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.isRequestSend = false;
        if (Intrinsics.areEqual(this.itemsList, items)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CharterMembersAdapter$addAllItems$1(this, items, null), 3, null);
    }

    public final void sort1(boolean z) {
        if (z) {
            List<CharterItem> list = this.itemsList;
            if (list.size() > 1) {
                CollectionsKt.sortWith(list, new Comparator() { // from class: ru.mrlargha.arizonaui.family.adapters.CharterMembersAdapter$sort1$$inlined$sortBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(((CharterItem) t).getOnline()), Integer.valueOf(((CharterItem) t2).getOnline()));
                    }
                });
            }
        } else {
            List<CharterItem> list2 = this.itemsList;
            if (list2.size() > 1) {
                CollectionsKt.sortWith(list2, new Comparator() { // from class: ru.mrlargha.arizonaui.family.adapters.CharterMembersAdapter$sort1$$inlined$sortByDescending$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(((CharterItem) t2).getOnline()), Integer.valueOf(((CharterItem) t).getOnline()));
                    }
                });
            }
        }
        notifyDataSetChanged();
    }

    public final void sort2(boolean z) {
        if (z) {
            List<CharterItem> list = this.itemsList;
            if (list.size() > 1) {
                CollectionsKt.sortWith(list, new Comparator() { // from class: ru.mrlargha.arizonaui.family.adapters.CharterMembersAdapter$sort2$$inlined$sortBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Boolean.valueOf(((CharterItem) t).isPaidRank()), Boolean.valueOf(((CharterItem) t2).isPaidRank()));
                    }
                });
            }
        } else {
            List<CharterItem> list2 = this.itemsList;
            if (list2.size() > 1) {
                CollectionsKt.sortWith(list2, new Comparator() { // from class: ru.mrlargha.arizonaui.family.adapters.CharterMembersAdapter$sort2$$inlined$sortByDescending$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Boolean.valueOf(((CharterItem) t2).isPaidRank()), Boolean.valueOf(((CharterItem) t).isPaidRank()));
                    }
                });
            }
        }
        notifyDataSetChanged();
    }

    public final void sort3(boolean z) {
        if (z) {
            List<CharterItem> list = this.itemsList;
            if (list.size() > 1) {
                CollectionsKt.sortWith(list, new Comparator() { // from class: ru.mrlargha.arizonaui.family.adapters.CharterMembersAdapter$sort3$$inlined$sortBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(((CharterItem) t).getFractionRank()), Integer.valueOf(((CharterItem) t2).getFractionRank()));
                    }
                });
            }
        } else {
            List<CharterItem> list2 = this.itemsList;
            if (list2.size() > 1) {
                CollectionsKt.sortWith(list2, new Comparator() { // from class: ru.mrlargha.arizonaui.family.adapters.CharterMembersAdapter$sort3$$inlined$sortByDescending$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(((CharterItem) t2).getFractionRank()), Integer.valueOf(((CharterItem) t).getFractionRank()));
                    }
                });
            }
        }
        notifyDataSetChanged();
    }

    public final void sort4(boolean z) {
        if (z) {
            List<CharterItem> list = this.itemsList;
            if (list.size() > 1) {
                CollectionsKt.sortWith(list, new Comparator() { // from class: ru.mrlargha.arizonaui.family.adapters.CharterMembersAdapter$sort4$$inlined$sortBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(((CharterItem) t).getFractionDays()), Integer.valueOf(((CharterItem) t2).getFractionDays()));
                    }
                });
            }
        } else {
            List<CharterItem> list2 = this.itemsList;
            if (list2.size() > 1) {
                CollectionsKt.sortWith(list2, new Comparator() { // from class: ru.mrlargha.arizonaui.family.adapters.CharterMembersAdapter$sort4$$inlined$sortByDescending$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(((CharterItem) t2).getFractionDays()), Integer.valueOf(((CharterItem) t).getFractionDays()));
                    }
                });
            }
        }
        notifyDataSetChanged();
    }

    public final void clearList() {
        this.page = 1;
        this.isRequestSend = false;
        this.itemsList.clear();
        notifyDataSetChanged();
    }
}
