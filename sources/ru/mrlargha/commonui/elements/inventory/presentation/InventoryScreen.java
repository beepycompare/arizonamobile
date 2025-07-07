package ru.mrlargha.commonui.elements.inventory.presentation;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.LayoutVehicleInventoryBinding;
import ru.mrlargha.commonui.databinding.MainInventoryBinding;
import ru.mrlargha.commonui.domain.db.AppDatabase;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.inventory.domain.ChangeFromSlot;
import ru.mrlargha.commonui.elements.inventory.domain.ChangeToSlot;
import ru.mrlargha.commonui.elements.inventory.domain.ChangeToSlotGuard;
import ru.mrlargha.commonui.elements.inventory.domain.GuardInfoResponse;
import ru.mrlargha.commonui.elements.inventory.domain.GuardInventorySendRequest;
import ru.mrlargha.commonui.elements.inventory.domain.GuardItemRequest;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryEditResponse;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryResponse;
import ru.mrlargha.commonui.elements.inventory.domain.InventorySendRequest;
import ru.mrlargha.commonui.elements.inventory.domain.models.GuardInfo;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryMenuData;
import ru.mrlargha.commonui.elements.inventory.domain.models.Skin;
import ru.mrlargha.commonui.elements.inventory.domain.models.VehicleInfoBars;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.DraggedItem;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.InventoryMenuAdapter;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.MainInventoryAdapter;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.SubInventoryAdapter;
import ru.mrlargha.commonui.elements.inventory.presentation.adapter.UpgradesInventoryAdapter;
import ru.mrlargha.commonui.elements.inventory.presentation.dialog.SelectorDialog;
import ru.mrlargha.commonui.utils.ArizonaBlockType;
import ru.mrlargha.commonui.utils.ArzInventoryButtonTypes;
import ru.mrlargha.commonui.utils.ConstantsKt;
import ru.mrlargha.commonui.utils.FirebaseConfigHelper;
import ru.mrlargha.commonui.utils.GsonStore;
import ru.mrlargha.commonui.utils.ItemTypes;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.RodInventoryButtonTypes;
import ru.mrlargha.commonui.utils.RodinaBlockType;
import ru.mrlargha.commonui.utils.RodinaItemTypes;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: InventoryScreen.kt */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 £\u00012\u00020\u00012\u00020\u0002:\u0004¢\u0001£\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010G\u001a\u00020HH\u0002J\u0018\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u0006H\u0002J\u0010\u0010L\u001a\u00020H2\u0006\u0010M\u001a\u00020\u0018H\u0002J\u0010\u0010N\u001a\u00020H2\u0006\u0010M\u001a\u00020\u0018H\u0002J\b\u0010O\u001a\u00020HH\u0002J\b\u0010P\u001a\u00020HH\u0002J\b\u0010Q\u001a\u00020HH\u0002J\b\u0010R\u001a\u00020HH\u0002J\u0010\u0010S\u001a\u00020H2\u0006\u0010M\u001a\u00020\u0012H\u0002J\b\u0010T\u001a\u00020HH\u0002J\b\u0010U\u001a\u00020HH\u0002J\u0016\u0010V\u001a\u00020H2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0016\u0010X\u001a\u00020H2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\b\u0010Y\u001a\u00020HH\u0002J\u0010\u0010Z\u001a\u00020H2\u0006\u0010[\u001a\u00020\u0006H\u0002J\u0018\u0010\\\u001a\u00020H2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u0006H\u0002J\b\u0010`\u001a\u00020HH\u0002J\b\u0010a\u001a\u00020HH\u0002J \u0010b\u001a\u00020H2\u0006\u0010c\u001a\u00020\u00062\u0006\u0010d\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u0006H\u0002J\u0016\u0010f\u001a\u00020H2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020$0\u0011H\u0002J\b\u0010g\u001a\u00020HH\u0002J\b\u0010h\u001a\u00020HH\u0002J\b\u0010i\u001a\u00020HH\u0002J\b\u0010j\u001a\u00020HH\u0002J\b\u0010k\u001a\u00020HH\u0002J\b\u0010l\u001a\u00020HH\u0002J\u0018\u0010m\u001a\u00020H2\u0006\u0010n\u001a\u00020o2\u0006\u0010J\u001a\u00020\u0006H\u0016J\u0010\u0010p\u001a\u00020H2\u0006\u0010q\u001a\u00020\u0006H\u0002J\u0010\u0010r\u001a\u00020H2\u0006\u0010q\u001a\u00020\u0006H\u0002J\b\u0010s\u001a\u00020HH\u0002J\b\u0010t\u001a\u00020HH\u0002J\b\u0010u\u001a\u00020HH\u0002J\u0010\u0010v\u001a\u00020H2\u0006\u0010w\u001a\u00020\u0006H\u0002J\u0010\u0010x\u001a\u00020H2\u0006\u0010w\u001a\u00020\u0006H\u0002J\u0016\u0010y\u001a\u00020H2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0002J\u0016\u0010z\u001a\u00020H2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0012\u0010{\u001a\u00020H2\b\u0010M\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010|\u001a\u00020HH\u0002J\u0017\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00120~2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002J\u001a\u0010\u0081\u0001\u001a\u00020H2\u0006\u0010M\u001a\u00020\u00122\u0007\u0010\u0082\u0001\u001a\u000204H\u0002J\u0012\u0010\u0083\u0001\u001a\u00020H2\u0007\u0010\u0082\u0001\u001a\u000204H\u0002J\u001a\u0010\u0084\u0001\u001a\u00020H2\u0006\u0010M\u001a\u00020\u00122\u0007\u0010\u0082\u0001\u001a\u000204H\u0002J\u0012\u0010\u0085\u0001\u001a\u00020H2\u0007\u0010\u0082\u0001\u001a\u000204H\u0002J\u001a\u0010\u0086\u0001\u001a\u00020H2\u0006\u0010M\u001a\u00020\u00122\u0007\u0010\u0082\u0001\u001a\u000204H\u0002J\u0012\u0010\u0087\u0001\u001a\u00020H2\u0007\u0010\u0082\u0001\u001a\u000204H\u0002J\u001a\u0010\u0088\u0001\u001a\u00020H2\u0006\u0010M\u001a\u00020\u00122\u0007\u0010\u0082\u0001\u001a\u000204H\u0002J\u0012\u0010\u0089\u0001\u001a\u00020H2\u0007\u0010\u0082\u0001\u001a\u000204H\u0002J\u0012\u0010\u008a\u0001\u001a\u00020H2\u0007\u0010\u0082\u0001\u001a\u000204H\u0002J\u0013\u0010\u008b\u0001\u001a\u00020H2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0002J\t\u0010\u008e\u0001\u001a\u00020HH\u0002J\t\u0010\u008f\u0001\u001a\u00020HH\u0002J\u001a\u0010\u0090\u0001\u001a\u00020H2\u0006\u0010n\u001a\u00020\u00062\u0007\u0010\u0091\u0001\u001a\u00020\u0006H\u0016J\u001b\u0010\u0090\u0001\u001a\u00020H2\u0006\u0010n\u001a\u00020\u00062\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0016J&\u0010\u0093\u0001\u001a\u00020H2\u0007\u0010]\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020o2\t\b\u0002\u0010\u0096\u0001\u001a\u00020\u0006H\u0002J\u0013\u0010\u0097\u0001\u001a\u00020H2\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0002J\u001b\u0010\u009a\u0001\u001a\u00020H2\u0007\u0010\u009b\u0001\u001a\u00020\u00122\u0007\u0010\u009c\u0001\u001a\u00020\u0012H\u0002J\u001b\u0010\u009d\u0001\u001a\u00020H2\u0007\u0010\u009b\u0001\u001a\u00020\u00122\u0007\u0010\u009c\u0001\u001a\u00020\u0012H\u0002J\t\u0010\u009e\u0001\u001a\u00020HH\u0002J\u0019\u0010\u009f\u0001\u001a\u00020H2\u0006\u0010n\u001a\u00020o2\u0006\u0010J\u001a\u00020\u0006H\u0002J\u0012\u0010 \u0001\u001a\u00020H2\u0007\u0010¡\u0001\u001a\u000204H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010<\u001a\n >*\u0004\u0018\u00010=0=X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¤\u0001"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/InventoryScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "inventoryScreen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/MainInventoryBinding;", "frontendNotifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "currentBackendId", "mainInventoryList", "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "subCaseArmorSkinList", "subAccessoriesList", "subUpgradesList", "walletInventoryList", "menuItemList", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryMenuData;", "inventoryMenuAdapter", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/InventoryMenuAdapter;", "mainInventoryAdapter", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/MainInventoryAdapter;", "subInventoryAdapter", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/SubInventoryAdapter;", "accessoriesInventoryAdapter", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/UpgradesInventoryAdapter;", "upgradesInventoryAdapter", "walletInventoryAdapter", "guardInfoList", "Lru/mrlargha/commonui/elements/inventory/domain/models/GuardInfo;", "guardAccessoriesList", "guardInventoryList", "guardWeaponList", "guardNumber", "guardSubInventoryAdapter", "guardInventoryAdapter", "vehicleSubList", "vehicleTechnicalList", "vehicleVisualList", "vehicleAccessoriesAdapter", "vehicleTechAdapter", "vehicleVisualAdapter", "warehouseList", "warehouseAdapter", "isAccessoriesListVisible", "", "isUpgradesListVisible", "isWalletListVisible", "isTechnicalListVisible", "isVisualListVisible", "selectedInventoryItem", "db", "Lru/mrlargha/commonui/domain/db/AppDatabase;", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "isArizonaType", "currentWarehouse", "vehicleVisibilityState", "currentModSkin", "currentSkin", "clickedMenuButtons", "scope", "Lkotlinx/coroutines/CoroutineScope;", "initClickListeners", "", "sendRequestToClicks", "subId", "button", "menuClickHandlerArz", "item", "menuClickHandlerRod", "initViewSize", "observeClickBtnInventoryGuard", "initAdapters", "defaultInventoryScreen", "showSelectorDialog", "btnTechnicalPressed", "btnVisualPressed", "addItemsVehicleTechList", "list", "addItemsVehicleVisList", "guardsTypeClickListeners", "openRecyclerView", "type", "setItemBackground", "view", "Landroid/view/View;", "res", "setVisibilityBtnGuards", "defaultGuardScreen", "editMainUi", "viewParent", "margin", "viewItem", "guardInfoSetUi", "observeGuardAccessories", "btnAccessoriesPressed", "btnUpgradesPressed", "btnWalletPressed", "initObservers", "refreshItemVisibility", "onBackendMessage", "data", "", "getArzWarehouseType", "id", "getRodWarehouseType", "showGuardScreen", "showVehicleScreen", "showWarehouseScreen", "getAndShowMenuButtonsArz", "bits", "getAndShowMenuButtonsRod", "addMenuCategories", "addInfoToDatabase", "updateInfoToDatabase", "addLockedItems", "editResponseInfo", "", "inventoryList", "Lru/mrlargha/commonui/elements/inventory/domain/InventoryResponse;", "colorItem", "isColorItem", "changeGuardSubList", "changeAccessoriesItem", "changeGunImprovementsItem", "changeCaseArmorItem", "changeSkinItem", "changeVehicleSubList", "changeVisualVehicleList", "changeTechVehicleList", "addTopBars", "skin", "Lru/mrlargha/commonui/elements/inventory/domain/models/Skin;", "closeWallet", "getUserInfo", "onUpdateData", "value", "", "observeUserSkin", "Landroid/widget/ImageView;", "url", "defaultImage", "addVehicleInfo", "userBars", "Lru/mrlargha/commonui/elements/inventory/domain/models/VehicleInfoBars;", "sendData", "fromItem", "toItem", "sendGuardData", "closeAllInventoryScreens", "sendRequestTo", "setVisible", "visible", "Spawner", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InventoryScreen extends SAMPUIElement implements InterfaceController {
    public static final Companion Companion = new Companion(null);
    private static boolean isDialogVisible;
    private final UpgradesInventoryAdapter accessoriesInventoryAdapter;
    private final MainInventoryBinding binding;
    private boolean clickedMenuButtons;
    private int currentBackendId;
    private InventoryItem currentModSkin;
    private InventoryItem currentSkin;
    private int currentWarehouse;
    private final AppDatabase db;
    private final IBackendNotifier frontendNotifier;
    private List<InventoryItem> guardAccessoriesList;
    private List<GuardInfo> guardInfoList;
    private final MainInventoryAdapter guardInventoryAdapter;
    private List<InventoryItem> guardInventoryList;
    private int guardNumber;
    private final UpgradesInventoryAdapter guardSubInventoryAdapter;
    private List<InventoryItem> guardWeaponList;
    private InventoryMenuAdapter inventoryMenuAdapter;
    private final ConstraintLayout inventoryScreen;
    private boolean isAccessoriesListVisible;
    private final boolean isArizonaType;
    private boolean isTechnicalListVisible;
    private boolean isUpgradesListVisible;
    private boolean isVisualListVisible;
    private boolean isWalletListVisible;
    private final MainInventoryAdapter mainInventoryAdapter;
    private List<InventoryItem> mainInventoryList;
    private List<InventoryMenuData> menuItemList;
    private final CoroutineScope scope;
    private InventoryItem selectedInventoryItem;
    private final SharedPreferences sharedPref;
    private List<InventoryItem> subAccessoriesList;
    private List<InventoryItem> subCaseArmorSkinList;
    private final SubInventoryAdapter subInventoryAdapter;
    private List<InventoryItem> subUpgradesList;
    private final UpgradesInventoryAdapter upgradesInventoryAdapter;
    private final UpgradesInventoryAdapter vehicleAccessoriesAdapter;
    private List<InventoryItem> vehicleSubList;
    private final UpgradesInventoryAdapter vehicleTechAdapter;
    private List<InventoryItem> vehicleTechnicalList;
    private int vehicleVisibilityState;
    private final UpgradesInventoryAdapter vehicleVisualAdapter;
    private List<InventoryItem> vehicleVisualList;
    private final MainInventoryAdapter walletInventoryAdapter;
    private List<InventoryItem> walletInventoryList;
    private final MainInventoryAdapter warehouseAdapter;
    private List<InventoryItem> warehouseList;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$54$lambda$44(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$54$lambda$45(View view) {
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onUpdateData(int i, long j) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InventoryScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.main_inventory, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.inventoryScreen = constraintLayout;
        MainInventoryBinding bind = MainInventoryBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.frontendNotifier = (IBackendNotifier) targetActivity;
        this.currentBackendId = -1;
        this.mainInventoryList = new ArrayList();
        this.subCaseArmorSkinList = new ArrayList();
        this.subAccessoriesList = new ArrayList();
        this.subUpgradesList = new ArrayList();
        this.walletInventoryList = new ArrayList();
        this.menuItemList = new ArrayList();
        this.inventoryMenuAdapter = new InventoryMenuAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda55
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit inventoryMenuAdapter$lambda$0;
                inventoryMenuAdapter$lambda$0 = InventoryScreen.inventoryMenuAdapter$lambda$0(InventoryScreen.this, (InventoryMenuData) obj);
                return inventoryMenuAdapter$lambda$0;
            }
        });
        Function1 function1 = new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit mainInventoryAdapter$lambda$2;
                mainInventoryAdapter$lambda$2 = InventoryScreen.mainInventoryAdapter$lambda$2(InventoryScreen.this, (DraggedItem) obj);
                return mainInventoryAdapter$lambda$2;
            }
        };
        RecyclerView rvMainInventory = bind.rvMainInventory;
        Intrinsics.checkNotNullExpressionValue(rvMainInventory, "rvMainInventory");
        Activity activity = targetActivity;
        this.mainInventoryAdapter = new MainInventoryAdapter(new MainInventoryAdapter.Params(function1, rvMainInventory, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit mainInventoryAdapter$lambda$3;
                mainInventoryAdapter$lambda$3 = InventoryScreen.mainInventoryAdapter$lambda$3(InventoryScreen.this, (InventoryItem) obj);
                return mainInventoryAdapter$lambda$3;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit mainInventoryAdapter$lambda$4;
                mainInventoryAdapter$lambda$4 = InventoryScreen.mainInventoryAdapter$lambda$4(InventoryScreen.this, (InventoryItem) obj);
                return mainInventoryAdapter$lambda$4;
            }
        }));
        this.subInventoryAdapter = new SubInventoryAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit subInventoryAdapter$lambda$5;
                subInventoryAdapter$lambda$5 = InventoryScreen.subInventoryAdapter$lambda$5(InventoryScreen.this, (DraggedItem) obj);
                return subInventoryAdapter$lambda$5;
            }
        }, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit subInventoryAdapter$lambda$6;
                subInventoryAdapter$lambda$6 = InventoryScreen.subInventoryAdapter$lambda$6((InventoryItem) obj);
                return subInventoryAdapter$lambda$6;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit subInventoryAdapter$lambda$7;
                subInventoryAdapter$lambda$7 = InventoryScreen.subInventoryAdapter$lambda$7(InventoryScreen.this, (InventoryItem) obj);
                return subInventoryAdapter$lambda$7;
            }
        });
        this.accessoriesInventoryAdapter = new UpgradesInventoryAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit accessoriesInventoryAdapter$lambda$8;
                accessoriesInventoryAdapter$lambda$8 = InventoryScreen.accessoriesInventoryAdapter$lambda$8(InventoryScreen.this, (DraggedItem) obj);
                return accessoriesInventoryAdapter$lambda$8;
            }
        }, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit accessoriesInventoryAdapter$lambda$9;
                accessoriesInventoryAdapter$lambda$9 = InventoryScreen.accessoriesInventoryAdapter$lambda$9((InventoryItem) obj);
                return accessoriesInventoryAdapter$lambda$9;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit accessoriesInventoryAdapter$lambda$10;
                accessoriesInventoryAdapter$lambda$10 = InventoryScreen.accessoriesInventoryAdapter$lambda$10(InventoryScreen.this, (InventoryItem) obj);
                return accessoriesInventoryAdapter$lambda$10;
            }
        });
        this.upgradesInventoryAdapter = new UpgradesInventoryAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda56
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit upgradesInventoryAdapter$lambda$11;
                upgradesInventoryAdapter$lambda$11 = InventoryScreen.upgradesInventoryAdapter$lambda$11(InventoryScreen.this, (DraggedItem) obj);
                return upgradesInventoryAdapter$lambda$11;
            }
        }, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda57
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit upgradesInventoryAdapter$lambda$12;
                upgradesInventoryAdapter$lambda$12 = InventoryScreen.upgradesInventoryAdapter$lambda$12((InventoryItem) obj);
                return upgradesInventoryAdapter$lambda$12;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda58
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit upgradesInventoryAdapter$lambda$13;
                upgradesInventoryAdapter$lambda$13 = InventoryScreen.upgradesInventoryAdapter$lambda$13(InventoryScreen.this, (InventoryItem) obj);
                return upgradesInventoryAdapter$lambda$13;
            }
        });
        RecyclerView rvWalletInventory = bind.rvWalletInventory;
        Intrinsics.checkNotNullExpressionValue(rvWalletInventory, "rvWalletInventory");
        this.walletInventoryAdapter = new MainInventoryAdapter(new MainInventoryAdapter.Params(new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit walletInventoryAdapter$lambda$14;
                walletInventoryAdapter$lambda$14 = InventoryScreen.walletInventoryAdapter$lambda$14(InventoryScreen.this, (DraggedItem) obj);
                return walletInventoryAdapter$lambda$14;
            }
        }, rvWalletInventory, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit walletInventoryAdapter$lambda$15;
                walletInventoryAdapter$lambda$15 = InventoryScreen.walletInventoryAdapter$lambda$15((InventoryItem) obj);
                return walletInventoryAdapter$lambda$15;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit walletInventoryAdapter$lambda$16;
                walletInventoryAdapter$lambda$16 = InventoryScreen.walletInventoryAdapter$lambda$16(InventoryScreen.this, (InventoryItem) obj);
                return walletInventoryAdapter$lambda$16;
            }
        }));
        this.guardInfoList = new ArrayList();
        this.guardAccessoriesList = new ArrayList();
        this.guardInventoryList = new ArrayList();
        this.guardWeaponList = new ArrayList();
        this.guardSubInventoryAdapter = new UpgradesInventoryAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit guardSubInventoryAdapter$lambda$17;
                guardSubInventoryAdapter$lambda$17 = InventoryScreen.guardSubInventoryAdapter$lambda$17(InventoryScreen.this, (DraggedItem) obj);
                return guardSubInventoryAdapter$lambda$17;
            }
        }, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit guardSubInventoryAdapter$lambda$18;
                guardSubInventoryAdapter$lambda$18 = InventoryScreen.guardSubInventoryAdapter$lambda$18((InventoryItem) obj);
                return guardSubInventoryAdapter$lambda$18;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit guardSubInventoryAdapter$lambda$19;
                guardSubInventoryAdapter$lambda$19 = InventoryScreen.guardSubInventoryAdapter$lambda$19(InventoryScreen.this, (InventoryItem) obj);
                return guardSubInventoryAdapter$lambda$19;
            }
        });
        Function1 function12 = new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit guardInventoryAdapter$lambda$20;
                guardInventoryAdapter$lambda$20 = InventoryScreen.guardInventoryAdapter$lambda$20(InventoryScreen.this, (DraggedItem) obj);
                return guardInventoryAdapter$lambda$20;
            }
        };
        RecyclerView rvGuardInventory = bind.rvGuardInventory;
        Intrinsics.checkNotNullExpressionValue(rvGuardInventory, "rvGuardInventory");
        this.guardInventoryAdapter = new MainInventoryAdapter(new MainInventoryAdapter.Params(function12, rvGuardInventory, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit guardInventoryAdapter$lambda$21;
                guardInventoryAdapter$lambda$21 = InventoryScreen.guardInventoryAdapter$lambda$21((InventoryItem) obj);
                return guardInventoryAdapter$lambda$21;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit guardInventoryAdapter$lambda$22;
                guardInventoryAdapter$lambda$22 = InventoryScreen.guardInventoryAdapter$lambda$22(InventoryScreen.this, (InventoryItem) obj);
                return guardInventoryAdapter$lambda$22;
            }
        }));
        this.vehicleSubList = new ArrayList();
        this.vehicleTechnicalList = new ArrayList();
        this.vehicleVisualList = new ArrayList();
        this.vehicleAccessoriesAdapter = new UpgradesInventoryAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vehicleAccessoriesAdapter$lambda$23;
                vehicleAccessoriesAdapter$lambda$23 = InventoryScreen.vehicleAccessoriesAdapter$lambda$23(InventoryScreen.this, (DraggedItem) obj);
                return vehicleAccessoriesAdapter$lambda$23;
            }
        }, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vehicleAccessoriesAdapter$lambda$24;
                vehicleAccessoriesAdapter$lambda$24 = InventoryScreen.vehicleAccessoriesAdapter$lambda$24((InventoryItem) obj);
                return vehicleAccessoriesAdapter$lambda$24;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vehicleAccessoriesAdapter$lambda$25;
                vehicleAccessoriesAdapter$lambda$25 = InventoryScreen.vehicleAccessoriesAdapter$lambda$25(InventoryScreen.this, (InventoryItem) obj);
                return vehicleAccessoriesAdapter$lambda$25;
            }
        });
        this.vehicleTechAdapter = new UpgradesInventoryAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vehicleTechAdapter$lambda$26;
                vehicleTechAdapter$lambda$26 = InventoryScreen.vehicleTechAdapter$lambda$26(InventoryScreen.this, (DraggedItem) obj);
                return vehicleTechAdapter$lambda$26;
            }
        }, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vehicleTechAdapter$lambda$27;
                vehicleTechAdapter$lambda$27 = InventoryScreen.vehicleTechAdapter$lambda$27((InventoryItem) obj);
                return vehicleTechAdapter$lambda$27;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vehicleTechAdapter$lambda$28;
                vehicleTechAdapter$lambda$28 = InventoryScreen.vehicleTechAdapter$lambda$28(InventoryScreen.this, (InventoryItem) obj);
                return vehicleTechAdapter$lambda$28;
            }
        });
        this.vehicleVisualAdapter = new UpgradesInventoryAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vehicleVisualAdapter$lambda$29;
                vehicleVisualAdapter$lambda$29 = InventoryScreen.vehicleVisualAdapter$lambda$29(InventoryScreen.this, (DraggedItem) obj);
                return vehicleVisualAdapter$lambda$29;
            }
        }, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vehicleVisualAdapter$lambda$30;
                vehicleVisualAdapter$lambda$30 = InventoryScreen.vehicleVisualAdapter$lambda$30((InventoryItem) obj);
                return vehicleVisualAdapter$lambda$30;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vehicleVisualAdapter$lambda$31;
                vehicleVisualAdapter$lambda$31 = InventoryScreen.vehicleVisualAdapter$lambda$31(InventoryScreen.this, (InventoryItem) obj);
                return vehicleVisualAdapter$lambda$31;
            }
        });
        this.warehouseList = new ArrayList();
        Function1 function13 = new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit warehouseAdapter$lambda$32;
                warehouseAdapter$lambda$32 = InventoryScreen.warehouseAdapter$lambda$32(InventoryScreen.this, (DraggedItem) obj);
                return warehouseAdapter$lambda$32;
            }
        };
        RecyclerView rvWarehouse = bind.layoutWarehouse.rvWarehouse;
        Intrinsics.checkNotNullExpressionValue(rvWarehouse, "rvWarehouse");
        this.warehouseAdapter = new MainInventoryAdapter(new MainInventoryAdapter.Params(function13, rvWarehouse, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit warehouseAdapter$lambda$33;
                warehouseAdapter$lambda$33 = InventoryScreen.warehouseAdapter$lambda$33((InventoryItem) obj);
                return warehouseAdapter$lambda$33;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit warehouseAdapter$lambda$34;
                warehouseAdapter$lambda$34 = InventoryScreen.warehouseAdapter$lambda$34(InventoryScreen.this, (InventoryItem) obj);
                return warehouseAdapter$lambda$34;
            }
        }));
        this.db = AppDatabase.Companion.invoke(activity);
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("isArizonaType", false);
        this.isArizonaType = z;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        addViewToConstraintLayout(constraintLayout, -1, -1);
        UtilsKt.checkItemsName(activity, z);
        initAdapters();
        initClickListeners();
        setVisible(false);
        Group groupCharacter = bind.groupCharacter;
        Intrinsics.checkNotNullExpressionValue(groupCharacter, "groupCharacter");
        groupCharacter.setVisibility(0);
        ConstraintLayout parentLayout = bind.layoutGuards.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
        parentLayout.setVisibility(8);
        ConstraintLayout parentLayout2 = bind.layoutVehicle.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout2, "parentLayout");
        parentLayout2.setVisibility(8);
        ConstraintLayout parentLayout3 = bind.layoutWarehouse.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout3, "parentLayout");
        parentLayout3.setVisibility(8);
        RecyclerView rvSubInventory = bind.rvSubInventory;
        Intrinsics.checkNotNullExpressionValue(rvSubInventory, "rvSubInventory");
        rvSubInventory.setVisibility(0);
        RecyclerView rvUpgradesInventory = bind.rvUpgradesInventory;
        Intrinsics.checkNotNullExpressionValue(rvUpgradesInventory, "rvUpgradesInventory");
        rvUpgradesInventory.setVisibility(8);
        RecyclerView rvWalletInventory2 = bind.rvWalletInventory;
        Intrinsics.checkNotNullExpressionValue(rvWalletInventory2, "rvWalletInventory");
        rvWalletInventory2.setVisibility(8);
        bind.layoutGuards.btnGuardTypeOne.setBackgroundResource(R.drawable.btn_guard_1_white);
        ProgressBar progressBar = bind.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(0);
        bind.layoutGuards.layoutGuardInfo.setOnDragListener(new View.OnDragListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda26
            @Override // android.view.View.OnDragListener
            public final boolean onDrag(View view, DragEvent dragEvent) {
                boolean _init_$lambda$35;
                _init_$lambda$35 = InventoryScreen._init_$lambda$35(InventoryScreen.this, view, dragEvent);
                return _init_$lambda$35;
            }
        });
        this.currentBackendId = i;
        bind.getRoot().post(new Runnable() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                InventoryScreen._init_$lambda$36(InventoryScreen.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inventoryMenuAdapter$lambda$0(InventoryScreen inventoryScreen, InventoryMenuData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (inventoryScreen.isArizonaType) {
            inventoryScreen.menuClickHandlerArz(it);
        } else {
            inventoryScreen.menuClickHandlerRod(it);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mainInventoryAdapter$lambda$2(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        InventoryItem inventoryItem = (InventoryItem) CollectionsKt.getOrNull(inventoryScreen.mainInventoryList, currentItem.getPosition());
        if (inventoryItem != null) {
            inventoryScreen.sendData(currentItem.getItemInfo(), inventoryItem);
            inventoryScreen.colorItem(currentItem.getItemInfo(), false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mainInventoryAdapter$lambda$3(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        inventoryScreen.colorItem(it, true);
        Group groupCharacter = inventoryScreen.binding.groupCharacter;
        Intrinsics.checkNotNullExpressionValue(groupCharacter, "groupCharacter");
        if (groupCharacter.getVisibility() == 0) {
            Integer item_type = it.getItem_type();
            inventoryScreen.openRecyclerView(item_type != null ? item_type.intValue() : 0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mainInventoryAdapter$lambda$4(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getItem() != null) {
            inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())), 2);
            inventoryScreen.showSelectorDialog(it);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit subInventoryAdapter$lambda$5(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        inventoryScreen.sendData(currentItem.getItemInfo(), inventoryScreen.subCaseArmorSkinList.get(currentItem.getPosition()));
        inventoryScreen.colorItem(currentItem.getItemInfo(), false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit subInventoryAdapter$lambda$6(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit subInventoryAdapter$lambda$7(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getItem() != null) {
            inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())), 2);
            inventoryScreen.showSelectorDialog(it);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit accessoriesInventoryAdapter$lambda$8(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        inventoryScreen.sendData(currentItem.getItemInfo(), inventoryScreen.subAccessoriesList.get(currentItem.getPosition()));
        inventoryScreen.colorItem(currentItem.getItemInfo(), false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit accessoriesInventoryAdapter$lambda$9(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit accessoriesInventoryAdapter$lambda$10(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getItem() != null) {
            inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())), 2);
            inventoryScreen.showSelectorDialog(it);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upgradesInventoryAdapter$lambda$11(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        inventoryScreen.sendData(currentItem.getItemInfo(), inventoryScreen.subUpgradesList.get(currentItem.getPosition()));
        inventoryScreen.colorItem(currentItem.getItemInfo(), false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upgradesInventoryAdapter$lambda$12(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upgradesInventoryAdapter$lambda$13(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getItem() != null) {
            inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())), 2);
            inventoryScreen.showSelectorDialog(it);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit walletInventoryAdapter$lambda$14(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        inventoryScreen.sendData(currentItem.getItemInfo(), inventoryScreen.walletInventoryList.get(currentItem.getPosition()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit walletInventoryAdapter$lambda$15(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit walletInventoryAdapter$lambda$16(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())), 2);
        inventoryScreen.showSelectorDialog(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit guardSubInventoryAdapter$lambda$17(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        inventoryScreen.sendGuardData(currentItem.getItemInfo(), inventoryScreen.guardInfoList.get(inventoryScreen.guardNumber).getAccessoriesList().get(currentItem.getPosition()));
        inventoryScreen.colorItem(currentItem.getItemInfo(), false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit guardSubInventoryAdapter$lambda$18(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit guardSubInventoryAdapter$lambda$19(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlotGuard(it.getSlot(), it.getInventoryType(), it.getId())), 2);
        inventoryScreen.showSelectorDialog(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit guardInventoryAdapter$lambda$20(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        inventoryScreen.sendGuardData(currentItem.getItemInfo(), inventoryScreen.guardInfoList.get(inventoryScreen.guardNumber).getInventoryList().get(currentItem.getPosition()));
        inventoryScreen.colorItem(currentItem.getItemInfo(), false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit guardInventoryAdapter$lambda$21(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit guardInventoryAdapter$lambda$22(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlotGuard(it.getSlot(), it.getInventoryType(), it.getId())), 2);
        inventoryScreen.showSelectorDialog(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vehicleAccessoriesAdapter$lambda$23(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        inventoryScreen.sendData(currentItem.getItemInfo(), inventoryScreen.vehicleSubList.get(currentItem.getPosition()));
        inventoryScreen.colorItem(currentItem.getItemInfo(), false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vehicleAccessoriesAdapter$lambda$24(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vehicleAccessoriesAdapter$lambda$25(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())), 2);
        inventoryScreen.showSelectorDialog(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vehicleTechAdapter$lambda$26(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        if (currentItem.getPosition() < 10) {
            inventoryScreen.sendData(currentItem.getItemInfo(), inventoryScreen.vehicleTechnicalList.get(currentItem.getPosition()));
        }
        inventoryScreen.colorItem(currentItem.getItemInfo(), false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vehicleTechAdapter$lambda$27(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vehicleTechAdapter$lambda$28(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())), 2);
        inventoryScreen.showSelectorDialog(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vehicleVisualAdapter$lambda$29(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        if (currentItem.getPosition() < 10) {
            inventoryScreen.sendData(currentItem.getItemInfo(), inventoryScreen.vehicleVisualList.get(currentItem.getPosition()));
        }
        inventoryScreen.colorItem(currentItem.getItemInfo(), false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vehicleVisualAdapter$lambda$30(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vehicleVisualAdapter$lambda$31(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())), 2);
        inventoryScreen.showSelectorDialog(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit warehouseAdapter$lambda$32(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        inventoryScreen.sendData(currentItem.getItemInfo(), inventoryScreen.warehouseList.get(currentItem.getPosition()));
        inventoryScreen.colorItem(currentItem.getItemInfo(), false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit warehouseAdapter$lambda$33(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit warehouseAdapter$lambda$34(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())), 2);
        inventoryScreen.showSelectorDialog(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$35(InventoryScreen inventoryScreen, View view, DragEvent dragEvent) {
        int action = dragEvent.getAction();
        if (action != 1) {
            if (action != 3) {
                return false;
            }
            Object fromJson = GsonStore.INSTANCE.getGson().fromJson(dragEvent.getClipData().getItemAt(0).getText().toString(), (Class<Object>) InventoryItem.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
            InventoryItem inventoryItem = (InventoryItem) fromJson;
            int slot = inventoryItem.getSlot();
            int inventoryType = inventoryItem.getInventoryType();
            Integer amount = inventoryItem.getAmount();
            ChangeFromSlot changeFromSlot = new ChangeFromSlot(slot, inventoryType, amount != null ? amount.intValue() : 1, inventoryItem.getId());
            Integer id = inventoryScreen.guardInfoList.get(inventoryScreen.guardNumber).getId();
            inventoryScreen.sendRequestTo(StringKt.toStringJson(new GuardItemRequest(changeFromSlot, id != null ? id.intValue() : -1)), 5);
            view.invalidate();
            Object localState = dragEvent.getLocalState();
            ConstraintLayout constraintLayout = localState instanceof ConstraintLayout ? (ConstraintLayout) localState : null;
            ViewParent parent = constraintLayout != null ? constraintLayout.getParent() : null;
            ViewGroup viewGroup = parent instanceof ViewGroup ? parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(constraintLayout);
            }
            return true;
        }
        return dragEvent.getClipDescription().hasMimeType("text/plain");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$36(InventoryScreen inventoryScreen) {
        inventoryScreen.binding.getRoot().getViewTreeObserver().addOnWindowAttachListener(new ViewTreeObserver.OnWindowAttachListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$2$1
            @Override // android.view.ViewTreeObserver.OnWindowAttachListener
            public void onWindowAttached() {
                Log.e("inventory", "🚪 View attached to window");
            }

            @Override // android.view.ViewTreeObserver.OnWindowAttachListener
            public void onWindowDetached() {
                Log.e("inventory", "🚪 View detached from window");
            }
        });
    }

    private final void initClickListeners() {
        final MainInventoryBinding mainInventoryBinding = this.binding;
        mainInventoryBinding.btnAccessories.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda36
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.initClickListeners$lambda$54$lambda$37(InventoryScreen.this, view);
            }
        });
        mainInventoryBinding.btnUpgrades.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda45
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.initClickListeners$lambda$54$lambda$38(InventoryScreen.this, view);
            }
        });
        mainInventoryBinding.btnWallet.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda46
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.initClickListeners$lambda$54$lambda$39(InventoryScreen.this, view);
            }
        });
        mainInventoryBinding.layoutGuards.btnGuardMenu.btnGuardMenu.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda47
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.initClickListeners$lambda$54$lambda$40(InventoryScreen.this, view);
            }
        });
        mainInventoryBinding.btnBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda48
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.initClickListeners$lambda$54$lambda$41(MainInventoryBinding.this, this, view);
            }
        });
        mainInventoryBinding.layoutGuards.btnGuardInventory.btnGuardInventory.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda49
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.this.observeClickBtnInventoryGuard();
            }
        });
        mainInventoryBinding.layoutGuards.layoutGuardInfo.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.initClickListeners$lambda$54$lambda$43(InventoryScreen.this, view);
            }
        });
        mainInventoryBinding.layoutGuards.parentLayout.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda51
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.initClickListeners$lambda$54$lambda$44(view);
            }
        });
        mainInventoryBinding.parentLayout.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.initClickListeners$lambda$54$lambda$45(view);
            }
        });
        mainInventoryBinding.layoutVehicle.btnVehicleTechnical.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.initClickListeners$lambda$54$lambda$46(InventoryScreen.this, mainInventoryBinding, view);
            }
        });
        mainInventoryBinding.layoutVehicle.btnVehicleVisual.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.initClickListeners$lambda$54$lambda$47(InventoryScreen.this, mainInventoryBinding, view);
            }
        });
        mainInventoryBinding.btnStats.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.this.sendRequestToClicks(6, 0);
            }
        });
        mainInventoryBinding.btnPassport.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.this.sendRequestToClicks(6, 1);
            }
        });
        mainInventoryBinding.btnMedbook.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.this.sendRequestToClicks(6, 2);
            }
        });
        mainInventoryBinding.btnVipStatus.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda41
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.this.sendRequestToClicks(6, 3);
            }
        });
        mainInventoryBinding.btnSortItems.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.this.sendRequestToClicks(6, 4);
            }
        });
        this.binding.layoutWarehouse.etStoreMoney.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.this.sendRequestTo("", 3);
            }
        });
        guardsTypeClickListeners();
        initViewSize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$54$lambda$37(InventoryScreen inventoryScreen, View view) {
        if (inventoryScreen.isAccessoriesListVisible) {
            inventoryScreen.binding.btnAccessories.setBackgroundResource(R.drawable.ic_btn_accessories_red);
            RecyclerView rvAccessoriesInventory = inventoryScreen.binding.rvAccessoriesInventory;
            Intrinsics.checkNotNullExpressionValue(rvAccessoriesInventory, "rvAccessoriesInventory");
            rvAccessoriesInventory.setVisibility(8);
            inventoryScreen.isAccessoriesListVisible = false;
            return;
        }
        RecyclerView rvAccessoriesInventory2 = inventoryScreen.binding.rvAccessoriesInventory;
        Intrinsics.checkNotNullExpressionValue(rvAccessoriesInventory2, "rvAccessoriesInventory");
        rvAccessoriesInventory2.setVisibility(8);
        inventoryScreen.btnAccessoriesPressed();
        inventoryScreen.isAccessoriesListVisible = true;
        if (inventoryScreen.isUpgradesListVisible) {
            inventoryScreen.isUpgradesListVisible = false;
        } else if (inventoryScreen.isWalletListVisible) {
            inventoryScreen.frontendNotifier.setUIElementVisible(UIElementID.INVENTORY_WALLET_SCREEN.getId(), false);
            inventoryScreen.frontendNotifier.setUIElementVisible(UIElementID.INVENTORY.getId(), true);
            inventoryScreen.isWalletListVisible = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$54$lambda$38(InventoryScreen inventoryScreen, View view) {
        if (inventoryScreen.isUpgradesListVisible) {
            inventoryScreen.binding.btnUpgrades.setBackgroundResource(R.drawable.ic_btn_upgrades);
            RecyclerView rvUpgradesInventory = inventoryScreen.binding.rvUpgradesInventory;
            Intrinsics.checkNotNullExpressionValue(rvUpgradesInventory, "rvUpgradesInventory");
            rvUpgradesInventory.setVisibility(8);
            inventoryScreen.isUpgradesListVisible = false;
            return;
        }
        RecyclerView rvUpgradesInventory2 = inventoryScreen.binding.rvUpgradesInventory;
        Intrinsics.checkNotNullExpressionValue(rvUpgradesInventory2, "rvUpgradesInventory");
        rvUpgradesInventory2.setVisibility(8);
        inventoryScreen.btnUpgradesPressed();
        inventoryScreen.isUpgradesListVisible = true;
        if (inventoryScreen.isAccessoriesListVisible) {
            inventoryScreen.isAccessoriesListVisible = false;
        } else if (inventoryScreen.isWalletListVisible) {
            inventoryScreen.frontendNotifier.setUIElementVisible(UIElementID.INVENTORY_WALLET_SCREEN.getId(), false);
            inventoryScreen.frontendNotifier.setUIElementVisible(UIElementID.INVENTORY.getId(), true);
            inventoryScreen.isWalletListVisible = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$54$lambda$39(InventoryScreen inventoryScreen, View view) {
        boolean z = inventoryScreen.isWalletListVisible;
        Log.e("wallet", "initClickListeners: " + z + " " + inventoryScreen.walletInventoryList);
        if (inventoryScreen.isWalletListVisible) {
            inventoryScreen.binding.btnWallet.setBackgroundResource(R.drawable.ic_btn_wallet_grey);
            RecyclerView rvSubInventory = inventoryScreen.binding.rvSubInventory;
            Intrinsics.checkNotNullExpressionValue(rvSubInventory, "rvSubInventory");
            rvSubInventory.setVisibility(0);
            RecyclerView rvWalletInventory = inventoryScreen.binding.rvWalletInventory;
            Intrinsics.checkNotNullExpressionValue(rvWalletInventory, "rvWalletInventory");
            rvWalletInventory.setVisibility(8);
            inventoryScreen.isWalletListVisible = false;
            inventoryScreen.frontendNotifier.setUIElementVisible(UIElementID.INVENTORY_WALLET_SCREEN.getId(), false);
            inventoryScreen.frontendNotifier.setUIElementVisible(UIElementID.INVENTORY.getId(), true);
            inventoryScreen.currentBackendId = UIElementID.INVENTORY.getId();
            return;
        }
        if (inventoryScreen.isAccessoriesListVisible) {
            inventoryScreen.isAccessoriesListVisible = false;
        } else if (inventoryScreen.isUpgradesListVisible) {
            inventoryScreen.isUpgradesListVisible = false;
        }
        if (inventoryScreen.isArizonaType) {
            IBackendNotifier iBackendNotifier = inventoryScreen.frontendNotifier;
            int id = UIElementID.INVENTORY_WALLET_SCREEN.getId();
            byte[] bytes = StringKt.toStringJson(new BlockType(24)).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            iBackendNotifier.clickedWrapper(id, -1, 0, bytes);
        } else {
            inventoryScreen.btnWalletPressed();
            IBackendNotifier iBackendNotifier2 = inventoryScreen.frontendNotifier;
            int id2 = UIElementID.INVENTORY_WALLET_SCREEN.getId();
            byte[] bytes2 = StringKt.toStringJson("").getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            iBackendNotifier2.clickedWrapper(id2, -1, 0, bytes2);
        }
        inventoryScreen.currentBackendId = UIElementID.INVENTORY_WALLET_SCREEN.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$54$lambda$40(InventoryScreen inventoryScreen, View view) {
        IBackendNotifier iBackendNotifier = inventoryScreen.frontendNotifier;
        int id = UIElementID.INVENTORY_SECURITY_SCREEN.getId();
        byte[] bytes = StringKt.toStringJson(new SendId(inventoryScreen.guardInfoList.get(inventoryScreen.guardNumber).getId())).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, 3, bytes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$54$lambda$41(MainInventoryBinding mainInventoryBinding, InventoryScreen inventoryScreen, View view) {
        RecyclerView rvGuardInventory = mainInventoryBinding.rvGuardInventory;
        Intrinsics.checkNotNullExpressionValue(rvGuardInventory, "rvGuardInventory");
        if (rvGuardInventory.getVisibility() == 0) {
            inventoryScreen.defaultGuardScreen();
        } else {
            inventoryScreen.defaultInventoryScreen();
            inventoryScreen.currentBackendId = inventoryScreen.getBackendID();
            inventoryScreen.isAccessoriesListVisible = false;
            inventoryScreen.isUpgradesListVisible = false;
            inventoryScreen.isWalletListVisible = false;
            inventoryScreen.isTechnicalListVisible = false;
            inventoryScreen.isVisualListVisible = false;
            inventoryScreen.closeAllInventoryScreens();
            inventoryScreen.setVisible(false);
        }
        inventoryScreen.inventoryMenuAdapter.resetSelectItemPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$54$lambda$43(InventoryScreen inventoryScreen, View view) {
        inventoryScreen.sendRequestTo(StringKt.toStringJson(new SendId(inventoryScreen.guardInfoList.get(inventoryScreen.guardNumber).getId())), 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$54$lambda$46(InventoryScreen inventoryScreen, MainInventoryBinding mainInventoryBinding, View view) {
        Log.e("inventory", "initClickListeners: " + inventoryScreen.isTechnicalListVisible);
        if (inventoryScreen.isTechnicalListVisible) {
            view.setBackgroundResource(R.drawable.btn_technical_grey);
            ConstraintLayout constraintTechVis = mainInventoryBinding.layoutVehicle.constraintTechVis;
            Intrinsics.checkNotNullExpressionValue(constraintTechVis, "constraintTechVis");
            constraintTechVis.setVisibility(8);
            RecyclerView rvVehicleAccessories = mainInventoryBinding.layoutVehicle.rvVehicleAccessories;
            Intrinsics.checkNotNullExpressionValue(rvVehicleAccessories, "rvVehicleAccessories");
            rvVehicleAccessories.setVisibility(0);
            LinearLayout layoutVehicleInfo = mainInventoryBinding.layoutVehicle.layoutVehicleInfo;
            Intrinsics.checkNotNullExpressionValue(layoutVehicleInfo, "layoutVehicleInfo");
            layoutVehicleInfo.setVisibility(0);
            inventoryScreen.isTechnicalListVisible = false;
            return;
        }
        inventoryScreen.btnTechnicalPressed();
        if (inventoryScreen.isVisualListVisible) {
            inventoryScreen.btnTechnicalPressed();
            inventoryScreen.isVisualListVisible = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$54$lambda$47(InventoryScreen inventoryScreen, MainInventoryBinding mainInventoryBinding, View view) {
        if (inventoryScreen.isVisualListVisible) {
            view.setBackgroundResource(R.drawable.btn_visual_grey);
            ConstraintLayout constraintTechVis = mainInventoryBinding.layoutVehicle.constraintTechVis;
            Intrinsics.checkNotNullExpressionValue(constraintTechVis, "constraintTechVis");
            constraintTechVis.setVisibility(8);
            RecyclerView rvVehicleAccessories = mainInventoryBinding.layoutVehicle.rvVehicleAccessories;
            Intrinsics.checkNotNullExpressionValue(rvVehicleAccessories, "rvVehicleAccessories");
            rvVehicleAccessories.setVisibility(0);
            LinearLayout layoutVehicleInfo = mainInventoryBinding.layoutVehicle.layoutVehicleInfo;
            Intrinsics.checkNotNullExpressionValue(layoutVehicleInfo, "layoutVehicleInfo");
            layoutVehicleInfo.setVisibility(0);
            inventoryScreen.isVisualListVisible = false;
            inventoryScreen.vehicleAccessoriesAdapter.submitList(CollectionsKt.toList(inventoryScreen.vehicleSubList));
            return;
        }
        inventoryScreen.btnVisualPressed();
        if (inventoryScreen.isTechnicalListVisible) {
            inventoryScreen.btnVisualPressed();
            inventoryScreen.isTechnicalListVisible = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendRequestToClicks(int i, int i2) {
        IBackendNotifier iBackendNotifier = this.frontendNotifier;
        int id = UIElementID.INVENTORY.getId();
        byte[] bytes = StringKt.toStringJson(new ButtonsType(i2)).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, i, bytes);
    }

    private final void menuClickHandlerArz(InventoryMenuData inventoryMenuData) {
        getArzWarehouseType(inventoryMenuData.getMenuId());
        Log.e("inventory", "menuClickHandlerArz: " + inventoryMenuData.getMenuId());
        switch (inventoryMenuData.getMenuId()) {
            case 0:
                IBackendNotifier iBackendNotifier = this.frontendNotifier;
                int id = UIElementID.INVENTORY.getId();
                byte[] bytes = "".getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                iBackendNotifier.clickedWrapper(id, -1, 0, bytes);
                defaultInventoryScreen();
                this.currentBackendId = UIElementID.INVENTORY.getId();
                return;
            case 1:
                IBackendNotifier iBackendNotifier2 = this.frontendNotifier;
                int id2 = UIElementID.INVENTORY_VEHICLE_SCREEN.getId();
                byte[] bytes2 = "".getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                iBackendNotifier2.clickedWrapper(id2, -1, 0, bytes2);
                this.currentBackendId = UIElementID.INVENTORY_VEHICLE_SCREEN.getId();
                return;
            case 2:
                IBackendNotifier iBackendNotifier3 = this.frontendNotifier;
                int id3 = UIElementID.INVENTORY_SECURITY_SCREEN.getId();
                byte[] bytes3 = "".getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
                iBackendNotifier3.clickedWrapper(id3, -1, 0, bytes3);
                this.currentBackendId = UIElementID.INVENTORY_SECURITY_SCREEN.getId();
                return;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                IBackendNotifier iBackendNotifier4 = this.frontendNotifier;
                int id4 = UIElementID.INVENTORY_WAREHOUSE.getId();
                byte[] bytes4 = StringKt.toStringJson(new BlockType(this.currentWarehouse)).getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes4, "getBytes(...)");
                iBackendNotifier4.clickedWrapper(id4, -1, 0, bytes4);
                return;
            case 12:
                sendRequestToClicks(5, 4096);
                this.inventoryMenuAdapter.resetSelectItemPosition();
                return;
            case 13:
                sendRequestToClicks(5, 8192);
                return;
            case 14:
                sendRequestToClicks(5, 16384);
                return;
            default:
                return;
        }
    }

    private final void menuClickHandlerRod(InventoryMenuData inventoryMenuData) {
        getRodWarehouseType(inventoryMenuData.getMenuId());
        switch (inventoryMenuData.getMenuId()) {
            case 0:
                IBackendNotifier iBackendNotifier = this.frontendNotifier;
                int id = UIElementID.INVENTORY.getId();
                byte[] bytes = "".getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                iBackendNotifier.clickedWrapper(id, -1, 0, bytes);
                defaultInventoryScreen();
                this.currentBackendId = UIElementID.INVENTORY.getId();
                return;
            case 1:
                IBackendNotifier iBackendNotifier2 = this.frontendNotifier;
                int id2 = UIElementID.INVENTORY_VEHICLE_SCREEN.getId();
                byte[] bytes2 = "".getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                iBackendNotifier2.clickedWrapper(id2, -1, 0, bytes2);
                this.currentBackendId = UIElementID.INVENTORY_VEHICLE_SCREEN.getId();
                return;
            case 2:
                IBackendNotifier iBackendNotifier3 = this.frontendNotifier;
                int id3 = UIElementID.INVENTORY_SECURITY_SCREEN.getId();
                byte[] bytes3 = "".getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
                iBackendNotifier3.clickedWrapper(id3, -1, 0, bytes3);
                this.currentBackendId = UIElementID.INVENTORY_SECURITY_SCREEN.getId();
                return;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 17:
                IBackendNotifier iBackendNotifier4 = this.frontendNotifier;
                int id4 = UIElementID.INVENTORY_WAREHOUSE.getId();
                byte[] bytes4 = StringKt.toStringJson(new BlockType(this.currentWarehouse)).getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes4, "getBytes(...)");
                iBackendNotifier4.clickedWrapper(id4, -1, 0, bytes4);
                return;
            case 14:
                sendRequestToClicks(5, 16384);
                return;
            case 15:
                sendRequestToClicks(5, 32768);
                return;
            case 16:
                sendRequestToClicks(5, 65536);
                return;
            default:
                return;
        }
    }

    private final void initViewSize() {
        double d = getTargetActivity().getResources().getDisplayMetrics().widthPixels;
        int roundToInt = MathKt.roundToInt(0.09d * d);
        int roundToInt2 = MathKt.roundToInt(d * 0.18d);
        ViewGroup.LayoutParams layoutParams = this.binding.layoutGuards.layoutGuardInfo.getLayoutParams();
        layoutParams.width = roundToInt;
        layoutParams.height = roundToInt2;
        this.binding.layoutGuards.layoutGuardInfo.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void observeClickBtnInventoryGuard() {
        this.binding.tvInventory.setText("ИНВЕНТАРЬ ОХРАННИКА - " + this.guardInfoList.get(this.guardNumber).getName());
        Group groupCharacterInfo = this.binding.groupCharacterInfo;
        Intrinsics.checkNotNullExpressionValue(groupCharacterInfo, "groupCharacterInfo");
        groupCharacterInfo.setVisibility(8);
        RecyclerView rvCategoryMenu = this.binding.rvCategoryMenu;
        Intrinsics.checkNotNullExpressionValue(rvCategoryMenu, "rvCategoryMenu");
        rvCategoryMenu.setVisibility(8);
        ConstraintLayout parentLayout = this.binding.layoutGuards.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
        parentLayout.setVisibility(8);
        editMainUi(0, 30, R.id.rvMainInventory);
        RecyclerView rvGuardInventory = this.binding.rvGuardInventory;
        Intrinsics.checkNotNullExpressionValue(rvGuardInventory, "rvGuardInventory");
        rvGuardInventory.setVisibility(0);
        this.currentBackendId = UIElementID.INVENTORY_SECURITY_SCREEN.getId();
    }

    private final void initAdapters() {
        this.binding.rvMainInventory.setItemAnimator(null);
        this.binding.rvCategoryMenu.setAdapter(this.inventoryMenuAdapter);
        this.binding.rvMainInventory.setAdapter(this.mainInventoryAdapter);
        this.binding.rvSubInventory.setAdapter(this.subInventoryAdapter);
        this.binding.rvAccessoriesInventory.setAdapter(this.accessoriesInventoryAdapter);
        this.binding.rvUpgradesInventory.setAdapter(this.upgradesInventoryAdapter);
        this.binding.rvWalletInventory.setAdapter(this.walletInventoryAdapter);
        this.binding.layoutGuards.rvGuardSubInventory.setAdapter(this.guardSubInventoryAdapter);
        this.binding.rvGuardInventory.setAdapter(this.guardInventoryAdapter);
        this.binding.layoutVehicle.rvVehicleAccessories.setAdapter(this.vehicleAccessoriesAdapter);
        this.binding.layoutVehicle.rvVehicleTech.setAdapter(this.vehicleTechAdapter);
        this.binding.layoutVehicle.rvVehicleVisual.setAdapter(this.vehicleVisualAdapter);
        this.binding.layoutWarehouse.rvWarehouse.setAdapter(this.warehouseAdapter);
    }

    private final void defaultInventoryScreen() {
        MainInventoryBinding mainInventoryBinding = this.binding;
        Group groupCharacter = mainInventoryBinding.groupCharacter;
        Intrinsics.checkNotNullExpressionValue(groupCharacter, "groupCharacter");
        groupCharacter.setVisibility(0);
        mainInventoryBinding.btnAccessories.setBackgroundResource(R.drawable.ic_btn_accessories_red);
        mainInventoryBinding.btnUpgrades.setBackgroundResource(R.drawable.ic_btn_upgrades);
        mainInventoryBinding.btnWallet.setBackgroundResource(R.drawable.ic_btn_wallet_grey);
        RecyclerView rvAccessoriesInventory = mainInventoryBinding.rvAccessoriesInventory;
        Intrinsics.checkNotNullExpressionValue(rvAccessoriesInventory, "rvAccessoriesInventory");
        rvAccessoriesInventory.setVisibility(8);
        RecyclerView rvUpgradesInventory = mainInventoryBinding.rvUpgradesInventory;
        Intrinsics.checkNotNullExpressionValue(rvUpgradesInventory, "rvUpgradesInventory");
        rvUpgradesInventory.setVisibility(8);
        RecyclerView rvWalletInventory = mainInventoryBinding.rvWalletInventory;
        Intrinsics.checkNotNullExpressionValue(rvWalletInventory, "rvWalletInventory");
        rvWalletInventory.setVisibility(8);
        ConstraintLayout parentLayout = mainInventoryBinding.layoutGuards.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
        parentLayout.setVisibility(8);
        ConstraintLayout parentLayout2 = mainInventoryBinding.layoutVehicle.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout2, "parentLayout");
        parentLayout2.setVisibility(8);
        ConstraintLayout constraintTechVis = mainInventoryBinding.layoutVehicle.constraintTechVis;
        Intrinsics.checkNotNullExpressionValue(constraintTechVis, "constraintTechVis");
        constraintTechVis.setVisibility(8);
        LinearLayout layoutVehicleInfo = mainInventoryBinding.layoutVehicle.layoutVehicleInfo;
        Intrinsics.checkNotNullExpressionValue(layoutVehicleInfo, "layoutVehicleInfo");
        layoutVehicleInfo.setVisibility(0);
        RecyclerView rvVehicleAccessories = mainInventoryBinding.layoutVehicle.rvVehicleAccessories;
        Intrinsics.checkNotNullExpressionValue(rvVehicleAccessories, "rvVehicleAccessories");
        rvVehicleAccessories.setVisibility(0);
        this.binding.layoutVehicle.btnVehicleTechnical.setBackgroundResource(R.drawable.btn_technical_grey);
        this.binding.layoutVehicle.btnVehicleVisual.setBackgroundResource(R.drawable.btn_visual_grey);
        ConstraintLayout parentLayout3 = mainInventoryBinding.layoutWarehouse.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout3, "parentLayout");
        parentLayout3.setVisibility(8);
    }

    private final void showSelectorDialog(InventoryItem inventoryItem) {
        isDialogVisible = true;
        this.selectedInventoryItem = inventoryItem;
    }

    private final void btnTechnicalPressed() {
        LayoutVehicleInventoryBinding layoutVehicleInventoryBinding = this.binding.layoutVehicle;
        layoutVehicleInventoryBinding.btnVehicleTechnical.setBackgroundResource(R.drawable.btn_technical_white);
        layoutVehicleInventoryBinding.btnVehicleVisual.setBackgroundResource(R.drawable.btn_visual_grey);
        ConstraintLayout constraintTechVis = layoutVehicleInventoryBinding.constraintTechVis;
        Intrinsics.checkNotNullExpressionValue(constraintTechVis, "constraintTechVis");
        constraintTechVis.setVisibility(0);
        RecyclerView rvVehicleTech = layoutVehicleInventoryBinding.rvVehicleTech;
        Intrinsics.checkNotNullExpressionValue(rvVehicleTech, "rvVehicleTech");
        rvVehicleTech.setVisibility(0);
        RecyclerView rvVehicleVisual = layoutVehicleInventoryBinding.rvVehicleVisual;
        Intrinsics.checkNotNullExpressionValue(rvVehicleVisual, "rvVehicleVisual");
        rvVehicleVisual.setVisibility(8);
        RecyclerView rvVehicleAccessories = layoutVehicleInventoryBinding.rvVehicleAccessories;
        Intrinsics.checkNotNullExpressionValue(rvVehicleAccessories, "rvVehicleAccessories");
        rvVehicleAccessories.setVisibility(8);
        LinearLayout layoutVehicleInfo = layoutVehicleInventoryBinding.layoutVehicleInfo;
        Intrinsics.checkNotNullExpressionValue(layoutVehicleInfo, "layoutVehicleInfo");
        layoutVehicleInfo.setVisibility(8);
        this.isTechnicalListVisible = true;
        if (this.vehicleTechnicalList.size() < 12) {
            addItemsVehicleTechList(this.vehicleTechnicalList);
        }
    }

    private final void btnVisualPressed() {
        LayoutVehicleInventoryBinding layoutVehicleInventoryBinding = this.binding.layoutVehicle;
        layoutVehicleInventoryBinding.btnVehicleTechnical.setBackgroundResource(R.drawable.btn_technical_grey);
        layoutVehicleInventoryBinding.btnVehicleVisual.setBackgroundResource(R.drawable.btn_visual_white);
        ConstraintLayout constraintTechVis = layoutVehicleInventoryBinding.constraintTechVis;
        Intrinsics.checkNotNullExpressionValue(constraintTechVis, "constraintTechVis");
        constraintTechVis.setVisibility(0);
        RecyclerView rvVehicleTech = layoutVehicleInventoryBinding.rvVehicleTech;
        Intrinsics.checkNotNullExpressionValue(rvVehicleTech, "rvVehicleTech");
        rvVehicleTech.setVisibility(8);
        RecyclerView rvVehicleVisual = layoutVehicleInventoryBinding.rvVehicleVisual;
        Intrinsics.checkNotNullExpressionValue(rvVehicleVisual, "rvVehicleVisual");
        rvVehicleVisual.setVisibility(0);
        RecyclerView rvVehicleAccessories = layoutVehicleInventoryBinding.rvVehicleAccessories;
        Intrinsics.checkNotNullExpressionValue(rvVehicleAccessories, "rvVehicleAccessories");
        rvVehicleAccessories.setVisibility(8);
        LinearLayout layoutVehicleInfo = layoutVehicleInventoryBinding.layoutVehicleInfo;
        Intrinsics.checkNotNullExpressionValue(layoutVehicleInfo, "layoutVehicleInfo");
        layoutVehicleInfo.setVisibility(8);
        this.isVisualListVisible = true;
        if (this.vehicleVisualList.size() < 12) {
            addItemsVehicleVisList(this.vehicleVisualList);
        }
    }

    private final void addItemsVehicleTechList(List<InventoryItem> list) {
        int slot = ((InventoryItem) CollectionsKt.last((List<? extends Object>) list)).getSlot();
        IntRange intRange = new IntRange(1, 2);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(InventoryItem.copy$default(ConstantsKt.getEmptyInventoryItem(), slot + ((IntIterator) it).nextInt(), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, false, true, 1048574, null));
        }
        list.addAll(arrayList);
        this.vehicleTechnicalList = list;
        this.vehicleTechAdapter.submitList(CollectionsKt.toList(list));
    }

    private final void addItemsVehicleVisList(List<InventoryItem> list) {
        int slot = ((InventoryItem) CollectionsKt.last((List<? extends Object>) list)).getSlot();
        IntRange intRange = new IntRange(1, 2);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(InventoryItem.copy$default(ConstantsKt.getEmptyInventoryItem(), slot + ((IntIterator) it).nextInt(), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, false, true, 1048574, null));
        }
        list.addAll(arrayList);
        this.vehicleVisualList = list;
        this.vehicleVisualAdapter.submitList(CollectionsKt.toList(list));
    }

    private final void guardsTypeClickListeners() {
        this.binding.layoutGuards.btnGuardTypeOne.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.guardsTypeClickListeners$lambda$60(InventoryScreen.this, view);
            }
        });
        this.binding.layoutGuards.btnGuardTypeTwo.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.guardsTypeClickListeners$lambda$61(InventoryScreen.this, view);
            }
        });
        this.binding.layoutGuards.btnGuardTypeThree.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda44
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.guardsTypeClickListeners$lambda$62(InventoryScreen.this, view);
            }
        });
        this.binding.layoutGuards.btnGuardTypeFour.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda54
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.guardsTypeClickListeners$lambda$63(InventoryScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void guardsTypeClickListeners$lambda$60(InventoryScreen inventoryScreen, View view) {
        inventoryScreen.guardNumber = 0;
        Intrinsics.checkNotNull(view);
        inventoryScreen.setItemBackground(view, R.drawable.btn_guard_1_white);
        AppCompatButton btnGuardTypeTwo = inventoryScreen.binding.layoutGuards.btnGuardTypeTwo;
        Intrinsics.checkNotNullExpressionValue(btnGuardTypeTwo, "btnGuardTypeTwo");
        inventoryScreen.setItemBackground(btnGuardTypeTwo, R.drawable.btn_guard_2_grey);
        AppCompatButton btnGuardTypeThree = inventoryScreen.binding.layoutGuards.btnGuardTypeThree;
        Intrinsics.checkNotNullExpressionValue(btnGuardTypeThree, "btnGuardTypeThree");
        inventoryScreen.setItemBackground(btnGuardTypeThree, R.drawable.btn_guard_3_grey);
        AppCompatButton btnGuardTypeFour = inventoryScreen.binding.layoutGuards.btnGuardTypeFour;
        Intrinsics.checkNotNullExpressionValue(btnGuardTypeFour, "btnGuardTypeFour");
        inventoryScreen.setItemBackground(btnGuardTypeFour, R.drawable.btn_guard_4_grey);
        inventoryScreen.guardInfoSetUi(inventoryScreen.guardInfoList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void guardsTypeClickListeners$lambda$61(InventoryScreen inventoryScreen, View view) {
        inventoryScreen.guardNumber = 1;
        Intrinsics.checkNotNull(view);
        inventoryScreen.setItemBackground(view, R.drawable.btn_guard_2_white);
        AppCompatButton btnGuardTypeOne = inventoryScreen.binding.layoutGuards.btnGuardTypeOne;
        Intrinsics.checkNotNullExpressionValue(btnGuardTypeOne, "btnGuardTypeOne");
        inventoryScreen.setItemBackground(btnGuardTypeOne, R.drawable.btn_guard_1_grey);
        AppCompatButton btnGuardTypeThree = inventoryScreen.binding.layoutGuards.btnGuardTypeThree;
        Intrinsics.checkNotNullExpressionValue(btnGuardTypeThree, "btnGuardTypeThree");
        inventoryScreen.setItemBackground(btnGuardTypeThree, R.drawable.btn_guard_3_grey);
        AppCompatButton btnGuardTypeFour = inventoryScreen.binding.layoutGuards.btnGuardTypeFour;
        Intrinsics.checkNotNullExpressionValue(btnGuardTypeFour, "btnGuardTypeFour");
        inventoryScreen.setItemBackground(btnGuardTypeFour, R.drawable.btn_guard_4_grey);
        inventoryScreen.guardInfoSetUi(inventoryScreen.guardInfoList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void guardsTypeClickListeners$lambda$62(InventoryScreen inventoryScreen, View view) {
        inventoryScreen.guardNumber = 2;
        Intrinsics.checkNotNull(view);
        inventoryScreen.setItemBackground(view, R.drawable.btn_guard_3_white);
        AppCompatButton btnGuardTypeOne = inventoryScreen.binding.layoutGuards.btnGuardTypeOne;
        Intrinsics.checkNotNullExpressionValue(btnGuardTypeOne, "btnGuardTypeOne");
        inventoryScreen.setItemBackground(btnGuardTypeOne, R.drawable.btn_guard_1_grey);
        AppCompatButton btnGuardTypeTwo = inventoryScreen.binding.layoutGuards.btnGuardTypeTwo;
        Intrinsics.checkNotNullExpressionValue(btnGuardTypeTwo, "btnGuardTypeTwo");
        inventoryScreen.setItemBackground(btnGuardTypeTwo, R.drawable.btn_guard_2_grey);
        AppCompatButton btnGuardTypeFour = inventoryScreen.binding.layoutGuards.btnGuardTypeFour;
        Intrinsics.checkNotNullExpressionValue(btnGuardTypeFour, "btnGuardTypeFour");
        inventoryScreen.setItemBackground(btnGuardTypeFour, R.drawable.btn_guard_4_grey);
        inventoryScreen.guardInfoSetUi(inventoryScreen.guardInfoList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void guardsTypeClickListeners$lambda$63(InventoryScreen inventoryScreen, View view) {
        inventoryScreen.guardNumber = 3;
        Intrinsics.checkNotNull(view);
        inventoryScreen.setItemBackground(view, R.drawable.btn_guard_4_white);
        AppCompatButton btnGuardTypeOne = inventoryScreen.binding.layoutGuards.btnGuardTypeOne;
        Intrinsics.checkNotNullExpressionValue(btnGuardTypeOne, "btnGuardTypeOne");
        inventoryScreen.setItemBackground(btnGuardTypeOne, R.drawable.btn_guard_1_grey);
        AppCompatButton btnGuardTypeTwo = inventoryScreen.binding.layoutGuards.btnGuardTypeTwo;
        Intrinsics.checkNotNullExpressionValue(btnGuardTypeTwo, "btnGuardTypeTwo");
        inventoryScreen.setItemBackground(btnGuardTypeTwo, R.drawable.btn_guard_2_grey);
        AppCompatButton btnGuardTypeThree = inventoryScreen.binding.layoutGuards.btnGuardTypeThree;
        Intrinsics.checkNotNullExpressionValue(btnGuardTypeThree, "btnGuardTypeThree");
        inventoryScreen.setItemBackground(btnGuardTypeThree, R.drawable.btn_guard_3_grey);
        inventoryScreen.guardInfoSetUi(inventoryScreen.guardInfoList);
    }

    private final void openRecyclerView(int i) {
        if (i == RodinaItemTypes.ITEM_TYPE_ATTACH.getId()) {
            RecyclerView rvAccessoriesInventory = this.binding.rvAccessoriesInventory;
            Intrinsics.checkNotNullExpressionValue(rvAccessoriesInventory, "rvAccessoriesInventory");
            if (rvAccessoriesInventory.getVisibility() == 0 || this.isArizonaType) {
                return;
            }
            btnAccessoriesPressed();
            this.isAccessoriesListVisible = true;
        } else if (i == ItemTypes.ITEM_TYPE_ACCESSORIES.getId()) {
            RecyclerView rvAccessoriesInventory2 = this.binding.rvAccessoriesInventory;
            Intrinsics.checkNotNullExpressionValue(rvAccessoriesInventory2, "rvAccessoriesInventory");
            if (rvAccessoriesInventory2.getVisibility() != 0 && this.isArizonaType) {
                btnAccessoriesPressed();
                this.isAccessoriesListVisible = true;
            }
        } else if (i == RodinaItemTypes.ITEM_TYPE_IMPROV_GUN.getId()) {
            RecyclerView rvUpgradesInventory = this.binding.rvUpgradesInventory;
            Intrinsics.checkNotNullExpressionValue(rvUpgradesInventory, "rvUpgradesInventory");
            if (rvUpgradesInventory.getVisibility() == 0 || this.isArizonaType) {
                return;
            }
            btnUpgradesPressed();
            this.isUpgradesListVisible = true;
        } else if (i == ItemTypes.ITEM_TYPE_IMPROV_GUN.getId()) {
            RecyclerView rvUpgradesInventory2 = this.binding.rvUpgradesInventory;
            Intrinsics.checkNotNullExpressionValue(rvUpgradesInventory2, "rvUpgradesInventory");
            if (rvUpgradesInventory2.getVisibility() != 0 && this.isArizonaType) {
                btnUpgradesPressed();
                this.isUpgradesListVisible = true;
            }
        }
    }

    private final void setItemBackground(View view, int i) {
        view.setBackgroundResource(i);
    }

    private final void setVisibilityBtnGuards() {
        if (this.guardInfoList.get(0).getSkin() == null) {
            this.binding.layoutGuards.btnGuardTypeOne.setEnabled(false);
            this.binding.layoutGuards.btnGuardTypeOne.setBackgroundResource(R.drawable.btn_guard_1_disabled);
        } else {
            this.binding.layoutGuards.btnGuardTypeOne.setEnabled(true);
        }
        if (this.guardInfoList.get(1).getSkin() == null) {
            this.binding.layoutGuards.btnGuardTypeTwo.setEnabled(false);
            this.binding.layoutGuards.btnGuardTypeTwo.setBackgroundResource(R.drawable.btn_guard_2_disabled);
        } else {
            this.binding.layoutGuards.btnGuardTypeTwo.setEnabled(true);
        }
        if (this.guardInfoList.get(2).getSkin() == null) {
            this.binding.layoutGuards.btnGuardTypeThree.setEnabled(false);
            this.binding.layoutGuards.btnGuardTypeThree.setBackgroundResource(R.drawable.btn_guard_3_disabled);
        } else {
            this.binding.layoutGuards.btnGuardTypeThree.setEnabled(true);
        }
        if (this.guardInfoList.get(3).getSkin() == null) {
            this.binding.layoutGuards.btnGuardTypeFour.setEnabled(false);
            this.binding.layoutGuards.btnGuardTypeFour.setBackgroundResource(R.drawable.btn_guard_4_disabled);
            return;
        }
        this.binding.layoutGuards.btnGuardTypeFour.setEnabled(true);
    }

    private final void defaultGuardScreen() {
        this.binding.tvInventory.setText("ИНВЕНТАРЬ");
        Group groupCharacterInfo = this.binding.groupCharacterInfo;
        Intrinsics.checkNotNullExpressionValue(groupCharacterInfo, "groupCharacterInfo");
        groupCharacterInfo.setVisibility(0);
        RecyclerView rvCategoryMenu = this.binding.rvCategoryMenu;
        Intrinsics.checkNotNullExpressionValue(rvCategoryMenu, "rvCategoryMenu");
        rvCategoryMenu.setVisibility(0);
        editMainUi(R.id.guidelineVer1, 0, R.id.rvMainInventory);
        ConstraintLayout parentLayout = this.binding.layoutGuards.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
        parentLayout.setVisibility(0);
        RecyclerView rvGuardInventory = this.binding.rvGuardInventory;
        Intrinsics.checkNotNullExpressionValue(rvGuardInventory, "rvGuardInventory");
        rvGuardInventory.setVisibility(8);
    }

    private final void editMainUi(int i, int i2, int i3) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.binding.parentLayout);
        constraintSet.connect(i3, 6, i, 6, i2);
        constraintSet.applyTo(this.binding.parentLayout);
    }

    private final void guardInfoSetUi(List<GuardInfo> list) {
        String str;
        observeGuardAccessories();
        this.binding.layoutGuards.tvGuardName.setText(list.get(this.guardNumber).getName());
        this.binding.layoutGuards.tvGuardType.setText(list.get(this.guardNumber).getQuality());
        this.binding.layoutGuards.tvGuardLevel.setText(list.get(this.guardNumber).getLevel() + " уровень");
        this.binding.layoutGuards.tvGuardExpPoints.setText(list.get(this.guardNumber).getExp() + RemoteSettings.FORWARD_SLASH_STRING + list.get(this.guardNumber).getMaxExp());
        this.binding.layoutGuards.tvGuardHealthCount.setText(String.valueOf(list.get(this.guardNumber).getHealth()));
        this.binding.layoutGuards.tvGuardShieldCount.setText(String.valueOf(list.get(this.guardNumber).getDefence()));
        this.binding.layoutGuards.tvGuardDamageCount.setText(String.valueOf(list.get(this.guardNumber).getDamage()));
        AppCompatTextView tvGuardStatus = this.binding.layoutGuards.tvGuardStatus;
        Intrinsics.checkNotNullExpressionValue(tvGuardStatus, "tvGuardStatus");
        AppCompatTextView appCompatTextView = tvGuardStatus;
        Integer died = list.get(this.guardNumber).getDied();
        appCompatTextView.setVisibility(died == null || died.intValue() != 0 ? 0 : 8);
        Integer skinBackground = list.get(this.guardNumber).getSkinBackground();
        if (skinBackground != null) {
            this.binding.layoutGuards.layoutGuardInfo.setCardBackgroundColor(UtilsKt.getColorTint(skinBackground.intValue()));
        }
        RecyclerView rvGuardInventory = this.binding.rvGuardInventory;
        Intrinsics.checkNotNullExpressionValue(rvGuardInventory, "rvGuardInventory");
        rvGuardInventory.setVisibility(8);
        if (this.isArizonaType) {
            str = FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/arizona-rp/assets/images/inventory/skins/512/" + list.get(this.guardNumber).getSkin() + ".webp";
        } else {
            str = FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/rodina-rp/assets/images/inventory/skins/512/" + list.get(this.guardNumber).getSkin() + ".webp";
        }
        String str2 = str;
        AppCompatImageView ivGuardSkin = this.binding.layoutGuards.ivGuardSkin;
        Intrinsics.checkNotNullExpressionValue(ivGuardSkin, "ivGuardSkin");
        observeUserSkin$default(this, ivGuardSkin, str2, 0, 4, null);
        IBackendNotifier iBackendNotifier = this.frontendNotifier;
        int id = UIElementID.INVENTORY_SECURITY_SCREEN.getId();
        byte[] bytes = StringKt.toStringJson(new SendId(this.guardInfoList.get(this.guardNumber).getId())).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, 6, bytes);
        setVisibilityBtnGuards();
    }

    private final void observeGuardAccessories() {
        Integer spawned = this.guardInfoList.get(this.guardNumber).getSpawned();
        if (spawned != null && spawned.intValue() == 0) {
            List<InventoryItem> accessoriesList = this.guardInfoList.get(this.guardNumber).getAccessoriesList();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(accessoriesList, 10));
            for (InventoryItem inventoryItem : accessoriesList) {
                arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, null, null, 1, null, null, null, null, 0, null, null, false, false, 2095103, null));
            }
            this.guardSubInventoryAdapter.submitList(CollectionsKt.toList(arrayList));
        } else {
            this.guardSubInventoryAdapter.submitList(CollectionsKt.toList(this.guardInfoList.get(this.guardNumber).getAccessoriesList()));
        }
        this.guardInventoryAdapter.submitList(CollectionsKt.toList(this.guardInfoList.get(this.guardNumber).getInventoryList()));
    }

    private final void btnAccessoriesPressed() {
        this.currentBackendId = UIElementID.INVENTORY.getId();
        this.binding.btnAccessories.setBackgroundResource(R.drawable.ic_btn_accessories_white);
        this.binding.btnUpgrades.setBackgroundResource(R.drawable.ic_btn_upgrades);
        this.binding.btnWallet.setBackgroundResource(R.drawable.ic_btn_wallet_grey);
        RecyclerView rvWalletInventory = this.binding.rvWalletInventory;
        Intrinsics.checkNotNullExpressionValue(rvWalletInventory, "rvWalletInventory");
        rvWalletInventory.setVisibility(8);
        RecyclerView rvSubInventory = this.binding.rvSubInventory;
        Intrinsics.checkNotNullExpressionValue(rvSubInventory, "rvSubInventory");
        rvSubInventory.setVisibility(0);
        RecyclerView rvAccessoriesInventory = this.binding.rvAccessoriesInventory;
        Intrinsics.checkNotNullExpressionValue(rvAccessoriesInventory, "rvAccessoriesInventory");
        rvAccessoriesInventory.setVisibility(0);
        RecyclerView rvUpgradesInventory = this.binding.rvUpgradesInventory;
        Intrinsics.checkNotNullExpressionValue(rvUpgradesInventory, "rvUpgradesInventory");
        rvUpgradesInventory.setVisibility(8);
        this.accessoriesInventoryAdapter.submitList(CollectionsKt.toList(this.subAccessoriesList));
        this.binding.rvAccessoriesInventory.scheduleLayoutAnimation();
    }

    private final void btnUpgradesPressed() {
        this.currentBackendId = UIElementID.INVENTORY.getId();
        this.binding.btnUpgrades.setBackgroundResource(R.drawable.ic_btn_upgrades_white);
        this.binding.btnAccessories.setBackgroundResource(R.drawable.ic_btn_accessories_red);
        this.binding.btnWallet.setBackgroundResource(R.drawable.ic_btn_wallet_grey);
        RecyclerView rvSubInventory = this.binding.rvSubInventory;
        Intrinsics.checkNotNullExpressionValue(rvSubInventory, "rvSubInventory");
        rvSubInventory.setVisibility(0);
        RecyclerView rvWalletInventory = this.binding.rvWalletInventory;
        Intrinsics.checkNotNullExpressionValue(rvWalletInventory, "rvWalletInventory");
        rvWalletInventory.setVisibility(8);
        RecyclerView rvUpgradesInventory = this.binding.rvUpgradesInventory;
        Intrinsics.checkNotNullExpressionValue(rvUpgradesInventory, "rvUpgradesInventory");
        rvUpgradesInventory.setVisibility(0);
        RecyclerView rvAccessoriesInventory = this.binding.rvAccessoriesInventory;
        Intrinsics.checkNotNullExpressionValue(rvAccessoriesInventory, "rvAccessoriesInventory");
        rvAccessoriesInventory.setVisibility(8);
        this.upgradesInventoryAdapter.submitList(CollectionsKt.toList(this.subUpgradesList));
        this.binding.rvUpgradesInventory.scheduleLayoutAnimation();
    }

    private final void btnWalletPressed() {
        this.binding.btnWallet.setBackgroundResource(R.drawable.ic_btn_wallet_white);
        this.binding.btnUpgrades.setBackgroundResource(R.drawable.ic_btn_upgrades);
        this.binding.btnAccessories.setBackgroundResource(R.drawable.ic_btn_accessories_red);
        this.binding.rvSubInventory.setVisibility(4);
        RecyclerView rvUpgradesInventory = this.binding.rvUpgradesInventory;
        Intrinsics.checkNotNullExpressionValue(rvUpgradesInventory, "rvUpgradesInventory");
        rvUpgradesInventory.setVisibility(8);
        RecyclerView rvAccessoriesInventory = this.binding.rvAccessoriesInventory;
        Intrinsics.checkNotNullExpressionValue(rvAccessoriesInventory, "rvAccessoriesInventory");
        rvAccessoriesInventory.setVisibility(8);
        RecyclerView rvWalletInventory = this.binding.rvWalletInventory;
        Intrinsics.checkNotNullExpressionValue(rvWalletInventory, "rvWalletInventory");
        rvWalletInventory.setVisibility(0);
        this.walletInventoryAdapter.submitList(this.walletInventoryList);
        this.binding.rvWalletInventory.scheduleLayoutAnimation();
        this.currentBackendId = UIElementID.INVENTORY_WALLET_SCREEN.getId();
    }

    private final void initObservers() {
        this.mainInventoryAdapter.submitList(CollectionsKt.toList(this.mainInventoryList));
        this.subInventoryAdapter.submitList(CollectionsKt.toList(this.subCaseArmorSkinList));
    }

    private final void refreshItemVisibility() {
        List<InventoryItem> list = this.mainInventoryList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (InventoryItem inventoryItem : list) {
            arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, 1, null, 0, null, null, null, null, 0, null, null, false, false, 2094591, null));
        }
        List<InventoryItem> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        this.mainInventoryList = mutableList;
        this.mainInventoryAdapter.submitList(CollectionsKt.toList(mutableList));
        List<InventoryItem> list2 = this.subCaseArmorSkinList;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (InventoryItem inventoryItem2 : list2) {
            arrayList2.add(InventoryItem.copy$default(inventoryItem2, 0, null, 0, null, null, null, null, null, null, 1, null, 0, null, null, null, null, 0, null, null, false, false, 2094591, null));
        }
        List<InventoryItem> mutableList2 = CollectionsKt.toMutableList((Collection) arrayList2);
        this.subCaseArmorSkinList = mutableList2;
        this.subInventoryAdapter.submitList(CollectionsKt.toList(mutableList2));
        List<InventoryItem> list3 = this.subAccessoriesList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        for (InventoryItem inventoryItem3 : list3) {
            arrayList3.add(InventoryItem.copy$default(inventoryItem3, 0, null, 0, null, null, null, null, null, null, 1, null, 0, null, null, null, null, 0, null, null, false, false, 2094591, null));
        }
        List<InventoryItem> mutableList3 = CollectionsKt.toMutableList((Collection) arrayList3);
        this.subAccessoriesList = mutableList3;
        this.accessoriesInventoryAdapter.submitList(CollectionsKt.toList(mutableList3));
        this.accessoriesInventoryAdapter.notifyDataSetChanged();
        List<InventoryItem> list4 = this.subUpgradesList;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
        for (InventoryItem inventoryItem4 : list4) {
            arrayList4.add(InventoryItem.copy$default(inventoryItem4, 0, null, 0, null, null, null, null, null, null, 1, null, 0, null, null, null, null, 0, null, null, false, false, 2094591, null));
        }
        List<InventoryItem> mutableList4 = CollectionsKt.toMutableList((Collection) arrayList4);
        this.subUpgradesList = mutableList4;
        this.upgradesInventoryAdapter.submitList(CollectionsKt.toList(mutableList4));
        List<InventoryItem> list5 = this.walletInventoryList;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
        for (InventoryItem inventoryItem5 : list5) {
            arrayList5.add(InventoryItem.copy$default(inventoryItem5, 0, null, 0, null, null, null, null, null, null, 1, null, 0, null, null, null, null, 0, null, null, false, false, 2094591, null));
        }
        List<InventoryItem> mutableList5 = CollectionsKt.toMutableList((Collection) arrayList5);
        this.walletInventoryList = mutableList5;
        this.walletInventoryAdapter.submitList(CollectionsKt.toList(mutableList5));
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        ArrayList arrayList;
        int id;
        int id2;
        int id3;
        int id4;
        Object obj;
        int id5;
        int id6;
        int id7;
        int id8;
        int id9;
        List<InventoryItem> items;
        List<InventoryItem> items2;
        List<InventoryItem> items3;
        List<InventoryItem> items4;
        List<InventoryItem> items5;
        List<InventoryItem> items6;
        List<InventoryItem> items7;
        List<InventoryItem> items8;
        Object obj2;
        List<InventoryItem> items9;
        Object obj3;
        Object obj4;
        List<InventoryItem> items10;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        int id10;
        int id11;
        int id12;
        int id13;
        int id14;
        int id15;
        int id16;
        int id17;
        Intrinsics.checkNotNullParameter(data, "data");
        Log.d("TAG_INVENTORY", "subID: " + i + " ===== data: " + data);
        boolean z = true;
        try {
            if (i == 0) {
                Object fromJson = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) InventoryResponse.class);
                Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
                InventoryResponse inventoryResponse = (InventoryResponse) fromJson;
                int type = inventoryResponse.getType();
                if (type == ArizonaBlockType.BLOCK_TYPE_MENU.getId()) {
                    if (inventoryResponse.getItems().get(0).getSlot() == 0) {
                        this.mainInventoryList.clear();
                        new Handler().postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                InventoryScreen.onBackendMessage$lambda$72(InventoryScreen.this);
                            }
                        }, 1000L);
                    }
                    CollectionsKt.removeAll((List) this.mainInventoryList, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj9) {
                            boolean onBackendMessage$lambda$73;
                            onBackendMessage$lambda$73 = InventoryScreen.onBackendMessage$lambda$73((InventoryItem) obj9);
                            return Boolean.valueOf(onBackendMessage$lambda$73);
                        }
                    });
                    CollectionsKt.addAll(this.mainInventoryList, editResponseInfo(inventoryResponse));
                } else if (type == ArizonaBlockType.BLOCK_TYPE_ATTACH.getId()) {
                    if (inventoryResponse.getItems().get(0).getSlot() == 0) {
                        this.subAccessoriesList.clear();
                        this.subCaseArmorSkinList.clear();
                    }
                    this.subAccessoriesList = CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse));
                } else {
                    if (!this.isArizonaType) {
                        id10 = RodinaBlockType.BLOCK_TYPE_IMPROV_GUN.getId();
                    } else {
                        id10 = ArizonaBlockType.BLOCK_TYPE_GUN.getId();
                    }
                    if (type == id10) {
                        if (inventoryResponse.getItems().get(0).getSlot() == 0) {
                            this.subUpgradesList.clear();
                        }
                        this.subUpgradesList = CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse));
                    } else {
                        if (!this.isArizonaType) {
                            id11 = RodinaBlockType.BLOCK_TYPE_IMPROV.getId();
                        } else {
                            id11 = ArizonaBlockType.BLOCK_TYPE_IMPROV.getId();
                        }
                        if (type == id11) {
                            if (this.isArizonaType) {
                                CollectionsKt.addAll(this.subCaseArmorSkinList, editResponseInfo(inventoryResponse));
                                if (this.subCaseArmorSkinList.size() >= 3) {
                                    List<InventoryItem> list = this.subCaseArmorSkinList;
                                    list.set(0, list.get(1));
                                    this.subCaseArmorSkinList.set(1, this.subCaseArmorSkinList.get(0));
                                }
                            } else {
                                CollectionsKt.addAll(this.subCaseArmorSkinList, editResponseInfo(inventoryResponse));
                            }
                        } else {
                            if (!this.isArizonaType) {
                                id12 = RodinaBlockType.BLOCK_TYPE_SKIN.getId();
                            } else {
                                id12 = ArizonaBlockType.BLOCK_TYPE_SKIN.getId();
                            }
                            if (type == id12) {
                                List<InventoryItem> items11 = inventoryResponse.getItems();
                                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(items11, 10));
                                for (InventoryItem inventoryItem : items11) {
                                    this.currentSkin = inventoryItem;
                                    arrayList2.add(Unit.INSTANCE);
                                }
                                ArrayList arrayList3 = arrayList2;
                                InventoryItem inventoryItem2 = this.currentModSkin;
                                if ((inventoryItem2 != null ? inventoryItem2.getItem() : null) == null) {
                                    CollectionsKt.addAll(this.subCaseArmorSkinList, editResponseInfo(inventoryResponse));
                                    if (this.subCaseArmorSkinList.size() >= 3) {
                                        List<InventoryItem> list2 = this.subCaseArmorSkinList;
                                        list2.set(1, list2.get(2));
                                        this.subCaseArmorSkinList.set(2, this.subCaseArmorSkinList.get(1));
                                    }
                                }
                            } else if (type == ArizonaBlockType.BLOCK_TYPE_MOD_SKIN.getId()) {
                                List<InventoryItem> items12 = inventoryResponse.getItems();
                                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(items12, 10));
                                for (InventoryItem inventoryItem3 : items12) {
                                    this.currentModSkin = inventoryItem3;
                                    arrayList4.add(Unit.INSTANCE);
                                }
                                ArrayList arrayList5 = arrayList4;
                                InventoryItem inventoryItem4 = this.currentModSkin;
                                if ((inventoryItem4 != null ? inventoryItem4.getItem() : null) != null) {
                                    CollectionsKt.addAll(this.subCaseArmorSkinList, editResponseInfo(inventoryResponse));
                                    if (this.subCaseArmorSkinList.size() >= 3) {
                                        List<InventoryItem> list3 = this.subCaseArmorSkinList;
                                        list3.set(1, list3.get(2));
                                        this.subCaseArmorSkinList.set(2, this.subCaseArmorSkinList.get(1));
                                    }
                                }
                            } else {
                                if (!this.isArizonaType) {
                                    id13 = RodinaBlockType.BLOCK_TYPE_WALLET.getId();
                                } else {
                                    id13 = ArizonaBlockType.BLOCK_TYPE_WALLET.getId();
                                }
                                if (type != id13 && type != ArizonaBlockType.BLOCK_TYPE_FISHBAG.getId()) {
                                    if (type == ArizonaBlockType.BLOCK_TYPE_ACTOR_ATTACH.getId()) {
                                        this.guardAccessoriesList.addAll(editResponseInfo(inventoryResponse));
                                    } else {
                                        if (!this.isArizonaType) {
                                            id14 = RodinaBlockType.BLOCK_TYPE_ACTOR_INVENTORY.getId();
                                        } else {
                                            id14 = ArizonaBlockType.BLOCK_TYPE_ACTOR_INVENTORY.getId();
                                        }
                                        if (type == id14) {
                                            this.guardInventoryList.addAll(editResponseInfo(inventoryResponse));
                                        } else {
                                            if (!this.isArizonaType) {
                                                id15 = RodinaBlockType.BLOCK_TYPE_ACTOR_WEAPON.getId();
                                            } else {
                                                id15 = ArizonaBlockType.BLOCK_TYPE_ACTOR_WEAPON.getId();
                                            }
                                            if (type == id15) {
                                                this.guardWeaponList.clear();
                                                this.guardWeaponList = CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse));
                                            } else {
                                                if (type != ArizonaBlockType.BLOCK_TYPE_VEH_SKIN.getId() && type != ArizonaBlockType.BLOCK_TYPE_VEH_MODIFICATION.getId() && type != ArizonaBlockType.BLOCK_TYPE_VEH_NUMBER.getId()) {
                                                    if (type == RodinaBlockType.BLOCK_TYPE_VEH_SKIN.getId()) {
                                                        if (!this.isArizonaType) {
                                                            this.vehicleSubList.clear();
                                                            CollectionsKt.addAll(this.vehicleSubList, CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse)));
                                                        }
                                                    } else {
                                                        if (!this.isArizonaType) {
                                                            id16 = RodinaBlockType.BLOCK_TYPE_TECH_TUNING.getId();
                                                        } else {
                                                            id16 = ArizonaBlockType.BLOCK_TYPE_TECH_TUNING.getId();
                                                        }
                                                        if (type == id16) {
                                                            if (inventoryResponse.getItems().get(0).getSlot() == 0) {
                                                                this.vehicleTechnicalList.clear();
                                                            }
                                                            this.vehicleTechnicalList = CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse));
                                                        } else {
                                                            if (!this.isArizonaType) {
                                                                id17 = RodinaBlockType.BLOCK_TYPE_VISUAL_TUNING.getId();
                                                            } else {
                                                                id17 = ArizonaBlockType.BLOCK_TYPE_VISUAL_TUNING.getId();
                                                            }
                                                            if (type == id17) {
                                                                if (inventoryResponse.getItems().get(0).getSlot() == 0) {
                                                                    this.vehicleVisualList.clear();
                                                                }
                                                                this.vehicleVisualList = CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse));
                                                            }
                                                        }
                                                    }
                                                }
                                                if (inventoryResponse.getType() == ArizonaBlockType.BLOCK_TYPE_VEH_SKIN.getId()) {
                                                    this.vehicleSubList.clear();
                                                }
                                                CollectionsKt.addAll(this.vehicleSubList, CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse)));
                                            }
                                        }
                                    }
                                }
                                Log.e("wallet", "onBackendMessage:");
                                if (this.isWalletListVisible) {
                                    this.walletInventoryList = CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse));
                                    btnWalletPressed();
                                }
                                if (!this.isArizonaType) {
                                    this.walletInventoryList = CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse));
                                }
                            }
                        }
                    }
                }
                if (this.isArizonaType && ConstantsKt.getArizonaWarehouseIds().contains(Integer.valueOf(inventoryResponse.getType()))) {
                    if (inventoryResponse.getItems().get(0).getSlot() == 0) {
                        this.warehouseList.clear();
                    }
                    CollectionsKt.addAll(this.warehouseList, CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse)));
                    this.currentBackendId = UIElementID.INVENTORY_WAREHOUSE.getId();
                    this.currentWarehouse = inventoryResponse.getType();
                    showWarehouseScreen();
                } else if (!this.isArizonaType && ConstantsKt.getRodinaWarehouseIds().contains(Integer.valueOf(inventoryResponse.getType()))) {
                    if (inventoryResponse.getItems().get(0).getSlot() == 0) {
                        this.warehouseList.clear();
                    }
                    CollectionsKt.addAll(this.warehouseList, CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse)));
                    this.currentBackendId = UIElementID.INVENTORY_WAREHOUSE.getId();
                    this.currentWarehouse = inventoryResponse.getType();
                    showWarehouseScreen();
                }
            } else if (i == 1) {
                if (StringsKt.startsWith$default(data, "{\"skin\"", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) data, (CharSequence) "oil", false, 2, (Object) null)) {
                    this.inventoryMenuAdapter.resetSelectItemPosition();
                    if (!this.clickedMenuButtons) {
                        refreshItemVisibility();
                    }
                    ProgressBar progressBar = this.binding.progressBar;
                    Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
                    progressBar.setVisibility(0);
                    Object fromJson2 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) Skin.class);
                    Intrinsics.checkNotNullExpressionValue(fromJson2, "fromJson(...)");
                    Skin skin = (Skin) fromJson2;
                    this.vehicleVisibilityState = skin.getVehicle();
                    if (this.isArizonaType) {
                        getAndShowMenuButtonsArz(skin.getButtons());
                    } else {
                        getAndShowMenuButtonsRod(skin.getButtons());
                    }
                    addTopBars(skin);
                    this.currentWarehouse = skin.getWarehouseType();
                    addLockedItems();
                    setVisible(true);
                } else if (!StringsKt.startsWith$default(data, "{\"securities\"", false, 2, (Object) null)) {
                    if (!StringsKt.startsWith$default(data, "{\"skin\"", false, 2, (Object) null) || !StringsKt.contains$default((CharSequence) data, (CharSequence) "oil", false, 2, (Object) null)) {
                        if (StringsKt.contains$default((CharSequence) data, (CharSequence) "\"money\"", false, 2, (Object) null)) {
                            Object fromJson3 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) WarehouseMoney.class);
                            Intrinsics.checkNotNullExpressionValue(fromJson3, "fromJson(...)");
                            WarehouseMoney warehouseMoney = (WarehouseMoney) fromJson3;
                            TextView etStoreMoney = this.binding.layoutWarehouse.etStoreMoney;
                            Intrinsics.checkNotNullExpressionValue(etStoreMoney, "etStoreMoney");
                            TextView textView = etStoreMoney;
                            if (warehouseMoney.getMoney() == -1) {
                                z = false;
                            }
                            if (!z) {
                                r12 = 8;
                            }
                            textView.setVisibility(r12);
                            this.binding.layoutWarehouse.etStoreMoney.setText(String.valueOf(warehouseMoney.getMoney()));
                            if (this.isArizonaType) {
                                TextView etStoreMoney2 = this.binding.layoutWarehouse.etStoreMoney;
                                Intrinsics.checkNotNullExpressionValue(etStoreMoney2, "etStoreMoney");
                                UtilsKt.setDrawableEnd(etStoreMoney2, R.drawable.ic_dollar_16, getTargetActivity());
                                return;
                            }
                            TextView etStoreMoney3 = this.binding.layoutWarehouse.etStoreMoney;
                            Intrinsics.checkNotNullExpressionValue(etStoreMoney3, "etStoreMoney");
                            UtilsKt.setDrawableEnd(etStoreMoney3, R.drawable.ic_rubble, getTargetActivity());
                            return;
                        }
                        return;
                    }
                    Object fromJson4 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) VehicleInfoBars.class);
                    Intrinsics.checkNotNullExpressionValue(fromJson4, "fromJson(...)");
                    VehicleInfoBars vehicleInfoBars = (VehicleInfoBars) fromJson4;
                    this.vehicleVisibilityState = 1;
                    if (this.isArizonaType) {
                        getAndShowMenuButtonsArz(vehicleInfoBars.getButtons());
                    } else {
                        getAndShowMenuButtonsRod(vehicleInfoBars.getButtons());
                    }
                    addVehicleInfo(vehicleInfoBars);
                    showVehicleScreen();
                } else {
                    Object fromJson5 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) GuardInfoResponse.class);
                    Intrinsics.checkNotNullExpressionValue(fromJson5, "fromJson(...)");
                    showGuardScreen();
                    List<GuardInfo> mutableList = CollectionsKt.toMutableList((Collection) ((GuardInfoResponse) fromJson5).getSecurities());
                    this.guardInfoList = mutableList;
                    List<GuardInfo> list4 = mutableList;
                    ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                    for (GuardInfo guardInfo : list4) {
                        ArrayList arrayList7 = new ArrayList();
                        for (Object obj9 : this.guardAccessoriesList) {
                            int id18 = ((InventoryItem) obj9).getId();
                            Integer id19 = guardInfo.getId();
                            if (id19 != null && id18 == id19.intValue()) {
                                arrayList7.add(obj9);
                            }
                        }
                        List mutableList2 = CollectionsKt.toMutableList((Collection) arrayList7);
                        ArrayList arrayList8 = new ArrayList();
                        for (Object obj10 : this.guardInventoryList) {
                            int id20 = ((InventoryItem) obj10).getId();
                            Integer id21 = guardInfo.getId();
                            if (id21 != null && id20 == id21.intValue()) {
                                arrayList8.add(obj10);
                            }
                        }
                        ArrayList arrayList9 = arrayList8;
                        Iterator<T> it = this.guardWeaponList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj8 = null;
                                break;
                            }
                            obj8 = it.next();
                            int id22 = ((InventoryItem) obj8).getId();
                            Integer id23 = guardInfo.getId();
                            if (id23 != null && id22 == id23.intValue()) {
                                break;
                            }
                        }
                        InventoryItem inventoryItem5 = (InventoryItem) obj8;
                        if (inventoryItem5 != null) {
                            mutableList2.add(inventoryItem5);
                        }
                        arrayList6.add(GuardInfo.copy$default(guardInfo, null, null, null, null, null, null, null, null, null, null, null, null, null, null, inventoryItem5, mutableList2, CollectionsKt.toMutableList((Collection) arrayList9), 16383, null));
                    }
                    List<GuardInfo> mutableList3 = CollectionsKt.toMutableList((Collection) arrayList6);
                    this.guardInfoList = mutableList3;
                    guardInfoSetUi(mutableList3);
                }
            } else if (i == 2) {
                Object fromJson6 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) InventoryEditResponse.class);
                Intrinsics.checkNotNullExpressionValue(fromJson6, "fromJson(...)");
                InventoryEditResponse inventoryEditResponse = (InventoryEditResponse) fromJson6;
                int type2 = inventoryEditResponse.getType();
                List<InventoryItem> items13 = inventoryEditResponse.getItems();
                if (items13 != null) {
                    List<InventoryItem> list5 = items13;
                    ArrayList arrayList10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
                    for (InventoryItem inventoryItem6 : list5) {
                        int type3 = inventoryEditResponse.getType();
                        Iterator<T> it2 = UtilsKt.getItemsName().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj6 = null;
                                break;
                            }
                            obj6 = it2.next();
                            int id24 = ((ItemsInfo) obj6).getId();
                            Integer item = inventoryItem6.getItem();
                            if (item != null && id24 == item.intValue()) {
                                break;
                            }
                        }
                        ItemsInfo itemsInfo = (ItemsInfo) obj6;
                        Integer valueOf = itemsInfo != null ? Integer.valueOf(itemsInfo.getType()) : null;
                        Iterator<T> it3 = UtilsKt.getItemsName().iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                obj7 = null;
                                break;
                            }
                            obj7 = it3.next();
                            int id25 = ((ItemsInfo) obj7).getId();
                            Integer item2 = inventoryItem6.getItem();
                            if (item2 != null && id25 == item2.intValue()) {
                                break;
                            }
                        }
                        ItemsInfo itemsInfo2 = (ItemsInfo) obj7;
                        arrayList10.add(InventoryItem.copy$default(inventoryItem6, 0, null, 0, null, valueOf, null, null, null, null, null, null, null, null, null, null, null, type3, itemsInfo2 != null ? Integer.valueOf(itemsInfo2.getAcs_slot()) : null, null, false, false, 1900527, null));
                    }
                    arrayList = arrayList10;
                } else {
                    arrayList = null;
                }
                InventoryEditResponse inventoryEditResponse2 = new InventoryEditResponse(type2, arrayList, inventoryEditResponse.getMoney());
                int type4 = inventoryEditResponse2.getType();
                if (type4 == ArizonaBlockType.BLOCK_TYPE_MENU.getId()) {
                    ArrayList<Number> arrayList11 = new ArrayList();
                    List<InventoryItem> items14 = inventoryEditResponse2.getItems();
                    if (items14 != null) {
                        for (InventoryItem inventoryItem7 : items14) {
                            if (inventoryItem7.getSlot() < this.mainInventoryList.size() && !this.mainInventoryList.isEmpty()) {
                                Iterator<InventoryItem> it4 = this.mainInventoryList.iterator();
                                int i2 = 0;
                                while (true) {
                                    if (!it4.hasNext()) {
                                        i2 = -1;
                                        break;
                                    } else if (it4.next().getSlot() == inventoryItem7.getSlot()) {
                                        break;
                                    } else {
                                        i2++;
                                    }
                                }
                                Iterator<T> it5 = this.mainInventoryList.iterator();
                                while (true) {
                                    if (!it5.hasNext()) {
                                        obj5 = null;
                                        break;
                                    }
                                    obj5 = it5.next();
                                    if (((InventoryItem) obj5).getSlot() == inventoryItem7.getSlot()) {
                                        break;
                                    }
                                }
                                InventoryItem updateInventoryItem = UtilsKt.updateInventoryItem((InventoryItem) obj5, inventoryItem7);
                                if (i2 >= 0) {
                                    arrayList11.add(Integer.valueOf(i2));
                                    if (inventoryItem7.getItem() != null) {
                                        List<InventoryItem> list6 = this.mainInventoryList;
                                        if (updateInventoryItem == null) {
                                            updateInventoryItem = ConstantsKt.getEmptyInventoryItem();
                                        }
                                        list6.set(i2, updateInventoryItem);
                                    } else {
                                        this.mainInventoryList.set(i2, inventoryItem7);
                                    }
                                }
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    this.mainInventoryAdapter.submitList(CollectionsKt.toList(this.mainInventoryList));
                    for (Number number : arrayList11) {
                        this.mainInventoryAdapter.notifyItemChanged(number.intValue());
                    }
                    List<InventoryItem> items15 = inventoryEditResponse2.getItems();
                    updateInfoToDatabase(items15 != null ? items15.get(0) : null);
                } else if (type4 == ArizonaBlockType.BLOCK_TYPE_ATTACH.getId()) {
                    if (!this.subAccessoriesList.isEmpty()) {
                        ArrayList<Number> arrayList12 = new ArrayList();
                        List<InventoryItem> items16 = inventoryEditResponse2.getItems();
                        if (items16 != null) {
                            for (InventoryItem inventoryItem8 : items16) {
                                Iterator<InventoryItem> it6 = this.subAccessoriesList.iterator();
                                int i3 = 0;
                                while (true) {
                                    if (!it6.hasNext()) {
                                        i3 = -1;
                                        break;
                                    } else if (it6.next().getSlot() == inventoryItem8.getSlot()) {
                                        break;
                                    } else {
                                        i3++;
                                    }
                                }
                                Iterator<T> it7 = this.subAccessoriesList.iterator();
                                while (true) {
                                    if (!it7.hasNext()) {
                                        obj4 = null;
                                        break;
                                    }
                                    obj4 = it7.next();
                                    if (((InventoryItem) obj4).getSlot() == inventoryItem8.getSlot()) {
                                        break;
                                    }
                                }
                                InventoryItem updateInventoryItem2 = UtilsKt.updateInventoryItem((InventoryItem) obj4, inventoryItem8);
                                if (i3 >= 0) {
                                    arrayList12.add(Integer.valueOf(i3));
                                    if (inventoryItem8.getItem() != null) {
                                        List<InventoryItem> list7 = this.subAccessoriesList;
                                        if (updateInventoryItem2 == null) {
                                            updateInventoryItem2 = ConstantsKt.getEmptyInventoryItem();
                                        }
                                        list7.set(i3, updateInventoryItem2);
                                    } else {
                                        this.subAccessoriesList.set(i3, inventoryItem8);
                                    }
                                }
                            }
                            Unit unit2 = Unit.INSTANCE;
                        }
                        this.accessoriesInventoryAdapter.submitList(CollectionsKt.toList(this.subAccessoriesList));
                        for (Number number2 : arrayList12) {
                            this.accessoriesInventoryAdapter.notifyItemChanged(number2.intValue());
                        }
                    }
                } else {
                    if (!this.isArizonaType) {
                        id = RodinaBlockType.BLOCK_TYPE_IMPROV_GUN.getId();
                    } else {
                        id = ArizonaBlockType.BLOCK_TYPE_GUN.getId();
                    }
                    if (type4 == id) {
                        if (!this.subUpgradesList.isEmpty() && (items9 = inventoryEditResponse2.getItems()) != null) {
                            for (InventoryItem inventoryItem9 : items9) {
                                Iterator<InventoryItem> it8 = this.subUpgradesList.iterator();
                                int i4 = 0;
                                while (true) {
                                    if (!it8.hasNext()) {
                                        i4 = -1;
                                        break;
                                    } else if (it8.next().getSlot() == inventoryItem9.getSlot()) {
                                        break;
                                    } else {
                                        i4++;
                                    }
                                }
                                Iterator<T> it9 = this.subUpgradesList.iterator();
                                while (true) {
                                    if (!it9.hasNext()) {
                                        obj3 = null;
                                        break;
                                    }
                                    obj3 = it9.next();
                                    if (((InventoryItem) obj3).getSlot() == inventoryItem9.getSlot()) {
                                        break;
                                    }
                                }
                                InventoryItem updateInventoryItem3 = UtilsKt.updateInventoryItem((InventoryItem) obj3, inventoryItem9);
                                if (i4 >= 0) {
                                    if (inventoryItem9.getItem() != null) {
                                        List<InventoryItem> list8 = this.subUpgradesList;
                                        if (updateInventoryItem3 == null) {
                                            updateInventoryItem3 = ConstantsKt.getEmptyInventoryItem();
                                        }
                                        list8.set(i4, updateInventoryItem3);
                                    } else {
                                        this.subUpgradesList.set(i4, inventoryItem9);
                                    }
                                }
                                this.upgradesInventoryAdapter.submitList(CollectionsKt.toList(this.subUpgradesList));
                            }
                            Unit unit3 = Unit.INSTANCE;
                        }
                    } else {
                        if (!this.isArizonaType) {
                            id2 = RodinaBlockType.BLOCK_TYPE_IMPROV.getId();
                        } else {
                            id2 = ArizonaBlockType.BLOCK_TYPE_IMPROV.getId();
                        }
                        if (type4 == id2) {
                            List<InventoryItem> items17 = inventoryEditResponse2.getItems();
                            if (items17 != null) {
                                for (InventoryItem inventoryItem10 : items17) {
                                    Iterator<InventoryItem> it10 = this.subCaseArmorSkinList.iterator();
                                    int i5 = 0;
                                    while (true) {
                                        if (!it10.hasNext()) {
                                            i5 = -1;
                                            break;
                                        } else if (it10.next().getSlot() == inventoryItem10.getSlot()) {
                                            break;
                                        } else {
                                            i5++;
                                        }
                                    }
                                    Iterator<T> it11 = this.subCaseArmorSkinList.iterator();
                                    while (true) {
                                        if (!it11.hasNext()) {
                                            obj2 = null;
                                            break;
                                        }
                                        obj2 = it11.next();
                                        if (((InventoryItem) obj2).getSlot() == inventoryItem10.getSlot()) {
                                            break;
                                        }
                                    }
                                    InventoryItem updateInventoryItem4 = UtilsKt.updateInventoryItem((InventoryItem) obj2, inventoryItem10);
                                    if (i5 >= 0) {
                                        if (inventoryItem10.getItem() != null) {
                                            List<InventoryItem> list9 = this.subCaseArmorSkinList;
                                            if (updateInventoryItem4 == null) {
                                                updateInventoryItem4 = ConstantsKt.getEmptyInventoryItem();
                                            }
                                            list9.set(i5, updateInventoryItem4);
                                        } else {
                                            this.subCaseArmorSkinList.set(i5, inventoryItem10);
                                        }
                                    }
                                    this.subInventoryAdapter.submitList(CollectionsKt.toList(this.subCaseArmorSkinList));
                                    this.subInventoryAdapter.notifyItemChanged(i5);
                                }
                                Unit unit4 = Unit.INSTANCE;
                            }
                        } else {
                            if (!this.isArizonaType) {
                                id3 = RodinaBlockType.BLOCK_TYPE_SKIN.getId();
                            } else {
                                id3 = ArizonaBlockType.BLOCK_TYPE_SKIN.getId();
                            }
                            if (type4 == id3) {
                                List<InventoryItem> items18 = inventoryEditResponse2.getItems();
                                if (items18 != null) {
                                    for (InventoryItem inventoryItem11 : items18) {
                                        this.currentSkin = inventoryItem11;
                                        if (!this.subCaseArmorSkinList.isEmpty()) {
                                            Iterator<InventoryItem> it12 = this.subCaseArmorSkinList.iterator();
                                            int i6 = 0;
                                            while (true) {
                                                if (!it12.hasNext()) {
                                                    i6 = -1;
                                                    break;
                                                }
                                                InventoryItem next = it12.next();
                                                if (next.getSlot() == inventoryItem11.getSlot() && (next.getInventoryType() == inventoryEditResponse2.getType() || next.getInventoryType() == ArizonaBlockType.BLOCK_TYPE_MOD_SKIN.getId())) {
                                                    break;
                                                }
                                                i6++;
                                            }
                                            if (i6 >= 0) {
                                                this.subCaseArmorSkinList.set(i6, inventoryItem11);
                                            }
                                            this.subInventoryAdapter.submitList(CollectionsKt.toList(this.subCaseArmorSkinList));
                                            this.subInventoryAdapter.notifyItemChanged(i6);
                                        }
                                    }
                                    Unit unit5 = Unit.INSTANCE;
                                }
                            } else if (type4 == ArizonaBlockType.BLOCK_TYPE_MOD_SKIN.getId()) {
                                List<InventoryItem> items19 = inventoryEditResponse2.getItems();
                                if (items19 != null) {
                                    for (InventoryItem inventoryItem12 : items19) {
                                        this.currentModSkin = inventoryItem12;
                                        Iterator<InventoryItem> it13 = this.subCaseArmorSkinList.iterator();
                                        int i7 = 0;
                                        while (true) {
                                            if (!it13.hasNext()) {
                                                i7 = -1;
                                                break;
                                            }
                                            InventoryItem next2 = it13.next();
                                            if (next2.getSlot() == inventoryItem12.getSlot() && (next2.getInventoryType() == inventoryEditResponse2.getType() || next2.getInventoryType() == ArizonaBlockType.BLOCK_TYPE_SKIN.getId())) {
                                                break;
                                            }
                                            i7++;
                                        }
                                        if (i7 >= 0) {
                                            this.subCaseArmorSkinList.set(i7, inventoryItem12);
                                        }
                                        this.subInventoryAdapter.submitList(CollectionsKt.toList(this.subCaseArmorSkinList));
                                        this.subInventoryAdapter.notifyItemChanged(i7);
                                    }
                                    Unit unit6 = Unit.INSTANCE;
                                }
                            } else {
                                if (!this.isArizonaType) {
                                    id4 = RodinaBlockType.BLOCK_TYPE_WALLET.getId();
                                } else {
                                    id4 = ArizonaBlockType.BLOCK_TYPE_WALLET.getId();
                                }
                                if (type4 != id4 && type4 != ArizonaBlockType.BLOCK_TYPE_FISHBAG.getId()) {
                                    if (!this.isArizonaType) {
                                        id5 = RodinaBlockType.BLOCK_TYPE_ACTOR_WEAPON.getId();
                                    } else {
                                        id5 = ArizonaBlockType.BLOCK_TYPE_ACTOR_WEAPON.getId();
                                    }
                                    if (type4 == id5) {
                                        if (!this.guardWeaponList.isEmpty() && (items8 = inventoryEditResponse2.getItems()) != null) {
                                            for (InventoryItem inventoryItem13 : items8) {
                                                Iterator<InventoryItem> it14 = this.guardInfoList.get(this.guardNumber).getAccessoriesList().iterator();
                                                int i8 = 0;
                                                while (true) {
                                                    if (!it14.hasNext()) {
                                                        i8 = -1;
                                                        break;
                                                    }
                                                    InventoryItem next3 = it14.next();
                                                    if (next3.getInventoryType() == ArizonaBlockType.BLOCK_TYPE_ACTOR_WEAPON.getId() || next3.getInventoryType() == RodinaBlockType.BLOCK_TYPE_ACTOR_WEAPON.getId()) {
                                                        break;
                                                    }
                                                    i8++;
                                                }
                                                if (i8 >= 0) {
                                                    this.guardInfoList.get(this.guardNumber).getAccessoriesList().set(i8, inventoryItem13);
                                                }
                                                this.guardSubInventoryAdapter.submitList(CollectionsKt.toList(this.guardInfoList.get(this.guardNumber).getAccessoriesList()));
                                                this.guardSubInventoryAdapter.notifyItemChanged(i8);
                                            }
                                            Unit unit7 = Unit.INSTANCE;
                                        }
                                    } else if (type4 == ArizonaBlockType.BLOCK_TYPE_ACTOR_ATTACH.getId()) {
                                        if (!this.guardInfoList.get(this.guardNumber).getAccessoriesList().isEmpty() && (items7 = inventoryEditResponse2.getItems()) != null) {
                                            for (InventoryItem inventoryItem14 : items7) {
                                                Iterator<InventoryItem> it15 = this.guardInfoList.get(this.guardNumber).getAccessoriesList().iterator();
                                                int i9 = 0;
                                                while (true) {
                                                    if (!it15.hasNext()) {
                                                        i9 = -1;
                                                        break;
                                                    }
                                                    InventoryItem next4 = it15.next();
                                                    if (next4.getSlot() == inventoryItem14.getSlot() && next4.getId() == inventoryItem14.getId()) {
                                                        break;
                                                    }
                                                    i9++;
                                                }
                                                if (i9 >= 0) {
                                                    this.guardInfoList.get(this.guardNumber).getAccessoriesList().set(i9, inventoryItem14);
                                                }
                                                this.guardSubInventoryAdapter.submitList(CollectionsKt.toList(this.guardInfoList.get(this.guardNumber).getAccessoriesList()));
                                                this.guardSubInventoryAdapter.notifyItemChanged(i9);
                                            }
                                            Unit unit8 = Unit.INSTANCE;
                                        }
                                    } else {
                                        if (!this.isArizonaType) {
                                            id6 = RodinaBlockType.BLOCK_TYPE_ACTOR_INVENTORY.getId();
                                        } else {
                                            id6 = ArizonaBlockType.BLOCK_TYPE_ACTOR_INVENTORY.getId();
                                        }
                                        if (type4 == id6) {
                                            if (!this.guardInfoList.get(this.guardNumber).getInventoryList().isEmpty() && (items6 = inventoryEditResponse2.getItems()) != null) {
                                                for (InventoryItem inventoryItem15 : items6) {
                                                    Iterator<InventoryItem> it16 = this.guardInfoList.get(this.guardNumber).getInventoryList().iterator();
                                                    int i10 = 0;
                                                    while (true) {
                                                        if (!it16.hasNext()) {
                                                            i10 = -1;
                                                            break;
                                                        } else if (it16.next().getSlot() == inventoryItem15.getSlot()) {
                                                            break;
                                                        } else {
                                                            i10++;
                                                        }
                                                    }
                                                    if (i10 >= 0) {
                                                        this.guardInfoList.get(this.guardNumber).getInventoryList().set(i10, inventoryItem15);
                                                    }
                                                    this.guardInventoryAdapter.submitList(CollectionsKt.toList(this.guardInfoList.get(this.guardNumber).getInventoryList()));
                                                    this.guardInventoryAdapter.notifyItemChanged(i10);
                                                }
                                                Unit unit9 = Unit.INSTANCE;
                                            }
                                        } else {
                                            if (!this.isArizonaType) {
                                                id7 = RodinaBlockType.BLOCK_TYPE_VISUAL_TUNING.getId();
                                            } else {
                                                id7 = ArizonaBlockType.BLOCK_TYPE_VISUAL_TUNING.getId();
                                            }
                                            if (type4 == id7) {
                                                if (!this.vehicleVisualList.isEmpty() && (items5 = inventoryEditResponse2.getItems()) != null) {
                                                    for (InventoryItem inventoryItem16 : items5) {
                                                        Iterator<InventoryItem> it17 = this.vehicleVisualList.iterator();
                                                        int i11 = 0;
                                                        while (true) {
                                                            if (!it17.hasNext()) {
                                                                i11 = -1;
                                                                break;
                                                            } else if (it17.next().getSlot() == inventoryItem16.getSlot()) {
                                                                break;
                                                            } else {
                                                                i11++;
                                                            }
                                                        }
                                                        if (i11 >= 0) {
                                                            this.vehicleVisualList.set(i11, inventoryItem16);
                                                        }
                                                        this.vehicleVisualAdapter.submitList(CollectionsKt.toList(this.vehicleVisualList));
                                                        this.vehicleVisualAdapter.notifyItemChanged(i11);
                                                        this.vehicleVisualAdapter.notifyDataSetChanged();
                                                    }
                                                    Unit unit10 = Unit.INSTANCE;
                                                }
                                            } else {
                                                if (!this.isArizonaType) {
                                                    id8 = RodinaBlockType.BLOCK_TYPE_TECH_TUNING.getId();
                                                } else {
                                                    id8 = ArizonaBlockType.BLOCK_TYPE_TECH_TUNING.getId();
                                                }
                                                if (type4 == id8) {
                                                    if (!this.vehicleTechnicalList.isEmpty() && (items4 = inventoryEditResponse2.getItems()) != null) {
                                                        for (InventoryItem inventoryItem17 : items4) {
                                                            Iterator<InventoryItem> it18 = this.vehicleTechnicalList.iterator();
                                                            int i12 = 0;
                                                            while (true) {
                                                                if (!it18.hasNext()) {
                                                                    i12 = -1;
                                                                    break;
                                                                } else if (it18.next().getSlot() == inventoryItem17.getSlot()) {
                                                                    break;
                                                                } else {
                                                                    i12++;
                                                                }
                                                            }
                                                            if (i12 >= 0) {
                                                                this.vehicleTechnicalList.set(i12, inventoryItem17);
                                                            }
                                                            this.vehicleTechAdapter.submitList(CollectionsKt.toList(this.vehicleTechnicalList));
                                                            this.vehicleTechAdapter.notifyItemChanged(i12);
                                                            this.vehicleTechAdapter.notifyDataSetChanged();
                                                        }
                                                        Unit unit11 = Unit.INSTANCE;
                                                    }
                                                } else {
                                                    if (!this.isArizonaType) {
                                                        id9 = RodinaBlockType.BLOCK_TYPE_VEH_SKIN.getId();
                                                    } else {
                                                        id9 = ArizonaBlockType.BLOCK_TYPE_VEH_SKIN.getId();
                                                    }
                                                    if (type4 == id9) {
                                                        if (!this.vehicleSubList.isEmpty() && (items3 = inventoryEditResponse2.getItems()) != null) {
                                                            for (InventoryItem inventoryItem18 : items3) {
                                                                Iterator<InventoryItem> it19 = this.vehicleSubList.iterator();
                                                                int i13 = 0;
                                                                while (true) {
                                                                    if (!it19.hasNext()) {
                                                                        i13 = -1;
                                                                        break;
                                                                    }
                                                                    InventoryItem next5 = it19.next();
                                                                    if (next5.getInventoryType() == ArizonaBlockType.BLOCK_TYPE_VEH_SKIN.getId() || next5.getInventoryType() == RodinaBlockType.BLOCK_TYPE_VEH_SKIN.getId()) {
                                                                        break;
                                                                    }
                                                                    i13++;
                                                                }
                                                                if (i13 >= 0) {
                                                                    this.vehicleSubList.set(i13, inventoryItem18);
                                                                }
                                                                this.vehicleAccessoriesAdapter.submitList(CollectionsKt.toList(this.vehicleSubList));
                                                                this.vehicleAccessoriesAdapter.notifyItemChanged(i13);
                                                            }
                                                            Unit unit12 = Unit.INSTANCE;
                                                        }
                                                    } else if (type4 == ArizonaBlockType.BLOCK_TYPE_VEH_MODIFICATION.getId()) {
                                                        if (!this.vehicleSubList.isEmpty() && (items2 = inventoryEditResponse2.getItems()) != null) {
                                                            for (InventoryItem inventoryItem19 : items2) {
                                                                Iterator<InventoryItem> it20 = this.vehicleSubList.iterator();
                                                                int i14 = 0;
                                                                while (true) {
                                                                    if (!it20.hasNext()) {
                                                                        i14 = -1;
                                                                        break;
                                                                    } else if (it20.next().getInventoryType() == ArizonaBlockType.BLOCK_TYPE_VEH_MODIFICATION.getId()) {
                                                                        break;
                                                                    } else {
                                                                        i14++;
                                                                    }
                                                                }
                                                                if (i14 >= 0) {
                                                                    this.vehicleSubList.set(i14, inventoryItem19);
                                                                }
                                                                this.vehicleAccessoriesAdapter.submitList(CollectionsKt.toList(this.vehicleSubList));
                                                                this.vehicleAccessoriesAdapter.notifyItemChanged(i14);
                                                            }
                                                            Unit unit13 = Unit.INSTANCE;
                                                        }
                                                    } else if (type4 == ArizonaBlockType.BLOCK_TYPE_VEH_NUMBER.getId() && !this.vehicleSubList.isEmpty() && (items = inventoryEditResponse2.getItems()) != null) {
                                                        for (InventoryItem inventoryItem20 : items) {
                                                            Iterator<InventoryItem> it21 = this.vehicleSubList.iterator();
                                                            int i15 = 0;
                                                            while (true) {
                                                                if (!it21.hasNext()) {
                                                                    i15 = -1;
                                                                    break;
                                                                } else if (it21.next().getInventoryType() == ArizonaBlockType.BLOCK_TYPE_VEH_NUMBER.getId()) {
                                                                    break;
                                                                } else {
                                                                    i15++;
                                                                }
                                                            }
                                                            if (i15 >= 0) {
                                                                this.vehicleSubList.set(i15, inventoryItem20);
                                                            }
                                                            this.vehicleAccessoriesAdapter.submitList(CollectionsKt.toList(this.vehicleSubList));
                                                            this.vehicleAccessoriesAdapter.notifyItemChanged(i15);
                                                        }
                                                        Unit unit14 = Unit.INSTANCE;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                Log.e("wallet", "onBackendMessage: " + inventoryEditResponse2.getType());
                                if (!this.walletInventoryList.isEmpty()) {
                                    this.isWalletListVisible = true;
                                    List<InventoryItem> items20 = inventoryEditResponse2.getItems();
                                    if (items20 != null) {
                                        for (InventoryItem inventoryItem21 : items20) {
                                            Iterator<InventoryItem> it22 = this.walletInventoryList.iterator();
                                            int i16 = 0;
                                            while (true) {
                                                if (!it22.hasNext()) {
                                                    i16 = -1;
                                                    break;
                                                } else if (it22.next().getSlot() == inventoryItem21.getSlot()) {
                                                    break;
                                                } else {
                                                    i16++;
                                                }
                                            }
                                            Iterator<T> it23 = this.walletInventoryList.iterator();
                                            while (true) {
                                                if (!it23.hasNext()) {
                                                    obj = null;
                                                    break;
                                                }
                                                obj = it23.next();
                                                if (((InventoryItem) obj).getSlot() == inventoryItem21.getSlot()) {
                                                    break;
                                                }
                                            }
                                            InventoryItem updateInventoryItem5 = UtilsKt.updateInventoryItem((InventoryItem) obj, inventoryItem21);
                                            if (i16 >= 0) {
                                                if (inventoryItem21.getItem() != null) {
                                                    List<InventoryItem> list10 = this.walletInventoryList;
                                                    if (updateInventoryItem5 == null) {
                                                        updateInventoryItem5 = ConstantsKt.getEmptyInventoryItem();
                                                    }
                                                    list10.set(i16, updateInventoryItem5);
                                                } else {
                                                    this.walletInventoryList.set(i16, inventoryItem21);
                                                }
                                            }
                                        }
                                        Unit unit15 = Unit.INSTANCE;
                                    }
                                    this.walletInventoryAdapter.submitList(CollectionsKt.toList(this.walletInventoryList));
                                }
                            }
                        }
                    }
                }
                if (this.isArizonaType && ConstantsKt.getArizonaWarehouseIds().contains(Integer.valueOf(inventoryEditResponse2.getType()))) {
                    List<InventoryItem> items21 = inventoryEditResponse2.getItems();
                    if (items21 != null) {
                        for (InventoryItem inventoryItem22 : items21) {
                            Iterator<InventoryItem> it24 = this.warehouseList.iterator();
                            int i17 = 0;
                            while (true) {
                                if (!it24.hasNext()) {
                                    i17 = -1;
                                    break;
                                } else if (it24.next().getSlot() == inventoryItem22.getSlot()) {
                                    break;
                                } else {
                                    i17++;
                                }
                            }
                            if (i17 >= 0) {
                                this.warehouseList.set(i17, inventoryItem22);
                            }
                            this.warehouseAdapter.submitList(CollectionsKt.toList(this.warehouseList));
                            this.warehouseAdapter.notifyItemChanged(i17);
                        }
                        Unit unit16 = Unit.INSTANCE;
                    }
                } else if (!this.isArizonaType && ConstantsKt.getRodinaWarehouseIds().contains(Integer.valueOf(inventoryEditResponse2.getType())) && (items10 = inventoryEditResponse2.getItems()) != null) {
                    for (InventoryItem inventoryItem23 : items10) {
                        Iterator<InventoryItem> it25 = this.warehouseList.iterator();
                        int i18 = 0;
                        while (true) {
                            if (!it25.hasNext()) {
                                i18 = -1;
                                break;
                            } else if (it25.next().getSlot() == inventoryItem23.getSlot()) {
                                break;
                            } else {
                                i18++;
                            }
                        }
                        if (i18 >= 0) {
                            this.warehouseList.set(i18, inventoryItem23);
                        }
                        this.warehouseAdapter.submitList(CollectionsKt.toList(this.warehouseList));
                        this.warehouseAdapter.notifyItemChanged(i18);
                    }
                    Unit unit17 = Unit.INSTANCE;
                }
            } else if (i == 3) {
                Object fromJson7 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) ShowDialogInfo.class);
                Intrinsics.checkNotNullExpressionValue(fromJson7, "fromJson(...)");
                ShowDialogInfo showDialogInfo = (ShowDialogInfo) fromJson7;
                if (this.guardInfoList.isEmpty()) {
                    InventoryItem inventoryItem24 = this.selectedInventoryItem;
                    if (inventoryItem24 != null) {
                        new SelectorDialog(getTargetActivity(), this.currentBackendId, InventoryItem.copy$default(inventoryItem24, 0, null, 0, null, null, null, null, null, Integer.valueOf(showDialogInfo.getBits()), null, null, null, null, null, null, null, 0, null, null, false, false, 2096895, null), 0);
                        return;
                    }
                    return;
                }
                InventoryItem inventoryItem25 = this.selectedInventoryItem;
                if (inventoryItem25 != null) {
                    Activity targetActivity = getTargetActivity();
                    int i19 = this.currentBackendId;
                    InventoryItem copy$default = InventoryItem.copy$default(inventoryItem25, 0, null, 0, null, null, null, null, null, Integer.valueOf(showDialogInfo.getBits()), null, null, null, null, null, null, null, 0, null, null, false, false, 2096895, null);
                    Integer id26 = this.guardInfoList.get(this.guardNumber).getId();
                    new SelectorDialog(targetActivity, i19, copy$default, id26 != null ? id26.intValue() : 0);
                }
            } else if (i == 5) {
                setVisible(true);
                closeWallet();
                this.clickedMenuButtons = true;
            } else if (i == 6) {
                Object fromJson8 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) BlockType.class);
                Intrinsics.checkNotNullExpressionValue(fromJson8, "fromJson(...)");
                int type5 = ((BlockType) fromJson8).getType();
                if (type5 == 1) {
                    RecyclerView rvAccessoriesInventory = this.binding.rvAccessoriesInventory;
                    Intrinsics.checkNotNullExpressionValue(rvAccessoriesInventory, "rvAccessoriesInventory");
                    if (rvAccessoriesInventory.getVisibility() == 0) {
                        return;
                    }
                    this.binding.btnAccessories.performClick();
                } else if (type5 == 2) {
                    RecyclerView rvUpgradesInventory = this.binding.rvUpgradesInventory;
                    Intrinsics.checkNotNullExpressionValue(rvUpgradesInventory, "rvUpgradesInventory");
                    if (rvUpgradesInventory.getVisibility() == 0) {
                        return;
                    }
                    this.binding.btnUpgrades.performClick();
                }
            } else if (i == 10) {
                ConstantsKt.setHealthBar(Integer.parseInt(data));
                this.binding.ivHealthBar.setProgress(ConstantsKt.getHealthBar());
                this.binding.tvHealthCount.setText(data);
            } else if (i == 11) {
                ConstantsKt.setShieldBar(Integer.parseInt(data));
                this.binding.ivShieldBar.setProgress(ConstantsKt.getShieldBar());
                this.binding.tvShieldCount.setText(data);
            } else if (i == 12) {
                ConstantsKt.setSatietyBar(Integer.parseInt(data));
                this.binding.ivFoodBar.setProgress(ConstantsKt.getSatietyBar());
                this.binding.tvFoodCount.setText(data);
            } else if (i == UIElementID.INVENTORY_SECURITY_SCREEN.getId()) {
                if (Intrinsics.areEqual(data, "true")) {
                    setVisible(true);
                    this.currentBackendId = UIElementID.INVENTORY_SECURITY_SCREEN.getId();
                    return;
                }
                setVisible(false);
            } else if (i == UIElementID.INVENTORY_WAREHOUSE.getId()) {
                if (Intrinsics.areEqual(data, "true")) {
                    setVisible(true);
                    initObservers();
                }
            } else if (i == UIElementID.INVENTORY_VEHICLE_SCREEN.getId()) {
                if (Intrinsics.areEqual(data, "true")) {
                    setVisible(true);
                    this.currentBackendId = UIElementID.INVENTORY_VEHICLE_SCREEN.getId();
                    initObservers();
                    return;
                }
                setVisible(false);
            } else if (i == UIElementID.INVENTORY_WALLET_SCREEN.getId()) {
                if (Intrinsics.areEqual(data, "true")) {
                    this.isWalletListVisible = true;
                    if (!this.isArizonaType) {
                        this.mainInventoryAdapter.setWalletVisible(true);
                        return;
                    }
                    setVisible(true);
                    this.currentBackendId = UIElementID.INVENTORY_WALLET_SCREEN.getId();
                    initObservers();
                } else if (!this.isArizonaType) {
                    this.mainInventoryAdapter.setWalletVisible(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackendMessage$lambda$72(InventoryScreen inventoryScreen) {
        inventoryScreen.addLockedItems();
        inventoryScreen.mainInventoryAdapter.notifyDataSetChanged();
        inventoryScreen.addInfoToDatabase(inventoryScreen.mainInventoryList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onBackendMessage$lambda$73(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.isLocked();
    }

    private final void getArzWarehouseType(int i) {
        int id;
        switch (i) {
            case 2:
                id = ArizonaBlockType.BLOCK_TYPE_CHEST.getId();
                break;
            case 3:
                id = ArizonaBlockType.BLOCK_TYPE_HOTEL_ROOM.getId();
                break;
            case 4:
                id = ArizonaBlockType.BLOCK_TYPE_TRUNK.getId();
                break;
            case 5:
                id = ArizonaBlockType.BLOCK_TYPE_FAM_FLAT.getId();
                break;
            case 6:
                id = ArizonaBlockType.BLOCK_TYPE_HOUSE.getId();
                break;
            case 7:
                id = ArizonaBlockType.BLOCK_TYPE_TRAILER.getId();
                break;
            case 8:
                id = ArizonaBlockType.BLOCK_TYPE_STOREHOUSE.getId();
                break;
            case 9:
                id = ArizonaBlockType.BLOCK_TYPE_PAWNSHOP.getId();
                break;
            case 10:
                id = ArizonaBlockType.BLOCK_TYPE_TRASH.getId();
                break;
            case 11:
                id = ArizonaBlockType.BLOCK_TYPE_ADMIN_FUND.getId();
                break;
            default:
                id = 0;
                break;
        }
        this.currentWarehouse = id;
    }

    private final void getRodWarehouseType(int i) {
        int id;
        if (i != 17) {
            switch (i) {
                case 2:
                    id = RodinaBlockType.BLOCK_TYPE_TRASH.getId();
                    break;
                case 3:
                    id = RodinaBlockType.BLOCK_TYPE_TRUNK.getId();
                    break;
                case 4:
                    id = RodinaBlockType.BLOCK_TYPE_HOUSE.getId();
                    break;
                case 5:
                    id = RodinaBlockType.BLOCK_TYPE_DRAWER.getId();
                    break;
                case 6:
                    id = RodinaBlockType.BLOCK_TYPE_SHIP.getId();
                    break;
                case 7:
                    id = RodinaBlockType.BLOCK_TYPE_CAMPER_CUPBOARD.getId();
                    break;
                case 8:
                    id = RodinaBlockType.BLOCK_TYPE_BANK_VAULT.getId();
                    break;
                case 9:
                    id = RodinaBlockType.BLOCK_TYPE_FRACTION_WAREHOUSE.getId();
                    break;
                case 10:
                    id = RodinaBlockType.BLOCK_TYPE_FAMILY_WAREHOUSE.getId();
                    break;
                case 11:
                    id = RodinaBlockType.BLOCK_TYPE_GARDENING_BARN.getId();
                    break;
                case 12:
                    id = RodinaBlockType.BLOCK_TYPE_GARAGE.getId();
                    break;
                default:
                    id = 0;
                    break;
            }
        } else {
            id = RodinaBlockType.BLOCK_TYPE_TRAILER.getId();
        }
        this.currentWarehouse = id;
    }

    private final void showGuardScreen() {
        MainInventoryBinding mainInventoryBinding = this.binding;
        ConstraintLayout parentLayout = mainInventoryBinding.layoutGuards.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
        parentLayout.setVisibility(0);
        Group groupCharacter = mainInventoryBinding.groupCharacter;
        Intrinsics.checkNotNullExpressionValue(groupCharacter, "groupCharacter");
        groupCharacter.setVisibility(8);
        RecyclerView rvAccessoriesInventory = mainInventoryBinding.rvAccessoriesInventory;
        Intrinsics.checkNotNullExpressionValue(rvAccessoriesInventory, "rvAccessoriesInventory");
        rvAccessoriesInventory.setVisibility(8);
        RecyclerView rvUpgradesInventory = mainInventoryBinding.rvUpgradesInventory;
        Intrinsics.checkNotNullExpressionValue(rvUpgradesInventory, "rvUpgradesInventory");
        rvUpgradesInventory.setVisibility(8);
        ConstraintLayout parentLayout2 = mainInventoryBinding.layoutVehicle.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout2, "parentLayout");
        parentLayout2.setVisibility(8);
        ConstraintLayout parentLayout3 = mainInventoryBinding.layoutWarehouse.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout3, "parentLayout");
        parentLayout3.setVisibility(8);
    }

    private final void showVehicleScreen() {
        MainInventoryBinding mainInventoryBinding = this.binding;
        ProgressBar progressBar = mainInventoryBinding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(8);
        Group groupCharacter = mainInventoryBinding.groupCharacter;
        Intrinsics.checkNotNullExpressionValue(groupCharacter, "groupCharacter");
        groupCharacter.setVisibility(8);
        ConstraintLayout parentLayout = mainInventoryBinding.layoutGuards.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
        parentLayout.setVisibility(8);
        ConstraintLayout parentLayout2 = mainInventoryBinding.layoutVehicle.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout2, "parentLayout");
        parentLayout2.setVisibility(0);
        ConstraintLayout parentLayout3 = mainInventoryBinding.layoutWarehouse.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout3, "parentLayout");
        parentLayout3.setVisibility(8);
        this.vehicleAccessoriesAdapter.submitList(CollectionsKt.toList(this.vehicleSubList));
        this.vehicleAccessoriesAdapter.notifyDataSetChanged();
    }

    private final void showWarehouseScreen() {
        MainInventoryBinding mainInventoryBinding = this.binding;
        Group groupCharacter = mainInventoryBinding.groupCharacter;
        Intrinsics.checkNotNullExpressionValue(groupCharacter, "groupCharacter");
        groupCharacter.setVisibility(8);
        ProgressBar progressBar = mainInventoryBinding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(8);
        ConstraintLayout parentLayout = mainInventoryBinding.layoutGuards.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
        parentLayout.setVisibility(8);
        ConstraintLayout parentLayout2 = mainInventoryBinding.layoutVehicle.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout2, "parentLayout");
        parentLayout2.setVisibility(8);
        ConstraintLayout parentLayout3 = mainInventoryBinding.layoutWarehouse.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout3, "parentLayout");
        parentLayout3.setVisibility(0);
        this.warehouseAdapter.submitList(CollectionsKt.toList(this.warehouseList));
        this.warehouseAdapter.notifyDataSetChanged();
    }

    private final void getAndShowMenuButtonsArz(int i) {
        EnumSet<ArzInventoryButtonTypes> allOf = EnumSet.allOf(ArzInventoryButtonTypes.class);
        Intrinsics.checkNotNullExpressionValue(allOf, "allOf(...)");
        ArrayList arrayList = new ArrayList();
        for (ArzInventoryButtonTypes arzInventoryButtonTypes : allOf) {
            if ((arzInventoryButtonTypes.getValue() & i) > 0) {
                arrayList.add(Integer.valueOf(arzInventoryButtonTypes.ordinal()));
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        addMenuCategories(arrayList);
    }

    private final void getAndShowMenuButtonsRod(int i) {
        EnumSet<RodInventoryButtonTypes> allOf = EnumSet.allOf(RodInventoryButtonTypes.class);
        Intrinsics.checkNotNullExpressionValue(allOf, "allOf(...)");
        ArrayList arrayList = new ArrayList();
        for (RodInventoryButtonTypes rodInventoryButtonTypes : allOf) {
            if ((rodInventoryButtonTypes.getValue() & i) > 0) {
                arrayList.add(Integer.valueOf(rodInventoryButtonTypes.ordinal()));
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        addMenuCategories(arrayList);
    }

    private final void addMenuCategories(List<Integer> list) {
        this.menuItemList.clear();
        if (this.isArizonaType) {
            for (Number number : list) {
                int intValue = number.intValue();
                this.menuItemList.add(new InventoryMenuData(intValue, UtilsKt.defineArzMenuText(intValue)));
            }
        } else {
            for (Number number2 : list) {
                int intValue2 = number2.intValue();
                this.menuItemList.add(new InventoryMenuData(intValue2, UtilsKt.defineRodMenuText(intValue2)));
            }
        }
        this.inventoryMenuAdapter.submitList(CollectionsKt.toList(this.menuItemList));
        this.inventoryMenuAdapter.resetSelectItemPosition();
    }

    private final void addInfoToDatabase(List<InventoryItem> list) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new InventoryScreen$addInfoToDatabase$1(this, list, null), 3, null);
    }

    private final void updateInfoToDatabase(InventoryItem inventoryItem) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new InventoryScreen$updateInfoToDatabase$1(inventoryItem, this, null), 3, null);
    }

    private final void addLockedItems() {
        int nextMultipleOfFive = UtilsKt.nextMultipleOfFive(this.mainInventoryList.size()) - this.mainInventoryList.size();
        int slot = ((InventoryItem) CollectionsKt.last((List<? extends Object>) this.mainInventoryList)).getSlot();
        IntRange intRange = new IntRange(1, nextMultipleOfFive);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(InventoryItem.copy$default(ConstantsKt.getEmptyInventoryItem(), slot + ((IntIterator) it).nextInt(), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, false, true, 1048574, null));
        }
        this.mainInventoryList.addAll(arrayList);
        initObservers();
    }

    private final List<InventoryItem> editResponseInfo(InventoryResponse inventoryResponse) {
        Integer num;
        Object obj;
        Object obj2;
        List<InventoryItem> items = inventoryResponse.getItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
        for (InventoryItem inventoryItem : items) {
            int type = inventoryResponse.getType();
            Iterator<T> it = UtilsKt.getItemsName().iterator();
            while (true) {
                num = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                int id = ((ItemsInfo) obj).getId();
                Integer item = inventoryItem.getItem();
                if (item != null && id == item.intValue()) {
                    break;
                }
            }
            ItemsInfo itemsInfo = (ItemsInfo) obj;
            Integer valueOf = itemsInfo != null ? Integer.valueOf(itemsInfo.getType()) : null;
            Iterator<T> it2 = UtilsKt.getItemsName().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it2.next();
                int id2 = ((ItemsInfo) obj2).getId();
                Integer item2 = inventoryItem.getItem();
                if (item2 != null && id2 == item2.intValue()) {
                    break;
                }
            }
            ItemsInfo itemsInfo2 = (ItemsInfo) obj2;
            if (itemsInfo2 != null) {
                num = Integer.valueOf(itemsInfo2.getAcs_slot());
            }
            arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, valueOf, null, null, null, null, null, null, null, null, null, null, null, type, num, null, false, false, 1900527, null));
        }
        return arrayList;
    }

    private final void colorItem(InventoryItem inventoryItem, boolean z) {
        if (this.isArizonaType) {
            Integer item_type = inventoryItem.getItem_type();
            int id = ItemTypes.ITEM_TYPE_ACCESSORIES.getId();
            if (item_type != null && item_type.intValue() == id) {
                ConstraintLayout parentLayout = this.binding.layoutGuards.parentLayout;
                Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
                if (parentLayout.getVisibility() != 0) {
                    changeAccessoriesItem(inventoryItem, z);
                    return;
                } else {
                    changeGuardSubList(z);
                    return;
                }
            }
            int id2 = ItemTypes.ITEM_TYPE_IMPROV.getId();
            if (item_type != null && item_type.intValue() == id2) {
                changeCaseArmorItem(inventoryItem, z);
                return;
            }
            int id3 = ItemTypes.ITEM_TYPE_SKIN.getId();
            if (item_type == null || item_type.intValue() != id3) {
                int id4 = ItemTypes.ITEM_TYPE_MOD_SKIN.getId();
                if (item_type == null || item_type.intValue() != id4) {
                    int id5 = ItemTypes.ITEM_TYPE_TECH_TUNING.getId();
                    if (item_type != null && item_type.intValue() == id5) {
                        changeTechVehicleList(z);
                        return;
                    }
                    int id6 = ItemTypes.ITEM_TYPE_VISUAL_TUNING.getId();
                    if (item_type == null || item_type.intValue() != id6) {
                        int id7 = ItemTypes.ITEM_TYPE_VEH_ACCESSORIES.getId();
                        if (item_type == null || item_type.intValue() != id7) {
                            int id8 = ItemTypes.ITEM_TYPE_VEH_SKIN.getId();
                            if (item_type == null || item_type.intValue() != id8) {
                                int id9 = ItemTypes.ITEM_TYPE_VEH_MODIFICATION.getId();
                                if (item_type == null || item_type.intValue() != id9) {
                                    int id10 = ItemTypes.ITEM_TYPE_VEH_NUMBER.getId();
                                    if (item_type == null || item_type.intValue() != id10) {
                                        int id11 = ItemTypes.ITEM_TYPE_IMPROV_GUN.getId();
                                        if (item_type == null || item_type.intValue() != id11) {
                                            int id12 = ItemTypes.ITEM_TYPE_GUN.getId();
                                            if (item_type == null || item_type.intValue() != id12) {
                                                int id13 = ItemTypes.ITEM_TYPE_CROSSHAIR.getId();
                                                if (item_type == null || item_type.intValue() != id13) {
                                                    int id14 = ItemTypes.ITEM_TYPE_INCREASED_MAGAZINE.getId();
                                                    if (item_type == null || item_type.intValue() != id14) {
                                                        return;
                                                    }
                                                }
                                            }
                                        }
                                        ConstraintLayout parentLayout2 = this.binding.layoutGuards.parentLayout;
                                        Intrinsics.checkNotNullExpressionValue(parentLayout2, "parentLayout");
                                        if (parentLayout2.getVisibility() == 0) {
                                            changeGuardSubList(z);
                                            return;
                                        } else {
                                            changeGunImprovementsItem(z);
                                            return;
                                        }
                                    }
                                }
                            }
                            changeVehicleSubList(inventoryItem, z);
                            return;
                        }
                    }
                    changeVisualVehicleList(z);
                    return;
                }
            }
            changeSkinItem(z);
            return;
        }
        Integer item_type2 = inventoryItem.getItem_type();
        int id15 = RodinaItemTypes.ITEM_TYPE_ATTACH.getId();
        if (item_type2 != null && item_type2.intValue() == id15) {
            changeAccessoriesItem(inventoryItem, z);
            return;
        }
        int id16 = RodinaItemTypes.ITEM_TYPE_IMPROV.getId();
        if (item_type2 != null && item_type2.intValue() == id16) {
            changeCaseArmorItem(inventoryItem, z);
            return;
        }
        int id17 = RodinaItemTypes.ITEM_TYPE_SKIN.getId();
        if (item_type2 != null && item_type2.intValue() == id17) {
            changeSkinItem(z);
        }
    }

    private final void changeGuardSubList(boolean z) {
        List<InventoryItem> accessoriesList = this.guardInfoList.get(this.guardNumber).getAccessoriesList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(accessoriesList, 10));
        for (InventoryItem inventoryItem : accessoriesList) {
            if (inventoryItem.getInventoryType() == ArizonaBlockType.BLOCK_TYPE_ACTOR_WEAPON.getId() || inventoryItem.getInventoryType() == RodinaBlockType.BLOCK_TYPE_ACTOR_WEAPON.getId()) {
                inventoryItem = InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z, false, 1572863, null);
            }
            arrayList.add(inventoryItem);
        }
        this.guardSubInventoryAdapter.submitList(CollectionsKt.toList(arrayList));
    }

    private final void changeAccessoriesItem(InventoryItem inventoryItem, boolean z) {
        List<InventoryItem> list = this.subAccessoriesList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (InventoryItem inventoryItem2 : list) {
            int slot = inventoryItem2.getSlot();
            Integer acsSlot = inventoryItem.getAcsSlot();
            if (acsSlot != null && slot == acsSlot.intValue()) {
                inventoryItem2 = InventoryItem.copy$default(inventoryItem2, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z, false, 1572863, null);
            }
            arrayList.add(inventoryItem2);
        }
        List<InventoryItem> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        this.subAccessoriesList = mutableList;
        this.accessoriesInventoryAdapter.submitList(CollectionsKt.toList(mutableList));
    }

    private final void changeGunImprovementsItem(boolean z) {
        Object obj;
        Iterator<T> it = this.subUpgradesList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((InventoryItem) obj).getItem() == null) {
                break;
            }
        }
        InventoryItem inventoryItem = (InventoryItem) obj;
        List<InventoryItem> list = this.subUpgradesList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (InventoryItem inventoryItem2 : list) {
            if (inventoryItem != null && inventoryItem2.getSlot() == inventoryItem.getSlot()) {
                inventoryItem2 = InventoryItem.copy$default(inventoryItem2, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z, false, 1572863, null);
            }
            arrayList.add(inventoryItem2);
        }
        List<InventoryItem> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        this.subUpgradesList = mutableList;
        this.upgradesInventoryAdapter.submitList(CollectionsKt.toList(mutableList));
    }

    private final void changeCaseArmorItem(InventoryItem inventoryItem, boolean z) {
        List<InventoryItem> list = this.subCaseArmorSkinList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (InventoryItem inventoryItem2 : list) {
            int slot = inventoryItem2.getSlot();
            Integer acsSlot = inventoryItem.getAcsSlot();
            if (acsSlot != null && slot == acsSlot.intValue() && (inventoryItem2.getInventoryType() == ArizonaBlockType.BLOCK_TYPE_IMPROV.getId() || inventoryItem2.getInventoryType() == RodinaBlockType.BLOCK_TYPE_IMPROV.getId())) {
                inventoryItem2 = InventoryItem.copy$default(inventoryItem2, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z, false, 1572863, null);
            }
            arrayList.add(inventoryItem2);
        }
        List<InventoryItem> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        this.subCaseArmorSkinList = mutableList;
        this.subInventoryAdapter.submitList(CollectionsKt.toList(mutableList));
    }

    private final void changeSkinItem(boolean z) {
        List<InventoryItem> list = this.subCaseArmorSkinList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (InventoryItem inventoryItem : list) {
            if (inventoryItem.getInventoryType() == ArizonaBlockType.BLOCK_TYPE_SKIN.getId() || inventoryItem.getInventoryType() == RodinaBlockType.BLOCK_TYPE_SKIN.getId()) {
                inventoryItem = InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z, false, 1572863, null);
            }
            arrayList.add(inventoryItem);
        }
        List<InventoryItem> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        this.subCaseArmorSkinList = mutableList;
        this.subInventoryAdapter.submitList(CollectionsKt.toList(mutableList));
    }

    private final void changeVehicleSubList(InventoryItem inventoryItem, boolean z) {
        Integer item_type = inventoryItem.getItem_type();
        int id = ItemTypes.ITEM_TYPE_VEH_SKIN.getId();
        int i = 0;
        if (item_type != null && item_type.intValue() == id) {
            List<InventoryItem> list = this.vehicleSubList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                InventoryItem inventoryItem2 = (InventoryItem) obj;
                if (i == 0) {
                    inventoryItem2 = InventoryItem.copy$default(inventoryItem2, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z, false, 1572863, null);
                }
                arrayList.add(inventoryItem2);
                i = i2;
            }
            this.vehicleSubList = CollectionsKt.toMutableList((Collection) arrayList);
        } else {
            int id2 = ItemTypes.ITEM_TYPE_VEH_MODIFICATION.getId();
            if (item_type != null && item_type.intValue() == id2) {
                List<InventoryItem> list2 = this.vehicleSubList;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (Object obj2 : list2) {
                    int i3 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    InventoryItem inventoryItem3 = (InventoryItem) obj2;
                    if (i == 1) {
                        inventoryItem3 = InventoryItem.copy$default(inventoryItem3, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z, false, 1572863, null);
                    }
                    arrayList2.add(inventoryItem3);
                    i = i3;
                }
                this.vehicleSubList = CollectionsKt.toMutableList((Collection) arrayList2);
            } else {
                int id3 = ItemTypes.ITEM_TYPE_VEH_NUMBER.getId();
                if (item_type != null && item_type.intValue() == id3) {
                    List<InventoryItem> list3 = this.vehicleSubList;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                    for (Object obj3 : list3) {
                        int i4 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        InventoryItem inventoryItem4 = (InventoryItem) obj3;
                        if (i == 2) {
                            inventoryItem4 = InventoryItem.copy$default(inventoryItem4, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z, false, 1572863, null);
                        }
                        arrayList3.add(inventoryItem4);
                        i = i4;
                    }
                    this.vehicleSubList = CollectionsKt.toMutableList((Collection) arrayList3);
                }
            }
        }
        this.vehicleAccessoriesAdapter.submitList(CollectionsKt.toList(this.vehicleSubList));
    }

    private final void changeVisualVehicleList(boolean z) {
        Object obj;
        Iterator<T> it = this.vehicleVisualList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((InventoryItem) obj).getItem() == null) {
                break;
            }
        }
        InventoryItem inventoryItem = (InventoryItem) obj;
        List<InventoryItem> list = this.vehicleVisualList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (InventoryItem inventoryItem2 : list) {
            if (inventoryItem != null && inventoryItem2.getSlot() == inventoryItem.getSlot()) {
                inventoryItem2 = InventoryItem.copy$default(inventoryItem2, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z, false, 1572863, null);
            }
            arrayList.add(inventoryItem2);
        }
        List<InventoryItem> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        this.vehicleVisualList = mutableList;
        this.vehicleVisualAdapter.submitList(CollectionsKt.toList(mutableList));
    }

    private final void changeTechVehicleList(boolean z) {
        Object obj;
        Iterator<T> it = this.vehicleTechnicalList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((InventoryItem) obj).getItem() == null) {
                break;
            }
        }
        InventoryItem inventoryItem = (InventoryItem) obj;
        List<InventoryItem> list = this.vehicleTechnicalList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (InventoryItem inventoryItem2 : list) {
            if (inventoryItem != null && inventoryItem2.getSlot() == inventoryItem.getSlot()) {
                inventoryItem2 = InventoryItem.copy$default(inventoryItem2, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z, false, 1572863, null);
            }
            arrayList.add(inventoryItem2);
        }
        List<InventoryItem> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        this.vehicleTechnicalList = mutableList;
        this.vehicleTechAdapter.submitList(CollectionsKt.toList(mutableList));
    }

    private final void addTopBars(Skin skin) {
        String str;
        if (this.isArizonaType) {
            str = FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/arizona-rp/assets/images/inventory/skins/512/" + skin.getSkin().getModel() + ".webp";
        } else {
            str = FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/rodina-rp/assets/images/inventory/skins/512/" + skin.getSkin().getModel() + ".webp";
        }
        String str2 = str;
        AppCompatImageView ivCharacterImage = this.binding.ivCharacterImage;
        Intrinsics.checkNotNullExpressionValue(ivCharacterImage, "ivCharacterImage");
        observeUserSkin$default(this, ivCharacterImage, str2, 0, 4, null);
        getUserInfo();
    }

    private final void closeWallet() {
        this.binding.btnWallet.setBackgroundResource(R.drawable.ic_btn_wallet_grey);
        RecyclerView rvSubInventory = this.binding.rvSubInventory;
        Intrinsics.checkNotNullExpressionValue(rvSubInventory, "rvSubInventory");
        rvSubInventory.setVisibility(0);
        RecyclerView rvWalletInventory = this.binding.rvWalletInventory;
        Intrinsics.checkNotNullExpressionValue(rvWalletInventory, "rvWalletInventory");
        rvWalletInventory.setVisibility(8);
        this.isWalletListVisible = false;
        this.frontendNotifier.setUIElementVisible(UIElementID.INVENTORY_WALLET_SCREEN.getId(), false);
        this.frontendNotifier.setUIElementVisible(UIElementID.INVENTORY.getId(), true);
        this.currentBackendId = UIElementID.INVENTORY.getId();
    }

    private final void getUserInfo() {
        this.binding.ivHealthBar.setProgress(ConstantsKt.getHealthBar());
        this.binding.tvHealthCount.setText(String.valueOf(ConstantsKt.getHealthBar()));
        this.binding.ivShieldBar.setProgress(ConstantsKt.getShieldBar());
        this.binding.tvShieldCount.setText(String.valueOf(ConstantsKt.getShieldBar()));
        this.binding.ivFoodBar.setProgress(ConstantsKt.getSatietyBar());
        this.binding.tvFoodCount.setText(String.valueOf(ConstantsKt.getSatietyBar()));
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onUpdateData(int i, int i2) {
        if (i == 0) {
            ConstantsKt.setHealthBar(i2);
        } else if (i == 1) {
            ConstantsKt.setShieldBar(i2);
        } else if (i != 2) {
        } else {
            ConstantsKt.setSatietyBar(i2);
        }
    }

    static /* synthetic */ void observeUserSkin$default(InventoryScreen inventoryScreen, ImageView imageView, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = R.drawable.default_char_skin_cropped;
        }
        inventoryScreen.observeUserSkin(imageView, str, i);
    }

    private final void observeUserSkin(ImageView imageView, String str, int i) {
        ProgressBar progressBar = this.binding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(0);
        Glide.with(getTargetActivity()).load(str).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(i).error(i).into(imageView);
        ProgressBar progressBar2 = this.binding.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar2, "progressBar");
        progressBar2.setVisibility(8);
    }

    private final void addVehicleInfo(VehicleInfoBars vehicleInfoBars) {
        String str;
        this.binding.layoutVehicle.ivOilBar.setProgress(vehicleInfoBars.getOil());
        this.binding.layoutVehicle.tvOilCount.setText(String.valueOf(vehicleInfoBars.getOil()));
        this.binding.layoutVehicle.ivEngineBar.setProgress((int) ((vehicleInfoBars.getHealth() / vehicleInfoBars.getMaxHealth()) * 100));
        this.binding.layoutVehicle.tvEngineCount.setText(String.valueOf(vehicleInfoBars.getHealth()));
        if (this.isArizonaType) {
            str = FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/arizona-rp/assets/images/inventory/vehicles/512/" + vehicleInfoBars.getSkin().getModel() + ".webp";
        } else {
            str = FirebaseConfigHelper.INSTANCE.getResourceUrl() + "projects/rodina-rp/assets/images/inventory/vehicles/512/" + vehicleInfoBars.getSkin().getModel() + ".webp";
        }
        AppCompatImageView ivVehicleBg = this.binding.layoutVehicle.ivVehicleBg;
        Intrinsics.checkNotNullExpressionValue(ivVehicleBg, "ivVehicleBg");
        observeUserSkin(ivVehicleBg, str, R.drawable.default_car_skin);
    }

    private final void sendData(InventoryItem inventoryItem, InventoryItem inventoryItem2) {
        int i;
        if (inventoryItem.getAmount() != null) {
            Integer amount = inventoryItem.getAmount();
            i = amount != null ? amount.intValue() : 0;
        } else {
            i = 1;
        }
        if (inventoryItem.getSlot() == inventoryItem2.getSlot() && inventoryItem.getInventoryType() == inventoryItem2.getInventoryType()) {
            Log.d("TAG_SEND", "EQUAL ITEMS");
            return;
        }
        Log.d("TAG_SEND", "backendID: " + this.currentBackendId + " ====== from : " + inventoryItem + " ===== toItem : " + inventoryItem2);
        IBackendNotifier iBackendNotifier = this.frontendNotifier;
        int i2 = this.currentBackendId;
        byte[] bytes = StringKt.toStringJson(new InventorySendRequest(new ChangeFromSlot(inventoryItem.getSlot(), inventoryItem.getInventoryType(), i, inventoryItem.getId()), new ChangeToSlot(inventoryItem2.getSlot(), inventoryItem2.getInventoryType()))).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(i2, -1, 1, bytes);
    }

    private final void sendGuardData(InventoryItem inventoryItem, InventoryItem inventoryItem2) {
        int i;
        if (inventoryItem.getAmount() != null) {
            Integer amount = inventoryItem.getAmount();
            i = amount != null ? amount.intValue() : 0;
        } else {
            i = 1;
        }
        if (inventoryItem.getSlot() == inventoryItem2.getSlot() && inventoryItem.getInventoryType() == inventoryItem2.getInventoryType()) {
            Log.d("TAG_SEND", "GUARD EQUAL ITEMS");
            return;
        }
        Log.d("TAG_SEND", "GUARD from : " + inventoryItem + " ===== toItem : " + inventoryItem2);
        IBackendNotifier iBackendNotifier = this.frontendNotifier;
        int id = UIElementID.INVENTORY_SECURITY_SCREEN.getId();
        byte[] bytes = StringKt.toStringJson(new GuardInventorySendRequest(new ChangeFromSlot(inventoryItem.getSlot(), inventoryItem.getInventoryType(), i, inventoryItem.getId()), new ChangeToSlotGuard(inventoryItem2.getSlot(), inventoryItem2.getInventoryType(), inventoryItem2.getId()))).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(id, -1, 1, bytes);
    }

    private final void closeAllInventoryScreens() {
        this.frontendNotifier.setUIElementVisible(UIElementID.INVENTORY_SECURITY_SCREEN.getId(), false);
        this.frontendNotifier.setUIElementVisible(UIElementID.INVENTORY_WAREHOUSE.getId(), false);
        this.frontendNotifier.setUIElementVisible(UIElementID.INVENTORY_VEHICLE_SCREEN.getId(), false);
        this.frontendNotifier.setUIElementVisible(UIElementID.INVENTORY_WALLET_SCREEN.getId(), false);
        this.frontendNotifier.setUIElementVisible(UIElementID.INVENTORY.getId(), false);
        this.clickedMenuButtons = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendRequestTo(String str, int i) {
        Log.d("TAG_DATA", "backID: " + this.currentBackendId + " ======= data: " + str);
        IBackendNotifier iBackendNotifier = this.frontendNotifier;
        int i2 = this.currentBackendId;
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        iBackendNotifier.clickedWrapper(i2, -1, i, bytes);
    }

    /* compiled from: InventoryScreen.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/InventoryScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new InventoryScreen(targetActivity, i);
        }
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        int i;
        ConstraintLayout constraintLayout = this.binding.parentLayout;
        if (z) {
            i = 0;
        } else {
            this.guardInventoryList.clear();
            this.guardAccessoriesList.clear();
            i = 8;
        }
        constraintLayout.setVisibility(i);
    }

    /* compiled from: InventoryScreen.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/InventoryScreen$Companion;", "", "<init>", "()V", "isDialogVisible", "", "()Z", "setDialogVisible", "(Z)V", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isDialogVisible() {
            return InventoryScreen.isDialogVisible;
        }

        public final void setDialogVisible(boolean z) {
            InventoryScreen.isDialogVisible = z;
        }
    }
}
