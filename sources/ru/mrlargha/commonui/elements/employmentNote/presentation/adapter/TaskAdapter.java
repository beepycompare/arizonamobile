package ru.mrlargha.commonui.elements.employmentNote.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.ItemTasksBinding;
import ru.mrlargha.commonui.elements.employmentNote.domain.FractionTasks;
import ru.mrlargha.commonui.elements.employmentNote.domain.TaskInfo;
import ru.mrlargha.commonui.elements.employmentNote.presentation.viewHolder.TaskViewHolder;
/* compiled from: TaskAdapter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001!B=\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lru/mrlargha/commonui/elements/employmentNote/presentation/adapter/TaskAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/employmentNote/domain/TaskInfo;", "Lru/mrlargha/commonui/elements/employmentNote/presentation/viewHolder/TaskViewHolder;", "context", "Landroid/content/Context;", "onItemClicked", "Lkotlin/Function2;", "", "", "onShowClueClicked", "Lkotlin/Function1;", "Lru/mrlargha/commonui/elements/employmentNote/domain/FractionTasks;", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "selectedItemPosition", "getSelectedItemPosition", "()I", "setSelectedItemPosition", "(I)V", "expandedViewVisible", "", "getExpandedViewVisible", "()Z", "setExpandedViewVisible", "(Z)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TaskAdapter extends ListAdapter<TaskInfo, TaskViewHolder> {
    private final Context context;
    private boolean expandedViewVisible;
    private final Function2<TaskInfo, Integer, Unit> onItemClicked;
    private final Function1<FractionTasks, Unit> onShowClueClicked;
    private int selectedItemPosition;
    public static final Companion Companion = new Companion(null);
    private static final TaskAdapter$Companion$COMPARATOR$1 COMPARATOR = new DiffUtil.ItemCallback<TaskInfo>() { // from class: ru.mrlargha.commonui.elements.employmentNote.presentation.adapter.TaskAdapter$Companion$COMPARATOR$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(TaskInfo oldItem, TaskInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getId() == newItem.getId();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(TaskInfo oldItem, TaskInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TaskAdapter(Context context, Function2<? super TaskInfo, ? super Integer, Unit> onItemClicked, Function1<? super FractionTasks, Unit> onShowClueClicked) {
        super(COMPARATOR);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        Intrinsics.checkNotNullParameter(onShowClueClicked, "onShowClueClicked");
        this.context = context;
        this.onItemClicked = onItemClicked;
        this.onShowClueClicked = onShowClueClicked;
        this.selectedItemPosition = -1;
    }

    public final int getSelectedItemPosition() {
        return this.selectedItemPosition;
    }

    public final void setSelectedItemPosition(int i) {
        this.selectedItemPosition = i;
    }

    public final boolean getExpandedViewVisible() {
        return this.expandedViewVisible;
    }

    public final void setExpandedViewVisible(boolean z) {
        this.expandedViewVisible = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemTasksBinding inflate = ItemTasksBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new TaskViewHolder(inflate, this.onItemClicked, this.onShowClueClicked, this.context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TaskViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        TaskInfo item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item, i, this.selectedItemPosition, this.expandedViewVisible);
    }

    /* compiled from: TaskAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/employmentNote/presentation/adapter/TaskAdapter$Companion;", "", "<init>", "()V", "COMPARATOR", "ru/mrlargha/commonui/elements/employmentNote/presentation/adapter/TaskAdapter$Companion$COMPARATOR$1", "Lru/mrlargha/commonui/elements/employmentNote/presentation/adapter/TaskAdapter$Companion$COMPARATOR$1;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
