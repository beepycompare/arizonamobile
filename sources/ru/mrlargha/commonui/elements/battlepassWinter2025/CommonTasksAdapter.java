package ru.mrlargha.commonui.elements.battlepassWinter2025;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.WinterBattlepassCommonTaskItemBinding;
import ru.mrlargha.commonui.elements.battlepassWinter2025.data.CategoryType;
import ru.mrlargha.commonui.elements.battlepassWinter2025.data.CommonTaskInfo;
/* compiled from: CommonTasksAdapter.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\u000e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0006J\u0014\u0010 \u001a\u00020\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\"J\u0006\u0010#\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000ej\b\u0012\u0004\u0012\u00020\t`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000ej\b\u0012\u0004\u0012\u00020\t`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006$"}, d2 = {"Lru/mrlargha/commonui/elements/battlepassWinter2025/CommonTasksAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/mrlargha/commonui/elements/battlepassWinter2025/RodinaBattlePassCommonTaskViewHolder;", "isArizona", "", "colorMaxProgress", "", "onSelectTask", "Lkotlin/Function2;", "Lru/mrlargha/commonui/elements/battlepassWinter2025/data/CommonTaskInfo;", "", "<init>", "(ZILkotlin/jvm/functions/Function2;)V", "allTasksList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAllTasksList", "()Ljava/util/ArrayList;", "currentTasksList", "getCurrentTasksList", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "filterList", "categoryType", "Lru/mrlargha/commonui/elements/battlepassWinter2025/data/CategoryType;", "selectTask", "addAllTasks", "tasks", "", "clearAllTasksList", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CommonTasksAdapter extends RecyclerView.Adapter<RodinaBattlePassCommonTaskViewHolder> {
    private final ArrayList<CommonTaskInfo> allTasksList;
    private final int colorMaxProgress;
    private final ArrayList<CommonTaskInfo> currentTasksList;
    private final boolean isArizona;
    private final Function2<CommonTaskInfo, Integer, Unit> onSelectTask;

    public /* synthetic */ CommonTasksAdapter(boolean z, int i, Function2 function2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, (i2 & 4) != 0 ? new Function2() { // from class: ru.mrlargha.commonui.elements.battlepassWinter2025.CommonTasksAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = CommonTasksAdapter._init_$lambda$0((CommonTaskInfo) obj, ((Integer) obj2).intValue());
                return _init_$lambda$0;
            }
        } : function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(CommonTaskInfo commonTaskInfo, int i) {
        Intrinsics.checkNotNullParameter(commonTaskInfo, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonTasksAdapter(boolean z, int i, Function2<? super CommonTaskInfo, ? super Integer, Unit> onSelectTask) {
        Intrinsics.checkNotNullParameter(onSelectTask, "onSelectTask");
        this.isArizona = z;
        this.colorMaxProgress = i;
        this.onSelectTask = onSelectTask;
        this.allTasksList = new ArrayList<>();
        this.currentTasksList = new ArrayList<>();
    }

    public final ArrayList<CommonTaskInfo> getAllTasksList() {
        return this.allTasksList;
    }

    public final ArrayList<CommonTaskInfo> getCurrentTasksList() {
        return this.currentTasksList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RodinaBattlePassCommonTaskViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.winter_battlepass_common_task_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new RodinaBattlePassCommonTaskViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RodinaBattlePassCommonTaskViewHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CommonTaskInfo commonTaskInfo = this.currentTasksList.get(i);
        Intrinsics.checkNotNullExpressionValue(commonTaskInfo, "get(...)");
        final CommonTaskInfo commonTaskInfo2 = commonTaskInfo;
        WinterBattlepassCommonTaskItemBinding binding = holder.getBinding();
        binding.itemTitle.setText(commonTaskInfo2.getTitle());
        binding.itemDescription.setText(commonTaskInfo2.getDescription());
        TextView textView = binding.itemCount;
        int validCurrentProgress = commonTaskInfo2.validCurrentProgress();
        textView.setText(validCurrentProgress + RemoteSettings.FORWARD_SLASH_STRING + commonTaskInfo2.getTotalProgress());
        binding.itemRewardDescription.setText("+" + commonTaskInfo2.getPrizeValue() + " ед.");
        binding.dayTaskProgressBar.setMax(commonTaskInfo2.getTotalProgress());
        binding.dayTaskProgressBar.setProgress(commonTaskInfo2.validCurrentProgress());
        if (commonTaskInfo2.isSelected()) {
            binding.getRoot().setBackgroundResource(R.drawable.az_battlepass_common_task_bg_selected);
        } else {
            binding.getRoot().setBackgroundResource(R.drawable.az_battlepass_common_task_bg_unselected);
        }
        if (commonTaskInfo2.validCurrentProgress() == commonTaskInfo2.getTotalProgress()) {
            binding.progressInPercentText.setVisibility(8);
            binding.progressDoneContainer.setVisibility(0);
            binding.dayTaskProgressBar.setProgressTintList(ColorStateList.valueOf(this.colorMaxProgress));
            binding.itemRewardDescription.setTextColor(this.colorMaxProgress);
        } else {
            binding.progressDoneContainer.setVisibility(8);
            binding.progressInPercentText.setVisibility(0);
            binding.progressInPercentText.setText(((int) ((commonTaskInfo2.validCurrentProgress() / commonTaskInfo2.getTotalProgress()) * 100)) + "%");
            binding.itemRewardDescription.setTextColor(-1);
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CommonTasksAdapter$onBindViewHolder$1$1(this, commonTaskInfo2, binding, holder, null), 3, null);
        binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.battlepassWinter2025.CommonTasksAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonTasksAdapter.onBindViewHolder$lambda$2$lambda$1(CommonTasksAdapter.this, commonTaskInfo2, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2$lambda$1(CommonTasksAdapter commonTasksAdapter, CommonTaskInfo commonTaskInfo, int i, View view) {
        commonTasksAdapter.onSelectTask.invoke(commonTaskInfo, Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.currentTasksList.size();
    }

    public final void filterList(CategoryType categoryType) {
        Intrinsics.checkNotNullParameter(categoryType, "categoryType");
        for (CommonTaskInfo commonTaskInfo : this.allTasksList) {
            commonTaskInfo.setSelected(false);
        }
        this.currentTasksList.clear();
        ArrayList<CommonTaskInfo> arrayList = this.currentTasksList;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.allTasksList) {
            CommonTaskInfo commonTaskInfo2 = (CommonTaskInfo) obj;
            if (commonTaskInfo2.getCategoryType() == categoryType.getValue() && commonTaskInfo2.isVisible()) {
                arrayList2.add(obj);
            }
        }
        arrayList.addAll(arrayList2);
        if (!this.currentTasksList.isEmpty()) {
            this.currentTasksList.get(0).setSelected(true);
        }
        notifyDataSetChanged();
    }

    public final void selectTask(int i) {
        for (CommonTaskInfo commonTaskInfo : this.allTasksList) {
            commonTaskInfo.setSelected(false);
        }
        for (CommonTaskInfo commonTaskInfo2 : this.currentTasksList) {
            commonTaskInfo2.setSelected(false);
        }
        CommonTaskInfo commonTaskInfo3 = (CommonTaskInfo) CollectionsKt.getOrNull(this.currentTasksList, i);
        if (commonTaskInfo3 != null) {
            commonTaskInfo3.setSelected(true);
        }
        notifyDataSetChanged();
    }

    public final void addAllTasks(List<CommonTaskInfo> tasks) {
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CommonTasksAdapter$addAllTasks$1(this, tasks, null), 3, null);
    }

    public final void clearAllTasksList() {
        this.allTasksList.clear();
        this.currentTasksList.clear();
        notifyDataSetChanged();
    }
}
