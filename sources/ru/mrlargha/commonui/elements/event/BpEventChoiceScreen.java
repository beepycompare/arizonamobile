package ru.mrlargha.commonui.elements.event;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.JsonParseException;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import com.squareup.picasso.Picasso;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.BpEasterChoiceBinding;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.utils.MapperKt;
/* compiled from: BpEventChoice.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001aB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u000fH\u0002R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/mrlargha/commonui/elements/event/BpEventChoiceScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/commonui/databinding/BpEasterChoiceBinding;", "setVisible", "", "visible", "", "onBackendMessageHandled", "data", "", "subId", "isBpAvailable", "setImages", "Lru/mrlargha/commonui/elements/event/ChoiceData;", "setupNavigation", "Spawner", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BpEventChoiceScreen extends SAMPUIElement implements InterfaceController {
    private final BpEasterChoiceBinding binding;
    private final View screen;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BpEventChoiceScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View screen = targetActivity.getLayoutInflater().inflate(R.layout.bp_easter_choice, (ViewGroup) null);
        this.screen = screen;
        BpEasterChoiceBinding bind = BpEasterChoiceBinding.bind(screen);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        Intrinsics.checkNotNullExpressionValue(screen, "screen");
        addViewToConstraintLayout(screen, -1, -1);
        setupNavigation();
        Picasso.get().load(FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "systems/battlepass/selector/event.webp").into(bind.item1);
        Picasso.get().load(FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "systems/battlepass/selector/main.webp").into(bind.item2);
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.binding.getRoot().setVisibility(z ? 0 : 8);
        this.binding.getRoot().setVisibility(z ? 0 : 8);
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i != 0) {
            if (i != 1) {
                return;
            }
            isBpAvailable(data);
        } else if (MapperKt.isJsonValid(data)) {
            setImages((ChoiceData) MapperKt.getGson().fromJson(data, (Class<Object>) ChoiceData.class));
        } else {
            throw new JsonParseException("Json is not valid");
        }
    }

    public final void isBpAvailable(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        StringsKt.contains$default((CharSequence) data, (CharSequence) "1", false, 2, (Object) null);
    }

    public final void setImages(ChoiceData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Picasso picasso = Picasso.get();
        String projectResourceUrl$default = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
        picasso.load(projectResourceUrl$default + "systems/battlepass/selector/" + data.getEvent()).into(this.binding.item1);
        Picasso picasso2 = Picasso.get();
        String projectResourceUrl$default2 = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
        picasso2.load(projectResourceUrl$default2 + "systems/battlepass/selector/" + data.getMain()).into(this.binding.item2);
    }

    private final void setupNavigation() {
        BpEasterChoiceBinding bpEasterChoiceBinding = this.binding;
        bpEasterChoiceBinding.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.event.BpEventChoiceScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BpEventChoiceScreen.setupNavigation$lambda$0$0(BpEventChoiceScreen.this, view);
            }
        });
        bpEasterChoiceBinding.item1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.event.BpEventChoiceScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BpEventChoiceScreen.setupNavigation$lambda$0$1(BpEventChoiceScreen.this, view);
            }
        });
        bpEasterChoiceBinding.item2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.event.BpEventChoiceScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BpEventChoiceScreen.setupNavigation$lambda$0$2(BpEventChoiceScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$0(BpEventChoiceScreen bpEventChoiceScreen, View view) {
        SAMPUIElement.notifyClick$default(bpEventChoiceScreen, 0, 0, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$1(BpEventChoiceScreen bpEventChoiceScreen, View view) {
        SAMPUIElement.notifyClick$default(bpEventChoiceScreen, 0, 1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$0$2(BpEventChoiceScreen bpEventChoiceScreen, View view) {
        SAMPUIElement.notifyClick$default(bpEventChoiceScreen, 1, 1, null, 4, null);
    }

    /* compiled from: BpEventChoice.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/event/BpEventChoiceScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.BP_EVENT_CHOICE);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new BpEventChoiceScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
