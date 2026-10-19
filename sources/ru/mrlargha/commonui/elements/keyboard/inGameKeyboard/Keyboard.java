package ru.mrlargha.commonui.elements.keyboard.inGameKeyboard;

import android.app.Activity;
import android.graphics.Color;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.common.ui.BinderButtonType;
import com.arizona.common.ui.KeyboardButton;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.KeyboardContainerBindingsBinding;
import ru.mrlargha.commonui.databinding.KeyboardContainerEngBinding;
import ru.mrlargha.commonui.databinding.KeyboardContainerOtherSymbolsBinding;
import ru.mrlargha.commonui.databinding.KeyboardContainerRusBinding;
import ru.mrlargha.commonui.databinding.KeyboardContainerSymbolsBinding;
import ru.mrlargha.commonui.databinding.KeyboardLayoutBinding;
import ru.mrlargha.commonui.elements.binder.CommandBinder;
import ru.mrlargha.commonui.elements.keyboard.HoldBackspaceController;
import ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard;
import ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard;
import ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.models.BinderData;
import ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.models.KeyboardPage;
import ru.mrlargha.commonui.utils.emoji.ChatEmoji;
/* compiled from: Keyboard.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 p2\u00020\u0001:\u0007nopqrstB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u00122\b\b\u0002\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020*J\u000e\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020\u001cJ\u0010\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020\u0012H\u0016J\b\u0010:\u001a\u00020*H\u0002J\b\u0010;\u001a\u00020*H\u0002J\b\u0010<\u001a\u00020*H\u0002J\b\u0010=\u001a\u00020*H\u0002J\u0010\u0010>\u001a\u00020*2\u0006\u0010?\u001a\u00020\u0017H\u0002J\b\u0010@\u001a\u00020*H\u0002J\b\u0010A\u001a\u00020*H\u0002J\b\u0010B\u001a\u00020*H\u0002J\b\u0010C\u001a\u00020*H\u0002J\b\u0010D\u001a\u00020*H\u0002J&\u0010E\u001a\u00020\u00122\u0006\u0010F\u001a\u0002032\u0006\u0010G\u001a\u00020H2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020*0JH\u0002J4\u0010K\u001a\u00020\u00122\u0006\u0010F\u001a\u0002032\u0006\u0010G\u001a\u00020H2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020*0J2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020*0JH\u0002J\b\u0010M\u001a\u00020*H\u0002J\b\u0010N\u001a\u00020*H\u0002J\b\u0010O\u001a\u00020*H\u0002J\b\u0010P\u001a\u00020*H\u0002J\b\u0010Q\u001a\u00020*H\u0002J\b\u0010R\u001a\u00020*H\u0002J\b\u0010S\u001a\u00020*H\u0002J\u0018\u0010T\u001a\u00020*2\u0006\u0010F\u001a\u00020U2\u0006\u0010V\u001a\u00020WH\u0002J\u0010\u0010X\u001a\u00020*2\u0006\u0010Y\u001a\u00020ZH\u0002J\f\u0010[\u001a\u00020-*\u00020\\H\u0002J\b\u0010]\u001a\u00020*H\u0002J\b\u0010^\u001a\u00020*H\u0002J\b\u0010_\u001a\u00020*H\u0002J\b\u0010`\u001a\u00020*H\u0002J\b\u0010a\u001a\u00020*H\u0002J\b\u0010b\u001a\u00020*H\u0002J\b\u0010c\u001a\u00020*H\u0002J\b\u0010d\u001a\u00020*H\u0002J\b\u0010e\u001a\u00020*H\u0002J\b\u0010f\u001a\u00020*H\u0002J\f\u0010g\u001a\u00020h*\u00020\u0012H\u0002J\u0016\u0010i\u001a\u00020*2\u0006\u0010j\u001a\u00020\u00052\u0006\u0010k\u001a\u00020\u0012J\u0016\u0010l\u001a\u00020*2\u0006\u0010j\u001a\u00020\u00052\u0006\u0010m\u001a\u00020-R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020302X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020302X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020302X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020302X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020302X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/Keyboard;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "keyboardLayout", "Landroid/widget/LinearLayout;", "binding", "Lru/mrlargha/commonui/databinding/KeyboardLayoutBinding;", "currPage", "Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/models/KeyboardPage;", "previousPage", "languagePage", "symbolsPage", "allTextIsCaps", "", "isDisabledInput", "isEnabledType", "currentHistoryIndex", "currChatType", "Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/Keyboard$ChatType;", "bindsList", "", "Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/models/BinderData;", "inputListener", "Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/Keyboard$KeyboardInputListener;", "longClickTriggered", "longClickRunnable", "Ljava/lang/Runnable;", "shiftType", "Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/Keyboard$ShiftType;", "bindersIsOpened", "bindersAdapter", "Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/BindersAdapter;", "emojiAdapter", "Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/EmojiKeyboardAdapter;", "holdBackspaceController", "Lru/mrlargha/commonui/elements/keyboard/HoldBackspaceController;", "disableTypeAndBinders", "", "enableType", "text", "", "enableTypeAndBinders", "setInputListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "keyBoardBtnsRus", "", "Lcom/arizona/common/ui/KeyboardButton;", "keyBoardBtnsSymbols", "keyBoardBtnsOthersSymbols", "keyBoardBtnsEng", "chatTypeBtns", "setVisibility", "visible", "lockBackClicking", "setupBindersButtons", "setupEmojiButtons", "setupChatTypeButtons", "updateCurrentChatType", "chatType", "setupHistoryButtons", "setupMargins", "chatTypeBtnButtonsSetInvisible", "chatTypeBtnButtonsSetVisible", "setupHistoryMainButton", "setupClickAnim", "buttonView", "event", "Landroid/view/MotionEvent;", "onClick", "Lkotlin/Function0;", "setupClickAnimLong", "onLongClick", "setupOtherSymbolsKeyboard", "setupSymbolsKeyboard", "setupEngKeyboard", "sendCommand", "updateTextByCurrentHistoryLevel", "setupRusKeyboard", "setupKeyboardButtons", "inputButton", "Landroid/view/View;", "char", "", "inputText", "emoji", "Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/EmojiKeyboardItem;", "toChatSendText", "", "removeText", "removeTextAll", "goToLanguageKeyboard", "changeLanguagePage", "goToSymbolsKeyboard", "changeSymbolsPage", "changeKeyboardPage", "changeShiftState", "changeCaps", "updateCapsButtonsState", "getBinderTypeByState", "Lcom/arizona/common/ui/BinderButtonType;", "setBinderState", "indexBinder", RemoteConfigConstants.ResponseFieldKey.STATE, "setBinderName", "name", "EmojiSendTextSpan", "EmojiSpanRange", "Companion", "ChatType", "ShiftType", "KeyboardInputListener", "Spawner", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Keyboard extends SAMPUIElement {
    private static final int BINDERS_MAX_SIZE = 29;
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "Keyboard";
    private boolean allTextIsCaps;
    private BindersAdapter bindersAdapter;
    private boolean bindersIsOpened;
    private final KeyboardLayoutBinding binding;
    private final List<BinderData> bindsList;
    private final List<KeyboardButton> chatTypeBtns;
    private ChatType currChatType;
    private KeyboardPage currPage;
    private int currentHistoryIndex;
    private EmojiKeyboardAdapter emojiAdapter;
    private final HoldBackspaceController holdBackspaceController;
    private KeyboardInputListener inputListener;
    private boolean isDisabledInput;
    private boolean isEnabledType;
    private final List<KeyboardButton> keyBoardBtnsEng;
    private final List<KeyboardButton> keyBoardBtnsOthersSymbols;
    private final List<KeyboardButton> keyBoardBtnsRus;
    private final List<KeyboardButton> keyBoardBtnsSymbols;
    private final LinearLayout keyboardLayout;
    private KeyboardPage languagePage;
    private Runnable longClickRunnable;
    private boolean longClickTriggered;
    private KeyboardPage previousPage;
    private ShiftType shiftType;
    private KeyboardPage symbolsPage;

    /* compiled from: Keyboard.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ChatType.values().length];
            try {
                iArr[ChatType.RP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChatType.NON_RP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ChatType.ORG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ChatType.FAMILY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ChatType.WORK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ChatType.VIP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[KeyboardPage.values().length];
            try {
                iArr2[KeyboardPage.RUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[KeyboardPage.ENG.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[KeyboardPage.SYMBOLS.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[KeyboardPage.OTHER_SYMBOLS.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[KeyboardPage.EMOJI.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[KeyboardPage.BINDERS.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ShiftType.values().length];
            try {
                iArr3[ShiftType.ONCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[ShiftType.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[ShiftType.UPPER.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lockBackClicking$lambda$0$0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lockBackClicking$lambda$0$1(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lockBackClicking$lambda$0$2(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lockBackClicking$lambda$0$3(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lockBackClicking$lambda$0$4(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lockBackClicking$lambda$0$5(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Keyboard(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.keyboard_layout, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) inflate;
        this.keyboardLayout = linearLayout;
        KeyboardLayoutBinding bind = KeyboardLayoutBinding.bind(linearLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.currPage = KeyboardPage.RUS;
        this.previousPage = KeyboardPage.RUS;
        this.languagePage = KeyboardPage.RUS;
        this.symbolsPage = KeyboardPage.OTHER_SYMBOLS;
        this.currentHistoryIndex = -1;
        this.currChatType = ChatType.RP;
        this.bindsList = new ArrayList();
        this.shiftType = ShiftType.LOWER;
        this.bindersIsOpened = true;
        this.bindersAdapter = new BindersAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Keyboard.bindersAdapter$lambda$0(Keyboard.this, ((Integer) obj).intValue());
            }
        });
        this.emojiAdapter = new EmojiKeyboardAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Keyboard.emojiAdapter$lambda$0(Keyboard.this, (EmojiKeyboardItem) obj);
            }
        });
        TextInputEditText mainInputEt = bind.mainInputEt;
        Intrinsics.checkNotNullExpressionValue(mainInputEt, "mainInputEt");
        HoldBackspaceController holdBackspaceController = new HoldBackspaceController(mainInputEt);
        this.holdBackspaceController = holdBackspaceController;
        KeyboardButton jButtonKey = bind.keyboardContainerRus.jButtonKey;
        Intrinsics.checkNotNullExpressionValue(jButtonKey, "jButtonKey");
        KeyboardButton cButtonKey = bind.keyboardContainerRus.cButtonKey;
        Intrinsics.checkNotNullExpressionValue(cButtonKey, "cButtonKey");
        KeyboardButton yButtonKey = bind.keyboardContainerRus.yButtonKey;
        Intrinsics.checkNotNullExpressionValue(yButtonKey, "yButtonKey");
        KeyboardButton kButtonKey = bind.keyboardContainerRus.kButtonKey;
        Intrinsics.checkNotNullExpressionValue(kButtonKey, "kButtonKey");
        KeyboardButton eButtonKey = bind.keyboardContainerRus.eButtonKey;
        Intrinsics.checkNotNullExpressionValue(eButtonKey, "eButtonKey");
        KeyboardButton nButtonKey = bind.keyboardContainerRus.nButtonKey;
        Intrinsics.checkNotNullExpressionValue(nButtonKey, "nButtonKey");
        KeyboardButton gButtonKey = bind.keyboardContainerRus.gButtonKey;
        Intrinsics.checkNotNullExpressionValue(gButtonKey, "gButtonKey");
        KeyboardButton shButtonKey = bind.keyboardContainerRus.shButtonKey;
        Intrinsics.checkNotNullExpressionValue(shButtonKey, "shButtonKey");
        KeyboardButton shchButtonKey = bind.keyboardContainerRus.shchButtonKey;
        Intrinsics.checkNotNullExpressionValue(shchButtonKey, "shchButtonKey");
        KeyboardButton zButtonKey = bind.keyboardContainerRus.zButtonKey;
        Intrinsics.checkNotNullExpressionValue(zButtonKey, "zButtonKey");
        KeyboardButton hButtonKey = bind.keyboardContainerRus.hButtonKey;
        Intrinsics.checkNotNullExpressionValue(hButtonKey, "hButtonKey");
        KeyboardButton fButtonKey = bind.keyboardContainerRus.fButtonKey;
        Intrinsics.checkNotNullExpressionValue(fButtonKey, "fButtonKey");
        KeyboardButton yuButtonKey = bind.keyboardContainerRus.yuButtonKey;
        Intrinsics.checkNotNullExpressionValue(yuButtonKey, "yuButtonKey");
        KeyboardButton vButtonKey = bind.keyboardContainerRus.vButtonKey;
        Intrinsics.checkNotNullExpressionValue(vButtonKey, "vButtonKey");
        KeyboardButton aButtonKey = bind.keyboardContainerRus.aButtonKey;
        Intrinsics.checkNotNullExpressionValue(aButtonKey, "aButtonKey");
        KeyboardButton pButtonKey = bind.keyboardContainerRus.pButtonKey;
        Intrinsics.checkNotNullExpressionValue(pButtonKey, "pButtonKey");
        KeyboardButton rButtonKey = bind.keyboardContainerRus.rButtonKey;
        Intrinsics.checkNotNullExpressionValue(rButtonKey, "rButtonKey");
        KeyboardButton oButtonKey = bind.keyboardContainerRus.oButtonKey;
        Intrinsics.checkNotNullExpressionValue(oButtonKey, "oButtonKey");
        KeyboardButton lButtonKey = bind.keyboardContainerRus.lButtonKey;
        Intrinsics.checkNotNullExpressionValue(lButtonKey, "lButtonKey");
        KeyboardButton dButtonKey = bind.keyboardContainerRus.dButtonKey;
        Intrinsics.checkNotNullExpressionValue(dButtonKey, "dButtonKey");
        KeyboardButton zhButtonKey = bind.keyboardContainerRus.zhButtonKey;
        Intrinsics.checkNotNullExpressionValue(zhButtonKey, "zhButtonKey");
        KeyboardButton eeButtonKey = bind.keyboardContainerRus.eeButtonKey;
        Intrinsics.checkNotNullExpressionValue(eeButtonKey, "eeButtonKey");
        KeyboardButton shiftButtonKey = bind.keyboardContainerRus.shiftButtonKey;
        Intrinsics.checkNotNullExpressionValue(shiftButtonKey, "shiftButtonKey");
        KeyboardButton yaButtonKey = bind.keyboardContainerRus.yaButtonKey;
        Intrinsics.checkNotNullExpressionValue(yaButtonKey, "yaButtonKey");
        KeyboardButton chButtonKey = bind.keyboardContainerRus.chButtonKey;
        Intrinsics.checkNotNullExpressionValue(chButtonKey, "chButtonKey");
        KeyboardButton sButtonKey = bind.keyboardContainerRus.sButtonKey;
        Intrinsics.checkNotNullExpressionValue(sButtonKey, "sButtonKey");
        KeyboardButton mButtonKey = bind.keyboardContainerRus.mButtonKey;
        Intrinsics.checkNotNullExpressionValue(mButtonKey, "mButtonKey");
        KeyboardButton iButtonKey = bind.keyboardContainerRus.iButtonKey;
        Intrinsics.checkNotNullExpressionValue(iButtonKey, "iButtonKey");
        KeyboardButton tButtonKey = bind.keyboardContainerRus.tButtonKey;
        Intrinsics.checkNotNullExpressionValue(tButtonKey, "tButtonKey");
        KeyboardButton iaiButtonKey = bind.keyboardContainerRus.iaiButtonKey;
        Intrinsics.checkNotNullExpressionValue(iaiButtonKey, "iaiButtonKey");
        KeyboardButton bButtonKey = bind.keyboardContainerRus.bButtonKey;
        Intrinsics.checkNotNullExpressionValue(bButtonKey, "bButtonKey");
        KeyboardButton uButtonKey = bind.keyboardContainerRus.uButtonKey;
        Intrinsics.checkNotNullExpressionValue(uButtonKey, "uButtonKey");
        KeyboardButton backspaceButtonKey = bind.keyboardContainerRus.backspaceButtonKey;
        Intrinsics.checkNotNullExpressionValue(backspaceButtonKey, "backspaceButtonKey");
        KeyboardButton slashButtonKey = bind.keyboardContainerRus.slashButtonKey;
        Intrinsics.checkNotNullExpressionValue(slashButtonKey, "slashButtonKey");
        KeyboardButton globusButtonKey = bind.keyboardContainerRus.globusButtonKey;
        Intrinsics.checkNotNullExpressionValue(globusButtonKey, "globusButtonKey");
        KeyboardButton symbolsButtonKey = bind.keyboardContainerRus.symbolsButtonKey;
        Intrinsics.checkNotNullExpressionValue(symbolsButtonKey, "symbolsButtonKey");
        KeyboardButton spaceButtonKey = bind.keyboardContainerRus.spaceButtonKey;
        Intrinsics.checkNotNullExpressionValue(spaceButtonKey, "spaceButtonKey");
        KeyboardButton commaButtonKey = bind.keyboardContainerRus.commaButtonKey;
        Intrinsics.checkNotNullExpressionValue(commaButtonKey, "commaButtonKey");
        KeyboardButton dotPointButtonKey = bind.keyboardContainerRus.dotPointButtonKey;
        Intrinsics.checkNotNullExpressionValue(dotPointButtonKey, "dotPointButtonKey");
        KeyboardButton sendButtonKey = bind.keyboardContainerRus.sendButtonKey;
        Intrinsics.checkNotNullExpressionValue(sendButtonKey, "sendButtonKey");
        this.keyBoardBtnsRus = CollectionsKt.listOf((Object[]) new KeyboardButton[]{jButtonKey, cButtonKey, yButtonKey, kButtonKey, eButtonKey, nButtonKey, gButtonKey, shButtonKey, shchButtonKey, zButtonKey, hButtonKey, fButtonKey, yuButtonKey, vButtonKey, aButtonKey, pButtonKey, rButtonKey, oButtonKey, lButtonKey, dButtonKey, zhButtonKey, eeButtonKey, shiftButtonKey, yaButtonKey, chButtonKey, sButtonKey, mButtonKey, iButtonKey, tButtonKey, iaiButtonKey, bButtonKey, uButtonKey, backspaceButtonKey, slashButtonKey, globusButtonKey, symbolsButtonKey, spaceButtonKey, commaButtonKey, dotPointButtonKey, sendButtonKey});
        KeyboardButton oneButtonKey = bind.keyboardContainerSymbols.oneButtonKey;
        Intrinsics.checkNotNullExpressionValue(oneButtonKey, "oneButtonKey");
        KeyboardButton twoButtonKey = bind.keyboardContainerSymbols.twoButtonKey;
        Intrinsics.checkNotNullExpressionValue(twoButtonKey, "twoButtonKey");
        KeyboardButton threeButtonKey = bind.keyboardContainerSymbols.threeButtonKey;
        Intrinsics.checkNotNullExpressionValue(threeButtonKey, "threeButtonKey");
        KeyboardButton fourButtonKey = bind.keyboardContainerSymbols.fourButtonKey;
        Intrinsics.checkNotNullExpressionValue(fourButtonKey, "fourButtonKey");
        KeyboardButton fiveButtonKey = bind.keyboardContainerSymbols.fiveButtonKey;
        Intrinsics.checkNotNullExpressionValue(fiveButtonKey, "fiveButtonKey");
        KeyboardButton sixButtonKey = bind.keyboardContainerSymbols.sixButtonKey;
        Intrinsics.checkNotNullExpressionValue(sixButtonKey, "sixButtonKey");
        KeyboardButton sevenButtonKey = bind.keyboardContainerSymbols.sevenButtonKey;
        Intrinsics.checkNotNullExpressionValue(sevenButtonKey, "sevenButtonKey");
        KeyboardButton eightButtonKey = bind.keyboardContainerSymbols.eightButtonKey;
        Intrinsics.checkNotNullExpressionValue(eightButtonKey, "eightButtonKey");
        KeyboardButton nineButtonKey = bind.keyboardContainerSymbols.nineButtonKey;
        Intrinsics.checkNotNullExpressionValue(nineButtonKey, "nineButtonKey");
        KeyboardButton zeroButtonKey = bind.keyboardContainerSymbols.zeroButtonKey;
        Intrinsics.checkNotNullExpressionValue(zeroButtonKey, "zeroButtonKey");
        KeyboardButton atButtonKey = bind.keyboardContainerSymbols.atButtonKey;
        Intrinsics.checkNotNullExpressionValue(atButtonKey, "atButtonKey");
        KeyboardButton hashtagButtonKey = bind.keyboardContainerSymbols.hashtagButtonKey;
        Intrinsics.checkNotNullExpressionValue(hashtagButtonKey, "hashtagButtonKey");
        KeyboardButton dollarButtonKey = bind.keyboardContainerSymbols.dollarButtonKey;
        Intrinsics.checkNotNullExpressionValue(dollarButtonKey, "dollarButtonKey");
        KeyboardButton percentButtonKey = bind.keyboardContainerSymbols.percentButtonKey;
        Intrinsics.checkNotNullExpressionValue(percentButtonKey, "percentButtonKey");
        KeyboardButton underlineButtonKey = bind.keyboardContainerSymbols.underlineButtonKey;
        Intrinsics.checkNotNullExpressionValue(underlineButtonKey, "underlineButtonKey");
        KeyboardButton splashButtonKey = bind.keyboardContainerSymbols.splashButtonKey;
        Intrinsics.checkNotNullExpressionValue(splashButtonKey, "splashButtonKey");
        KeyboardButton commaButtonKey2 = bind.keyboardContainerSymbols.commaButtonKey;
        Intrinsics.checkNotNullExpressionValue(commaButtonKey2, "commaButtonKey");
        KeyboardButton quotButtonKey = bind.keyboardContainerSymbols.quotButtonKey;
        Intrinsics.checkNotNullExpressionValue(quotButtonKey, "quotButtonKey");
        KeyboardButton doubleQuotButtonKey = bind.keyboardContainerSymbols.doubleQuotButtonKey;
        Intrinsics.checkNotNullExpressionValue(doubleQuotButtonKey, "doubleQuotButtonKey");
        KeyboardButton multiplyButtonKey = bind.keyboardContainerSymbols.multiplyButtonKey;
        Intrinsics.checkNotNullExpressionValue(multiplyButtonKey, "multiplyButtonKey");
        KeyboardButton leftBracketButtonKey = bind.keyboardContainerSymbols.leftBracketButtonKey;
        Intrinsics.checkNotNullExpressionValue(leftBracketButtonKey, "leftBracketButtonKey");
        KeyboardButton rightBracketButtonKey = bind.keyboardContainerSymbols.rightBracketButtonKey;
        Intrinsics.checkNotNullExpressionValue(rightBracketButtonKey, "rightBracketButtonKey");
        KeyboardButton minusButtonKey = bind.keyboardContainerSymbols.minusButtonKey;
        Intrinsics.checkNotNullExpressionValue(minusButtonKey, "minusButtonKey");
        KeyboardButton colonButtonKey = bind.keyboardContainerSymbols.colonButtonKey;
        Intrinsics.checkNotNullExpressionValue(colonButtonKey, "colonButtonKey");
        KeyboardButton semicolonButtonKey = bind.keyboardContainerSymbols.semicolonButtonKey;
        Intrinsics.checkNotNullExpressionValue(semicolonButtonKey, "semicolonButtonKey");
        KeyboardButton plusButtonKey = bind.keyboardContainerSymbols.plusButtonKey;
        Intrinsics.checkNotNullExpressionValue(plusButtonKey, "plusButtonKey");
        KeyboardButton otherSymbolsButtonKey = bind.keyboardContainerSymbols.otherSymbolsButtonKey;
        Intrinsics.checkNotNullExpressionValue(otherSymbolsButtonKey, "otherSymbolsButtonKey");
        KeyboardButton andButtonKey = bind.keyboardContainerSymbols.andButtonKey;
        Intrinsics.checkNotNullExpressionValue(andButtonKey, "andButtonKey");
        KeyboardButton exclamationPointButtonKey = bind.keyboardContainerSymbols.exclamationPointButtonKey;
        Intrinsics.checkNotNullExpressionValue(exclamationPointButtonKey, "exclamationPointButtonKey");
        KeyboardButton questionMarkButtonKey = bind.keyboardContainerSymbols.questionMarkButtonKey;
        Intrinsics.checkNotNullExpressionValue(questionMarkButtonKey, "questionMarkButtonKey");
        KeyboardButton slashButtonKey2 = bind.keyboardContainerSymbols.slashButtonKey;
        Intrinsics.checkNotNullExpressionValue(slashButtonKey2, "slashButtonKey");
        KeyboardButton dotButtonKey = bind.keyboardContainerSymbols.dotButtonKey;
        Intrinsics.checkNotNullExpressionValue(dotButtonKey, "dotButtonKey");
        KeyboardButton backspaceButtonKey2 = bind.keyboardContainerSymbols.backspaceButtonKey;
        Intrinsics.checkNotNullExpressionValue(backspaceButtonKey2, "backspaceButtonKey");
        KeyboardButton backspaceButtonKey3 = bind.keyboardContainerSymbols.backspaceButtonKey;
        Intrinsics.checkNotNullExpressionValue(backspaceButtonKey3, "backspaceButtonKey");
        KeyboardButton globusButtonKey2 = bind.keyboardContainerSymbols.globusButtonKey;
        Intrinsics.checkNotNullExpressionValue(globusButtonKey2, "globusButtonKey");
        KeyboardButton abcButtonKey = bind.keyboardContainerSymbols.abcButtonKey;
        Intrinsics.checkNotNullExpressionValue(abcButtonKey, "abcButtonKey");
        KeyboardButton spaceButtonKey2 = bind.keyboardContainerSymbols.spaceButtonKey;
        Intrinsics.checkNotNullExpressionValue(spaceButtonKey2, "spaceButtonKey");
        KeyboardButton sendButtonKey2 = bind.keyboardContainerSymbols.sendButtonKey;
        Intrinsics.checkNotNullExpressionValue(sendButtonKey2, "sendButtonKey");
        this.keyBoardBtnsSymbols = CollectionsKt.listOf((Object[]) new KeyboardButton[]{oneButtonKey, twoButtonKey, threeButtonKey, fourButtonKey, fiveButtonKey, sixButtonKey, sevenButtonKey, eightButtonKey, nineButtonKey, zeroButtonKey, atButtonKey, hashtagButtonKey, dollarButtonKey, percentButtonKey, underlineButtonKey, splashButtonKey, commaButtonKey2, quotButtonKey, doubleQuotButtonKey, multiplyButtonKey, leftBracketButtonKey, rightBracketButtonKey, minusButtonKey, colonButtonKey, semicolonButtonKey, plusButtonKey, otherSymbolsButtonKey, andButtonKey, exclamationPointButtonKey, questionMarkButtonKey, slashButtonKey2, dotButtonKey, backspaceButtonKey2, backspaceButtonKey3, globusButtonKey2, abcButtonKey, spaceButtonKey2, sendButtonKey2});
        KeyboardButton oneButtonKey2 = bind.keyboardContainerOtherSymbols.oneButtonKey;
        Intrinsics.checkNotNullExpressionValue(oneButtonKey2, "oneButtonKey");
        KeyboardButton twoButtonKey2 = bind.keyboardContainerOtherSymbols.twoButtonKey;
        Intrinsics.checkNotNullExpressionValue(twoButtonKey2, "twoButtonKey");
        KeyboardButton threeButtonKey2 = bind.keyboardContainerOtherSymbols.threeButtonKey;
        Intrinsics.checkNotNullExpressionValue(threeButtonKey2, "threeButtonKey");
        KeyboardButton fourButtonKey2 = bind.keyboardContainerOtherSymbols.fourButtonKey;
        Intrinsics.checkNotNullExpressionValue(fourButtonKey2, "fourButtonKey");
        KeyboardButton fiveButtonKey2 = bind.keyboardContainerOtherSymbols.fiveButtonKey;
        Intrinsics.checkNotNullExpressionValue(fiveButtonKey2, "fiveButtonKey");
        KeyboardButton sixButtonKey2 = bind.keyboardContainerOtherSymbols.sixButtonKey;
        Intrinsics.checkNotNullExpressionValue(sixButtonKey2, "sixButtonKey");
        KeyboardButton sevenButtonKey2 = bind.keyboardContainerOtherSymbols.sevenButtonKey;
        Intrinsics.checkNotNullExpressionValue(sevenButtonKey2, "sevenButtonKey");
        KeyboardButton eightButtonKey2 = bind.keyboardContainerOtherSymbols.eightButtonKey;
        Intrinsics.checkNotNullExpressionValue(eightButtonKey2, "eightButtonKey");
        KeyboardButton nineButtonKey2 = bind.keyboardContainerOtherSymbols.nineButtonKey;
        Intrinsics.checkNotNullExpressionValue(nineButtonKey2, "nineButtonKey");
        KeyboardButton zeroButtonKey2 = bind.keyboardContainerOtherSymbols.zeroButtonKey;
        Intrinsics.checkNotNullExpressionValue(zeroButtonKey2, "zeroButtonKey");
        KeyboardButton multiplyButtonKey2 = bind.keyboardContainerOtherSymbols.multiplyButtonKey;
        Intrinsics.checkNotNullExpressionValue(multiplyButtonKey2, "multiplyButtonKey");
        KeyboardButton divideButtonKey = bind.keyboardContainerOtherSymbols.divideButtonKey;
        Intrinsics.checkNotNullExpressionValue(divideButtonKey, "divideButtonKey");
        KeyboardButton tickUpButtonKey = bind.keyboardContainerOtherSymbols.tickUpButtonKey;
        Intrinsics.checkNotNullExpressionValue(tickUpButtonKey, "tickUpButtonKey");
        KeyboardButton rootNumberButtonKey = bind.keyboardContainerOtherSymbols.rootNumberButtonKey;
        Intrinsics.checkNotNullExpressionValue(rootNumberButtonKey, "rootNumberButtonKey");
        KeyboardButton triangleButtonKey = bind.keyboardContainerOtherSymbols.triangleButtonKey;
        Intrinsics.checkNotNullExpressionValue(triangleButtonKey, "triangleButtonKey");
        KeyboardButton minusButtonKey2 = bind.keyboardContainerOtherSymbols.minusButtonKey;
        Intrinsics.checkNotNullExpressionValue(minusButtonKey2, "minusButtonKey");
        KeyboardButton plusButtonKey2 = bind.keyboardContainerOtherSymbols.plusButtonKey;
        Intrinsics.checkNotNullExpressionValue(plusButtonKey2, "plusButtonKey");
        KeyboardButton tickLeftButtonKey = bind.keyboardContainerOtherSymbols.tickLeftButtonKey;
        Intrinsics.checkNotNullExpressionValue(tickLeftButtonKey, "tickLeftButtonKey");
        KeyboardButton tickRightButtonKey = bind.keyboardContainerOtherSymbols.tickRightButtonKey;
        Intrinsics.checkNotNullExpressionValue(tickRightButtonKey, "tickRightButtonKey");
        KeyboardButton equalButtonKey = bind.keyboardContainerOtherSymbols.equalButtonKey;
        Intrinsics.checkNotNullExpressionValue(equalButtonKey, "equalButtonKey");
        KeyboardButton otherSymbolsButtonKey2 = bind.keyboardContainerOtherSymbols.otherSymbolsButtonKey;
        Intrinsics.checkNotNullExpressionValue(otherSymbolsButtonKey2, "otherSymbolsButtonKey");
        KeyboardButton aButtonKey2 = bind.keyboardContainerOtherSymbols.aButtonKey;
        Intrinsics.checkNotNullExpressionValue(aButtonKey2, "aButtonKey");
        KeyboardButton topCircleButtonKey = bind.keyboardContainerOtherSymbols.topCircleButtonKey;
        Intrinsics.checkNotNullExpressionValue(topCircleButtonKey, "topCircleButtonKey");
        KeyboardButton centerDotButtonKey = bind.keyboardContainerOtherSymbols.centerDotButtonKey;
        Intrinsics.checkNotNullExpressionValue(centerDotButtonKey, "centerDotButtonKey");
        KeyboardButton verticalLineButtonKey = bind.keyboardContainerOtherSymbols.verticalLineButtonKey;
        Intrinsics.checkNotNullExpressionValue(verticalLineButtonKey, "verticalLineButtonKey");
        KeyboardButton figureBraceLeftButtonKey = bind.keyboardContainerOtherSymbols.figureBraceLeftButtonKey;
        Intrinsics.checkNotNullExpressionValue(figureBraceLeftButtonKey, "figureBraceLeftButtonKey");
        KeyboardButton figureBraceRightButtonKey = bind.keyboardContainerOtherSymbols.figureBraceRightButtonKey;
        Intrinsics.checkNotNullExpressionValue(figureBraceRightButtonKey, "figureBraceRightButtonKey");
        KeyboardButton squareBraceLeftButtonKey = bind.keyboardContainerOtherSymbols.squareBraceLeftButtonKey;
        Intrinsics.checkNotNullExpressionValue(squareBraceLeftButtonKey, "squareBraceLeftButtonKey");
        KeyboardButton squareBraceRightButtonKey = bind.keyboardContainerOtherSymbols.squareBraceRightButtonKey;
        Intrinsics.checkNotNullExpressionValue(squareBraceRightButtonKey, "squareBraceRightButtonKey");
        KeyboardButton backspaceButtonKey4 = bind.keyboardContainerOtherSymbols.backspaceButtonKey;
        Intrinsics.checkNotNullExpressionValue(backspaceButtonKey4, "backspaceButtonKey");
        KeyboardButton splashButtonKey2 = bind.keyboardContainerOtherSymbols.splashButtonKey;
        Intrinsics.checkNotNullExpressionValue(splashButtonKey2, "splashButtonKey");
        KeyboardButton abcButtonKey2 = bind.keyboardContainerOtherSymbols.abcButtonKey;
        Intrinsics.checkNotNullExpressionValue(abcButtonKey2, "abcButtonKey");
        KeyboardButton globusButtonKey3 = bind.keyboardContainerOtherSymbols.globusButtonKey;
        Intrinsics.checkNotNullExpressionValue(globusButtonKey3, "globusButtonKey");
        KeyboardButton spaceButtonKey3 = bind.keyboardContainerOtherSymbols.spaceButtonKey;
        Intrinsics.checkNotNullExpressionValue(spaceButtonKey3, "spaceButtonKey");
        KeyboardButton commaButtonKey3 = bind.keyboardContainerOtherSymbols.commaButtonKey;
        Intrinsics.checkNotNullExpressionValue(commaButtonKey3, "commaButtonKey");
        KeyboardButton questionButtonKey = bind.keyboardContainerOtherSymbols.questionButtonKey;
        Intrinsics.checkNotNullExpressionValue(questionButtonKey, "questionButtonKey");
        KeyboardButton sendButtonKey3 = bind.keyboardContainerOtherSymbols.sendButtonKey;
        Intrinsics.checkNotNullExpressionValue(sendButtonKey3, "sendButtonKey");
        this.keyBoardBtnsOthersSymbols = CollectionsKt.listOf((Object[]) new KeyboardButton[]{oneButtonKey2, twoButtonKey2, threeButtonKey2, fourButtonKey2, fiveButtonKey2, sixButtonKey2, sevenButtonKey2, eightButtonKey2, nineButtonKey2, zeroButtonKey2, multiplyButtonKey2, divideButtonKey, tickUpButtonKey, rootNumberButtonKey, triangleButtonKey, minusButtonKey2, plusButtonKey2, tickLeftButtonKey, tickRightButtonKey, equalButtonKey, otherSymbolsButtonKey2, aButtonKey2, topCircleButtonKey, centerDotButtonKey, verticalLineButtonKey, figureBraceLeftButtonKey, figureBraceRightButtonKey, squareBraceLeftButtonKey, squareBraceRightButtonKey, backspaceButtonKey4, splashButtonKey2, abcButtonKey2, globusButtonKey3, spaceButtonKey3, commaButtonKey3, questionButtonKey, sendButtonKey3});
        KeyboardButton qButtonKey = bind.keyboardContainerEng.qButtonKey;
        Intrinsics.checkNotNullExpressionValue(qButtonKey, "qButtonKey");
        KeyboardButton wButtonKey = bind.keyboardContainerEng.wButtonKey;
        Intrinsics.checkNotNullExpressionValue(wButtonKey, "wButtonKey");
        KeyboardButton eButtonKey2 = bind.keyboardContainerEng.eButtonKey;
        Intrinsics.checkNotNullExpressionValue(eButtonKey2, "eButtonKey");
        KeyboardButton rButtonKey2 = bind.keyboardContainerEng.rButtonKey;
        Intrinsics.checkNotNullExpressionValue(rButtonKey2, "rButtonKey");
        KeyboardButton tButtonKey2 = bind.keyboardContainerEng.tButtonKey;
        Intrinsics.checkNotNullExpressionValue(tButtonKey2, "tButtonKey");
        KeyboardButton yButtonKey2 = bind.keyboardContainerEng.yButtonKey;
        Intrinsics.checkNotNullExpressionValue(yButtonKey2, "yButtonKey");
        KeyboardButton uButtonKey2 = bind.keyboardContainerEng.uButtonKey;
        Intrinsics.checkNotNullExpressionValue(uButtonKey2, "uButtonKey");
        KeyboardButton iButtonKey2 = bind.keyboardContainerEng.iButtonKey;
        Intrinsics.checkNotNullExpressionValue(iButtonKey2, "iButtonKey");
        KeyboardButton oButtonKey2 = bind.keyboardContainerEng.oButtonKey;
        Intrinsics.checkNotNullExpressionValue(oButtonKey2, "oButtonKey");
        KeyboardButton pButtonKey2 = bind.keyboardContainerEng.pButtonKey;
        Intrinsics.checkNotNullExpressionValue(pButtonKey2, "pButtonKey");
        KeyboardButton aButtonKey3 = bind.keyboardContainerEng.aButtonKey;
        Intrinsics.checkNotNullExpressionValue(aButtonKey3, "aButtonKey");
        KeyboardButton sButtonKey2 = bind.keyboardContainerEng.sButtonKey;
        Intrinsics.checkNotNullExpressionValue(sButtonKey2, "sButtonKey");
        KeyboardButton dButtonKey2 = bind.keyboardContainerEng.dButtonKey;
        Intrinsics.checkNotNullExpressionValue(dButtonKey2, "dButtonKey");
        KeyboardButton fButtonKey2 = bind.keyboardContainerEng.fButtonKey;
        Intrinsics.checkNotNullExpressionValue(fButtonKey2, "fButtonKey");
        KeyboardButton gButtonKey2 = bind.keyboardContainerEng.gButtonKey;
        Intrinsics.checkNotNullExpressionValue(gButtonKey2, "gButtonKey");
        KeyboardButton hButtonKey2 = bind.keyboardContainerEng.hButtonKey;
        Intrinsics.checkNotNullExpressionValue(hButtonKey2, "hButtonKey");
        KeyboardButton jButtonKey2 = bind.keyboardContainerEng.jButtonKey;
        Intrinsics.checkNotNullExpressionValue(jButtonKey2, "jButtonKey");
        KeyboardButton kButtonKey2 = bind.keyboardContainerEng.kButtonKey;
        Intrinsics.checkNotNullExpressionValue(kButtonKey2, "kButtonKey");
        KeyboardButton lButtonKey2 = bind.keyboardContainerEng.lButtonKey;
        Intrinsics.checkNotNullExpressionValue(lButtonKey2, "lButtonKey");
        KeyboardButton shiftButtonKey2 = bind.keyboardContainerEng.shiftButtonKey;
        Intrinsics.checkNotNullExpressionValue(shiftButtonKey2, "shiftButtonKey");
        KeyboardButton zButtonKey2 = bind.keyboardContainerEng.zButtonKey;
        Intrinsics.checkNotNullExpressionValue(zButtonKey2, "zButtonKey");
        KeyboardButton xButtonKey = bind.keyboardContainerEng.xButtonKey;
        Intrinsics.checkNotNullExpressionValue(xButtonKey, "xButtonKey");
        KeyboardButton cButtonKey2 = bind.keyboardContainerEng.cButtonKey;
        Intrinsics.checkNotNullExpressionValue(cButtonKey2, "cButtonKey");
        KeyboardButton vButtonKey2 = bind.keyboardContainerEng.vButtonKey;
        Intrinsics.checkNotNullExpressionValue(vButtonKey2, "vButtonKey");
        KeyboardButton bButtonKey2 = bind.keyboardContainerEng.bButtonKey;
        Intrinsics.checkNotNullExpressionValue(bButtonKey2, "bButtonKey");
        KeyboardButton nButtonKey2 = bind.keyboardContainerEng.nButtonKey;
        Intrinsics.checkNotNullExpressionValue(nButtonKey2, "nButtonKey");
        KeyboardButton mButtonKey2 = bind.keyboardContainerEng.mButtonKey;
        Intrinsics.checkNotNullExpressionValue(mButtonKey2, "mButtonKey");
        KeyboardButton globusButtonKey4 = bind.keyboardContainerEng.globusButtonKey;
        Intrinsics.checkNotNullExpressionValue(globusButtonKey4, "globusButtonKey");
        KeyboardButton symbolsButtonKey2 = bind.keyboardContainerEng.symbolsButtonKey;
        Intrinsics.checkNotNullExpressionValue(symbolsButtonKey2, "symbolsButtonKey");
        KeyboardButton spaceButtonKey4 = bind.keyboardContainerEng.spaceButtonKey;
        Intrinsics.checkNotNullExpressionValue(spaceButtonKey4, "spaceButtonKey");
        KeyboardButton commaButtonKey4 = bind.keyboardContainerEng.commaButtonKey;
        Intrinsics.checkNotNullExpressionValue(commaButtonKey4, "commaButtonKey");
        KeyboardButton dotPointButtonKey2 = bind.keyboardContainerEng.dotPointButtonKey;
        Intrinsics.checkNotNullExpressionValue(dotPointButtonKey2, "dotPointButtonKey");
        KeyboardButton sendButtonKey4 = bind.keyboardContainerEng.sendButtonKey;
        Intrinsics.checkNotNullExpressionValue(sendButtonKey4, "sendButtonKey");
        KeyboardButton backspaceButtonKey5 = bind.keyboardContainerEng.backspaceButtonKey;
        Intrinsics.checkNotNullExpressionValue(backspaceButtonKey5, "backspaceButtonKey");
        KeyboardButton splashButtonKey3 = bind.keyboardContainerEng.splashButtonKey;
        Intrinsics.checkNotNullExpressionValue(splashButtonKey3, "splashButtonKey");
        this.keyBoardBtnsEng = CollectionsKt.listOf((Object[]) new KeyboardButton[]{qButtonKey, wButtonKey, eButtonKey2, rButtonKey2, tButtonKey2, yButtonKey2, uButtonKey2, iButtonKey2, oButtonKey2, pButtonKey2, aButtonKey3, sButtonKey2, dButtonKey2, fButtonKey2, gButtonKey2, hButtonKey2, jButtonKey2, kButtonKey2, lButtonKey2, shiftButtonKey2, zButtonKey2, xButtonKey, cButtonKey2, vButtonKey2, bButtonKey2, nButtonKey2, mButtonKey2, globusButtonKey4, symbolsButtonKey2, spaceButtonKey4, commaButtonKey4, dotPointButtonKey2, sendButtonKey4, backspaceButtonKey5, splashButtonKey3});
        KeyboardButton rpBinderButtonKey = bind.rpBinderButtonKey;
        Intrinsics.checkNotNullExpressionValue(rpBinderButtonKey, "rpBinderButtonKey");
        KeyboardButton nonRpBinderButtonKey = bind.nonRpBinderButtonKey;
        Intrinsics.checkNotNullExpressionValue(nonRpBinderButtonKey, "nonRpBinderButtonKey");
        KeyboardButton orgBinderButtonKey = bind.orgBinderButtonKey;
        Intrinsics.checkNotNullExpressionValue(orgBinderButtonKey, "orgBinderButtonKey");
        KeyboardButton familyBinderButtonKey = bind.familyBinderButtonKey;
        Intrinsics.checkNotNullExpressionValue(familyBinderButtonKey, "familyBinderButtonKey");
        KeyboardButton workBinderButtonKey = bind.workBinderButtonKey;
        Intrinsics.checkNotNullExpressionValue(workBinderButtonKey, "workBinderButtonKey");
        KeyboardButton vipBinderButtonKey = bind.vipBinderButtonKey;
        Intrinsics.checkNotNullExpressionValue(vipBinderButtonKey, "vipBinderButtonKey");
        this.chatTypeBtns = CollectionsKt.listOf((Object[]) new KeyboardButton[]{rpBinderButtonKey, nonRpBinderButtonKey, orgBinderButtonKey, familyBinderButtonKey, workBinderButtonKey, vipBinderButtonKey});
        bind.mainKeyboardLayout.setClickable(true);
        addViewToConstraintLayout(linearLayout, -1, -1, true);
        linearLayout.setElevation(10.0f);
        bind.getRoot().setElevation(10.0f);
        lockBackClicking();
        setPosition(SAMPUIElement.PositionType.CENTER_BOTTOM, 0, 0);
        ChatEmoji.INSTANCE.init(targetActivity);
        setupKeyboardButtons();
        setupRusKeyboard();
        setupEngKeyboard();
        setupSymbolsKeyboard();
        setupOtherSymbolsKeyboard();
        setupHistoryButtons();
        setupBindersButtons();
        setupEmojiButtons();
        setupMargins();
        setupHistoryMainButton();
        setupChatTypeButtons();
        updateCurrentChatType(this.currChatType);
        setVisibility(false);
        changeShiftState();
        holdBackspaceController.attachTo(CollectionsKt.listOf((Object[]) new KeyboardButton[]{bind.keyboardContainerRus.backspaceButtonKey, bind.keyboardContainerEng.backspaceButtonKey, bind.keyboardContainerSymbols.backspaceButtonKey, bind.keyboardContainerOtherSymbols.backspaceButtonKey}));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit bindersAdapter$lambda$0(Keyboard keyboard, int i) {
        keyboard.getNotifier().clickedWrapper(UIElementID.COMMAND_BINDER.getId(), i, -1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit emojiAdapter$lambda$0(Keyboard keyboard, EmojiKeyboardItem emoji) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        keyboard.inputText(emoji);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Keyboard.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/Keyboard$EmojiSendTextSpan;", "", "sendText", "", "<init>", "(Ljava/lang/String;)V", "getSendText", "()Ljava/lang/String;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class EmojiSendTextSpan {
        private final String sendText;

        public EmojiSendTextSpan(String sendText) {
            Intrinsics.checkNotNullParameter(sendText, "sendText");
            this.sendText = sendText;
        }

        public final String getSendText() {
            return this.sendText;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Keyboard.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/Keyboard$EmojiSpanRange;", "", TtmlNode.START, "", TtmlNode.END, "sendText", "", "<init>", "(IILjava/lang/String;)V", "getStart", "()I", "getEnd", "getSendText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class EmojiSpanRange {
        private final int end;
        private final String sendText;
        private final int start;

        public static /* synthetic */ EmojiSpanRange copy$default(EmojiSpanRange emojiSpanRange, int i, int i2, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = emojiSpanRange.start;
            }
            if ((i3 & 2) != 0) {
                i2 = emojiSpanRange.end;
            }
            if ((i3 & 4) != 0) {
                str = emojiSpanRange.sendText;
            }
            return emojiSpanRange.copy(i, i2, str);
        }

        public final int component1() {
            return this.start;
        }

        public final int component2() {
            return this.end;
        }

        public final String component3() {
            return this.sendText;
        }

        public final EmojiSpanRange copy(int i, int i2, String sendText) {
            Intrinsics.checkNotNullParameter(sendText, "sendText");
            return new EmojiSpanRange(i, i2, sendText);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EmojiSpanRange) {
                EmojiSpanRange emojiSpanRange = (EmojiSpanRange) obj;
                return this.start == emojiSpanRange.start && this.end == emojiSpanRange.end && Intrinsics.areEqual(this.sendText, emojiSpanRange.sendText);
            }
            return false;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.start) * 31) + Integer.hashCode(this.end)) * 31) + this.sendText.hashCode();
        }

        public String toString() {
            int i = this.start;
            int i2 = this.end;
            return "EmojiSpanRange(start=" + i + ", end=" + i2 + ", sendText=" + this.sendText + ")";
        }

        public EmojiSpanRange(int i, int i2, String sendText) {
            Intrinsics.checkNotNullParameter(sendText, "sendText");
            this.start = i;
            this.end = i2;
            this.sendText = sendText;
        }

        public final int getStart() {
            return this.start;
        }

        public final int getEnd() {
            return this.end;
        }

        public final String getSendText() {
            return this.sendText;
        }
    }

    /* compiled from: Keyboard.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/Keyboard$Companion;", "", "<init>", "()V", "BINDERS_MAX_SIZE", "", "TAG", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void disableTypeAndBinders$default(Keyboard keyboard, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            str = "";
        }
        keyboard.disableTypeAndBinders(z, str);
    }

    public final void disableTypeAndBinders(boolean z, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.currentHistoryIndex = -1;
        KeyboardLayoutBinding keyboardLayoutBinding = this.binding;
        this.isDisabledInput = true;
        keyboardLayoutBinding.mainBinderBtn.setVisibility(8);
        keyboardLayoutBinding.emojiBtn.setVisibility(8);
        keyboardLayoutBinding.upBtnHistory.setVisibility(8);
        keyboardLayoutBinding.downBtnHistory.setVisibility(8);
        keyboardLayoutBinding.bindersBtnsContainer.setVisibility(4);
        keyboardLayoutBinding.bindersBtnContainer.setVisibility(4);
        this.holdBackspaceController.setIsEnableType(z);
        if (z) {
            this.isEnabledType = true;
            keyboardLayoutBinding.inputContainer.setVisibility(0);
            keyboardLayoutBinding.mainInputEt.setText(text);
            keyboardLayoutBinding.mainInputEt.requestFocus();
            keyboardLayoutBinding.mainInputEt.setSelection(text.length());
            return;
        }
        this.isEnabledType = false;
        keyboardLayoutBinding.inputContainer.setVisibility(8);
        this.holdBackspaceController.setOnRemove(new Function0() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit disableTypeAndBinders$lambda$0$0;
                disableTypeAndBinders$lambda$0$0 = Keyboard.disableTypeAndBinders$lambda$0$0(Keyboard.this);
                return disableTypeAndBinders$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit disableTypeAndBinders$lambda$0$0(Keyboard keyboard) {
        KeyboardInputListener keyboardInputListener = keyboard.inputListener;
        if (keyboardInputListener != null) {
            keyboardInputListener.onTextRemove();
        }
        return Unit.INSTANCE;
    }

    public final void enableTypeAndBinders() {
        this.currentHistoryIndex = -1;
        KeyboardLayoutBinding keyboardLayoutBinding = this.binding;
        this.isDisabledInput = false;
        this.isEnabledType = false;
        keyboardLayoutBinding.inputContainer.setVisibility(0);
        keyboardLayoutBinding.mainBinderBtn.setVisibility(0);
        keyboardLayoutBinding.emojiBtn.setVisibility(0);
        keyboardLayoutBinding.upBtnHistory.setVisibility(0);
        keyboardLayoutBinding.downBtnHistory.setVisibility(0);
    }

    public final void setInputListener(KeyboardInputListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.inputListener = listener;
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        this.symbolsPage = KeyboardPage.SYMBOLS;
        this.currPage = this.languagePage;
        setupMargins();
        if (!z) {
            changeKeyboardPage();
        } else {
            bringToFrontView();
            if (!this.isDisabledInput) {
                this.binding.mainInputEt.requestFocus();
            }
        }
        super.setVisibility(z);
    }

    private final void lockBackClicking() {
        KeyboardLayoutBinding keyboardLayoutBinding = this.binding;
        keyboardLayoutBinding.keyboardContainerRus.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda35
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Keyboard.lockBackClicking$lambda$0$0(view);
            }
        });
        keyboardLayoutBinding.keyboardContainerEng.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda36
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Keyboard.lockBackClicking$lambda$0$1(view);
            }
        });
        keyboardLayoutBinding.keyboardContainerSymbols.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Keyboard.lockBackClicking$lambda$0$2(view);
            }
        });
        keyboardLayoutBinding.keyboardContainerOtherSymbols.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Keyboard.lockBackClicking$lambda$0$3(view);
            }
        });
        keyboardLayoutBinding.keyboardContainerEmoji.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Keyboard.lockBackClicking$lambda$0$4(view);
            }
        });
        keyboardLayoutBinding.keyboardContainerBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Keyboard.lockBackClicking$lambda$0$5(view);
            }
        });
    }

    private final void setupBindersButtons() {
        this.binding.mainBinderBtn.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Keyboard.setupBindersButtons$lambda$0(Keyboard.this, view);
            }
        });
        KeyboardContainerBindingsBinding keyboardContainerBindingsBinding = this.binding.keyboardContainerBinding;
        keyboardContainerBindingsBinding.settingsButton.setBackgroundResource(com.arizona.common.R.drawable.bg_binders_key_blue);
        keyboardContainerBindingsBinding.settingsButton.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda10
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                z = Keyboard.setupBindersButtons$lambda$1$0(Keyboard.this, view, motionEvent);
                return z;
            }
        });
        keyboardContainerBindingsBinding.bindersList.setAdapter(this.bindersAdapter);
        for (int i = 0; i < 30; i++) {
            Activity targetActivity = getTargetActivity();
            Intrinsics.checkNotNull(targetActivity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.binder.CommandBinder.BinderListener");
            String b_getBinderName = ((CommandBinder.BinderListener) targetActivity).b_getBinderName(i);
            Activity targetActivity2 = getTargetActivity();
            Intrinsics.checkNotNull(targetActivity2, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.binder.CommandBinder.BinderListener");
            this.bindsList.add(new BinderData(i, b_getBinderName, getBinderTypeByState(((CommandBinder.BinderListener) targetActivity2).b_getBinderState(i))));
        }
        this.bindersAdapter.submitList(this.bindsList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setupBindersButtons$lambda$0(Keyboard keyboard, View view) {
        if (keyboard.currPage == KeyboardPage.BINDERS) {
            keyboard.binding.mainBinderBtn.setBackgroundResource(R.drawable.bg_binder_btn);
            keyboard.currPage = keyboard.previousPage;
            keyboard.changeKeyboardPage();
            return;
        }
        keyboard.binding.mainBinderBtn.setBackgroundResource(R.drawable.bg_binder_btn_pressed);
        keyboard.currPage = KeyboardPage.BINDERS;
        keyboard.changeKeyboardPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupBindersButtons$lambda$1$0(final Keyboard keyboard, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.arizona.common.ui.KeyboardButton");
        Intrinsics.checkNotNull(motionEvent);
        keyboard.setupClickAnim((KeyboardButton) view, motionEvent, new Function0() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Keyboard.setupBindersButtons$lambda$1$0$0(Keyboard.this);
                return unit;
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupBindersButtons$lambda$1$0$0(Keyboard keyboard) {
        keyboard.getNotifier().clickedWrapper(UIElementID.COMMAND_BINDER.getId(), 30, -1);
        return Unit.INSTANCE;
    }

    private final void setupEmojiButtons() {
        this.binding.emojiBtn.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda17
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return Keyboard.setupEmojiButtons$lambda$0(Keyboard.this, view, motionEvent);
            }
        });
        this.binding.keyboardContainerEmoji.emojiList.setAdapter(this.emojiAdapter);
        EmojiKeyboardAdapter emojiKeyboardAdapter = this.emojiAdapter;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : ChatEmoji.INSTANCE.getNamedTags().entrySet()) {
            if (hashSet.add(Integer.valueOf(((Number) ((Map.Entry) obj).getValue()).intValue()))) {
                arrayList.add(obj);
            }
        }
        ArrayList<Map.Entry> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (Map.Entry entry : arrayList2) {
            arrayList3.add(new EmojiKeyboardItem((String) entry.getKey(), ((Number) entry.getValue()).intValue()));
        }
        emojiKeyboardAdapter.submitList(arrayList3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean setupEmojiButtons$lambda$0(final Keyboard keyboard, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.arizona.common.ui.KeyboardButton");
        Intrinsics.checkNotNull(motionEvent);
        keyboard.setupClickAnim((KeyboardButton) view, motionEvent, new Function0() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Keyboard.setupEmojiButtons$lambda$0$0(Keyboard.this);
                return unit;
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupEmojiButtons$lambda$0$0(Keyboard keyboard) {
        keyboard.currPage = keyboard.currPage == KeyboardPage.EMOJI ? keyboard.previousPage : KeyboardPage.EMOJI;
        keyboard.changeKeyboardPage();
        return Unit.INSTANCE;
    }

    private final void setupChatTypeButtons() {
        final KeyboardLayoutBinding keyboardLayoutBinding = this.binding;
        for (final KeyboardButton keyboardButton : this.chatTypeBtns) {
            keyboardButton.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda6
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean z;
                    z = Keyboard.setupChatTypeButtons$lambda$0$0$0(Keyboard.this, keyboardButton, keyboardLayoutBinding, view, motionEvent);
                    return z;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupChatTypeButtons$lambda$0$0$0(final Keyboard keyboard, final KeyboardButton keyboardButton, final KeyboardLayoutBinding keyboardLayoutBinding, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.arizona.common.ui.KeyboardButton");
        Intrinsics.checkNotNull(motionEvent);
        keyboard.setupClickAnim((KeyboardButton) view, motionEvent, new Function0() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Keyboard.setupChatTypeButtons$lambda$0$0$0$0(KeyboardButton.this, keyboardLayoutBinding, keyboard);
                return unit;
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupChatTypeButtons$lambda$0$0$0$0(KeyboardButton keyboardButton, KeyboardLayoutBinding keyboardLayoutBinding, Keyboard keyboard) {
        int id = keyboardButton.getId();
        if (id == keyboardLayoutBinding.rpBinderButtonKey.getId()) {
            keyboard.updateCurrentChatType(ChatType.RP);
        } else if (id == keyboardLayoutBinding.nonRpBinderButtonKey.getId()) {
            keyboard.updateCurrentChatType(ChatType.NON_RP);
        } else if (id == keyboardLayoutBinding.orgBinderButtonKey.getId()) {
            keyboard.updateCurrentChatType(ChatType.ORG);
        } else if (id == keyboardLayoutBinding.familyBinderButtonKey.getId()) {
            keyboard.updateCurrentChatType(ChatType.FAMILY);
        } else if (id == keyboardLayoutBinding.workBinderButtonKey.getId()) {
            keyboard.updateCurrentChatType(ChatType.WORK);
        } else if (id == keyboardLayoutBinding.vipBinderButtonKey.getId()) {
            keyboard.updateCurrentChatType(ChatType.VIP);
        }
        return Unit.INSTANCE;
    }

    private final void updateCurrentChatType(ChatType chatType) {
        chatTypeBtnButtonsSetInvisible();
        this.currChatType = chatType;
        switch (WhenMappings.$EnumSwitchMapping$0[chatType.ordinal()]) {
            case 1:
                this.binding.bindersKeyBtn.setText("РП");
                return;
            case 2:
                this.binding.bindersKeyBtn.setText("НонРП");
                return;
            case 3:
                this.binding.bindersKeyBtn.setText("Орг.");
                return;
            case 4:
                this.binding.bindersKeyBtn.setText("Семья");
                return;
            case 5:
                this.binding.bindersKeyBtn.setText("Работа");
                return;
            case 6:
                this.binding.bindersKeyBtn.setText("VIP");
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void setupHistoryButtons() {
        KeyboardLayoutBinding keyboardLayoutBinding = this.binding;
        keyboardLayoutBinding.upBtnHistory.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda13
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                z = Keyboard.setupHistoryButtons$lambda$0$0(Keyboard.this, view, motionEvent);
                return z;
            }
        });
        keyboardLayoutBinding.downBtnHistory.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda14
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                z = Keyboard.setupHistoryButtons$lambda$0$1(Keyboard.this, view, motionEvent);
                return z;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupHistoryButtons$lambda$0$0(final Keyboard keyboard, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.arizona.common.ui.KeyboardButton");
        Intrinsics.checkNotNull(motionEvent);
        keyboard.setupClickAnim((KeyboardButton) view, motionEvent, new Function0() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Keyboard.setupHistoryButtons$lambda$0$0$0(Keyboard.this);
                return unit;
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupHistoryButtons$lambda$0$0$0(Keyboard keyboard) {
        Activity targetActivity = keyboard.getTargetActivity();
        Intrinsics.checkNotNull(targetActivity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard.InputListener");
        int t_GetKeyboardHistorySize = ((CustomKeyboard.InputListener) targetActivity).t_GetKeyboardHistorySize();
        int i = keyboard.currentHistoryIndex;
        if (i != t_GetKeyboardHistorySize - 1 && t_GetKeyboardHistorySize > 0) {
            keyboard.currentHistoryIndex = i + 1;
            keyboard.updateTextByCurrentHistoryLevel();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupHistoryButtons$lambda$0$1(final Keyboard keyboard, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.arizona.common.ui.KeyboardButton");
        Intrinsics.checkNotNull(motionEvent);
        keyboard.setupClickAnim((KeyboardButton) view, motionEvent, new Function0() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Keyboard.setupHistoryButtons$lambda$0$1$0(Keyboard.this);
                return unit;
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupHistoryButtons$lambda$0$1$0(Keyboard keyboard) {
        int i = keyboard.currentHistoryIndex;
        if (i > -1) {
            keyboard.currentHistoryIndex = i - 1;
            keyboard.updateTextByCurrentHistoryLevel();
        }
        return Unit.INSTANCE;
    }

    private final void setupMargins() {
        final KeyboardLayoutBinding keyboardLayoutBinding = this.binding;
        keyboardLayoutBinding.keyboardContainerRus.getRoot().postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                Keyboard.setupMargins$lambda$0$0(Keyboard.this, keyboardLayoutBinding);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupMargins$lambda$0$0(Keyboard keyboard, KeyboardLayoutBinding keyboardLayoutBinding) {
        int width = keyboard.binding.keyboardContainerRus.spacerLeft.getWidth();
        int width2 = keyboard.binding.keyboardContainerRus.spacerRight.getWidth();
        keyboardLayoutBinding.editTextSpacerLeft.getLayoutParams().width = width;
        keyboardLayoutBinding.editTextSpacerRight.getLayoutParams().width = width2 + 10;
        keyboardLayoutBinding.bindersSpacerLeft.getLayoutParams().width = width;
        keyboardLayoutBinding.bindersSpacerRight.getLayoutParams().width = width2;
        keyboardLayoutBinding.editTextSpacerLeft.requestLayout();
        keyboardLayoutBinding.editTextSpacerRight.requestLayout();
        keyboardLayoutBinding.bindersSpacerLeft.requestLayout();
        keyboardLayoutBinding.bindersSpacerRight.requestLayout();
    }

    private final void chatTypeBtnButtonsSetInvisible() {
        KeyboardLayoutBinding keyboardLayoutBinding = this.binding;
        keyboardLayoutBinding.bindersTickOpen.setImageResource(R.drawable.ic_arrow_up);
        keyboardLayoutBinding.bindersBtnsContainer.setVisibility(4);
    }

    private final void chatTypeBtnButtonsSetVisible() {
        KeyboardLayoutBinding keyboardLayoutBinding = this.binding;
        keyboardLayoutBinding.bindersBtnsContainer.setVisibility(0);
        keyboardLayoutBinding.bindersBtnContainer.setVisibility(0);
    }

    private final void setupHistoryMainButton() {
        final KeyboardLayoutBinding keyboardLayoutBinding = this.binding;
        keyboardLayoutBinding.bindersBtnContainer.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda11
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                z = Keyboard.setupHistoryMainButton$lambda$0$0(KeyboardLayoutBinding.this, this, view, motionEvent);
                return z;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupHistoryMainButton$lambda$0$0(final KeyboardLayoutBinding keyboardLayoutBinding, final Keyboard keyboard, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            keyboardLayoutBinding.bindersKeyBtn.onActionDown();
        } else if (action == 1) {
            keyboardLayoutBinding.bindersBtnContainer.post(new Runnable() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    Keyboard.setupHistoryMainButton$lambda$0$0$0(KeyboardLayoutBinding.this, keyboard);
                }
            });
            keyboard.bindersIsOpened = !keyboard.bindersIsOpened;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupHistoryMainButton$lambda$0$0$0(KeyboardLayoutBinding keyboardLayoutBinding, Keyboard keyboard) {
        keyboardLayoutBinding.bindersKeyBtn.onActionUp();
        if (!keyboard.bindersIsOpened) {
            keyboardLayoutBinding.bindersTickOpen.setImageResource(R.drawable.ic_arrow_down);
            keyboardLayoutBinding.bindersBtnsContainer.setVisibility(0);
            return;
        }
        keyboard.chatTypeBtnButtonsSetInvisible();
    }

    private final boolean setupClickAnim(KeyboardButton keyboardButton, MotionEvent motionEvent, Function0<Unit> function0) {
        int action = motionEvent.getAction();
        if (action == 0) {
            keyboardButton.onActionDown();
            return true;
        } else if (action != 1) {
            return false;
        } else {
            keyboardButton.onActionUp();
            function0.invoke();
            return true;
        }
    }

    private final boolean setupClickAnimLong(KeyboardButton keyboardButton, MotionEvent motionEvent, Function0<Unit> function0, final Function0<Unit> function02) {
        int action = motionEvent.getAction();
        if (action == 0) {
            keyboardButton.onActionDown();
            this.longClickTriggered = false;
            Runnable runnable = new Runnable() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    Keyboard.setupClickAnimLong$lambda$0(Keyboard.this, function02);
                }
            };
            this.longClickRunnable = runnable;
            Intrinsics.checkNotNull(runnable);
            keyboardButton.postDelayed(runnable, 500L);
            return true;
        } else if (action != 1) {
            if (action != 3) {
                return false;
            }
            keyboardButton.onActionUp();
            Runnable runnable2 = this.longClickRunnable;
            if (runnable2 != null) {
                keyboardButton.removeCallbacks(runnable2);
            }
            return true;
        } else {
            keyboardButton.onActionUp();
            if (!this.longClickTriggered) {
                function0.invoke();
            }
            Runnable runnable3 = this.longClickRunnable;
            if (runnable3 != null) {
                keyboardButton.removeCallbacks(runnable3);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setupClickAnimLong$lambda$0(Keyboard keyboard, Function0 function0) {
        keyboard.longClickTriggered = true;
        function0.invoke();
    }

    private final void setupOtherSymbolsKeyboard() {
        final KeyboardContainerOtherSymbolsBinding keyboardContainerOtherSymbolsBinding = this.binding.keyboardContainerOtherSymbols;
        for (final KeyboardButton keyboardButton : this.keyBoardBtnsOthersSymbols) {
            keyboardButton.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda16
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean z;
                    z = Keyboard.setupOtherSymbolsKeyboard$lambda$0$0$0(Keyboard.this, keyboardButton, keyboardContainerOtherSymbolsBinding, view, motionEvent);
                    return z;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupOtherSymbolsKeyboard$lambda$0$0$0(final Keyboard keyboard, final KeyboardButton keyboardButton, final KeyboardContainerOtherSymbolsBinding keyboardContainerOtherSymbolsBinding, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.arizona.common.ui.KeyboardButton");
        Intrinsics.checkNotNull(motionEvent);
        keyboard.setupClickAnim((KeyboardButton) view, motionEvent, new Function0() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Keyboard.setupOtherSymbolsKeyboard$lambda$0$0$0$0(KeyboardButton.this, keyboardContainerOtherSymbolsBinding, keyboard);
                return unit;
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupOtherSymbolsKeyboard$lambda$0$0$0$0(KeyboardButton keyboardButton, KeyboardContainerOtherSymbolsBinding keyboardContainerOtherSymbolsBinding, Keyboard keyboard) {
        int id = keyboardButton.getId();
        if (id == keyboardContainerOtherSymbolsBinding.oneButtonKey.getId()) {
            KeyboardButton oneButtonKey = keyboardContainerOtherSymbolsBinding.oneButtonKey;
            Intrinsics.checkNotNullExpressionValue(oneButtonKey, "oneButtonKey");
            keyboard.inputButton(oneButtonKey, '1');
        } else if (id == keyboardContainerOtherSymbolsBinding.twoButtonKey.getId()) {
            KeyboardButton twoButtonKey = keyboardContainerOtherSymbolsBinding.twoButtonKey;
            Intrinsics.checkNotNullExpressionValue(twoButtonKey, "twoButtonKey");
            keyboard.inputButton(twoButtonKey, '2');
        } else if (id == keyboardContainerOtherSymbolsBinding.threeButtonKey.getId()) {
            KeyboardButton threeButtonKey = keyboardContainerOtherSymbolsBinding.threeButtonKey;
            Intrinsics.checkNotNullExpressionValue(threeButtonKey, "threeButtonKey");
            keyboard.inputButton(threeButtonKey, '3');
        } else if (id == keyboardContainerOtherSymbolsBinding.fourButtonKey.getId()) {
            KeyboardButton fourButtonKey = keyboardContainerOtherSymbolsBinding.fourButtonKey;
            Intrinsics.checkNotNullExpressionValue(fourButtonKey, "fourButtonKey");
            keyboard.inputButton(fourButtonKey, '4');
        } else if (id == keyboardContainerOtherSymbolsBinding.fiveButtonKey.getId()) {
            KeyboardButton fiveButtonKey = keyboardContainerOtherSymbolsBinding.fiveButtonKey;
            Intrinsics.checkNotNullExpressionValue(fiveButtonKey, "fiveButtonKey");
            keyboard.inputButton(fiveButtonKey, '5');
        } else if (id == keyboardContainerOtherSymbolsBinding.sixButtonKey.getId()) {
            KeyboardButton sixButtonKey = keyboardContainerOtherSymbolsBinding.sixButtonKey;
            Intrinsics.checkNotNullExpressionValue(sixButtonKey, "sixButtonKey");
            keyboard.inputButton(sixButtonKey, '6');
        } else if (id == keyboardContainerOtherSymbolsBinding.sevenButtonKey.getId()) {
            KeyboardButton sevenButtonKey = keyboardContainerOtherSymbolsBinding.sevenButtonKey;
            Intrinsics.checkNotNullExpressionValue(sevenButtonKey, "sevenButtonKey");
            keyboard.inputButton(sevenButtonKey, '7');
        } else if (id == keyboardContainerOtherSymbolsBinding.eightButtonKey.getId()) {
            KeyboardButton eightButtonKey = keyboardContainerOtherSymbolsBinding.eightButtonKey;
            Intrinsics.checkNotNullExpressionValue(eightButtonKey, "eightButtonKey");
            keyboard.inputButton(eightButtonKey, '8');
        } else if (id == keyboardContainerOtherSymbolsBinding.nineButtonKey.getId()) {
            KeyboardButton nineButtonKey = keyboardContainerOtherSymbolsBinding.nineButtonKey;
            Intrinsics.checkNotNullExpressionValue(nineButtonKey, "nineButtonKey");
            keyboard.inputButton(nineButtonKey, '9');
        } else if (id == keyboardContainerOtherSymbolsBinding.zeroButtonKey.getId()) {
            KeyboardButton zeroButtonKey = keyboardContainerOtherSymbolsBinding.zeroButtonKey;
            Intrinsics.checkNotNullExpressionValue(zeroButtonKey, "zeroButtonKey");
            keyboard.inputButton(zeroButtonKey, '0');
        } else if (id == keyboardContainerOtherSymbolsBinding.multiplyButtonKey.getId()) {
            KeyboardButton multiplyButtonKey = keyboardContainerOtherSymbolsBinding.multiplyButtonKey;
            Intrinsics.checkNotNullExpressionValue(multiplyButtonKey, "multiplyButtonKey");
            keyboard.inputButton(multiplyButtonKey, 'x');
        } else if (id == keyboardContainerOtherSymbolsBinding.divideButtonKey.getId()) {
            KeyboardButton divideButtonKey = keyboardContainerOtherSymbolsBinding.divideButtonKey;
            Intrinsics.checkNotNullExpressionValue(divideButtonKey, "divideButtonKey");
            keyboard.inputButton(divideButtonKey, (char) 247);
        } else if (id == keyboardContainerOtherSymbolsBinding.tickUpButtonKey.getId()) {
            KeyboardButton tickUpButtonKey = keyboardContainerOtherSymbolsBinding.tickUpButtonKey;
            Intrinsics.checkNotNullExpressionValue(tickUpButtonKey, "tickUpButtonKey");
            keyboard.inputButton(tickUpButtonKey, '^');
        } else if (id == keyboardContainerOtherSymbolsBinding.rootNumberButtonKey.getId()) {
            KeyboardButton rootNumberButtonKey = keyboardContainerOtherSymbolsBinding.rootNumberButtonKey;
            Intrinsics.checkNotNullExpressionValue(rootNumberButtonKey, "rootNumberButtonKey");
            keyboard.inputButton(rootNumberButtonKey, (char) 8730);
        } else if (id == keyboardContainerOtherSymbolsBinding.triangleButtonKey.getId()) {
            KeyboardButton triangleButtonKey = keyboardContainerOtherSymbolsBinding.triangleButtonKey;
            Intrinsics.checkNotNullExpressionValue(triangleButtonKey, "triangleButtonKey");
            keyboard.inputButton(triangleButtonKey, (char) 916);
        } else if (id == keyboardContainerOtherSymbolsBinding.minusButtonKey.getId()) {
            KeyboardButton minusButtonKey = keyboardContainerOtherSymbolsBinding.minusButtonKey;
            Intrinsics.checkNotNullExpressionValue(minusButtonKey, "minusButtonKey");
            keyboard.inputButton(minusButtonKey, '-');
        } else if (id == keyboardContainerOtherSymbolsBinding.plusButtonKey.getId()) {
            KeyboardButton plusButtonKey = keyboardContainerOtherSymbolsBinding.plusButtonKey;
            Intrinsics.checkNotNullExpressionValue(plusButtonKey, "plusButtonKey");
            keyboard.inputButton(plusButtonKey, '+');
        } else if (id == keyboardContainerOtherSymbolsBinding.tickLeftButtonKey.getId()) {
            KeyboardButton tickLeftButtonKey = keyboardContainerOtherSymbolsBinding.tickLeftButtonKey;
            Intrinsics.checkNotNullExpressionValue(tickLeftButtonKey, "tickLeftButtonKey");
            keyboard.inputButton(tickLeftButtonKey, Typography.less);
        } else if (id == keyboardContainerOtherSymbolsBinding.tickRightButtonKey.getId()) {
            KeyboardButton tickRightButtonKey = keyboardContainerOtherSymbolsBinding.tickRightButtonKey;
            Intrinsics.checkNotNullExpressionValue(tickRightButtonKey, "tickRightButtonKey");
            keyboard.inputButton(tickRightButtonKey, Typography.greater);
        } else if (id == keyboardContainerOtherSymbolsBinding.equalButtonKey.getId()) {
            KeyboardButton equalButtonKey = keyboardContainerOtherSymbolsBinding.equalButtonKey;
            Intrinsics.checkNotNullExpressionValue(equalButtonKey, "equalButtonKey");
            keyboard.inputButton(equalButtonKey, '=');
        } else if (id == keyboardContainerOtherSymbolsBinding.otherSymbolsButtonKey.getId()) {
            keyboard.changeSymbolsPage();
        } else if (id == keyboardContainerOtherSymbolsBinding.aButtonKey.getId()) {
            KeyboardButton aButtonKey = keyboardContainerOtherSymbolsBinding.aButtonKey;
            Intrinsics.checkNotNullExpressionValue(aButtonKey, "aButtonKey");
            keyboard.inputButton(aButtonKey, (char) 945);
        } else if (id == keyboardContainerOtherSymbolsBinding.topCircleButtonKey.getId()) {
            KeyboardButton topCircleButtonKey = keyboardContainerOtherSymbolsBinding.topCircleButtonKey;
            Intrinsics.checkNotNullExpressionValue(topCircleButtonKey, "topCircleButtonKey");
            keyboard.inputButton(topCircleButtonKey, Typography.degree);
        } else if (id == keyboardContainerOtherSymbolsBinding.centerDotButtonKey.getId()) {
            KeyboardButton centerDotButtonKey = keyboardContainerOtherSymbolsBinding.centerDotButtonKey;
            Intrinsics.checkNotNullExpressionValue(centerDotButtonKey, "centerDotButtonKey");
            keyboard.inputButton(centerDotButtonKey, Typography.middleDot);
        } else if (id == keyboardContainerOtherSymbolsBinding.verticalLineButtonKey.getId()) {
            KeyboardButton verticalLineButtonKey = keyboardContainerOtherSymbolsBinding.verticalLineButtonKey;
            Intrinsics.checkNotNullExpressionValue(verticalLineButtonKey, "verticalLineButtonKey");
            keyboard.inputButton(verticalLineButtonKey, '|');
        } else if (id == keyboardContainerOtherSymbolsBinding.figureBraceLeftButtonKey.getId()) {
            KeyboardButton figureBraceLeftButtonKey = keyboardContainerOtherSymbolsBinding.figureBraceLeftButtonKey;
            Intrinsics.checkNotNullExpressionValue(figureBraceLeftButtonKey, "figureBraceLeftButtonKey");
            keyboard.inputButton(figureBraceLeftButtonKey, AbstractJsonLexerKt.BEGIN_OBJ);
        } else if (id == keyboardContainerOtherSymbolsBinding.figureBraceRightButtonKey.getId()) {
            KeyboardButton figureBraceRightButtonKey = keyboardContainerOtherSymbolsBinding.figureBraceRightButtonKey;
            Intrinsics.checkNotNullExpressionValue(figureBraceRightButtonKey, "figureBraceRightButtonKey");
            keyboard.inputButton(figureBraceRightButtonKey, AbstractJsonLexerKt.END_OBJ);
        } else if (id == keyboardContainerOtherSymbolsBinding.squareBraceLeftButtonKey.getId()) {
            KeyboardButton squareBraceLeftButtonKey = keyboardContainerOtherSymbolsBinding.squareBraceLeftButtonKey;
            Intrinsics.checkNotNullExpressionValue(squareBraceLeftButtonKey, "squareBraceLeftButtonKey");
            keyboard.inputButton(squareBraceLeftButtonKey, AbstractJsonLexerKt.BEGIN_LIST);
        } else if (id == keyboardContainerOtherSymbolsBinding.squareBraceRightButtonKey.getId()) {
            KeyboardButton squareBraceRightButtonKey = keyboardContainerOtherSymbolsBinding.squareBraceRightButtonKey;
            Intrinsics.checkNotNullExpressionValue(squareBraceRightButtonKey, "squareBraceRightButtonKey");
            keyboard.inputButton(squareBraceRightButtonKey, AbstractJsonLexerKt.END_LIST);
        } else if (id == keyboardContainerOtherSymbolsBinding.splashButtonKey.getId()) {
            KeyboardButton splashButtonKey = keyboardContainerOtherSymbolsBinding.splashButtonKey;
            Intrinsics.checkNotNullExpressionValue(splashButtonKey, "splashButtonKey");
            keyboard.inputButton(splashButtonKey, '/');
        } else if (id == keyboardContainerOtherSymbolsBinding.abcButtonKey.getId()) {
            keyboard.goToLanguageKeyboard();
        } else if (id == keyboardContainerOtherSymbolsBinding.globusButtonKey.getId()) {
            keyboard.changeLanguagePage();
        } else if (id == keyboardContainerOtherSymbolsBinding.spaceButtonKey.getId()) {
            KeyboardButton spaceButtonKey = keyboardContainerOtherSymbolsBinding.spaceButtonKey;
            Intrinsics.checkNotNullExpressionValue(spaceButtonKey, "spaceButtonKey");
            keyboard.inputButton(spaceButtonKey, ' ');
        } else if (id == keyboardContainerOtherSymbolsBinding.commaButtonKey.getId()) {
            KeyboardButton commaButtonKey = keyboardContainerOtherSymbolsBinding.commaButtonKey;
            Intrinsics.checkNotNullExpressionValue(commaButtonKey, "commaButtonKey");
            keyboard.inputButton(commaButtonKey, AbstractJsonLexerKt.COMMA);
        } else if (id == keyboardContainerOtherSymbolsBinding.questionButtonKey.getId()) {
            KeyboardButton questionButtonKey = keyboardContainerOtherSymbolsBinding.questionButtonKey;
            Intrinsics.checkNotNullExpressionValue(questionButtonKey, "questionButtonKey");
            keyboard.inputButton(questionButtonKey, '?');
        } else if (id == keyboardContainerOtherSymbolsBinding.sendButtonKey.getId()) {
            keyboard.sendCommand();
        }
        return Unit.INSTANCE;
    }

    private final void setupSymbolsKeyboard() {
        final KeyboardContainerSymbolsBinding keyboardContainerSymbolsBinding = this.binding.keyboardContainerSymbols;
        for (final KeyboardButton keyboardButton : this.keyBoardBtnsSymbols) {
            keyboardButton.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda31
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean z;
                    z = Keyboard.setupSymbolsKeyboard$lambda$0$0$0(Keyboard.this, keyboardButton, keyboardContainerSymbolsBinding, view, motionEvent);
                    return z;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupSymbolsKeyboard$lambda$0$0$0(final Keyboard keyboard, final KeyboardButton keyboardButton, final KeyboardContainerSymbolsBinding keyboardContainerSymbolsBinding, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.arizona.common.ui.KeyboardButton");
        Intrinsics.checkNotNull(motionEvent);
        keyboard.setupClickAnim((KeyboardButton) view, motionEvent, new Function0() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Keyboard.setupSymbolsKeyboard$lambda$0$0$0$0(KeyboardButton.this, keyboardContainerSymbolsBinding, keyboard);
                return unit;
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupSymbolsKeyboard$lambda$0$0$0$0(KeyboardButton keyboardButton, KeyboardContainerSymbolsBinding keyboardContainerSymbolsBinding, Keyboard keyboard) {
        int id = keyboardButton.getId();
        if (id == keyboardContainerSymbolsBinding.oneButtonKey.getId()) {
            KeyboardButton oneButtonKey = keyboardContainerSymbolsBinding.oneButtonKey;
            Intrinsics.checkNotNullExpressionValue(oneButtonKey, "oneButtonKey");
            keyboard.inputButton(oneButtonKey, '1');
        } else if (id == keyboardContainerSymbolsBinding.twoButtonKey.getId()) {
            KeyboardButton twoButtonKey = keyboardContainerSymbolsBinding.twoButtonKey;
            Intrinsics.checkNotNullExpressionValue(twoButtonKey, "twoButtonKey");
            keyboard.inputButton(twoButtonKey, '2');
        } else if (id == keyboardContainerSymbolsBinding.threeButtonKey.getId()) {
            KeyboardButton threeButtonKey = keyboardContainerSymbolsBinding.threeButtonKey;
            Intrinsics.checkNotNullExpressionValue(threeButtonKey, "threeButtonKey");
            keyboard.inputButton(threeButtonKey, '3');
        } else if (id == keyboardContainerSymbolsBinding.fourButtonKey.getId()) {
            KeyboardButton fourButtonKey = keyboardContainerSymbolsBinding.fourButtonKey;
            Intrinsics.checkNotNullExpressionValue(fourButtonKey, "fourButtonKey");
            keyboard.inputButton(fourButtonKey, '4');
        } else if (id == keyboardContainerSymbolsBinding.fiveButtonKey.getId()) {
            KeyboardButton fiveButtonKey = keyboardContainerSymbolsBinding.fiveButtonKey;
            Intrinsics.checkNotNullExpressionValue(fiveButtonKey, "fiveButtonKey");
            keyboard.inputButton(fiveButtonKey, '5');
        } else if (id == keyboardContainerSymbolsBinding.sixButtonKey.getId()) {
            KeyboardButton sixButtonKey = keyboardContainerSymbolsBinding.sixButtonKey;
            Intrinsics.checkNotNullExpressionValue(sixButtonKey, "sixButtonKey");
            keyboard.inputButton(sixButtonKey, '6');
        } else if (id == keyboardContainerSymbolsBinding.sevenButtonKey.getId()) {
            KeyboardButton sevenButtonKey = keyboardContainerSymbolsBinding.sevenButtonKey;
            Intrinsics.checkNotNullExpressionValue(sevenButtonKey, "sevenButtonKey");
            keyboard.inputButton(sevenButtonKey, '7');
        } else if (id == keyboardContainerSymbolsBinding.eightButtonKey.getId()) {
            KeyboardButton eightButtonKey = keyboardContainerSymbolsBinding.eightButtonKey;
            Intrinsics.checkNotNullExpressionValue(eightButtonKey, "eightButtonKey");
            keyboard.inputButton(eightButtonKey, '8');
        } else if (id == keyboardContainerSymbolsBinding.nineButtonKey.getId()) {
            KeyboardButton nineButtonKey = keyboardContainerSymbolsBinding.nineButtonKey;
            Intrinsics.checkNotNullExpressionValue(nineButtonKey, "nineButtonKey");
            keyboard.inputButton(nineButtonKey, '9');
        } else if (id == keyboardContainerSymbolsBinding.zeroButtonKey.getId()) {
            KeyboardButton zeroButtonKey = keyboardContainerSymbolsBinding.zeroButtonKey;
            Intrinsics.checkNotNullExpressionValue(zeroButtonKey, "zeroButtonKey");
            keyboard.inputButton(zeroButtonKey, '0');
        } else if (id == keyboardContainerSymbolsBinding.atButtonKey.getId()) {
            KeyboardButton atButtonKey = keyboardContainerSymbolsBinding.atButtonKey;
            Intrinsics.checkNotNullExpressionValue(atButtonKey, "atButtonKey");
            keyboard.inputButton(atButtonKey, '@');
        } else if (id == keyboardContainerSymbolsBinding.hashtagButtonKey.getId()) {
            KeyboardButton hashtagButtonKey = keyboardContainerSymbolsBinding.hashtagButtonKey;
            Intrinsics.checkNotNullExpressionValue(hashtagButtonKey, "hashtagButtonKey");
            keyboard.inputButton(hashtagButtonKey, '#');
        } else if (id == keyboardContainerSymbolsBinding.dollarButtonKey.getId()) {
            KeyboardButton dollarButtonKey = keyboardContainerSymbolsBinding.dollarButtonKey;
            Intrinsics.checkNotNullExpressionValue(dollarButtonKey, "dollarButtonKey");
            keyboard.inputButton(dollarButtonKey, Typography.dollar);
        } else if (id == keyboardContainerSymbolsBinding.percentButtonKey.getId()) {
            KeyboardButton percentButtonKey = keyboardContainerSymbolsBinding.percentButtonKey;
            Intrinsics.checkNotNullExpressionValue(percentButtonKey, "percentButtonKey");
            keyboard.inputButton(percentButtonKey, '%');
        } else if (id == keyboardContainerSymbolsBinding.doubleQuotButtonKey.getId()) {
            KeyboardButton doubleQuotButtonKey = keyboardContainerSymbolsBinding.doubleQuotButtonKey;
            Intrinsics.checkNotNullExpressionValue(doubleQuotButtonKey, "doubleQuotButtonKey");
            keyboard.inputButton(doubleQuotButtonKey, '\"');
        } else if (id == keyboardContainerSymbolsBinding.multiplyButtonKey.getId()) {
            KeyboardButton multiplyButtonKey = keyboardContainerSymbolsBinding.multiplyButtonKey;
            Intrinsics.checkNotNullExpressionValue(multiplyButtonKey, "multiplyButtonKey");
            keyboard.inputButton(multiplyButtonKey, '*');
        } else if (id == keyboardContainerSymbolsBinding.leftBracketButtonKey.getId()) {
            KeyboardButton leftBracketButtonKey = keyboardContainerSymbolsBinding.leftBracketButtonKey;
            Intrinsics.checkNotNullExpressionValue(leftBracketButtonKey, "leftBracketButtonKey");
            keyboard.inputButton(leftBracketButtonKey, '(');
        } else if (id == keyboardContainerSymbolsBinding.rightBracketButtonKey.getId()) {
            KeyboardButton rightBracketButtonKey = keyboardContainerSymbolsBinding.rightBracketButtonKey;
            Intrinsics.checkNotNullExpressionValue(rightBracketButtonKey, "rightBracketButtonKey");
            keyboard.inputButton(rightBracketButtonKey, ')');
        } else if (id == keyboardContainerSymbolsBinding.minusButtonKey.getId()) {
            KeyboardButton minusButtonKey = keyboardContainerSymbolsBinding.minusButtonKey;
            Intrinsics.checkNotNullExpressionValue(minusButtonKey, "minusButtonKey");
            keyboard.inputButton(minusButtonKey, '-');
        } else if (id == keyboardContainerSymbolsBinding.underlineButtonKey.getId()) {
            KeyboardButton underlineButtonKey = keyboardContainerSymbolsBinding.underlineButtonKey;
            Intrinsics.checkNotNullExpressionValue(underlineButtonKey, "underlineButtonKey");
            keyboard.inputButton(underlineButtonKey, '_');
        } else if (id == keyboardContainerSymbolsBinding.splashButtonKey.getId()) {
            KeyboardButton splashButtonKey = keyboardContainerSymbolsBinding.splashButtonKey;
            Intrinsics.checkNotNullExpressionValue(splashButtonKey, "splashButtonKey");
            keyboard.inputButton(splashButtonKey, '/');
        } else if (id == keyboardContainerSymbolsBinding.commaButtonKey.getId()) {
            KeyboardButton commaButtonKey = keyboardContainerSymbolsBinding.commaButtonKey;
            Intrinsics.checkNotNullExpressionValue(commaButtonKey, "commaButtonKey");
            keyboard.inputButton(commaButtonKey, AbstractJsonLexerKt.COMMA);
        } else if (id == keyboardContainerSymbolsBinding.quotButtonKey.getId()) {
            KeyboardButton quotButtonKey = keyboardContainerSymbolsBinding.quotButtonKey;
            Intrinsics.checkNotNullExpressionValue(quotButtonKey, "quotButtonKey");
            keyboard.inputButton(quotButtonKey, '\'');
        } else if (id == keyboardContainerSymbolsBinding.colonButtonKey.getId()) {
            KeyboardButton colonButtonKey = keyboardContainerSymbolsBinding.colonButtonKey;
            Intrinsics.checkNotNullExpressionValue(colonButtonKey, "colonButtonKey");
            keyboard.inputButton(colonButtonKey, AbstractJsonLexerKt.COLON);
        } else if (id == keyboardContainerSymbolsBinding.semicolonButtonKey.getId()) {
            KeyboardButton semicolonButtonKey = keyboardContainerSymbolsBinding.semicolonButtonKey;
            Intrinsics.checkNotNullExpressionValue(semicolonButtonKey, "semicolonButtonKey");
            keyboard.inputButton(semicolonButtonKey, ';');
        } else if (id == keyboardContainerSymbolsBinding.plusButtonKey.getId()) {
            KeyboardButton plusButtonKey = keyboardContainerSymbolsBinding.plusButtonKey;
            Intrinsics.checkNotNullExpressionValue(plusButtonKey, "plusButtonKey");
            keyboard.inputButton(plusButtonKey, '+');
        } else if (id == keyboardContainerSymbolsBinding.andButtonKey.getId()) {
            KeyboardButton andButtonKey = keyboardContainerSymbolsBinding.andButtonKey;
            Intrinsics.checkNotNullExpressionValue(andButtonKey, "andButtonKey");
            keyboard.inputButton(andButtonKey, Typography.amp);
        } else if (id == keyboardContainerSymbolsBinding.exclamationPointButtonKey.getId()) {
            KeyboardButton exclamationPointButtonKey = keyboardContainerSymbolsBinding.exclamationPointButtonKey;
            Intrinsics.checkNotNullExpressionValue(exclamationPointButtonKey, "exclamationPointButtonKey");
            keyboard.inputButton(exclamationPointButtonKey, '!');
        } else if (id == keyboardContainerSymbolsBinding.questionMarkButtonKey.getId()) {
            KeyboardButton questionMarkButtonKey = keyboardContainerSymbolsBinding.questionMarkButtonKey;
            Intrinsics.checkNotNullExpressionValue(questionMarkButtonKey, "questionMarkButtonKey");
            keyboard.inputButton(questionMarkButtonKey, '?');
        } else if (id == keyboardContainerSymbolsBinding.slashButtonKey.getId()) {
            KeyboardButton slashButtonKey = keyboardContainerSymbolsBinding.slashButtonKey;
            Intrinsics.checkNotNullExpressionValue(slashButtonKey, "slashButtonKey");
            keyboard.inputButton(slashButtonKey, '/');
        } else if (id == keyboardContainerSymbolsBinding.otherSymbolsButtonKey.getId()) {
            keyboard.changeSymbolsPage();
        } else if (id == keyboardContainerSymbolsBinding.dotButtonKey.getId()) {
            KeyboardButton dotButtonKey = keyboardContainerSymbolsBinding.dotButtonKey;
            Intrinsics.checkNotNullExpressionValue(dotButtonKey, "dotButtonKey");
            keyboard.inputButton(dotButtonKey, '.');
        } else if (id == keyboardContainerSymbolsBinding.slashButtonKey.getId()) {
            KeyboardButton slashButtonKey2 = keyboardContainerSymbolsBinding.slashButtonKey;
            Intrinsics.checkNotNullExpressionValue(slashButtonKey2, "slashButtonKey");
            keyboard.inputButton(slashButtonKey2, '/');
        } else if (id == keyboardContainerSymbolsBinding.spaceButtonKey.getId()) {
            KeyboardButton spaceButtonKey = keyboardContainerSymbolsBinding.spaceButtonKey;
            Intrinsics.checkNotNullExpressionValue(spaceButtonKey, "spaceButtonKey");
            keyboard.inputButton(spaceButtonKey, ' ');
        } else if (id == keyboardContainerSymbolsBinding.questionMarkButtonKey.getId()) {
            KeyboardButton questionMarkButtonKey2 = keyboardContainerSymbolsBinding.questionMarkButtonKey;
            Intrinsics.checkNotNullExpressionValue(questionMarkButtonKey2, "questionMarkButtonKey");
            keyboard.inputButton(questionMarkButtonKey2, '?');
        } else if (id == keyboardContainerSymbolsBinding.exclamationPointButtonKey.getId()) {
            KeyboardButton exclamationPointButtonKey2 = keyboardContainerSymbolsBinding.exclamationPointButtonKey;
            Intrinsics.checkNotNullExpressionValue(exclamationPointButtonKey2, "exclamationPointButtonKey");
            keyboard.inputButton(exclamationPointButtonKey2, '!');
        } else if (id == keyboardContainerSymbolsBinding.sendButtonKey.getId()) {
            keyboard.sendCommand();
        } else if (id == keyboardContainerSymbolsBinding.abcButtonKey.getId()) {
            keyboard.goToLanguageKeyboard();
        } else if (id == keyboardContainerSymbolsBinding.globusButtonKey.getId()) {
            keyboard.changeLanguagePage();
        } else if (id == keyboardContainerSymbolsBinding.spaceButtonKey.getId()) {
            KeyboardButton spaceButtonKey2 = keyboardContainerSymbolsBinding.spaceButtonKey;
            Intrinsics.checkNotNullExpressionValue(spaceButtonKey2, "spaceButtonKey");
            keyboard.inputButton(spaceButtonKey2, ' ');
        }
        return Unit.INSTANCE;
    }

    private final void setupEngKeyboard() {
        final KeyboardContainerEngBinding keyboardContainerEngBinding = this.binding.keyboardContainerEng;
        for (KeyboardButton keyboardButton : this.keyBoardBtnsEng) {
            keyboardButton.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda21
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean z;
                    z = Keyboard.setupEngKeyboard$lambda$0$0$0(Keyboard.this, keyboardContainerEngBinding, view, motionEvent);
                    return z;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupEngKeyboard$lambda$0$0$0(final Keyboard keyboard, final KeyboardContainerEngBinding keyboardContainerEngBinding, final View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.arizona.common.ui.KeyboardButton");
        Intrinsics.checkNotNull(motionEvent);
        keyboard.setupClickAnim((KeyboardButton) view, motionEvent, new Function0() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Keyboard.setupEngKeyboard$lambda$0$0$0$0(view, keyboardContainerEngBinding, keyboard);
                return unit;
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupEngKeyboard$lambda$0$0$0$0(View view, KeyboardContainerEngBinding keyboardContainerEngBinding, Keyboard keyboard) {
        int id = ((KeyboardButton) view).getId();
        if (id == keyboardContainerEngBinding.qButtonKey.getId()) {
            KeyboardButton qButtonKey = keyboardContainerEngBinding.qButtonKey;
            Intrinsics.checkNotNullExpressionValue(qButtonKey, "qButtonKey");
            keyboard.inputButton(qButtonKey, 'q');
        } else if (id == keyboardContainerEngBinding.wButtonKey.getId()) {
            KeyboardButton wButtonKey = keyboardContainerEngBinding.wButtonKey;
            Intrinsics.checkNotNullExpressionValue(wButtonKey, "wButtonKey");
            keyboard.inputButton(wButtonKey, 'w');
        } else if (id == keyboardContainerEngBinding.eButtonKey.getId()) {
            KeyboardButton eButtonKey = keyboardContainerEngBinding.eButtonKey;
            Intrinsics.checkNotNullExpressionValue(eButtonKey, "eButtonKey");
            keyboard.inputButton(eButtonKey, 'e');
        } else if (id == keyboardContainerEngBinding.rButtonKey.getId()) {
            KeyboardButton rButtonKey = keyboardContainerEngBinding.rButtonKey;
            Intrinsics.checkNotNullExpressionValue(rButtonKey, "rButtonKey");
            keyboard.inputButton(rButtonKey, 'r');
        } else if (id == keyboardContainerEngBinding.tButtonKey.getId()) {
            KeyboardButton tButtonKey = keyboardContainerEngBinding.tButtonKey;
            Intrinsics.checkNotNullExpressionValue(tButtonKey, "tButtonKey");
            keyboard.inputButton(tButtonKey, 't');
        } else if (id == keyboardContainerEngBinding.yButtonKey.getId()) {
            KeyboardButton yButtonKey = keyboardContainerEngBinding.yButtonKey;
            Intrinsics.checkNotNullExpressionValue(yButtonKey, "yButtonKey");
            keyboard.inputButton(yButtonKey, 'y');
        } else if (id == keyboardContainerEngBinding.uButtonKey.getId()) {
            KeyboardButton uButtonKey = keyboardContainerEngBinding.uButtonKey;
            Intrinsics.checkNotNullExpressionValue(uButtonKey, "uButtonKey");
            keyboard.inputButton(uButtonKey, AbstractJsonLexerKt.UNICODE_ESC);
        } else if (id == keyboardContainerEngBinding.iButtonKey.getId()) {
            KeyboardButton iButtonKey = keyboardContainerEngBinding.iButtonKey;
            Intrinsics.checkNotNullExpressionValue(iButtonKey, "iButtonKey");
            keyboard.inputButton(iButtonKey, 'i');
        } else if (id == keyboardContainerEngBinding.oButtonKey.getId()) {
            KeyboardButton oButtonKey = keyboardContainerEngBinding.oButtonKey;
            Intrinsics.checkNotNullExpressionValue(oButtonKey, "oButtonKey");
            keyboard.inputButton(oButtonKey, 'o');
        } else if (id == keyboardContainerEngBinding.pButtonKey.getId()) {
            KeyboardButton pButtonKey = keyboardContainerEngBinding.pButtonKey;
            Intrinsics.checkNotNullExpressionValue(pButtonKey, "pButtonKey");
            keyboard.inputButton(pButtonKey, 'p');
        } else if (id == keyboardContainerEngBinding.aButtonKey.getId()) {
            KeyboardButton aButtonKey = keyboardContainerEngBinding.aButtonKey;
            Intrinsics.checkNotNullExpressionValue(aButtonKey, "aButtonKey");
            keyboard.inputButton(aButtonKey, 'a');
        } else if (id == keyboardContainerEngBinding.sButtonKey.getId()) {
            KeyboardButton sButtonKey = keyboardContainerEngBinding.sButtonKey;
            Intrinsics.checkNotNullExpressionValue(sButtonKey, "sButtonKey");
            keyboard.inputButton(sButtonKey, 's');
        } else if (id == keyboardContainerEngBinding.dButtonKey.getId()) {
            KeyboardButton dButtonKey = keyboardContainerEngBinding.dButtonKey;
            Intrinsics.checkNotNullExpressionValue(dButtonKey, "dButtonKey");
            keyboard.inputButton(dButtonKey, 'd');
        } else if (id == keyboardContainerEngBinding.fButtonKey.getId()) {
            KeyboardButton fButtonKey = keyboardContainerEngBinding.fButtonKey;
            Intrinsics.checkNotNullExpressionValue(fButtonKey, "fButtonKey");
            keyboard.inputButton(fButtonKey, 'f');
        } else if (id == keyboardContainerEngBinding.gButtonKey.getId()) {
            KeyboardButton gButtonKey = keyboardContainerEngBinding.gButtonKey;
            Intrinsics.checkNotNullExpressionValue(gButtonKey, "gButtonKey");
            keyboard.inputButton(gButtonKey, 'g');
        } else if (id == keyboardContainerEngBinding.hButtonKey.getId()) {
            KeyboardButton hButtonKey = keyboardContainerEngBinding.hButtonKey;
            Intrinsics.checkNotNullExpressionValue(hButtonKey, "hButtonKey");
            keyboard.inputButton(hButtonKey, 'h');
        } else if (id == keyboardContainerEngBinding.jButtonKey.getId()) {
            KeyboardButton jButtonKey = keyboardContainerEngBinding.jButtonKey;
            Intrinsics.checkNotNullExpressionValue(jButtonKey, "jButtonKey");
            keyboard.inputButton(jButtonKey, 'j');
        } else if (id == keyboardContainerEngBinding.kButtonKey.getId()) {
            KeyboardButton kButtonKey = keyboardContainerEngBinding.kButtonKey;
            Intrinsics.checkNotNullExpressionValue(kButtonKey, "kButtonKey");
            keyboard.inputButton(kButtonKey, 'k');
        } else if (id == keyboardContainerEngBinding.lButtonKey.getId()) {
            KeyboardButton lButtonKey = keyboardContainerEngBinding.lButtonKey;
            Intrinsics.checkNotNullExpressionValue(lButtonKey, "lButtonKey");
            keyboard.inputButton(lButtonKey, 'l');
        } else if (id == keyboardContainerEngBinding.shiftButtonKey.getId()) {
            keyboard.changeShiftState();
        } else if (id == keyboardContainerEngBinding.zButtonKey.getId()) {
            KeyboardButton zButtonKey = keyboardContainerEngBinding.zButtonKey;
            Intrinsics.checkNotNullExpressionValue(zButtonKey, "zButtonKey");
            keyboard.inputButton(zButtonKey, 'z');
        } else if (id == keyboardContainerEngBinding.xButtonKey.getId()) {
            KeyboardButton xButtonKey = keyboardContainerEngBinding.xButtonKey;
            Intrinsics.checkNotNullExpressionValue(xButtonKey, "xButtonKey");
            keyboard.inputButton(xButtonKey, 'x');
        } else if (id == keyboardContainerEngBinding.cButtonKey.getId()) {
            KeyboardButton cButtonKey = keyboardContainerEngBinding.cButtonKey;
            Intrinsics.checkNotNullExpressionValue(cButtonKey, "cButtonKey");
            keyboard.inputButton(cButtonKey, 'c');
        } else if (id == keyboardContainerEngBinding.vButtonKey.getId()) {
            KeyboardButton vButtonKey = keyboardContainerEngBinding.vButtonKey;
            Intrinsics.checkNotNullExpressionValue(vButtonKey, "vButtonKey");
            keyboard.inputButton(vButtonKey, 'v');
        } else if (id == keyboardContainerEngBinding.bButtonKey.getId()) {
            KeyboardButton bButtonKey = keyboardContainerEngBinding.bButtonKey;
            Intrinsics.checkNotNullExpressionValue(bButtonKey, "bButtonKey");
            keyboard.inputButton(bButtonKey, 'b');
        } else if (id == keyboardContainerEngBinding.nButtonKey.getId()) {
            KeyboardButton nButtonKey = keyboardContainerEngBinding.nButtonKey;
            Intrinsics.checkNotNullExpressionValue(nButtonKey, "nButtonKey");
            keyboard.inputButton(nButtonKey, 'n');
        } else if (id == keyboardContainerEngBinding.mButtonKey.getId()) {
            KeyboardButton mButtonKey = keyboardContainerEngBinding.mButtonKey;
            Intrinsics.checkNotNullExpressionValue(mButtonKey, "mButtonKey");
            keyboard.inputButton(mButtonKey, 'm');
        } else if (id == keyboardContainerEngBinding.splashButtonKey.getId()) {
            KeyboardButton splashButtonKey = keyboardContainerEngBinding.splashButtonKey;
            Intrinsics.checkNotNullExpressionValue(splashButtonKey, "splashButtonKey");
            keyboard.inputButton(splashButtonKey, '/');
        } else if (id == keyboardContainerEngBinding.spaceButtonKey.getId()) {
            KeyboardButton spaceButtonKey = keyboardContainerEngBinding.spaceButtonKey;
            Intrinsics.checkNotNullExpressionValue(spaceButtonKey, "spaceButtonKey");
            keyboard.inputButton(spaceButtonKey, ' ');
        } else if (id == keyboardContainerEngBinding.commaButtonKey.getId()) {
            KeyboardButton commaButtonKey = keyboardContainerEngBinding.commaButtonKey;
            Intrinsics.checkNotNullExpressionValue(commaButtonKey, "commaButtonKey");
            keyboard.inputButton(commaButtonKey, AbstractJsonLexerKt.COMMA);
        } else if (id == keyboardContainerEngBinding.dotPointButtonKey.getId()) {
            KeyboardButton dotPointButtonKey = keyboardContainerEngBinding.dotPointButtonKey;
            Intrinsics.checkNotNullExpressionValue(dotPointButtonKey, "dotPointButtonKey");
            keyboard.inputButton(dotPointButtonKey, '.');
        } else if (id == keyboardContainerEngBinding.sendButtonKey.getId()) {
            keyboard.sendCommand();
        } else if (id == keyboardContainerEngBinding.globusButtonKey.getId()) {
            keyboard.changeLanguagePage();
        } else if (id == keyboardContainerEngBinding.symbolsButtonKey.getId()) {
            keyboard.goToSymbolsKeyboard();
        } else if (id == keyboardContainerEngBinding.spaceButtonKey.getId()) {
            KeyboardButton spaceButtonKey2 = keyboardContainerEngBinding.spaceButtonKey;
            Intrinsics.checkNotNullExpressionValue(spaceButtonKey2, "spaceButtonKey");
            keyboard.inputButton(spaceButtonKey2, ' ');
        }
        return Unit.INSTANCE;
    }

    private final void sendCommand() {
        if (this.isDisabledInput) {
            if (this.isEnabledType) {
                Editable text = this.binding.mainInputEt.getText();
                if (text != null) {
                    String obj = text.toString();
                    KeyboardInputListener keyboardInputListener = this.inputListener;
                    if (keyboardInputListener != null) {
                        keyboardInputListener.onSendText(obj);
                    }
                }
            } else {
                KeyboardInputListener keyboardInputListener2 = this.inputListener;
                if (keyboardInputListener2 != null) {
                    keyboardInputListener2.onSend();
                }
            }
            this.binding.mainInputEt.setText("");
        } else {
            Editable text2 = this.binding.mainInputEt.getText();
            if (text2 != null) {
                String chatSendText = toChatSendText(text2);
                this.binding.mainInputEt.setText("");
                Object firstOrNull = StringsKt.firstOrNull(chatSendText);
                if (!Intrinsics.areEqual(firstOrNull != null ? firstOrNull : "", (Object) '/') && this.currChatType.getCommandText().length() > 0) {
                    chatSendText = this.currChatType.getCommandText() + " " + chatSendText;
                }
                Activity targetActivity = getTargetActivity();
                Intrinsics.checkNotNull(targetActivity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard.InputListener");
                ((CustomKeyboard.InputListener) targetActivity).t_OnInputEnd(chatSendText);
            }
        }
        this.shiftType = ShiftType.LOWER;
        changeShiftState();
    }

    private final void updateTextByCurrentHistoryLevel() {
        try {
            TextInputEditText textInputEditText = this.binding.mainInputEt;
            Activity targetActivity = getTargetActivity();
            Intrinsics.checkNotNull(targetActivity, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.keyboard.customKeyboard.CustomKeyboard.InputListener");
            textInputEditText.setText(((CustomKeyboard.InputListener) targetActivity).t_GetKeyboardHistoryText(this.currentHistoryIndex));
            TextInputEditText textInputEditText2 = this.binding.mainInputEt;
            Editable text = this.binding.mainInputEt.getText();
            textInputEditText2.setSelection(text != null ? text.length() : 0);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "currentHistory == -1");
            this.binding.mainInputEt.setText("");
        }
    }

    private final void setupRusKeyboard() {
        final KeyboardContainerRusBinding keyboardContainerRusBinding = this.binding.keyboardContainerRus;
        for (KeyboardButton keyboardButton : this.keyBoardBtnsRus) {
            keyboardButton.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda25
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean z;
                    z = Keyboard.setupRusKeyboard$lambda$0$0$0(Keyboard.this, keyboardContainerRusBinding, view, motionEvent);
                    return z;
                }
            });
            keyboardContainerRusBinding.eButtonKey.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda26
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean z;
                    z = Keyboard.setupRusKeyboard$lambda$0$0$1(Keyboard.this, keyboardContainerRusBinding, view, motionEvent);
                    return z;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupRusKeyboard$lambda$0$0$0(final Keyboard keyboard, final KeyboardContainerRusBinding keyboardContainerRusBinding, final View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.arizona.common.ui.KeyboardButton");
        Intrinsics.checkNotNull(motionEvent);
        return keyboard.setupClickAnim((KeyboardButton) view, motionEvent, new Function0() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Keyboard.setupRusKeyboard$lambda$0$0$0$0(view, keyboardContainerRusBinding, keyboard);
                return unit;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupRusKeyboard$lambda$0$0$0$0(View view, KeyboardContainerRusBinding keyboardContainerRusBinding, Keyboard keyboard) {
        int id = ((KeyboardButton) view).getId();
        if (id == keyboardContainerRusBinding.jButtonKey.getId()) {
            KeyboardButton jButtonKey = keyboardContainerRusBinding.jButtonKey;
            Intrinsics.checkNotNullExpressionValue(jButtonKey, "jButtonKey");
            keyboard.inputButton(jButtonKey, (char) 1081);
        } else if (id == keyboardContainerRusBinding.cButtonKey.getId()) {
            KeyboardButton cButtonKey = keyboardContainerRusBinding.cButtonKey;
            Intrinsics.checkNotNullExpressionValue(cButtonKey, "cButtonKey");
            keyboard.inputButton(cButtonKey, (char) 1094);
        } else if (id == keyboardContainerRusBinding.yButtonKey.getId()) {
            KeyboardButton yButtonKey = keyboardContainerRusBinding.yButtonKey;
            Intrinsics.checkNotNullExpressionValue(yButtonKey, "yButtonKey");
            keyboard.inputButton(yButtonKey, (char) 1091);
        } else if (id == keyboardContainerRusBinding.kButtonKey.getId()) {
            KeyboardButton kButtonKey = keyboardContainerRusBinding.kButtonKey;
            Intrinsics.checkNotNullExpressionValue(kButtonKey, "kButtonKey");
            keyboard.inputButton(kButtonKey, (char) 1082);
        } else if (id == keyboardContainerRusBinding.nButtonKey.getId()) {
            KeyboardButton nButtonKey = keyboardContainerRusBinding.nButtonKey;
            Intrinsics.checkNotNullExpressionValue(nButtonKey, "nButtonKey");
            keyboard.inputButton(nButtonKey, (char) 1085);
        } else if (id == keyboardContainerRusBinding.gButtonKey.getId()) {
            KeyboardButton gButtonKey = keyboardContainerRusBinding.gButtonKey;
            Intrinsics.checkNotNullExpressionValue(gButtonKey, "gButtonKey");
            keyboard.inputButton(gButtonKey, (char) 1075);
        } else if (id == keyboardContainerRusBinding.shButtonKey.getId()) {
            KeyboardButton shButtonKey = keyboardContainerRusBinding.shButtonKey;
            Intrinsics.checkNotNullExpressionValue(shButtonKey, "shButtonKey");
            keyboard.inputButton(shButtonKey, (char) 1096);
        } else if (id == keyboardContainerRusBinding.shchButtonKey.getId()) {
            KeyboardButton shchButtonKey = keyboardContainerRusBinding.shchButtonKey;
            Intrinsics.checkNotNullExpressionValue(shchButtonKey, "shchButtonKey");
            keyboard.inputButton(shchButtonKey, (char) 1097);
        } else if (id == keyboardContainerRusBinding.zButtonKey.getId()) {
            KeyboardButton zButtonKey = keyboardContainerRusBinding.zButtonKey;
            Intrinsics.checkNotNullExpressionValue(zButtonKey, "zButtonKey");
            keyboard.inputButton(zButtonKey, (char) 1079);
        } else if (id == keyboardContainerRusBinding.hButtonKey.getId()) {
            KeyboardButton hButtonKey = keyboardContainerRusBinding.hButtonKey;
            Intrinsics.checkNotNullExpressionValue(hButtonKey, "hButtonKey");
            keyboard.inputButton(hButtonKey, (char) 1093);
        } else if (id == keyboardContainerRusBinding.fButtonKey.getId()) {
            KeyboardButton fButtonKey = keyboardContainerRusBinding.fButtonKey;
            Intrinsics.checkNotNullExpressionValue(fButtonKey, "fButtonKey");
            keyboard.inputButton(fButtonKey, (char) 1092);
        } else if (id == keyboardContainerRusBinding.yuButtonKey.getId()) {
            KeyboardButton yuButtonKey = keyboardContainerRusBinding.yuButtonKey;
            Intrinsics.checkNotNullExpressionValue(yuButtonKey, "yuButtonKey");
            keyboard.inputButton(yuButtonKey, (char) 1099);
        } else if (id == keyboardContainerRusBinding.vButtonKey.getId()) {
            KeyboardButton vButtonKey = keyboardContainerRusBinding.vButtonKey;
            Intrinsics.checkNotNullExpressionValue(vButtonKey, "vButtonKey");
            keyboard.inputButton(vButtonKey, (char) 1074);
        } else if (id == keyboardContainerRusBinding.aButtonKey.getId()) {
            KeyboardButton aButtonKey = keyboardContainerRusBinding.aButtonKey;
            Intrinsics.checkNotNullExpressionValue(aButtonKey, "aButtonKey");
            keyboard.inputButton(aButtonKey, (char) 1072);
        } else if (id == keyboardContainerRusBinding.pButtonKey.getId()) {
            KeyboardButton pButtonKey = keyboardContainerRusBinding.pButtonKey;
            Intrinsics.checkNotNullExpressionValue(pButtonKey, "pButtonKey");
            keyboard.inputButton(pButtonKey, (char) 1087);
        } else if (id == keyboardContainerRusBinding.rButtonKey.getId()) {
            KeyboardButton rButtonKey = keyboardContainerRusBinding.rButtonKey;
            Intrinsics.checkNotNullExpressionValue(rButtonKey, "rButtonKey");
            keyboard.inputButton(rButtonKey, (char) 1088);
        } else if (id == keyboardContainerRusBinding.oButtonKey.getId()) {
            KeyboardButton oButtonKey = keyboardContainerRusBinding.oButtonKey;
            Intrinsics.checkNotNullExpressionValue(oButtonKey, "oButtonKey");
            keyboard.inputButton(oButtonKey, (char) 1086);
        } else if (id == keyboardContainerRusBinding.lButtonKey.getId()) {
            KeyboardButton lButtonKey = keyboardContainerRusBinding.lButtonKey;
            Intrinsics.checkNotNullExpressionValue(lButtonKey, "lButtonKey");
            keyboard.inputButton(lButtonKey, (char) 1083);
        } else if (id == keyboardContainerRusBinding.dButtonKey.getId()) {
            KeyboardButton dButtonKey = keyboardContainerRusBinding.dButtonKey;
            Intrinsics.checkNotNullExpressionValue(dButtonKey, "dButtonKey");
            keyboard.inputButton(dButtonKey, (char) 1076);
        } else if (id == keyboardContainerRusBinding.zhButtonKey.getId()) {
            KeyboardButton zhButtonKey = keyboardContainerRusBinding.zhButtonKey;
            Intrinsics.checkNotNullExpressionValue(zhButtonKey, "zhButtonKey");
            keyboard.inputButton(zhButtonKey, (char) 1078);
        } else if (id == keyboardContainerRusBinding.eeButtonKey.getId()) {
            KeyboardButton eeButtonKey = keyboardContainerRusBinding.eeButtonKey;
            Intrinsics.checkNotNullExpressionValue(eeButtonKey, "eeButtonKey");
            keyboard.inputButton(eeButtonKey, (char) 1101);
        } else if (id == keyboardContainerRusBinding.shiftButtonKey.getId()) {
            keyboard.changeShiftState();
        } else if (id == keyboardContainerRusBinding.yaButtonKey.getId()) {
            KeyboardButton yaButtonKey = keyboardContainerRusBinding.yaButtonKey;
            Intrinsics.checkNotNullExpressionValue(yaButtonKey, "yaButtonKey");
            keyboard.inputButton(yaButtonKey, (char) 1103);
        } else if (id == keyboardContainerRusBinding.chButtonKey.getId()) {
            KeyboardButton chButtonKey = keyboardContainerRusBinding.chButtonKey;
            Intrinsics.checkNotNullExpressionValue(chButtonKey, "chButtonKey");
            keyboard.inputButton(chButtonKey, (char) 1095);
        } else if (id == keyboardContainerRusBinding.sButtonKey.getId()) {
            KeyboardButton sButtonKey = keyboardContainerRusBinding.sButtonKey;
            Intrinsics.checkNotNullExpressionValue(sButtonKey, "sButtonKey");
            keyboard.inputButton(sButtonKey, (char) 1089);
        } else if (id == keyboardContainerRusBinding.mButtonKey.getId()) {
            KeyboardButton mButtonKey = keyboardContainerRusBinding.mButtonKey;
            Intrinsics.checkNotNullExpressionValue(mButtonKey, "mButtonKey");
            keyboard.inputButton(mButtonKey, (char) 1084);
        } else if (id == keyboardContainerRusBinding.iButtonKey.getId()) {
            KeyboardButton iButtonKey = keyboardContainerRusBinding.iButtonKey;
            Intrinsics.checkNotNullExpressionValue(iButtonKey, "iButtonKey");
            keyboard.inputButton(iButtonKey, (char) 1080);
        } else if (id == keyboardContainerRusBinding.tButtonKey.getId()) {
            KeyboardButton tButtonKey = keyboardContainerRusBinding.tButtonKey;
            Intrinsics.checkNotNullExpressionValue(tButtonKey, "tButtonKey");
            keyboard.inputButton(tButtonKey, (char) 1090);
        } else if (id == keyboardContainerRusBinding.iaiButtonKey.getId()) {
            KeyboardButton iaiButtonKey = keyboardContainerRusBinding.iaiButtonKey;
            Intrinsics.checkNotNullExpressionValue(iaiButtonKey, "iaiButtonKey");
            keyboard.inputButton(iaiButtonKey, (char) 1100);
        } else if (id == keyboardContainerRusBinding.bButtonKey.getId()) {
            KeyboardButton bButtonKey = keyboardContainerRusBinding.bButtonKey;
            Intrinsics.checkNotNullExpressionValue(bButtonKey, "bButtonKey");
            keyboard.inputButton(bButtonKey, (char) 1073);
        } else if (id == keyboardContainerRusBinding.uButtonKey.getId()) {
            KeyboardButton uButtonKey = keyboardContainerRusBinding.uButtonKey;
            Intrinsics.checkNotNullExpressionValue(uButtonKey, "uButtonKey");
            keyboard.inputButton(uButtonKey, (char) 1102);
        } else if (id == keyboardContainerRusBinding.slashButtonKey.getId()) {
            KeyboardButton slashButtonKey = keyboardContainerRusBinding.slashButtonKey;
            Intrinsics.checkNotNullExpressionValue(slashButtonKey, "slashButtonKey");
            keyboard.inputButton(slashButtonKey, '/');
        } else if (id == keyboardContainerRusBinding.spaceButtonKey.getId()) {
            KeyboardButton spaceButtonKey = keyboardContainerRusBinding.spaceButtonKey;
            Intrinsics.checkNotNullExpressionValue(spaceButtonKey, "spaceButtonKey");
            keyboard.inputButton(spaceButtonKey, ' ');
        } else if (id == keyboardContainerRusBinding.commaButtonKey.getId()) {
            KeyboardButton commaButtonKey = keyboardContainerRusBinding.commaButtonKey;
            Intrinsics.checkNotNullExpressionValue(commaButtonKey, "commaButtonKey");
            keyboard.inputButton(commaButtonKey, AbstractJsonLexerKt.COMMA);
        } else if (id == keyboardContainerRusBinding.dotPointButtonKey.getId()) {
            KeyboardButton dotPointButtonKey = keyboardContainerRusBinding.dotPointButtonKey;
            Intrinsics.checkNotNullExpressionValue(dotPointButtonKey, "dotPointButtonKey");
            keyboard.inputButton(dotPointButtonKey, '.');
        } else if (id == keyboardContainerRusBinding.sendButtonKey.getId()) {
            keyboard.sendCommand();
        } else if (id == keyboardContainerRusBinding.globusButtonKey.getId()) {
            keyboard.changeLanguagePage();
        } else if (id == keyboardContainerRusBinding.symbolsButtonKey.getId()) {
            keyboard.goToSymbolsKeyboard();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupRusKeyboard$lambda$0$0$1(final Keyboard keyboard, final KeyboardContainerRusBinding keyboardContainerRusBinding, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.arizona.common.ui.KeyboardButton");
        Intrinsics.checkNotNull(motionEvent);
        return keyboard.setupClickAnimLong((KeyboardButton) view, motionEvent, new Function0() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Keyboard.setupRusKeyboard$lambda$0$0$1$0(Keyboard.this, keyboardContainerRusBinding);
                return unit;
            }
        }, new Function0() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Keyboard.setupRusKeyboard$lambda$0$0$1$1(Keyboard.this, keyboardContainerRusBinding);
                return unit;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupRusKeyboard$lambda$0$0$1$0(Keyboard keyboard, KeyboardContainerRusBinding keyboardContainerRusBinding) {
        KeyboardButton eButtonKey = keyboardContainerRusBinding.eButtonKey;
        Intrinsics.checkNotNullExpressionValue(eButtonKey, "eButtonKey");
        keyboard.inputButton(eButtonKey, (char) 1077);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupRusKeyboard$lambda$0$0$1$1(Keyboard keyboard, KeyboardContainerRusBinding keyboardContainerRusBinding) {
        KeyboardButton eButtonKey = keyboardContainerRusBinding.eButtonKey;
        Intrinsics.checkNotNullExpressionValue(eButtonKey, "eButtonKey");
        keyboard.inputButton(eButtonKey, (char) 1105);
        return Unit.INSTANCE;
    }

    private final void setupKeyboardButtons() {
        KeyboardLayoutBinding keyboardLayoutBinding = this.binding;
        keyboardLayoutBinding.mainInputEt.setShowSoftInputOnFocus(false);
        keyboardLayoutBinding.mainInputEt.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda18
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                z = Keyboard.setupKeyboardButtons$lambda$0$0(Keyboard.this, view, motionEvent);
                return z;
            }
        });
        keyboardLayoutBinding.clearText.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Keyboard.this.removeTextAll();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupKeyboardButtons$lambda$0$0(Keyboard keyboard, View view, MotionEvent motionEvent) {
        SAMPUIElement.Companion.hideKeyboard(keyboard.getTargetActivity());
        return false;
    }

    private final void inputButton(View view, char c) {
        KeyboardInputListener keyboardInputListener;
        if (this.allTextIsCaps) {
            c = Character.toUpperCase(c);
        }
        TextInputEditText textInputEditText = this.binding.mainInputEt;
        int selectionStart = textInputEditText.getSelectionStart();
        int selectionEnd = textInputEditText.getSelectionEnd();
        if (selectionStart != selectionEnd) {
            Editable text = textInputEditText.getText();
            if (text != null) {
                text.replace(selectionStart, selectionEnd, String.valueOf(c));
            }
        } else {
            Editable text2 = textInputEditText.getText();
            if (text2 != null) {
                text2.insert(selectionStart, String.valueOf(c));
            }
        }
        if (!this.isEnabledType && (keyboardInputListener = this.inputListener) != null) {
            keyboardInputListener.onSymbolInput(c);
        }
        if (this.shiftType == ShiftType.ONCE) {
            this.shiftType = ShiftType.UPPER;
            changeShiftState();
        }
    }

    private final void inputText(EmojiKeyboardItem emojiKeyboardItem) {
        KeyboardInputListener keyboardInputListener;
        SpannableString spannableString = new SpannableString(ChatEmoji.toSpannable$default(ChatEmoji.INSTANCE, emojiKeyboardItem.getInputText(), 1.1f, null, 2, null));
        spannableString.setSpan(new EmojiSendTextSpan(emojiKeyboardItem.getSendText()), 0, spannableString.length(), 33);
        TextInputEditText textInputEditText = this.binding.mainInputEt;
        int selectionStart = textInputEditText.getSelectionStart();
        int selectionEnd = textInputEditText.getSelectionEnd();
        if (selectionStart != selectionEnd) {
            Editable text = textInputEditText.getText();
            if (text != null) {
                text.replace(selectionStart, selectionEnd, spannableString);
            }
        } else {
            Editable text2 = textInputEditText.getText();
            if (text2 != null) {
                text2.insert(selectionStart, spannableString);
            }
        }
        if (this.isEnabledType || (keyboardInputListener = this.inputListener) == null) {
            return;
        }
        keyboardInputListener.onTextInput(emojiKeyboardItem.getInputText());
    }

    private final String toChatSendText(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            int i = 0;
            Object[] spans = spanned.getSpans(0, charSequence.length(), EmojiSendTextSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
            ArrayList arrayList = new ArrayList(spans.length);
            for (Object obj : spans) {
                EmojiSendTextSpan emojiSendTextSpan = (EmojiSendTextSpan) obj;
                arrayList.add(new EmojiSpanRange(spanned.getSpanStart(emojiSendTextSpan), spanned.getSpanEnd(emojiSendTextSpan), emojiSendTextSpan.getSendText()));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                EmojiSpanRange emojiSpanRange = (EmojiSpanRange) obj2;
                if (emojiSpanRange.getStart() >= 0 && emojiSpanRange.getEnd() > emojiSpanRange.getStart()) {
                    arrayList2.add(obj2);
                }
            }
            List<EmojiSpanRange> sortedWith = CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.Keyboard$toChatSendText$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((Keyboard.EmojiSpanRange) t).getStart()), Integer.valueOf(((Keyboard.EmojiSpanRange) t2).getStart()));
                }
            });
            if (sortedWith.isEmpty()) {
                return charSequence.toString();
            }
            StringBuilder sb = new StringBuilder();
            for (EmojiSpanRange emojiSpanRange2 : sortedWith) {
                if (emojiSpanRange2.getStart() >= i) {
                    sb.append(charSequence.subSequence(i, emojiSpanRange2.getStart()));
                    sb.append(emojiSpanRange2.getSendText());
                    i = emojiSpanRange2.getEnd();
                }
            }
            sb.append(charSequence.subSequence(i, charSequence.length()));
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }
        return charSequence.toString();
    }

    private final void removeText() {
        Editable text;
        KeyboardInputListener keyboardInputListener;
        if (!this.isEnabledType && (keyboardInputListener = this.inputListener) != null) {
            keyboardInputListener.onTextRemove();
        }
        Editable text2 = this.binding.mainInputEt.getText();
        if (text2 == null || text2.length() != 0) {
            TextInputEditText textInputEditText = this.binding.mainInputEt;
            int selectionStart = textInputEditText.getSelectionStart();
            int selectionEnd = textInputEditText.getSelectionEnd();
            if (selectionStart != selectionEnd) {
                Editable text3 = textInputEditText.getText();
                if (text3 != null) {
                    text3.delete(selectionStart, selectionEnd);
                }
            } else if (selectionStart <= 0 || (text = textInputEditText.getText()) == null) {
            } else {
                text.delete(selectionStart - 1, selectionStart);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeTextAll() {
        KeyboardInputListener keyboardInputListener;
        if (!this.isEnabledType && (keyboardInputListener = this.inputListener) != null) {
            keyboardInputListener.onTextRemoveAll();
        }
        this.binding.mainInputEt.setText("");
    }

    private final void goToLanguageKeyboard() {
        this.currPage = this.languagePage;
        changeKeyboardPage();
        this.shiftType = ShiftType.LOWER;
        changeShiftState();
    }

    private final void changeLanguagePage() {
        KeyboardPage keyboardPage = this.languagePage == KeyboardPage.RUS ? KeyboardPage.ENG : KeyboardPage.RUS;
        this.languagePage = keyboardPage;
        this.currPage = keyboardPage;
        changeKeyboardPage();
        this.shiftType = ShiftType.LOWER;
        changeShiftState();
    }

    private final void goToSymbolsKeyboard() {
        KeyboardPage keyboardPage = KeyboardPage.OTHER_SYMBOLS;
        this.symbolsPage = keyboardPage;
        this.currPage = keyboardPage;
        changeKeyboardPage();
        this.shiftType = ShiftType.LOWER;
        changeShiftState();
    }

    private final void changeSymbolsPage() {
        KeyboardPage keyboardPage = this.symbolsPage == KeyboardPage.SYMBOLS ? KeyboardPage.OTHER_SYMBOLS : KeyboardPage.SYMBOLS;
        this.symbolsPage = keyboardPage;
        this.currPage = keyboardPage;
        changeKeyboardPage();
        this.shiftType = ShiftType.LOWER;
        changeShiftState();
    }

    private final void changeKeyboardPage() {
        this.allTextIsCaps = false;
        KeyboardLayoutBinding keyboardLayoutBinding = this.binding;
        LinearLayout root = keyboardLayoutBinding.keyboardContainerRus.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
        LinearLayout root2 = keyboardLayoutBinding.keyboardContainerEng.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        root2.setVisibility(8);
        LinearLayout root3 = keyboardLayoutBinding.keyboardContainerSymbols.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
        root3.setVisibility(8);
        LinearLayout root4 = keyboardLayoutBinding.keyboardContainerOtherSymbols.getRoot();
        Intrinsics.checkNotNullExpressionValue(root4, "getRoot(...)");
        root4.setVisibility(8);
        LinearLayout root5 = keyboardLayoutBinding.keyboardContainerEmoji.getRoot();
        Intrinsics.checkNotNullExpressionValue(root5, "getRoot(...)");
        root5.setVisibility(8);
        LinearLayout root6 = keyboardLayoutBinding.keyboardContainerBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root6, "getRoot(...)");
        root6.setVisibility(8);
        switch (WhenMappings.$EnumSwitchMapping$1[this.currPage.ordinal()]) {
            case 1:
                LinearLayout root7 = keyboardLayoutBinding.keyboardContainerRus.getRoot();
                Intrinsics.checkNotNullExpressionValue(root7, "getRoot(...)");
                root7.setVisibility(0);
                break;
            case 2:
                LinearLayout root8 = keyboardLayoutBinding.keyboardContainerEng.getRoot();
                Intrinsics.checkNotNullExpressionValue(root8, "getRoot(...)");
                root8.setVisibility(0);
                break;
            case 3:
                LinearLayout root9 = keyboardLayoutBinding.keyboardContainerSymbols.getRoot();
                Intrinsics.checkNotNullExpressionValue(root9, "getRoot(...)");
                root9.setVisibility(0);
                break;
            case 4:
                LinearLayout root10 = keyboardLayoutBinding.keyboardContainerOtherSymbols.getRoot();
                Intrinsics.checkNotNullExpressionValue(root10, "getRoot(...)");
                root10.setVisibility(0);
                break;
            case 5:
                LinearLayout root11 = keyboardLayoutBinding.keyboardContainerEmoji.getRoot();
                Intrinsics.checkNotNullExpressionValue(root11, "getRoot(...)");
                root11.setVisibility(0);
                break;
            case 6:
                LinearLayout root12 = keyboardLayoutBinding.keyboardContainerBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root12, "getRoot(...)");
                root12.setVisibility(0);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (this.currPage != KeyboardPage.BINDERS && this.currPage != KeyboardPage.EMOJI) {
            this.previousPage = this.currPage;
        }
        keyboardLayoutBinding.mainBinderBtn.setBackgroundResource(this.currPage == KeyboardPage.BINDERS ? R.drawable.bg_binder_btn_pressed : R.drawable.bg_binder_btn);
        if (this.currPage == KeyboardPage.EMOJI) {
            keyboardLayoutBinding.emojiBtn.onActionDown();
        } else {
            keyboardLayoutBinding.emojiBtn.onActionUp();
        }
    }

    private final void changeShiftState() {
        int i = WhenMappings.$EnumSwitchMapping$2[this.shiftType.ordinal()];
        if (i == 1) {
            this.shiftType = ShiftType.UPPER;
            this.binding.keyboardContainerRus.shiftButtonKey.setColor(Color.parseColor("#FFFFFF"));
            this.binding.keyboardContainerEng.shiftButtonKey.setColor(Color.parseColor("#FFFFFF"));
        } else if (i == 2) {
            this.shiftType = ShiftType.ONCE;
            this.binding.keyboardContainerRus.shiftButtonKey.setColor(Color.parseColor("#3D81FF"));
            this.binding.keyboardContainerEng.shiftButtonKey.setColor(Color.parseColor("#3D81FF"));
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            this.shiftType = ShiftType.LOWER;
            this.binding.keyboardContainerRus.shiftButtonKey.setColor(Color.parseColor("#A9A9A9"));
            this.binding.keyboardContainerEng.shiftButtonKey.setColor(Color.parseColor("#A9A9A9"));
        }
        changeCaps();
    }

    private final void changeCaps() {
        int i = WhenMappings.$EnumSwitchMapping$2[this.shiftType.ordinal()];
        if (i == 1) {
            this.allTextIsCaps = true;
        } else if (i == 2) {
            this.allTextIsCaps = false;
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            this.allTextIsCaps = true;
        }
        updateCapsButtonsState();
    }

    private final void updateCapsButtonsState() {
        String lowerCase;
        String lowerCase2;
        if (this.languagePage == KeyboardPage.RUS) {
            Log.d(TAG, "changeCaps: RUS");
            for (KeyboardButton keyboardButton : this.keyBoardBtnsRus) {
                if (this.allTextIsCaps) {
                    lowerCase2 = keyboardButton.getText().toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toUpperCase(...)");
                } else {
                    lowerCase2 = keyboardButton.getText().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                }
                keyboardButton.setText(lowerCase2);
            }
            return;
        }
        Log.d(TAG, "changeCaps: ENG");
        for (KeyboardButton keyboardButton2 : this.keyBoardBtnsEng) {
            if (this.allTextIsCaps) {
                lowerCase = keyboardButton2.getText().toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toUpperCase(...)");
            } else {
                lowerCase = keyboardButton2.getText().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            }
            keyboardButton2.setText(lowerCase);
        }
    }

    private final BinderButtonType getBinderTypeByState(boolean z) {
        if (z) {
            return BinderButtonType.EDITABLE;
        }
        return BinderButtonType.INITIAL;
    }

    public final void setBinderState(int i, boolean z) {
        this.bindsList.get(i).setBinderType(getBinderTypeByState(z));
        this.bindersAdapter.submitList(this.bindsList);
        this.bindersAdapter.notifyItemChanged(i);
    }

    public final void setBinderName(int i, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.bindsList.get(i).setBinderType(BinderButtonType.BINDED);
        this.bindsList.get(i).setBinderName(name);
        this.bindersAdapter.submitList(this.bindsList);
        this.bindersAdapter.notifyItemChanged(i);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Keyboard.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/Keyboard$ChatType;", "", "commandText", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getCommandText", "()Ljava/lang/String;", "RP", "NON_RP", "ORG", "FAMILY", "WORK", "VIP", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class ChatType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ChatType[] $VALUES;
        private final String commandText;
        public static final ChatType RP = new ChatType("RP", 0, "");
        public static final ChatType NON_RP = new ChatType("NON_RP", 1, "/b");
        public static final ChatType ORG = new ChatType("ORG", 2, "/fr");
        public static final ChatType FAMILY = new ChatType("FAMILY", 3, "/fam");
        public static final ChatType WORK = new ChatType("WORK", 4, "/j");
        public static final ChatType VIP = new ChatType("VIP", 5, "/vr");

        private static final /* synthetic */ ChatType[] $values() {
            return new ChatType[]{RP, NON_RP, ORG, FAMILY, WORK, VIP};
        }

        public static EnumEntries<ChatType> getEntries() {
            return $ENTRIES;
        }

        public static ChatType valueOf(String str) {
            return (ChatType) Enum.valueOf(ChatType.class, str);
        }

        public static ChatType[] values() {
            return (ChatType[]) $VALUES.clone();
        }

        private ChatType(String str, int i, String str2) {
            this.commandText = str2;
        }

        public final String getCommandText() {
            return this.commandText;
        }

        static {
            ChatType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Keyboard.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/Keyboard$ShiftType;", "", "<init>", "(Ljava/lang/String;I)V", "LOWER", "UPPER", "ONCE", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class ShiftType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ShiftType[] $VALUES;
        public static final ShiftType LOWER = new ShiftType("LOWER", 0);
        public static final ShiftType UPPER = new ShiftType("UPPER", 1);
        public static final ShiftType ONCE = new ShiftType("ONCE", 2);

        private static final /* synthetic */ ShiftType[] $values() {
            return new ShiftType[]{LOWER, UPPER, ONCE};
        }

        public static EnumEntries<ShiftType> getEntries() {
            return $ENTRIES;
        }

        public static ShiftType valueOf(String str) {
            return (ShiftType) Enum.valueOf(ShiftType.class, str);
        }

        public static ShiftType[] values() {
            return (ShiftType[]) $VALUES.clone();
        }

        private ShiftType(String str, int i) {
        }

        static {
            ShiftType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* compiled from: Keyboard.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/Keyboard$KeyboardInputListener;", "", "onSymbolInput", "", "symbol", "", "onTextInput", "text", "", "onTextRemove", "onTextRemoveAll", "onSend", "onSendText", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public interface KeyboardInputListener {
        void onSend();

        default void onSendText(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
        }

        void onSymbolInput(char c);

        void onTextRemove();

        void onTextRemoveAll();

        /* compiled from: Keyboard.kt */
        @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class DefaultImpls {
            @Deprecated
            public static void onTextInput(KeyboardInputListener keyboardInputListener, String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                KeyboardInputListener.super.onTextInput(text);
            }

            @Deprecated
            public static void onSendText(KeyboardInputListener keyboardInputListener, String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                KeyboardInputListener.super.onSendText(text);
            }
        }

        default void onTextInput(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            String str = text;
            for (int i = 0; i < str.length(); i++) {
                onSymbolInput(str.charAt(i));
            }
        }
    }

    /* compiled from: Keyboard.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/keyboard/inGameKeyboard/Keyboard$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.IN_GAME_KEYBOARD);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            Log.d("Spawner", "Keyboard Spawn");
            return new Keyboard(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
