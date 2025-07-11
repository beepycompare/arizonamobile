package ru.mrlargha.commonui.elements.employmentNote.presentation.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.ItemEmploymentHistoryBinding;
import ru.mrlargha.commonui.elements.employmentNote.domain.TaskHistory;
/* compiled from: EmploymentHistoryAdapter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u0010"}, d2 = {"Lru/mrlargha/commonui/elements/employmentNote/presentation/adapter/EmploymentHistoryAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/employmentNote/domain/TaskHistory;", "Lru/mrlargha/commonui/elements/employmentNote/presentation/adapter/EmploymentHistoryViewHolder;", "<init>", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmploymentHistoryAdapter extends ListAdapter<TaskHistory, EmploymentHistoryViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final EmploymentHistoryAdapter$Companion$COMPARATOR$1 COMPARATOR = new DiffUtil.ItemCallback<TaskHistory>() { // from class: ru.mrlargha.commonui.elements.employmentNote.presentation.adapter.EmploymentHistoryAdapter$Companion$COMPARATOR$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(TaskHistory oldItem, TaskHistory newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getDate(), newItem.getDate());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(TaskHistory oldItem, TaskHistory newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    public EmploymentHistoryAdapter() {
        super(COMPARATOR);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public EmploymentHistoryViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemEmploymentHistoryBinding inflate = ItemEmploymentHistoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new EmploymentHistoryViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(EmploymentHistoryViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        TaskHistory item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item);
    }

    /* compiled from: EmploymentHistoryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/employmentNote/presentation/adapter/EmploymentHistoryAdapter$Companion;", "", "<init>", "()V", "COMPARATOR", "ru/mrlargha/commonui/elements/employmentNote/presentation/adapter/EmploymentHistoryAdapter$Companion$COMPARATOR$1", "Lru/mrlargha/commonui/elements/employmentNote/presentation/adapter/EmploymentHistoryAdapter$Companion$COMPARATOR$1;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
