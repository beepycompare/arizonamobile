package androidx.compose.foundation.text.input.internal.selection;

import android.os.Build;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.contextmenu.ContextMenuState_androidKt;
import androidx.compose.foundation.text.ContextMenu_androidKt$TextItem$1;
import androidx.compose.foundation.text.MenuItemsAvailability;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.runtime.State;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: TextFieldSelectionState.android.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u001d\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0002\b\u0004H\u0000¨\u0006\u000e"}, d2 = {"contextMenuBuilder", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "itemsAvailability", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/text/MenuItemsAvailability;", "onMenuItemClicked", "Lkotlin/Function2;", "Landroidx/compose/foundation/text/TextContextMenuItems;", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldSelectionState_androidKt {
    public static final Function1<ContextMenuScope, Unit> contextMenuBuilder(final TextFieldSelectionState textFieldSelectionState, final ContextMenuState contextMenuState, final State<MenuItemsAvailability> state, final Function2<? super TextFieldSelectionState, ? super TextContextMenuItems, Unit> function2) {
        return new Function1<ContextMenuScope, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$contextMenuBuilder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContextMenuScope contextMenuScope) {
                invoke2(contextMenuScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ContextMenuScope contextMenuScope) {
                int m1134unboximpl = state.getValue().m1134unboximpl();
                final ContextMenuState contextMenuState2 = contextMenuState;
                TextContextMenuItems textContextMenuItems = TextContextMenuItems.Cut;
                boolean m1129getCanCutimpl = MenuItemsAvailability.m1129getCanCutimpl(m1134unboximpl);
                final Function2<TextFieldSelectionState, TextContextMenuItems, Unit> function22 = function2;
                final TextFieldSelectionState textFieldSelectionState2 = textFieldSelectionState;
                if (m1129getCanCutimpl) {
                    ContextMenuScope.item$default(contextMenuScope, new ContextMenu_androidKt$TextItem$1(textContextMenuItems), null, false, null, new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function22.invoke(textFieldSelectionState2, TextContextMenuItems.Cut);
                            ContextMenuState_androidKt.close(ContextMenuState.this);
                        }
                    }, 14, null);
                }
                final ContextMenuState contextMenuState3 = contextMenuState;
                TextContextMenuItems textContextMenuItems2 = TextContextMenuItems.Copy;
                boolean m1128getCanCopyimpl = MenuItemsAvailability.m1128getCanCopyimpl(m1134unboximpl);
                final Function2<TextFieldSelectionState, TextContextMenuItems, Unit> function23 = function2;
                final TextFieldSelectionState textFieldSelectionState3 = textFieldSelectionState;
                if (m1128getCanCopyimpl) {
                    ContextMenuScope.item$default(contextMenuScope, new ContextMenu_androidKt$TextItem$1(textContextMenuItems2), null, false, null, new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function23.invoke(textFieldSelectionState3, TextContextMenuItems.Copy);
                            ContextMenuState_androidKt.close(ContextMenuState.this);
                        }
                    }, 14, null);
                }
                final ContextMenuState contextMenuState4 = contextMenuState;
                TextContextMenuItems textContextMenuItems3 = TextContextMenuItems.Paste;
                boolean m1130getCanPasteimpl = MenuItemsAvailability.m1130getCanPasteimpl(m1134unboximpl);
                final Function2<TextFieldSelectionState, TextContextMenuItems, Unit> function24 = function2;
                final TextFieldSelectionState textFieldSelectionState4 = textFieldSelectionState;
                if (m1130getCanPasteimpl) {
                    ContextMenuScope.item$default(contextMenuScope, new ContextMenu_androidKt$TextItem$1(textContextMenuItems3), null, false, null, new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function24.invoke(textFieldSelectionState4, TextContextMenuItems.Paste);
                            ContextMenuState_androidKt.close(ContextMenuState.this);
                        }
                    }, 14, null);
                }
                final ContextMenuState contextMenuState5 = contextMenuState;
                TextContextMenuItems textContextMenuItems4 = TextContextMenuItems.SelectAll;
                boolean m1131getCanSelectAllimpl = MenuItemsAvailability.m1131getCanSelectAllimpl(m1134unboximpl);
                final Function2<TextFieldSelectionState, TextContextMenuItems, Unit> function25 = function2;
                final TextFieldSelectionState textFieldSelectionState5 = textFieldSelectionState;
                if (m1131getCanSelectAllimpl) {
                    ContextMenuScope.item$default(contextMenuScope, new ContextMenu_androidKt$TextItem$1(textContextMenuItems4), null, false, null, new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function25.invoke(textFieldSelectionState5, TextContextMenuItems.SelectAll);
                            ContextMenuState_androidKt.close(ContextMenuState.this);
                        }
                    }, 14, null);
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    final ContextMenuState contextMenuState6 = contextMenuState;
                    TextContextMenuItems textContextMenuItems5 = TextContextMenuItems.Autofill;
                    boolean m1127getCanAutofillimpl = MenuItemsAvailability.m1127getCanAutofillimpl(m1134unboximpl);
                    final Function2<TextFieldSelectionState, TextContextMenuItems, Unit> function26 = function2;
                    final TextFieldSelectionState textFieldSelectionState6 = textFieldSelectionState;
                    if (m1127getCanAutofillimpl) {
                        ContextMenuScope.item$default(contextMenuScope, new ContextMenu_androidKt$TextItem$1(textContextMenuItems5), null, false, null, new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function26.invoke(textFieldSelectionState6, TextContextMenuItems.Autofill);
                                ContextMenuState_androidKt.close(ContextMenuState.this);
                            }
                        }, 14, null);
                    }
                }
            }
        };
    }
}
