package ru.mrlargha.commonui.elements.quest.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.ItemQuestTaskBinding;
import ru.mrlargha.commonui.elements.quest.domain.QuestTask;
import ru.mrlargha.commonui.elements.quest.presentation.adapter.QuestTaskAdapter;
import ru.mrlargha.commonui.elements.quest.presentation.viewHolder.QuestTaskViewHolder;
/* compiled from: QuestTaskAdapter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003$%&B7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\u0014\u0010\u001b\u001a\u00020\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u000eJ\u000e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\tJ\b\u0010 \u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010!\u001a\u00020\u0010*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lru/mrlargha/commonui/elements/quest/presentation/adapter/QuestTaskAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/quest/presentation/adapter/QuestTaskAdapter$QuestTaskRow;", "Lru/mrlargha/commonui/elements/quest/presentation/viewHolder/QuestTaskViewHolder;", "context", "Landroid/content/Context;", "onItemClicked", "Lkotlin/Function1;", "Lru/mrlargha/commonui/elements/quest/domain/QuestTask;", "", "onShowClueClicked", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "sourceTasks", "", "selectedTaskKey", "Lru/mrlargha/commonui/elements/quest/presentation/adapter/QuestTaskAdapter$QuestTaskKey;", "selectedTaskExpanded", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "submitTasks", "tasks", "toggleSelection", "task", "clearSelection", "submitRows", "key", "getKey", "(Lru/mrlargha/commonui/elements/quest/domain/QuestTask;)Lru/mrlargha/commonui/elements/quest/presentation/adapter/QuestTaskAdapter$QuestTaskKey;", "Companion", "QuestTaskRow", "QuestTaskKey", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class QuestTaskAdapter extends ListAdapter<QuestTaskRow, QuestTaskViewHolder> {
    private final Context context;
    private final Function1<QuestTask, Unit> onItemClicked;
    private final Function1<QuestTask, Unit> onShowClueClicked;
    private boolean selectedTaskExpanded;
    private QuestTaskKey selectedTaskKey;
    private List<QuestTask> sourceTasks;
    public static final Companion Companion = new Companion(null);
    private static final QuestTaskAdapter$Companion$COMPARATOR$1 COMPARATOR = new DiffUtil.ItemCallback<QuestTaskRow>() { // from class: ru.mrlargha.commonui.elements.quest.presentation.adapter.QuestTaskAdapter$Companion$COMPARATOR$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(QuestTaskAdapter.QuestTaskRow oldItem, QuestTaskAdapter.QuestTaskRow newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getTask().getId() == newItem.getTask().getId() && oldItem.getTask().getStageId() == newItem.getTask().getStageId();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(QuestTaskAdapter.QuestTaskRow oldItem, QuestTaskAdapter.QuestTaskRow newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QuestTaskAdapter(Context context, Function1<? super QuestTask, Unit> onItemClicked, Function1<? super QuestTask, Unit> onShowClueClicked) {
        super(COMPARATOR);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        Intrinsics.checkNotNullParameter(onShowClueClicked, "onShowClueClicked");
        this.context = context;
        this.onItemClicked = onItemClicked;
        this.onShowClueClicked = onShowClueClicked;
        this.sourceTasks = CollectionsKt.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public QuestTaskViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemQuestTaskBinding inflate = ItemQuestTaskBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new QuestTaskViewHolder(inflate, this.onItemClicked, this.onShowClueClicked, this.context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(QuestTaskViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        QuestTaskRow item = getItem(i);
        holder.bind(item.getTask(), item.isExpanded());
    }

    public final void submitTasks(List<QuestTask> tasks) {
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        List<QuestTask> list = CollectionsKt.toList(tasks);
        this.sourceTasks = list;
        if (this.selectedTaskKey != null) {
            List<QuestTask> list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                for (QuestTask questTask : list2) {
                    if (Intrinsics.areEqual(getKey(questTask), this.selectedTaskKey)) {
                        break;
                    }
                }
            }
            this.selectedTaskKey = null;
            this.selectedTaskExpanded = false;
        }
        submitRows();
    }

    public final void toggleSelection(QuestTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        QuestTaskKey key = getKey(task);
        if (Intrinsics.areEqual(this.selectedTaskKey, key)) {
            this.selectedTaskExpanded = !this.selectedTaskExpanded;
        } else {
            this.selectedTaskKey = key;
            this.selectedTaskExpanded = true;
        }
        submitRows();
    }

    public final void clearSelection() {
        if (this.selectedTaskKey == null) {
            return;
        }
        this.selectedTaskKey = null;
        this.selectedTaskExpanded = false;
        submitRows();
    }

    private final void submitRows() {
        QuestTaskKey questTaskKey = this.selectedTaskKey;
        List<QuestTask> list = this.sourceTasks;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (QuestTask questTask : list) {
            arrayList.add(new QuestTaskRow(questTask, this.selectedTaskExpanded && Intrinsics.areEqual(getKey(questTask), questTaskKey)));
        }
        submitList(arrayList);
    }

    /* compiled from: QuestTaskAdapter.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/quest/presentation/adapter/QuestTaskAdapter$Companion;", "", "<init>", "()V", "COMPARATOR", "ru/mrlargha/commonui/elements/quest/presentation/adapter/QuestTaskAdapter$Companion$COMPARATOR$1", "Lru/mrlargha/commonui/elements/quest/presentation/adapter/QuestTaskAdapter$Companion$COMPARATOR$1;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: QuestTaskAdapter.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/quest/presentation/adapter/QuestTaskAdapter$QuestTaskRow;", "", "task", "Lru/mrlargha/commonui/elements/quest/domain/QuestTask;", "isExpanded", "", "<init>", "(Lru/mrlargha/commonui/elements/quest/domain/QuestTask;Z)V", "getTask", "()Lru/mrlargha/commonui/elements/quest/domain/QuestTask;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class QuestTaskRow {
        private final boolean isExpanded;
        private final QuestTask task;

        public static /* synthetic */ QuestTaskRow copy$default(QuestTaskRow questTaskRow, QuestTask questTask, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                questTask = questTaskRow.task;
            }
            if ((i & 2) != 0) {
                z = questTaskRow.isExpanded;
            }
            return questTaskRow.copy(questTask, z);
        }

        public final QuestTask component1() {
            return this.task;
        }

        public final boolean component2() {
            return this.isExpanded;
        }

        public final QuestTaskRow copy(QuestTask task, boolean z) {
            Intrinsics.checkNotNullParameter(task, "task");
            return new QuestTaskRow(task, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof QuestTaskRow) {
                QuestTaskRow questTaskRow = (QuestTaskRow) obj;
                return Intrinsics.areEqual(this.task, questTaskRow.task) && this.isExpanded == questTaskRow.isExpanded;
            }
            return false;
        }

        public int hashCode() {
            return (this.task.hashCode() * 31) + Boolean.hashCode(this.isExpanded);
        }

        public String toString() {
            QuestTask questTask = this.task;
            return "QuestTaskRow(task=" + questTask + ", isExpanded=" + this.isExpanded + ")";
        }

        public QuestTaskRow(QuestTask task, boolean z) {
            Intrinsics.checkNotNullParameter(task, "task");
            this.task = task;
            this.isExpanded = z;
        }

        public final QuestTask getTask() {
            return this.task;
        }

        public final boolean isExpanded() {
            return this.isExpanded;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: QuestTaskAdapter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/quest/presentation/adapter/QuestTaskAdapter$QuestTaskKey;", "", "stageId", "", "taskId", "<init>", "(II)V", "getStageId", "()I", "getTaskId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class QuestTaskKey {
        private final int stageId;
        private final int taskId;

        public static /* synthetic */ QuestTaskKey copy$default(QuestTaskKey questTaskKey, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = questTaskKey.stageId;
            }
            if ((i3 & 2) != 0) {
                i2 = questTaskKey.taskId;
            }
            return questTaskKey.copy(i, i2);
        }

        public final int component1() {
            return this.stageId;
        }

        public final int component2() {
            return this.taskId;
        }

        public final QuestTaskKey copy(int i, int i2) {
            return new QuestTaskKey(i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof QuestTaskKey) {
                QuestTaskKey questTaskKey = (QuestTaskKey) obj;
                return this.stageId == questTaskKey.stageId && this.taskId == questTaskKey.taskId;
            }
            return false;
        }

        public int hashCode() {
            return (Integer.hashCode(this.stageId) * 31) + Integer.hashCode(this.taskId);
        }

        public String toString() {
            int i = this.stageId;
            return "QuestTaskKey(stageId=" + i + ", taskId=" + this.taskId + ")";
        }

        public QuestTaskKey(int i, int i2) {
            this.stageId = i;
            this.taskId = i2;
        }

        public final int getStageId() {
            return this.stageId;
        }

        public final int getTaskId() {
            return this.taskId;
        }
    }

    private final QuestTaskKey getKey(QuestTask questTask) {
        return new QuestTaskKey(questTask.getStageId(), questTask.getId());
    }
}
