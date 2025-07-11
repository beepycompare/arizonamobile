package ru.mrlargha.commonui.elements.hud.presentation.hud_screens;

import android.os.CountDownTimer;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.databinding.HudProposalScreenBinding;
/* compiled from: HudProposalScreen.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\t0\u000fJ\u0006\u0010\u0014\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/HudProposalScreen;", "", "<init>", "()V", "timer", "Landroid/os/CountDownTimer;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "showProposalScreen", "", "proposalBinding", "Lru/mrlargha/commonui/databinding/HudProposalScreenBinding;", "proposalResponse", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/HudProposalScreen$ProposalResponse;", "notifyClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "id", "stopTimer", "PROPOSAL_ACCEPT", "PROPOSAL_DECLINE", "ProposalType", "ProposalResponse", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HudProposalScreen {
    private static final int PROPOSAL_ACCEPT = 16;
    private static final int PROPOSAL_DECLINE = 17;
    public static final HudProposalScreen INSTANCE = new HudProposalScreen();
    private static CountDownTimer timer = new CountDownTimer() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudProposalScreen$timer$1
        @Override // android.os.CountDownTimer
        public void onFinish() {
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    };
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());

    private HudProposalScreen() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: HudProposalScreen.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/HudProposalScreen$ProposalType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "PROPOSE_REQUEST", "PROPOSE_RESPONSE", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ProposalType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ProposalType[] $VALUES;
        public static final ProposalType PROPOSE_REQUEST = new ProposalType("PROPOSE_REQUEST", 0, 0);
        public static final ProposalType PROPOSE_RESPONSE = new ProposalType("PROPOSE_RESPONSE", 1, 1);
        private final int type;

        private static final /* synthetic */ ProposalType[] $values() {
            return new ProposalType[]{PROPOSE_REQUEST, PROPOSE_RESPONSE};
        }

        public static EnumEntries<ProposalType> getEntries() {
            return $ENTRIES;
        }

        public static ProposalType valueOf(String str) {
            return (ProposalType) Enum.valueOf(ProposalType.class, str);
        }

        public static ProposalType[] values() {
            return (ProposalType[]) $VALUES.clone();
        }

        private ProposalType(String str, int i, int i2) {
            this.type = i2;
        }

        public final int getType() {
            return this.type;
        }

        static {
            ProposalType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* compiled from: HudProposalScreen.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/HudProposalScreen$ProposalResponse;", "", "name", "", "text", "id", "", "time", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;III)V", "getName", "()Ljava/lang/String;", "getText", "getId", "()I", "getTime", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ProposalResponse {
        private final int id;
        private final String name;
        private final String text;
        private final int time;
        private final int type;

        public static /* synthetic */ ProposalResponse copy$default(ProposalResponse proposalResponse, String str, String str2, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = proposalResponse.name;
            }
            if ((i4 & 2) != 0) {
                str2 = proposalResponse.text;
            }
            if ((i4 & 4) != 0) {
                i = proposalResponse.id;
            }
            if ((i4 & 8) != 0) {
                i2 = proposalResponse.time;
            }
            if ((i4 & 16) != 0) {
                i3 = proposalResponse.type;
            }
            int i5 = i3;
            int i6 = i;
            return proposalResponse.copy(str, str2, i6, i2, i5);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.text;
        }

        public final int component3() {
            return this.id;
        }

        public final int component4() {
            return this.time;
        }

        public final int component5() {
            return this.type;
        }

        public final ProposalResponse copy(String name, String text, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(text, "text");
            return new ProposalResponse(name, text, i, i2, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ProposalResponse) {
                ProposalResponse proposalResponse = (ProposalResponse) obj;
                return Intrinsics.areEqual(this.name, proposalResponse.name) && Intrinsics.areEqual(this.text, proposalResponse.text) && this.id == proposalResponse.id && this.time == proposalResponse.time && this.type == proposalResponse.type;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.name.hashCode() * 31) + this.text.hashCode()) * 31) + Integer.hashCode(this.id)) * 31) + Integer.hashCode(this.time)) * 31) + Integer.hashCode(this.type);
        }

        public String toString() {
            String str = this.name;
            String str2 = this.text;
            int i = this.id;
            int i2 = this.time;
            return "ProposalResponse(name=" + str + ", text=" + str2 + ", id=" + i + ", time=" + i2 + ", type=" + this.type + ")";
        }

        public ProposalResponse(String name, String text, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(text, "text");
            this.name = name;
            this.text = text;
            this.id = i;
            this.time = i2;
            this.type = i3;
        }

        public final String getName() {
            return this.name;
        }

        public final String getText() {
            return this.text;
        }

        public final int getId() {
            return this.id;
        }

        public final int getTime() {
            return this.time;
        }

        public final int getType() {
            return this.type;
        }
    }

    public final void showProposalScreen(HudProposalScreenBinding proposalBinding, ProposalResponse proposalResponse, final Function1<? super Integer, Unit> notifyClick) {
        Intrinsics.checkNotNullParameter(proposalBinding, "proposalBinding");
        Intrinsics.checkNotNullParameter(proposalResponse, "proposalResponse");
        Intrinsics.checkNotNullParameter(notifyClick, "notifyClick");
        int type = proposalResponse.getType();
        int i = 8;
        if (type != ProposalType.PROPOSE_REQUEST.getType() && type == ProposalType.PROPOSE_RESPONSE.getType()) {
            i = 0;
        }
        proposalBinding.proposalAcceptBtn.setVisibility(i);
        proposalBinding.proposalTitle.setText(proposalResponse.getText());
        proposalBinding.proposalNickname.setText(proposalResponse.getName());
        proposalBinding.proposalId.setText("ID:" + proposalResponse.getId());
        proposalBinding.proposalProgress.setProgress(100);
        proposalBinding.proposalAcceptBtn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudProposalScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HudProposalScreen.showProposalScreen$lambda$2$lambda$0(Function1.this, view);
            }
        });
        proposalBinding.proposalDeclineBtn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.HudProposalScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HudProposalScreen.showProposalScreen$lambda$2$lambda$1(Function1.this, view);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new HudProposalScreen$showProposalScreen$2(proposalResponse, proposalBinding, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showProposalScreen$lambda$2$lambda$0(Function1 function1, View view) {
        function1.invoke(16);
        timer.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showProposalScreen$lambda$2$lambda$1(Function1 function1, View view) {
        function1.invoke(17);
        timer.cancel();
    }

    public final void stopTimer() {
        timer.cancel();
    }
}
