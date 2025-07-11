package ru.mrlargha.commonui.elements.quest;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.databinding.RodinaQuestScreenBinding;
import ru.mrlargha.commonui.elements.quest.QuestAdapter;
/* compiled from: QuestScreen.kt */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"ru/mrlargha/commonui/elements/quest/QuestScreen$installQuestLayout$1$4", "Lru/mrlargha/commonui/elements/quest/QuestAdapter$OnQuestClickListener;", "callback", "", "quest", "Lru/mrlargha/commonui/elements/quest/QuestLine;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuestScreen$installQuestLayout$1$4 implements QuestAdapter.OnQuestClickListener {
    final /* synthetic */ RodinaQuestScreenBinding $this_apply;
    final /* synthetic */ QuestScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QuestScreen$installQuestLayout$1$4(RodinaQuestScreenBinding rodinaQuestScreenBinding, QuestScreen questScreen) {
        this.$this_apply = rodinaQuestScreenBinding;
        this.this$0 = questScreen;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0146  */
    @Override // ru.mrlargha.commonui.elements.quest.QuestAdapter.OnQuestClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void callback(final QuestLine quest) {
        double progress;
        boolean z;
        Activity targetActivity;
        QuestAwardsAdapter questAwardsAdapter;
        QuestAwardsAdapter questAwardsAdapter2;
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.checkNotNullParameter(quest, "quest");
        this.$this_apply.rodinaQuestInfoTitle.setText(quest.getTitle());
        this.$this_apply.textProgress.setText(quest.getTextProgress());
        this.$this_apply.rodinaQuestInfoDescription.setText(quest.getDescription());
        this.$this_apply.rodinaQuestStatText.setText((Math.abs(quest.getProgress() / quest.getMaxProgress()) <= Double.MAX_VALUE ? MathKt.roundToInt(progress * 100) : 0) + "%");
        this.$this_apply.rodinaQuestProgress.setMax(quest.getMaxProgress());
        this.$this_apply.rodinaQuestProgress.setProgress(quest.getProgress());
        String str = "";
        if (!quest.getAwards().isEmpty()) {
            z4 = this.this$0.isArizonaType;
            if (z4) {
                z = false;
                for (QuestAwards questAwards : quest.getAwards()) {
                    if (Intrinsics.areEqual(questAwards.getIcon(), "-1")) {
                        str = questAwards.getTitle();
                        z = true;
                    }
                }
                if (z) {
                    z3 = this.this$0.isArizonaType;
                    if (z3) {
                        this.$this_apply.rodinaQuestAwards.setVisibility(8);
                        this.$this_apply.textAwardAz.setVisibility(0);
                        this.$this_apply.textAwardAz.setText(str);
                        ConstraintLayout constraintLayout = this.$this_apply.rodinaQuestAwardsButton;
                        final QuestScreen questScreen = this.this$0;
                        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.quest.QuestScreen$installQuestLayout$1$4$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                QuestScreen$installQuestLayout$1$4.callback$lambda$1(QuestScreen.this, quest, view);
                            }
                        });
                        z2 = this.this$0.isArizonaType;
                        if (z2) {
                            this.$this_apply.rodinaQuestAwardsCancelButton.setVisibility(0);
                        } else {
                            this.$this_apply.rodinaQuestAwardsCancelButton.setVisibility(8);
                        }
                        ConstraintLayout constraintLayout2 = this.$this_apply.rodinaQuestAwardsCancelButton;
                        final QuestScreen questScreen2 = this.this$0;
                        constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.quest.QuestScreen$installQuestLayout$1$4$$ExternalSyntheticLambda1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                QuestScreen$installQuestLayout$1$4.callback$lambda$2(QuestScreen.this, quest, view);
                            }
                        });
                    }
                }
                this.$this_apply.textAwardAz.setVisibility(8);
                this.$this_apply.rodinaQuestAwards.setVisibility(0);
                RecyclerView recyclerView = this.$this_apply.rodinaQuestAwards;
                targetActivity = this.this$0.getTargetActivity();
                recyclerView.setLayoutManager(new GridLayoutManager((Context) targetActivity, 1, 0, false));
                RecyclerView recyclerView2 = this.$this_apply.rodinaQuestAwards;
                questAwardsAdapter = this.this$0.questAwardsAdapter;
                recyclerView2.setAdapter(questAwardsAdapter);
                questAwardsAdapter2 = this.this$0.questAwardsAdapter;
                questAwardsAdapter2.addQuestAwards(quest.getAwards());
                ConstraintLayout constraintLayout3 = this.$this_apply.rodinaQuestAwardsButton;
                final QuestScreen questScreen3 = this.this$0;
                constraintLayout3.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.quest.QuestScreen$installQuestLayout$1$4$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QuestScreen$installQuestLayout$1$4.callback$lambda$1(QuestScreen.this, quest, view);
                    }
                });
                z2 = this.this$0.isArizonaType;
                if (z2) {
                }
                ConstraintLayout constraintLayout22 = this.$this_apply.rodinaQuestAwardsCancelButton;
                final QuestScreen questScreen22 = this.this$0;
                constraintLayout22.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.quest.QuestScreen$installQuestLayout$1$4$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QuestScreen$installQuestLayout$1$4.callback$lambda$2(QuestScreen.this, quest, view);
                    }
                });
            }
        }
        z = false;
        if (z) {
        }
        this.$this_apply.textAwardAz.setVisibility(8);
        this.$this_apply.rodinaQuestAwards.setVisibility(0);
        RecyclerView recyclerView3 = this.$this_apply.rodinaQuestAwards;
        targetActivity = this.this$0.getTargetActivity();
        recyclerView3.setLayoutManager(new GridLayoutManager((Context) targetActivity, 1, 0, false));
        RecyclerView recyclerView22 = this.$this_apply.rodinaQuestAwards;
        questAwardsAdapter = this.this$0.questAwardsAdapter;
        recyclerView22.setAdapter(questAwardsAdapter);
        questAwardsAdapter2 = this.this$0.questAwardsAdapter;
        questAwardsAdapter2.addQuestAwards(quest.getAwards());
        ConstraintLayout constraintLayout32 = this.$this_apply.rodinaQuestAwardsButton;
        final QuestScreen questScreen32 = this.this$0;
        constraintLayout32.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.quest.QuestScreen$installQuestLayout$1$4$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuestScreen$installQuestLayout$1$4.callback$lambda$1(QuestScreen.this, quest, view);
            }
        });
        z2 = this.this$0.isArizonaType;
        if (z2) {
        }
        ConstraintLayout constraintLayout222 = this.$this_apply.rodinaQuestAwardsCancelButton;
        final QuestScreen questScreen222 = this.this$0;
        constraintLayout222.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.quest.QuestScreen$installQuestLayout$1$4$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuestScreen$installQuestLayout$1$4.callback$lambda$2(QuestScreen.this, quest, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void callback$lambda$1(QuestScreen questScreen, QuestLine questLine, View view) {
        SAMPUIElement.notifyClick$default(questScreen, 0, questLine.getId(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void callback$lambda$2(QuestScreen questScreen, QuestLine questLine, View view) {
        SAMPUIElement.notifyClick$default(questScreen, 1, questLine.getId(), null, 4, null);
    }
}
