package ru.mrlargha.commonui.elements.quest;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.RodinaQuestScreenBinding;
import ru.mrlargha.commonui.utils.ConverterKt;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: QuestScreen.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0016\u0010\u001a\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0018\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0016R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lru/mrlargha/commonui/elements/quest/QuestScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "quest", "Landroid/view/View;", "kotlin.jvm.PlatformType", "questBinding", "Lru/mrlargha/commonui/databinding/RodinaQuestScreenBinding;", "questAdapter", "Lru/mrlargha/commonui/elements/quest/QuestAdapter;", "questAwardsAdapter", "Lru/mrlargha/commonui/elements/quest/QuestAwardsAdapter;", "infoTextView", "Landroid/widget/TextView;", "sharedPref", "Landroid/content/SharedPreferences;", "isArizonaType", "", "setVisibility", "", "visible", "installQuestLayout", "quests", "", "Lru/mrlargha/commonui/elements/quest/QuestLine;", "onBackendMessage", "data", "", "subId", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuestScreen extends SAMPUIElement {
    private final TextView infoTextView;
    private final boolean isArizonaType;
    private final View quest;
    private QuestAdapter questAdapter;
    private final QuestAwardsAdapter questAwardsAdapter;
    private final RodinaQuestScreenBinding questBinding;
    private final SharedPreferences sharedPref;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuestScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View quest = targetActivity.getLayoutInflater().inflate(R.layout.rodina_quest_screen, (ViewGroup) null);
        this.quest = quest;
        RodinaQuestScreenBinding bind = RodinaQuestScreenBinding.bind(quest);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.questBinding = bind;
        this.questAdapter = new QuestAdapter();
        this.questAwardsAdapter = new QuestAwardsAdapter();
        View findViewById = quest.findViewById(R.id.rodina_quest_info_description);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.infoTextView = (TextView) findViewById;
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPref = sharedPreferences;
        this.isArizonaType = sharedPreferences.getBoolean("isArizonaType", false);
        quest.setClickable(true);
        Intrinsics.checkNotNullExpressionValue(quest, "quest");
        addViewToConstraintLayout(quest, -1, -1);
        bind.rodinaQuests.setLayoutManager(new GridLayoutManager((Context) targetActivity, 1, 0, false));
        bind.rodinaQuests.setAdapter(this.questAdapter);
        bind.rodinaExitButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.quest.QuestScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SAMPUIElement.notifyClick$default(QuestScreen.this, 2, -2, null, 4, null);
            }
        });
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        if (!z) {
            this.questAdapter.clearQuests();
        }
        super.setVisibility(z);
    }

    private final void installQuestLayout(List<QuestLine> list) {
        boolean z;
        if (!list.isEmpty()) {
            if (this.questAdapter.getItemCount() == 0) {
                RodinaQuestScreenBinding rodinaQuestScreenBinding = this.questBinding;
                rodinaQuestScreenBinding.rodinaQuestTitle.setText("Доступные квесты");
                rodinaQuestScreenBinding.rodinaQuestContractDescription.setText("Выберите квест, чтобы посмотреть информацию");
                rodinaQuestScreenBinding.rodinaQuestInfoContainer.setVisibility(0);
                rodinaQuestScreenBinding.rodinaQuests.setVisibility(0);
                rodinaQuestScreenBinding.emptyQuestTitle.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = rodinaQuestScreenBinding.rodinaQuests.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ((ConstraintLayout.LayoutParams) layoutParams).setMarginStart(ConverterKt.dpToPx(36, getTargetActivity()));
                final QuestLine questLine = list.get(0);
                rodinaQuestScreenBinding.rodinaQuestInfoTitle.setText(questLine.getTitle());
                rodinaQuestScreenBinding.textProgress.setText(questLine.getTextProgress());
                rodinaQuestScreenBinding.rodinaQuestInfoDescription.setText(questLine.getDescription());
                this.infoTextView.setMovementMethod(new ScrollingMovementMethod());
                rodinaQuestScreenBinding.rodinaQuestStatText.setText(MathKt.roundToInt((questLine.getProgress() / questLine.getMaxProgress()) * 100) + "%");
                rodinaQuestScreenBinding.rodinaQuestProgress.setMax(questLine.getMaxProgress());
                rodinaQuestScreenBinding.rodinaQuestProgress.setProgress(questLine.getProgress());
                String str = "";
                if (questLine.getAwards().isEmpty() || !this.isArizonaType) {
                    z = false;
                } else {
                    z = false;
                    for (QuestAwards questAwards : questLine.getAwards()) {
                        if (Intrinsics.areEqual(questAwards.getIcon(), "-1")) {
                            str = questAwards.getTitle();
                            z = true;
                        }
                    }
                }
                if (z && this.isArizonaType) {
                    rodinaQuestScreenBinding.rodinaQuestAwards.setVisibility(8);
                    rodinaQuestScreenBinding.textAwardAz.setVisibility(0);
                    rodinaQuestScreenBinding.textAwardAz.setText(str);
                } else {
                    rodinaQuestScreenBinding.textAwardAz.setVisibility(8);
                    rodinaQuestScreenBinding.rodinaQuestAwards.setVisibility(0);
                    rodinaQuestScreenBinding.rodinaQuestAwards.setLayoutManager(new GridLayoutManager((Context) getTargetActivity(), 1, 0, false));
                    rodinaQuestScreenBinding.rodinaQuestAwards.setAdapter(this.questAwardsAdapter);
                    this.questAwardsAdapter.addQuestAwards(questLine.getAwards());
                }
                rodinaQuestScreenBinding.rodinaQuestAwardsButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.quest.QuestScreen$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QuestScreen.installQuestLayout$lambda$5$lambda$3(QuestScreen.this, questLine, view);
                    }
                });
                if (this.isArizonaType) {
                    rodinaQuestScreenBinding.rodinaQuestAwardsCancelButton.setVisibility(0);
                } else {
                    rodinaQuestScreenBinding.rodinaQuestAwardsCancelButton.setVisibility(8);
                }
                rodinaQuestScreenBinding.rodinaQuestAwardsCancelButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.quest.QuestScreen$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QuestScreen.installQuestLayout$lambda$5$lambda$4(QuestScreen.this, questLine, view);
                    }
                });
                this.questAdapter.setOnQuestClickListener(new QuestScreen$installQuestLayout$1$4(rodinaQuestScreenBinding, this));
                this.questAdapter.addQuests(list);
            } else {
                this.questAdapter.addQuests(list);
            }
            this.questAdapter.notifyDataSetChanged();
            return;
        }
        RodinaQuestScreenBinding rodinaQuestScreenBinding2 = this.questBinding;
        rodinaQuestScreenBinding2.rodinaQuestInfoContainer.setVisibility(8);
        rodinaQuestScreenBinding2.rodinaQuests.setVisibility(8);
        rodinaQuestScreenBinding2.emptyQuestTitle.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void installQuestLayout$lambda$5$lambda$3(QuestScreen questScreen, QuestLine questLine, View view) {
        SAMPUIElement.notifyClick$default(questScreen, 0, questLine.getId(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void installQuestLayout$lambda$5$lambda$4(QuestScreen questScreen, QuestLine questLine, View view) {
        SAMPUIElement.notifyClick$default(questScreen, 1, questLine.getId(), null, 4, null);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 2) {
            installQuestLayout(MapperKt.toListModel(data, QuestLine.class));
        } else if (i != 3) {
        } else {
            this.questAdapter.clearQuests();
        }
    }

    /* compiled from: QuestScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/quest/QuestScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new QuestScreen(targetActivity, i);
        }
    }
}
