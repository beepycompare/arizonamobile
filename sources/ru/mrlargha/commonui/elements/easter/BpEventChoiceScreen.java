package ru.mrlargha.commonui.elements.easter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.databinding.BpEasterChoiceBinding;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
/* compiled from: BpEventChoice.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0017\u0018B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0002R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/easter/BpEventChoiceScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/commonui/databinding/BpEasterChoiceBinding;", "setVisible", "", "visible", "", "onBackendMessage", "data", "", "subId", "setupNavigation", "Navigation", "Spawner", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BpEventChoiceScreen extends SAMPUIElement implements InterfaceController {
    private final BpEasterChoiceBinding binding;
    private final View screen;

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

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
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.binding.getRoot().setVisibility(z ? 0 : 8);
        this.binding.getRoot().setVisibility(z ? 0 : 8);
    }

    private final void setupNavigation() {
        BpEasterChoiceBinding bpEasterChoiceBinding = this.binding;
        bpEasterChoiceBinding.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.BpEventChoiceScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BpEventChoiceScreen.setupNavigation$lambda$3$lambda$0(BpEventChoiceScreen.this, view);
            }
        });
        bpEasterChoiceBinding.item1.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.BpEventChoiceScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BpEventChoiceScreen.setupNavigation$lambda$3$lambda$1(BpEventChoiceScreen.this, view);
            }
        });
        bpEasterChoiceBinding.item2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.easter.BpEventChoiceScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BpEventChoiceScreen.setupNavigation$lambda$3$lambda$2(BpEventChoiceScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$3$lambda$0(BpEventChoiceScreen bpEventChoiceScreen, View view) {
        SAMPUIElement.notifyClick$default(bpEventChoiceScreen, 0, 0, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$3$lambda$1(BpEventChoiceScreen bpEventChoiceScreen, View view) {
        SAMPUIElement.notifyClick$default(bpEventChoiceScreen, 0, 1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupNavigation$lambda$3$lambda$2(BpEventChoiceScreen bpEventChoiceScreen, View view) {
        SAMPUIElement.notifyClick$default(bpEventChoiceScreen, 1, 1, null, 4, null);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: BpEventChoice.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lru/mrlargha/commonui/elements/easter/BpEventChoiceScreen$Navigation;", "", "<init>", "(Ljava/lang/String;I)V", "Welcome", "Create", "Join", "Menu", "Settings", "Shop", "Property", "Criminal", "Upgrades", "Members", "Rating", "RatingAwards", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Navigation {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Navigation[] $VALUES;
        public static final Navigation Welcome = new Navigation("Welcome", 0);
        public static final Navigation Create = new Navigation("Create", 1);
        public static final Navigation Join = new Navigation("Join", 2);
        public static final Navigation Menu = new Navigation("Menu", 3);
        public static final Navigation Settings = new Navigation("Settings", 4);
        public static final Navigation Shop = new Navigation("Shop", 5);
        public static final Navigation Property = new Navigation("Property", 6);
        public static final Navigation Criminal = new Navigation("Criminal", 7);
        public static final Navigation Upgrades = new Navigation("Upgrades", 8);
        public static final Navigation Members = new Navigation("Members", 9);
        public static final Navigation Rating = new Navigation("Rating", 10);
        public static final Navigation RatingAwards = new Navigation("RatingAwards", 11);

        private static final /* synthetic */ Navigation[] $values() {
            return new Navigation[]{Welcome, Create, Join, Menu, Settings, Shop, Property, Criminal, Upgrades, Members, Rating, RatingAwards};
        }

        public static EnumEntries<Navigation> getEntries() {
            return $ENTRIES;
        }

        public static Navigation valueOf(String str) {
            return (Navigation) Enum.valueOf(Navigation.class, str);
        }

        public static Navigation[] values() {
            return (Navigation[]) $VALUES.clone();
        }

        private Navigation(String str, int i) {
        }

        static {
            Navigation[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* compiled from: BpEventChoice.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/easter/BpEventChoiceScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new BpEventChoiceScreen(targetActivity, i);
        }
    }
}
