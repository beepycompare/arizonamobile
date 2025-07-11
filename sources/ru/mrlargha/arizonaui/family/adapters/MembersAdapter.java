package ru.mrlargha.arizonaui.family.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import ru.mrlargha.arizonaui.databinding.FamilyMembersItemBinding;
import ru.mrlargha.arizonaui.family.data.MemberItem;
/* compiled from: MembersAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\u0014\u0010\u001b\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dJ\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0010J\u000e\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0010J\u000e\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0010J\u0006\u0010#\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lru/mrlargha/arizonaui/family/adapters/MembersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/arizonaui/family/adapters/MembersViewHolder;", "onClick", "Lkotlin/Function1;", "Lru/mrlargha/arizonaui/family/data/MemberItem;", "", "onScrollFinish", "", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "itemsList", "", "getItemsList", "()Ljava/util/List;", "isRequestSend", "", "page", "_isManager", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "addAllItems", FirebaseAnalytics.Param.ITEMS, "", "setManager", "isManager", "sort1", RemoteConfigConstants.ResponseFieldKey.STATE, "sort2", "clearList", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MembersAdapter extends RecyclerView.Adapter<MembersViewHolder> {
    private boolean _isManager;
    private boolean isRequestSend;
    private final List<MemberItem> itemsList;
    private final Function1<MemberItem, Unit> onClick;
    private final Function1<Integer, Unit> onScrollFinish;
    private int page;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3$lambda$2(View view) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MembersAdapter(Function1<? super MemberItem, Unit> onClick, Function1<? super Integer, Unit> onScrollFinish) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onScrollFinish, "onScrollFinish");
        this.onClick = onClick;
        this.onScrollFinish = onScrollFinish;
        this.itemsList = new ArrayList();
        this.page = 1;
    }

    public final List<MemberItem> getItemsList() {
        return this.itemsList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MembersViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.family_members_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new MembersViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MembersViewHolder holder, int i) {
        int i2;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final MemberItem memberItem = (MemberItem) CollectionsKt.getOrNull(this.itemsList, i);
        if (memberItem == null) {
            memberItem = (MemberItem) CollectionsKt.first((List<? extends Object>) this.itemsList);
        }
        FamilyMembersItemBinding binding = holder.getBinding();
        if (memberItem.getOnline() == 1001) {
            i2 = R.drawable.family_offline_ic;
        } else {
            i2 = R.drawable.family_online_ic;
        }
        binding.onlineImage.setImageResource(i2);
        TextView textView = binding.memberName;
        if (memberItem.getOnline() == 1001) {
            str = memberItem.getName();
        } else {
            str = memberItem.getName() + " (" + memberItem.getOnline() + ")";
        }
        textView.setText(str);
        TextView textView2 = binding.memberRole;
        if (!memberItem.isLeader()) {
            str2 = memberItem.isDeputy() ? "Заместитель" : "";
        }
        textView2.setText(str2);
        binding.memberOffileTime.setVisibility(8);
        String dateOfflineString = memberItem.getDateOfflineString();
        if (dateOfflineString != null) {
            binding.memberOffileTime.setVisibility(0);
            binding.memberOffileTime.setText(dateOfflineString);
        }
        binding.rank.setText(String.valueOf(memberItem.getFamilyRank()));
        binding.warns.setText(String.valueOf(memberItem.getWarns()));
        binding.tasks.setText(String.valueOf(memberItem.getQuests()));
        if (this._isManager) {
            binding.actions.setVisibility(0);
            binding.actions.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.adapters.MembersAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MembersAdapter.onBindViewHolder$lambda$3$lambda$1(MembersAdapter.this, memberItem, view);
                }
            });
        } else {
            binding.actions.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.arizonaui.family.adapters.MembersAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MembersAdapter.onBindViewHolder$lambda$3$lambda$2(view);
                }
            });
            binding.actions.setVisibility(8);
        }
        if (i + 1 != this.itemsList.size() || this.isRequestSend || i <= 20) {
            return;
        }
        this.isRequestSend = true;
        int i3 = this.page + 1;
        this.page = i3;
        this.onScrollFinish.invoke(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3$lambda$1(MembersAdapter membersAdapter, MemberItem memberItem, View view) {
        membersAdapter.onClick.invoke(memberItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemsList.size();
    }

    public final void addAllItems(List<MemberItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.isRequestSend = false;
        if (Intrinsics.areEqual(this.itemsList, items)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new MembersAdapter$addAllItems$1(this, items, null), 3, null);
    }

    public final void setManager(boolean z) {
        Log.d("setManager", "setManager: " + z);
        this._isManager = z;
        notifyDataSetChanged();
    }

    public final void sort1(boolean z) {
        if (z) {
            List<MemberItem> list = this.itemsList;
            if (list.size() > 1) {
                CollectionsKt.sortWith(list, new Comparator() { // from class: ru.mrlargha.arizonaui.family.adapters.MembersAdapter$sort1$$inlined$sortByDescending$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(((MemberItem) t2).getOnline()), Integer.valueOf(((MemberItem) t).getOnline()));
                    }
                });
            }
        } else {
            List<MemberItem> list2 = this.itemsList;
            if (list2.size() > 1) {
                CollectionsKt.sortWith(list2, new Comparator() { // from class: ru.mrlargha.arizonaui.family.adapters.MembersAdapter$sort1$$inlined$sortBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(((MemberItem) t).getOnline()), Integer.valueOf(((MemberItem) t2).getOnline()));
                    }
                });
            }
        }
        notifyDataSetChanged();
    }

    public final void sort2(boolean z) {
        if (z) {
            List<MemberItem> list = this.itemsList;
            if (list.size() > 1) {
                CollectionsKt.sortWith(list, new Comparator() { // from class: ru.mrlargha.arizonaui.family.adapters.MembersAdapter$sort2$$inlined$sortByDescending$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(((MemberItem) t2).getQuests()), Integer.valueOf(((MemberItem) t).getQuests()));
                    }
                });
            }
        } else {
            List<MemberItem> list2 = this.itemsList;
            if (list2.size() > 1) {
                CollectionsKt.sortWith(list2, new Comparator() { // from class: ru.mrlargha.arizonaui.family.adapters.MembersAdapter$sort2$$inlined$sortBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Integer.valueOf(((MemberItem) t).getQuests()), Integer.valueOf(((MemberItem) t2).getQuests()));
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
