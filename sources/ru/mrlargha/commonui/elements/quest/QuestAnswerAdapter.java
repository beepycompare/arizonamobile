package ru.mrlargha.commonui.elements.quest;

import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.emoji.text.EmojiCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.databinding.RodinaQuestDialogItemBinding;
import ru.mrlargha.commonui.elements.quest.QuestAnswerAdapter;
/* compiled from: QuestAnswerAdapter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\bH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/quest/QuestAnswerAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/mrlargha/commonui/elements/quest/QuestAnswer;", "Lru/mrlargha/commonui/elements/quest/QuestAnswerAdapter$QuestAnswerViewHolder;", "answers", "", "onClick", "Lkotlin/Function1;", "", "", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "QuestAnswerViewHolder", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuestAnswerAdapter extends ListAdapter<QuestAnswer, QuestAnswerViewHolder> {
    private final Function1<Integer, Unit> onClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QuestAnswerAdapter(List<QuestAnswer> answers, Function1<? super Integer, Unit> onClick) {
        super(new DiffUtil.ItemCallback<QuestAnswer>() { // from class: ru.mrlargha.commonui.elements.quest.QuestAnswerAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areItemsTheSame(QuestAnswer oldItem, QuestAnswer newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public boolean areContentsTheSame(QuestAnswer oldItem, QuestAnswer newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }
        });
        Intrinsics.checkNotNullParameter(answers, "answers");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
        submitList(answers);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public QuestAnswerViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return QuestAnswerViewHolder.Companion.create(parent, this.onClick);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(QuestAnswerViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        QuestAnswer questAnswer = getCurrentList().get(i);
        Intrinsics.checkNotNullExpressionValue(questAnswer, "get(...)");
        holder.bind(questAnswer);
    }

    /* compiled from: QuestAnswerAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lru/mrlargha/commonui/elements/quest/QuestAnswerAdapter$QuestAnswerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onClick", "Lkotlin/Function1;", "", "", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "binding", "Lru/mrlargha/commonui/databinding/RodinaQuestDialogItemBinding;", "bind", "questAnswer", "Lru/mrlargha/commonui/elements/quest/QuestAnswer;", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class QuestAnswerViewHolder extends RecyclerView.ViewHolder {
        public static final Companion Companion = new Companion(null);
        private static final String TAG = "QuestAnswerAdapter";
        private final RodinaQuestDialogItemBinding binding;
        private final Function1<Integer, Unit> onClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public QuestAnswerViewHolder(View itemView, Function1<? super Integer, Unit> onClick) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            this.onClick = onClick;
            RodinaQuestDialogItemBinding bind = RodinaQuestDialogItemBinding.bind(itemView);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            this.binding = bind;
        }

        public final void bind(QuestAnswer questAnswer) {
            Intrinsics.checkNotNullParameter(questAnswer, "questAnswer");
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.quest.QuestAnswerAdapter$QuestAnswerViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QuestAnswerAdapter.QuestAnswerViewHolder.bind$lambda$0(QuestAnswerAdapter.QuestAnswerViewHolder.this, view);
                }
            });
            RodinaQuestDialogItemBinding rodinaQuestDialogItemBinding = this.binding;
            rodinaQuestDialogItemBinding.rodinaQuestDialogItemText.setText(questAnswer.getText());
            if (Intrinsics.areEqual(questAnswer.getEmoji(), " ")) {
                rodinaQuestDialogItemBinding.rodinaQuestDialogItemEmoji.setText(Html.fromHtml("&#12539;"));
            } else if (EmojiCompat.get().getLoadState() == 1) {
                rodinaQuestDialogItemBinding.rodinaQuestDialogItemEmoji.setText(EmojiCompat.get().process(Html.fromHtml(questAnswer.getEmoji())));
            } else {
                Log.w(TAG, "Emoji could not be rendered, EmojiCompatState: " + EmojiCompat.get().getLoadState());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(QuestAnswerViewHolder questAnswerViewHolder, View view) {
            questAnswerViewHolder.onClick.invoke(Integer.valueOf(questAnswerViewHolder.getAdapterPosition()));
        }

        /* compiled from: QuestAnswerAdapter.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lru/mrlargha/commonui/elements/quest/QuestAnswerAdapter$QuestAnswerViewHolder$Companion;", "", "<init>", "()V", "TAG", "", "create", "Lru/mrlargha/commonui/elements/quest/QuestAnswerAdapter$QuestAnswerViewHolder;", "parent", "Landroid/view/ViewGroup;", "onClick", "Lkotlin/Function1;", "", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final QuestAnswerViewHolder create(ViewGroup parent, Function1<? super Integer, Unit> onClick) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(onClick, "onClick");
                LinearLayout root = RodinaQuestDialogItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false).getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                return new QuestAnswerViewHolder(root, onClick);
            }
        }
    }
}
