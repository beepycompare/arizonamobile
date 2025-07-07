package ru.mrlargha.commonui.elements.quest.presentation.viewHolder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.databinding.ItemQuestTaskBinding;
import ru.mrlargha.commonui.elements.quest.domain.QuestTask;
import ru.mrlargha.commonui.elements.quest.presentation.adapter.QuestRewardAdapter;
/* compiled from: QuestTaskViewHolder.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ&\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014J \u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/elements/quest/presentation/viewHolder/QuestTaskViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/mrlargha/commonui/databinding/ItemQuestTaskBinding;", "onItemClicked", "Lkotlin/Function2;", "Lru/mrlargha/commonui/elements/quest/domain/QuestTask;", "", "", "onShowClueClicked", "Lkotlin/Function1;", "context", "Landroid/content/Context;", "<init>", "(Lru/mrlargha/commonui/databinding/ItemQuestTaskBinding;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroid/content/Context;)V", "bind", "item", "position", "selectedItemPosition", "isVisible", "", "editUi", "doneText", "", "showClueText", "color", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuestTaskViewHolder extends RecyclerView.ViewHolder {
    private final ItemQuestTaskBinding binding;
    private final Context context;
    private final Function2<QuestTask, Integer, Unit> onItemClicked;
    private final Function1<QuestTask, Unit> onShowClueClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QuestTaskViewHolder(ItemQuestTaskBinding binding, Function2<? super QuestTask, ? super Integer, Unit> onItemClicked, Function1<? super QuestTask, Unit> onShowClueClicked, Context context) {
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

    public final void bind(final QuestTask item, final int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(item, "item");
        ItemQuestTaskBinding itemQuestTaskBinding = this.binding;
        QuestRewardAdapter questRewardAdapter = new QuestRewardAdapter();
        itemQuestTaskBinding.rvQuestRewards.setAdapter(questRewardAdapter);
        itemQuestTaskBinding.tvStage.setText(item.getTitle());
        itemQuestTaskBinding.tvTaskDescription.setText(item.getDescription());
        questRewardAdapter.submitList(item.getRewards());
        if (item.getProgress() == item.getMaxProgress() && item.getRewardReceived() == 0) {
            LinearLayout layoutProgressCount = itemQuestTaskBinding.layoutProgressCount;
            Intrinsics.checkNotNullExpressionValue(layoutProgressCount, "layoutProgressCount");
            layoutProgressCount.setVisibility(8);
            TextView tvDone = itemQuestTaskBinding.tvDone;
            Intrinsics.checkNotNullExpressionValue(tvDone, "tvDone");
            tvDone.setVisibility(0);
            editUi("Получите\n награду", "Получить награду", R.color.yellow_type2);
            itemQuestTaskBinding.btnShowClue.setClickable(true);
        } else if (item.getProgress() == item.getMaxProgress() && item.getRewardReceived() == 1) {
            LinearLayout layoutProgressCount2 = itemQuestTaskBinding.layoutProgressCount;
            Intrinsics.checkNotNullExpressionValue(layoutProgressCount2, "layoutProgressCount");
            layoutProgressCount2.setVisibility(8);
            TextView tvDone2 = itemQuestTaskBinding.tvDone;
            Intrinsics.checkNotNullExpressionValue(tvDone2, "tvDone");
            tvDone2.setVisibility(0);
            editUi("Завершено", "Получено", R.color.green_type6);
            itemQuestTaskBinding.btnShowClue.setClickable(false);
        } else {
            if (item.getHasLocation() == 0) {
                Button btnShowClue = itemQuestTaskBinding.btnShowClue;
                Intrinsics.checkNotNullExpressionValue(btnShowClue, "btnShowClue");
                btnShowClue.setVisibility(8);
            } else {
                Button button = itemQuestTaskBinding.btnShowClue;
                String buttonText = item.getButtonText();
                if (buttonText == null) {
                    buttonText = "Отследить в GPS";
                }
                button.setText(buttonText);
                itemQuestTaskBinding.btnShowClue.setBackgroundTintList(ColorStateList.valueOf(this.context.getColor(R.color.grey_type7)));
                itemQuestTaskBinding.btnShowClue.setClickable(true);
            }
            LinearLayout layoutProgressCount3 = itemQuestTaskBinding.layoutProgressCount;
            Intrinsics.checkNotNullExpressionValue(layoutProgressCount3, "layoutProgressCount");
            layoutProgressCount3.setVisibility(0);
            TextView tvDone3 = itemQuestTaskBinding.tvDone;
            Intrinsics.checkNotNullExpressionValue(tvDone3, "tvDone");
            tvDone3.setVisibility(8);
            TextView textView = itemQuestTaskBinding.tvStageCount;
            int progress = item.getProgress();
            textView.setText(progress + " / " + item.getMaxProgress());
        }
        itemQuestTaskBinding.parentItem.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.quest.presentation.viewHolder.QuestTaskViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuestTaskViewHolder.bind$lambda$2$lambda$0(QuestTaskViewHolder.this, item, i, view);
            }
        });
        itemQuestTaskBinding.btnShowClue.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.quest.presentation.viewHolder.QuestTaskViewHolder$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuestTaskViewHolder.bind$lambda$2$lambda$1(QuestTaskViewHolder.this, item, view);
            }
        });
        if (i == i2) {
            ConstraintLayout expandedLayout = itemQuestTaskBinding.expandedLayout;
            Intrinsics.checkNotNullExpressionValue(expandedLayout, "expandedLayout");
            expandedLayout.setVisibility(0);
            itemQuestTaskBinding.ivTaskShow.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_quest_close_arrow_grey));
            if (z) {
                ConstraintLayout expandedLayout2 = itemQuestTaskBinding.expandedLayout;
                Intrinsics.checkNotNullExpressionValue(expandedLayout2, "expandedLayout");
                expandedLayout2.setVisibility(8);
                itemQuestTaskBinding.ivTaskShow.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_quest_open_arrow_grey));
                return;
            }
            return;
        }
        ConstraintLayout expandedLayout3 = itemQuestTaskBinding.expandedLayout;
        Intrinsics.checkNotNullExpressionValue(expandedLayout3, "expandedLayout");
        expandedLayout3.setVisibility(8);
        itemQuestTaskBinding.ivTaskShow.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_quest_open_arrow_grey));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$2$lambda$0(QuestTaskViewHolder questTaskViewHolder, QuestTask questTask, int i, View view) {
        questTaskViewHolder.onItemClicked.invoke(questTask, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$2$lambda$1(QuestTaskViewHolder questTaskViewHolder, QuestTask questTask, View view) {
        questTaskViewHolder.onShowClueClicked.invoke(questTask);
    }

    private final void editUi(String str, String str2, int i) {
        ItemQuestTaskBinding itemQuestTaskBinding = this.binding;
        itemQuestTaskBinding.tvDone.setText(str);
        itemQuestTaskBinding.btnShowClue.setText(str2);
        itemQuestTaskBinding.tvDone.setBackgroundTintList(ColorStateList.valueOf(this.context.getColor(i)));
        itemQuestTaskBinding.btnShowClue.setBackgroundTintList(ColorStateList.valueOf(this.context.getColor(i)));
    }
}
