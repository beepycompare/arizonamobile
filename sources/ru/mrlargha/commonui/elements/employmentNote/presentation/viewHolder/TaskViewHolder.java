package ru.mrlargha.commonui.elements.employmentNote.presentation.viewHolder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.ItemTasksBinding;
import ru.mrlargha.commonui.elements.employmentNote.domain.FractionTasks;
import ru.mrlargha.commonui.elements.employmentNote.domain.TaskInfo;
import ru.mrlargha.commonui.elements.employmentNote.presentation.adapter.TaskRewardAdapter;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: TaskViewHolder.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/employmentNote/presentation/viewHolder/TaskViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemTasksBinding;", "onItemClicked", "Lkotlin/Function2;", "Lru/mrlargha/commonui/elements/employmentNote/domain/TaskInfo;", "", "", "onShowClueClicked", "Lkotlin/Function1;", "Lru/mrlargha/commonui/elements/employmentNote/domain/FractionTasks;", "context", "Landroid/content/Context;", "<init>", "(Lru/mrlargha/commonui/databinding/ItemTasksBinding;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroid/content/Context;)V", "bind", "item", "position", "selectedItemPosition", "isVisible", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TaskViewHolder extends RecyclerView.ViewHolder {
    private final ItemTasksBinding binding;
    private final Context context;
    private final Function2<TaskInfo, Integer, Unit> onItemClicked;
    private final Function1<FractionTasks, Unit> onShowClueClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TaskViewHolder(ItemTasksBinding binding, Function2<? super TaskInfo, ? super Integer, Unit> onItemClicked, Function1<? super FractionTasks, Unit> onShowClueClicked, Context context) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        Intrinsics.checkNotNullParameter(onShowClueClicked, "onShowClueClicked");
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding = binding;
        this.onItemClicked = onItemClicked;
        this.onShowClueClicked = onShowClueClicked;
        this.context = context;
    }

    public final void bind(final TaskInfo item, final int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(item, "item");
        ItemTasksBinding itemTasksBinding = this.binding;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : UtilsKt.getFractionTasks()) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            FractionTasks fractionTasks = (FractionTasks) obj;
            if (item.getId() == i3) {
                arrayList.add(obj);
            }
            i3 = i4;
        }
        final ArrayList arrayList2 = arrayList;
        TaskRewardAdapter taskRewardAdapter = new TaskRewardAdapter();
        itemTasksBinding.rvTaskRewards.setAdapter(taskRewardAdapter);
        if (!arrayList2.isEmpty()) {
            Log.d("frontend", "bind: " + arrayList2);
            itemTasksBinding.bg.setBackground(null);
            if (item.getCompleted() == 1) {
                itemTasksBinding.parentLayout.setBackgroundTintList(ColorStateList.valueOf(this.context.getColor(R.color.green_type5)));
                itemTasksBinding.ivItemIcon.setImageResource(R.drawable.ic_task_done);
                Button btnShowClue = itemTasksBinding.btnShowClue;
                Intrinsics.checkNotNullExpressionValue(btnShowClue, "btnShowClue");
                btnShowClue.setVisibility(8);
            } else {
                itemTasksBinding.parentLayout.setBackgroundTintList(ColorStateList.valueOf(this.context.getColor(R.color.black_type2)));
                Button btnShowClue2 = itemTasksBinding.btnShowClue;
                Intrinsics.checkNotNullExpressionValue(btnShowClue2, "btnShowClue");
                btnShowClue2.setVisibility(0);
                switch (((FractionTasks) arrayList2.get(0)).getType()) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        itemTasksBinding.ivItemIcon.setImageResource(R.drawable.ic_task_info);
                        break;
                    case 4:
                        itemTasksBinding.bg.setBackgroundResource(R.drawable.employement_task_bg_daily);
                        itemTasksBinding.ivItemIcon.setImageResource(R.drawable.ic_daily_task);
                        break;
                    case 5:
                        itemTasksBinding.bg.setBackgroundResource(R.drawable.employement_task_bg_global);
                        itemTasksBinding.ivItemIcon.setImageResource(R.drawable.ic_global_task);
                        break;
                    case 6:
                        itemTasksBinding.ivItemIcon.setImageResource(R.drawable.ic_vicecity_task);
                        break;
                }
            }
            itemTasksBinding.btnShowClue.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.employmentNote.presentation.viewHolder.TaskViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TaskViewHolder.bind$lambda$3$lambda$1(TaskViewHolder.this, arrayList2, view);
                }
            });
            itemTasksBinding.tvTaskInfo.setText(((FractionTasks) arrayList2.get(0)).getTitle());
            itemTasksBinding.tvTaskDescription.setText(((FractionTasks) arrayList2.get(0)).getDescription());
            taskRewardAdapter.submitList(((FractionTasks) arrayList2.get(0)).getRedwards());
        }
        itemTasksBinding.tvTasksDone.setText(String.valueOf(item.getProgress()));
        itemTasksBinding.tvTasksRemain.setText(RemoteSettings.FORWARD_SLASH_STRING + item.getMax());
        itemTasksBinding.progressBar.setMax(item.getMax());
        itemTasksBinding.progressBar.setProgress(item.getProgress());
        itemTasksBinding.linearItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.employmentNote.presentation.viewHolder.TaskViewHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskViewHolder.bind$lambda$3$lambda$2(TaskViewHolder.this, item, i, view);
            }
        });
        if (i == i2) {
            ConstraintLayout expandedLayout = itemTasksBinding.expandedLayout;
            Intrinsics.checkNotNullExpressionValue(expandedLayout, "expandedLayout");
            expandedLayout.setVisibility(0);
            itemTasksBinding.ivTaskShow.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_task_close_arrow));
            if (z) {
                ConstraintLayout expandedLayout2 = itemTasksBinding.expandedLayout;
                Intrinsics.checkNotNullExpressionValue(expandedLayout2, "expandedLayout");
                expandedLayout2.setVisibility(8);
                itemTasksBinding.ivTaskShow.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_task_open_arrow));
                return;
            }
            return;
        }
        ConstraintLayout expandedLayout3 = itemTasksBinding.expandedLayout;
        Intrinsics.checkNotNullExpressionValue(expandedLayout3, "expandedLayout");
        expandedLayout3.setVisibility(8);
        itemTasksBinding.ivTaskShow.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ic_task_open_arrow));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void bind$lambda$3$lambda$1(TaskViewHolder taskViewHolder, List list, View view) {
        taskViewHolder.onShowClueClicked.invoke(list.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$3$lambda$2(TaskViewHolder taskViewHolder, TaskInfo taskInfo, int i, View view) {
        taskViewHolder.onItemClicked.invoke(taskInfo, Integer.valueOf(i));
    }
}
