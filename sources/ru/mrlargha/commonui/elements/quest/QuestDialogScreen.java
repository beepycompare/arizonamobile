package ru.mrlargha.commonui.elements.quest;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.RodinaQuestDialogBinding;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
/* compiled from: QuestDialogScreen.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/elements/quest/QuestDialogScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screenLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/RodinaQuestDialogBinding;", "onBackendMessageHandled", "", "data", "", "subId", "Spawner", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class QuestDialogScreen extends SAMPUIElement {
    private final RodinaQuestDialogBinding binding;
    private final ConstraintLayout screenLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuestDialogScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.rodina_quest_dialog, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.screenLayout = constraintLayout;
        RodinaQuestDialogBinding bind = RodinaQuestDialogBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        addViewToConstraintLayout(constraintLayout, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBackendMessageHandled$lambda$0$0(QuestDialogScreen questDialogScreen, int i) {
        questDialogScreen.getNotifier().clickedWrapper(questDialogScreen.getBackendID(), 1, i);
        return Unit.INSTANCE;
    }

    /* compiled from: QuestDialogScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/quest/QuestDialogScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.QUEST_DIALOG);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new QuestDialogScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Object fromJson = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) QuestData.class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
        QuestData questData = (QuestData) ((RodinaSerializableData) fromJson);
        RodinaQuestDialogBinding rodinaQuestDialogBinding = this.binding;
        rodinaQuestDialogBinding.rodinaQuestTitle.setText(questData.getQuestName());
        rodinaQuestDialogBinding.rodinaQuestNpcName.setText(questData.getNpcName());
        rodinaQuestDialogBinding.rodinaQuestNpcText.setText(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, questData.getNpcText(), 0.0f, null, 3, null));
        rodinaQuestDialogBinding.rodinaQuestDialogRecycler.setAdapter(new QuestAnswerAdapter(questData.getAnswers(), new Function1() { // from class: ru.mrlargha.commonui.elements.quest.QuestDialogScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit onBackendMessageHandled$lambda$0$0;
                onBackendMessageHandled$lambda$0$0 = QuestDialogScreen.onBackendMessageHandled$lambda$0$0(QuestDialogScreen.this, ((Integer) obj).intValue());
                return onBackendMessageHandled$lambda$0$0;
            }
        }));
    }
}
