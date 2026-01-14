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
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.InventoryPersonSectionBinding;
import ru.mrlargha.commonui.databinding.LayoutGuardInventoryBinding;
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
import ru.mrlargha.commonui.elements.inventory.domain.InventoryApi;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryEditResponse;
import ru.mrlargha.commonui.elements.inventory.domain.InventoryResponse;
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
import ru.mrlargha.commonui.elements.inventory.presentation.section.person_section.InventoryPersonSection;
import ru.mrlargha.commonui.utils.ArizonaBlockType;
import ru.mrlargha.commonui.utils.ArzInventoryButtonTypes;
import ru.mrlargha.commonui.utils.ConstantsKt;
import ru.mrlargha.commonui.utils.GsonStore;
import ru.mrlargha.commonui.utils.ItemTypes;
import ru.mrlargha.commonui.utils.ItemsInfo;
import ru.mrlargha.commonui.utils.MapperKt;
import ru.mrlargha.commonui.utils.RodInventoryButtonTypes;
import ru.mrlargha.commonui.utils.RodinaBlockType;
import ru.mrlargha.commonui.utils.RodinaItemTypes;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.commonui.utils.ui.ArizonaRetrofit;
/* compiled from: InventoryScreen.kt */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ¦\u00012\u00020\u00012\u00020\u0002:\u0004¥\u0001¦\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010O\u001a\u00020PH\u0002J\b\u0010Q\u001a\u00020PH\u0002J\u0018\u0010R\u001a\u00020P2\u0006\u0010S\u001a\u00020\u00062\u0006\u0010T\u001a\u00020\u0006H\u0002J\u0010\u0010U\u001a\u00020P2\u0006\u0010V\u001a\u00020\u0013H\u0002J\u0010\u0010W\u001a\u00020P2\u0006\u0010V\u001a\u00020\u0013H\u0002J\b\u0010X\u001a\u00020PH\u0002J\b\u0010Y\u001a\u00020PH\u0002J\b\u0010Z\u001a\u00020PH\u0002J\b\u0010[\u001a\u00020PH\u0002J\u0010\u0010\\\u001a\u00020P2\u0006\u0010V\u001a\u00020\u0011H\u0002J\b\u0010]\u001a\u00020PH\u0002J\b\u0010^\u001a\u00020PH\u0002J\u0016\u0010_\u001a\u00020P2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0016\u0010a\u001a\u00020P2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\b\u0010b\u001a\u00020PH\u0002J\u0018\u0010c\u001a\u00020P2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020\u0006H\u0002J\b\u0010g\u001a\u00020PH\u0002J\b\u0010h\u001a\u00020PH\u0002J \u0010i\u001a\u00020P2\u0006\u0010j\u001a\u00020\u00062\u0006\u0010k\u001a\u00020\u00062\u0006\u0010l\u001a\u00020\u0006H\u0002J\u0016\u0010m\u001a\u00020P2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020&0\u0010H\u0002J\b\u0010n\u001a\u00020PH\u0002J\b\u0010o\u001a\u00020PH\u0002J\b\u0010p\u001a\u00020PH\u0002J\u0018\u0010q\u001a\u00020P2\u0006\u0010r\u001a\u00020s2\u0006\u0010S\u001a\u00020\u0006H\u0016J\u0010\u0010t\u001a\u00020P2\u0006\u0010u\u001a\u00020\u0006H\u0002J\u0010\u0010v\u001a\u00020P2\u0006\u0010u\u001a\u00020\u0006H\u0002J\b\u0010w\u001a\u00020PH\u0002J\b\u0010x\u001a\u00020PH\u0002J\b\u0010y\u001a\u00020PH\u0002J\u0010\u0010z\u001a\u00020P2\u0006\u0010{\u001a\u00020\u0006H\u0002J\u0010\u0010|\u001a\u00020P2\u0006\u0010{\u001a\u00020\u0006H\u0002J\u0016\u0010}\u001a\u00020P2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0002J\u0016\u0010~\u001a\u00020P2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0010\u0010\u007f\u001a\u00020P2\u0006\u0010r\u001a\u00020sH\u0002J\u000f\u0010\u0080\u0001\u001a\u00020P2\u0006\u0010r\u001a\u00020sJ\u0013\u0010\u0081\u0001\u001a\u00020P2\b\u0010V\u001a\u0004\u0018\u00010\u0011H\u0002J\t\u0010\u0082\u0001\u001a\u00020PH\u0002J\u001a\u0010\u0083\u0001\u001a\t\u0012\u0004\u0012\u00020\u00110\u0084\u00012\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0002J\u001a\u0010\u0087\u0001\u001a\u00020P2\u0006\u0010V\u001a\u00020\u00112\u0007\u0010\u0088\u0001\u001a\u000206H\u0002J\u0012\u0010\u0089\u0001\u001a\u00020P2\u0007\u0010\u0088\u0001\u001a\u000206H\u0002J\u0012\u0010\u008a\u0001\u001a\u00020P2\u0007\u0010\u0088\u0001\u001a\u000206H\u0002J\u001a\u0010\u008b\u0001\u001a\u00020P2\u0006\u0010V\u001a\u00020\u00112\u0007\u0010\u0088\u0001\u001a\u000206H\u0002J\u0012\u0010\u008c\u0001\u001a\u00020P2\u0007\u0010\u0088\u0001\u001a\u000206H\u0002J\u001a\u0010\u008d\u0001\u001a\u00020P2\u0006\u0010V\u001a\u00020\u00112\u0007\u0010\u0088\u0001\u001a\u000206H\u0002J\u0012\u0010\u008e\u0001\u001a\u00020P2\u0007\u0010\u0088\u0001\u001a\u000206H\u0002J\u0012\u0010\u008f\u0001\u001a\u00020P2\u0007\u0010\u0088\u0001\u001a\u000206H\u0002J\u0013\u0010\u0090\u0001\u001a\u00020P2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0002J\t\u0010\u0093\u0001\u001a\u00020PH\u0002J\u001a\u0010\u0094\u0001\u001a\u00020P2\u0006\u0010r\u001a\u00020\u00062\u0007\u0010\u0095\u0001\u001a\u00020\u0006H\u0016J\u001b\u0010\u0094\u0001\u001a\u00020P2\u0006\u0010r\u001a\u00020\u00062\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0016J&\u0010\u0097\u0001\u001a\u00020P2\u0007\u0010d\u001a\u00030\u0098\u00012\u0007\u0010\u0099\u0001\u001a\u00020s2\t\b\u0002\u0010\u009a\u0001\u001a\u00020\u0006H\u0002J\u0013\u0010\u009b\u0001\u001a\u00020P2\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0002J\u001b\u0010\u009e\u0001\u001a\u00020P2\u0007\u0010\u009f\u0001\u001a\u00020\u00112\u0007\u0010 \u0001\u001a\u00020\u0011H\u0002J\t\u0010¡\u0001\u001a\u00020PH\u0002J\u0019\u0010¢\u0001\u001a\u00020P2\u0006\u0010r\u001a\u00020s2\u0006\u0010S\u001a\u00020\u0006H\u0002J\u0012\u0010£\u0001\u001a\u00020P2\u0007\u0010¤\u0001\u001a\u000206H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0014\u0010\"\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010>\u001a\n @*\u0004\u0018\u00010?0?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010G\u001a\u00020H¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0011\u0010K\u001a\u00020L¢\u0006\b\n\u0000\u001a\u0004\bM\u0010N¨\u0006§\u0001"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/InventoryScreen;", "Lru/mrlargha/commonui/elements/inventory/presentation/BaseInventory;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "inventoryScreen", "Landroidx/constraintlayout/widget/ConstraintLayout;", "binding", "Lru/mrlargha/commonui/databinding/MainInventoryBinding;", "person", "Lru/mrlargha/commonui/elements/inventory/presentation/section/person_section/InventoryPersonSection;", "mainInventoryList", "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "menuItemList", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryMenuData;", "inventoryMenuAdapter", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/InventoryMenuAdapter;", "mainInventoryAdapter", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/MainInventoryAdapter;", "subInventoryAdapter", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/SubInventoryAdapter;", "getSubInventoryAdapter", "()Lru/mrlargha/commonui/elements/inventory/presentation/adapter/SubInventoryAdapter;", "accessoriesInventoryAdapter", "Lru/mrlargha/commonui/elements/inventory/presentation/adapter/UpgradesInventoryAdapter;", "getAccessoriesInventoryAdapter", "()Lru/mrlargha/commonui/elements/inventory/presentation/adapter/UpgradesInventoryAdapter;", "upgradesInventoryAdapter", "getUpgradesInventoryAdapter", "walletInventoryAdapter", "getWalletInventoryAdapter", "()Lru/mrlargha/commonui/elements/inventory/presentation/adapter/MainInventoryAdapter;", "guardInfoList", "Lru/mrlargha/commonui/elements/inventory/domain/models/GuardInfo;", "guardAccessoriesList", "guardInventoryList", "guardWeaponList", "guardNumber", "guardSubInventoryAdapter", "guardInventoryAdapter", "vehicleSubList", "vehicleTechnicalList", "vehicleVisualList", "vehicleAccessoriesAdapter", "vehicleTechAdapter", "vehicleVisualAdapter", "warehouseList", "warehouseAdapter", "isAccessoriesListVisible", "", "isUpgradesListVisible", "isWalletListVisible", "isTechnicalListVisible", "isVisualListVisible", "selectedInventoryItem", "db", "Lru/mrlargha/commonui/domain/db/AppDatabase;", "sharedPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "isArizonaType", "currentWarehouse", "vehicleVisibilityState", "currentModSkin", "currentSkin", "clickedMenuButtons", "client", "Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "getClient", "()Lru/mrlargha/commonui/utils/ui/ArizonaRetrofit;", "api", "Lru/mrlargha/commonui/elements/inventory/domain/InventoryApi;", "getApi", "()Lru/mrlargha/commonui/elements/inventory/domain/InventoryApi;", "initRetrofit", "", "initClickListeners", "sendRequestToClicks", "subId", "button", "menuClickHandlerArz", "item", "menuClickHandlerRod", "initViewSize", "observeClickBtnInventoryGuard", "initAdapters", "defaultInventoryScreen", "showSelectorDialog", "btnTechnicalPressed", "btnVisualPressed", "addItemsVehicleTechList", "list", "addItemsVehicleVisList", "guardsTypeClickListeners", "setItemBackground", "view", "Landroid/view/View;", "res", "setVisibilityBtnGuards", "defaultGuardScreen", "editMainUi", "viewParent", "margin", "viewItem", "guardInfoSetUi", "observeGuardAccessories", "initObservers", "refreshItemVisibility", "onBackendMessage", "data", "", "getArzWarehouseType", "id", "getRodWarehouseType", "showGuardScreen", "showVehicleScreen", "showWarehouseScreen", "getAndShowMenuButtonsArz", "bits", "getAndShowMenuButtonsRod", "addMenuCategories", "addInfoToDatabase", "setSkinType", "addAccessPages", "updateInfoToDatabase", "addLockedItems", "editResponseInfo", "", "inventoryList", "Lru/mrlargha/commonui/elements/inventory/domain/InventoryResponse;", "colorItem", "isColorItem", "changeGuardSubList", "changeGunImprovementsItem", "changeCaseArmorItem", "changeSkinItem", "changeVehicleSubList", "changeVisualVehicleList", "changeTechVehicleList", "addTopBars", "skin", "Lru/mrlargha/commonui/elements/inventory/domain/models/Skin;", "getUserInfo", "onUpdateData", "value", "", "observeUserSkin", "Landroid/widget/ImageView;", "url", "defaultImage", "addVehicleInfo", "userBars", "Lru/mrlargha/commonui/elements/inventory/domain/models/VehicleInfoBars;", "sendGuardData", "fromItem", "toItem", "closeAllInventoryScreens", "sendRequestTo", "setVisible", "visible", "Spawner", "Companion", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InventoryScreen extends BaseInventory implements InterfaceController {
    public static final Companion Companion = new Companion(null);
    private static boolean isDialogVisible;
    private final UpgradesInventoryAdapter accessoriesInventoryAdapter;
    private final InventoryApi api;
    private final MainInventoryBinding binding;
    private boolean clickedMenuButtons;
    private final ArizonaRetrofit client;
    private InventoryItem currentModSkin;
    private InventoryItem currentSkin;
    private int currentWarehouse;
    private final AppDatabase db;
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
    private final InventoryPersonSection person;
    private InventoryItem selectedInventoryItem;
    private final SharedPreferences sharedPref;
    private final SubInventoryAdapter subInventoryAdapter;
    private final UpgradesInventoryAdapter upgradesInventoryAdapter;
    private final UpgradesInventoryAdapter vehicleAccessoriesAdapter;
    private List<InventoryItem> vehicleSubList;
    private final UpgradesInventoryAdapter vehicleTechAdapter;
    private List<InventoryItem> vehicleTechnicalList;
    private int vehicleVisibilityState;
    private final UpgradesInventoryAdapter vehicleVisualAdapter;
    private List<InventoryItem> vehicleVisualList;
    private final MainInventoryAdapter walletInventoryAdapter;
    private final MainInventoryAdapter warehouseAdapter;
    private List<InventoryItem> warehouseList;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$0$4(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$0$5(View view) {
    }

    private final void setSkinType(String str) {
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
        InventoryPersonSectionBinding personSection = bind.personSection;
        Intrinsics.checkNotNullExpressionValue(personSection, "personSection");
        this.person = new InventoryPersonSection(this, personSection);
        this.mainInventoryList = new ArrayList();
        this.menuItemList = new ArrayList();
        this.inventoryMenuAdapter = new InventoryMenuAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda52
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
                Unit mainInventoryAdapter$lambda$0;
                mainInventoryAdapter$lambda$0 = InventoryScreen.mainInventoryAdapter$lambda$0(InventoryScreen.this, (DraggedItem) obj);
                return mainInventoryAdapter$lambda$0;
            }
        };
        RecyclerView rvMainInventory = bind.rvMainInventory;
        Intrinsics.checkNotNullExpressionValue(rvMainInventory, "rvMainInventory");
        Activity activity = targetActivity;
        this.mainInventoryAdapter = new MainInventoryAdapter(new MainInventoryAdapter.Params(function1, rvMainInventory, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit mainInventoryAdapter$lambda$1;
                mainInventoryAdapter$lambda$1 = InventoryScreen.mainInventoryAdapter$lambda$1(InventoryScreen.this, (InventoryItem) obj);
                return mainInventoryAdapter$lambda$1;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit mainInventoryAdapter$lambda$2;
                mainInventoryAdapter$lambda$2 = InventoryScreen.mainInventoryAdapter$lambda$2(InventoryScreen.this, (InventoryItem) obj);
                return mainInventoryAdapter$lambda$2;
            }
        }));
        this.subInventoryAdapter = new SubInventoryAdapter(new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit subInventoryAdapter$lambda$0;
                subInventoryAdapter$lambda$0 = InventoryScreen.subInventoryAdapter$lambda$0(InventoryScreen.this, (DraggedItem) obj);
                return subInventoryAdapter$lambda$0;
            }
        }, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit subInventoryAdapter$lambda$1;
                subInventoryAdapter$lambda$1 = InventoryScreen.subInventoryAdapter$lambda$1((InventoryItem) obj);
                return subInventoryAdapter$lambda$1;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit subInventoryAdapter$lambda$2;
                subInventoryAdapter$lambda$2 = InventoryScreen.subInventoryAdapter$lambda$2(InventoryScreen.this, (InventoryItem) obj);
                return subInventoryAdapter$lambda$2;
            }
        });
        this.accessoriesInventoryAdapter = new UpgradesInventoryAdapter(UpgradesInventoryAdapter.Companion.Type.ACCESS, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit accessoriesInventoryAdapter$lambda$0;
                accessoriesInventoryAdapter$lambda$0 = InventoryScreen.accessoriesInventoryAdapter$lambda$0(InventoryScreen.this, (DraggedItem) obj);
                return accessoriesInventoryAdapter$lambda$0;
            }
        }, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit accessoriesInventoryAdapter$lambda$1;
                accessoriesInventoryAdapter$lambda$1 = InventoryScreen.accessoriesInventoryAdapter$lambda$1((InventoryItem) obj);
                return accessoriesInventoryAdapter$lambda$1;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit accessoriesInventoryAdapter$lambda$2;
                accessoriesInventoryAdapter$lambda$2 = InventoryScreen.accessoriesInventoryAdapter$lambda$2(InventoryScreen.this, (InventoryItem) obj);
                return accessoriesInventoryAdapter$lambda$2;
            }
        });
        this.upgradesInventoryAdapter = new UpgradesInventoryAdapter(null, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda53
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit upgradesInventoryAdapter$lambda$0;
                upgradesInventoryAdapter$lambda$0 = InventoryScreen.upgradesInventoryAdapter$lambda$0(InventoryScreen.this, (DraggedItem) obj);
                return upgradesInventoryAdapter$lambda$0;
            }
        }, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda54
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit upgradesInventoryAdapter$lambda$1;
                upgradesInventoryAdapter$lambda$1 = InventoryScreen.upgradesInventoryAdapter$lambda$1((InventoryItem) obj);
                return upgradesInventoryAdapter$lambda$1;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda55
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit upgradesInventoryAdapter$lambda$2;
                upgradesInventoryAdapter$lambda$2 = InventoryScreen.upgradesInventoryAdapter$lambda$2(InventoryScreen.this, (InventoryItem) obj);
                return upgradesInventoryAdapter$lambda$2;
            }
        }, 1, null);
        RecyclerView rvWalletInventory = bind.personSection.rvWalletInventory;
        Intrinsics.checkNotNullExpressionValue(rvWalletInventory, "rvWalletInventory");
        this.walletInventoryAdapter = new MainInventoryAdapter(new MainInventoryAdapter.Params(new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit walletInventoryAdapter$lambda$0;
                walletInventoryAdapter$lambda$0 = InventoryScreen.walletInventoryAdapter$lambda$0(InventoryScreen.this, (DraggedItem) obj);
                return walletInventoryAdapter$lambda$0;
            }
        }, rvWalletInventory, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit walletInventoryAdapter$lambda$1;
                walletInventoryAdapter$lambda$1 = InventoryScreen.walletInventoryAdapter$lambda$1((InventoryItem) obj);
                return walletInventoryAdapter$lambda$1;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit walletInventoryAdapter$lambda$2;
                walletInventoryAdapter$lambda$2 = InventoryScreen.walletInventoryAdapter$lambda$2(InventoryScreen.this, (InventoryItem) obj);
                return walletInventoryAdapter$lambda$2;
            }
        }));
        this.guardInfoList = new ArrayList();
        this.guardAccessoriesList = new ArrayList();
        this.guardInventoryList = new ArrayList();
        this.guardWeaponList = new ArrayList();
        this.guardSubInventoryAdapter = new UpgradesInventoryAdapter(null, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit guardSubInventoryAdapter$lambda$0;
                guardSubInventoryAdapter$lambda$0 = InventoryScreen.guardSubInventoryAdapter$lambda$0(InventoryScreen.this, (DraggedItem) obj);
                return guardSubInventoryAdapter$lambda$0;
            }
        }, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit guardSubInventoryAdapter$lambda$1;
                guardSubInventoryAdapter$lambda$1 = InventoryScreen.guardSubInventoryAdapter$lambda$1((InventoryItem) obj);
                return guardSubInventoryAdapter$lambda$1;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit guardSubInventoryAdapter$lambda$2;
                guardSubInventoryAdapter$lambda$2 = InventoryScreen.guardSubInventoryAdapter$lambda$2(InventoryScreen.this, (InventoryItem) obj);
                return guardSubInventoryAdapter$lambda$2;
            }
        }, 1, null);
        Function1 function12 = new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit guardInventoryAdapter$lambda$0;
                guardInventoryAdapter$lambda$0 = InventoryScreen.guardInventoryAdapter$lambda$0(InventoryScreen.this, (DraggedItem) obj);
                return guardInventoryAdapter$lambda$0;
            }
        };
        RecyclerView rvGuardInventory = bind.rvGuardInventory;
        Intrinsics.checkNotNullExpressionValue(rvGuardInventory, "rvGuardInventory");
        this.guardInventoryAdapter = new MainInventoryAdapter(new MainInventoryAdapter.Params(function12, rvGuardInventory, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit guardInventoryAdapter$lambda$1;
                guardInventoryAdapter$lambda$1 = InventoryScreen.guardInventoryAdapter$lambda$1((InventoryItem) obj);
                return guardInventoryAdapter$lambda$1;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit guardInventoryAdapter$lambda$2;
                guardInventoryAdapter$lambda$2 = InventoryScreen.guardInventoryAdapter$lambda$2(InventoryScreen.this, (InventoryItem) obj);
                return guardInventoryAdapter$lambda$2;
            }
        }));
        this.vehicleSubList = new ArrayList();
        this.vehicleTechnicalList = new ArrayList();
        this.vehicleVisualList = new ArrayList();
        this.vehicleAccessoriesAdapter = new UpgradesInventoryAdapter(null, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vehicleAccessoriesAdapter$lambda$0;
                vehicleAccessoriesAdapter$lambda$0 = InventoryScreen.vehicleAccessoriesAdapter$lambda$0(InventoryScreen.this, (DraggedItem) obj);
                return vehicleAccessoriesAdapter$lambda$0;
            }
        }, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vehicleAccessoriesAdapter$lambda$1;
                vehicleAccessoriesAdapter$lambda$1 = InventoryScreen.vehicleAccessoriesAdapter$lambda$1((InventoryItem) obj);
                return vehicleAccessoriesAdapter$lambda$1;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vehicleAccessoriesAdapter$lambda$2;
                vehicleAccessoriesAdapter$lambda$2 = InventoryScreen.vehicleAccessoriesAdapter$lambda$2(InventoryScreen.this, (InventoryItem) obj);
                return vehicleAccessoriesAdapter$lambda$2;
            }
        }, 1, null);
        this.vehicleTechAdapter = new UpgradesInventoryAdapter(null, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vehicleTechAdapter$lambda$0;
                vehicleTechAdapter$lambda$0 = InventoryScreen.vehicleTechAdapter$lambda$0(InventoryScreen.this, (DraggedItem) obj);
                return vehicleTechAdapter$lambda$0;
            }
        }, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vehicleTechAdapter$lambda$1;
                vehicleTechAdapter$lambda$1 = InventoryScreen.vehicleTechAdapter$lambda$1((InventoryItem) obj);
                return vehicleTechAdapter$lambda$1;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vehicleTechAdapter$lambda$2;
                vehicleTechAdapter$lambda$2 = InventoryScreen.vehicleTechAdapter$lambda$2(InventoryScreen.this, (InventoryItem) obj);
                return vehicleTechAdapter$lambda$2;
            }
        }, 1, null);
        this.vehicleVisualAdapter = new UpgradesInventoryAdapter(null, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vehicleVisualAdapter$lambda$0;
                vehicleVisualAdapter$lambda$0 = InventoryScreen.vehicleVisualAdapter$lambda$0(InventoryScreen.this, (DraggedItem) obj);
                return vehicleVisualAdapter$lambda$0;
            }
        }, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vehicleVisualAdapter$lambda$1;
                vehicleVisualAdapter$lambda$1 = InventoryScreen.vehicleVisualAdapter$lambda$1((InventoryItem) obj);
                return vehicleVisualAdapter$lambda$1;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit vehicleVisualAdapter$lambda$2;
                vehicleVisualAdapter$lambda$2 = InventoryScreen.vehicleVisualAdapter$lambda$2(InventoryScreen.this, (InventoryItem) obj);
                return vehicleVisualAdapter$lambda$2;
            }
        }, 1, null);
        this.warehouseList = new ArrayList();
        Function1 function13 = new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit warehouseAdapter$lambda$0;
                warehouseAdapter$lambda$0 = InventoryScreen.warehouseAdapter$lambda$0(InventoryScreen.this, (DraggedItem) obj);
                return warehouseAdapter$lambda$0;
            }
        };
        RecyclerView rvWarehouse = bind.layoutWarehouse.rvWarehouse;
        Intrinsics.checkNotNullExpressionValue(rvWarehouse, "rvWarehouse");
        this.warehouseAdapter = new MainInventoryAdapter(new MainInventoryAdapter.Params(function13, rvWarehouse, activity, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit warehouseAdapter$lambda$1;
                warehouseAdapter$lambda$1 = InventoryScreen.warehouseAdapter$lambda$1((InventoryItem) obj);
                return warehouseAdapter$lambda$1;
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit warehouseAdapter$lambda$2;
                warehouseAdapter$lambda$2 = InventoryScreen.warehouseAdapter$lambda$2(InventoryScreen.this, (InventoryItem) obj);
                return warehouseAdapter$lambda$2;
            }
        }));
        this.db = AppDatabase.Companion.invoke(activity);
        SharedPreferences sharedPreferences = targetActivity.getSharedPreferences("flavorType", 0);
        this.sharedPref = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("isArizonaType", false);
        this.isArizonaType = z;
        ArizonaRetrofit arizonaRetrofit = new ArizonaRetrofit(targetActivity, i);
        this.client = arizonaRetrofit;
        this.api = (InventoryApi) ArizonaRetrofit.create$default(arizonaRetrofit, InventoryApi.class, false, null, null, 14, null);
        addViewToConstraintLayout(constraintLayout, -1, -1);
        ImageView btnWallet = bind.personSection.btnWallet;
        Intrinsics.checkNotNullExpressionValue(btnWallet, "btnWallet");
        btnWallet.setVisibility(0);
        RecyclerView rvSubInventory = bind.personSection.rvSubInventory;
        Intrinsics.checkNotNullExpressionValue(rvSubInventory, "rvSubInventory");
        rvSubInventory.setVisibility(0);
        UtilsKt.checkItemsName(activity, z);
        initAdapters();
        initClickListeners();
        setVisible(false);
        initRetrofit();
        LinearLayout root = bind.personSection.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        AppCompatImageView ivCharacterImage = bind.ivCharacterImage;
        Intrinsics.checkNotNullExpressionValue(ivCharacterImage, "ivCharacterImage");
        ivCharacterImage.setVisibility(0);
        ConstraintLayout parentLayout = bind.layoutGuards.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
        parentLayout.setVisibility(8);
        ConstraintLayout parentLayout2 = bind.layoutVehicle.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout2, "parentLayout");
        parentLayout2.setVisibility(8);
        ConstraintLayout parentLayout3 = bind.layoutWarehouse.parentLayout;
        Intrinsics.checkNotNullExpressionValue(parentLayout3, "parentLayout");
        parentLayout3.setVisibility(8);
        RecyclerView rvSubInventory2 = bind.personSection.rvSubInventory;
        Intrinsics.checkNotNullExpressionValue(rvSubInventory2, "rvSubInventory");
        rvSubInventory2.setVisibility(0);
        RecyclerView rvUpgradesInventory = bind.personSection.rvUpgradesInventory;
        Intrinsics.checkNotNullExpressionValue(rvUpgradesInventory, "rvUpgradesInventory");
        rvUpgradesInventory.setVisibility(8);
        RecyclerView rvWalletInventory2 = bind.personSection.rvWalletInventory;
        Intrinsics.checkNotNullExpressionValue(rvWalletInventory2, "rvWalletInventory");
        rvWalletInventory2.setVisibility(8);
        bind.layoutGuards.btnGuardTypeOne.setBackgroundResource(R.drawable.btn_guard_1_white);
        ProgressBar progressBar = bind.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(0);
        bind.layoutGuards.layoutGuardInfo.setOnDragListener(new View.OnDragListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda26
            @Override // android.view.View.OnDragListener
            public final boolean onDrag(View view, DragEvent dragEvent) {
                boolean _init_$lambda$0;
                _init_$lambda$0 = InventoryScreen._init_$lambda$0(InventoryScreen.this, view, dragEvent);
                return _init_$lambda$0;
            }
        });
        BaseInventory.Companion.setCurrentBackendId(i);
        bind.getRoot().post(new Runnable() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                InventoryScreen._init_$lambda$1(InventoryScreen.this);
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
    public static final Unit mainInventoryAdapter$lambda$0(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        InventoryItem inventoryItem = (InventoryItem) CollectionsKt.getOrNull(inventoryScreen.mainInventoryList, currentItem.getPosition());
        if (inventoryItem != null) {
            inventoryScreen.sendData(currentItem.getItemInfo(), inventoryItem);
            inventoryScreen.colorItem(currentItem.getItemInfo(), false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mainInventoryAdapter$lambda$1(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        inventoryScreen.colorItem(it, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mainInventoryAdapter$lambda$2(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getItem() != null) {
            inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())), 2);
            inventoryScreen.showSelectorDialog(it);
        }
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.elements.inventory.presentation.BaseInventory
    public SubInventoryAdapter getSubInventoryAdapter() {
        return this.subInventoryAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit subInventoryAdapter$lambda$0(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        inventoryScreen.sendData(currentItem.getItemInfo(), inventoryScreen.getSubCaseArmorSkinList().get(currentItem.getPosition()));
        inventoryScreen.colorItem(currentItem.getItemInfo(), false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit subInventoryAdapter$lambda$1(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit subInventoryAdapter$lambda$2(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getItem() != null) {
            inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())), 2);
            inventoryScreen.showSelectorDialog(it);
        }
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.elements.inventory.presentation.BaseInventory
    public UpgradesInventoryAdapter getAccessoriesInventoryAdapter() {
        return this.accessoriesInventoryAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit accessoriesInventoryAdapter$lambda$0(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        inventoryScreen.sendData(currentItem.getItemInfo(), inventoryScreen.getSubAccessoriesList().get(currentItem.getPosition()));
        inventoryScreen.colorItem(currentItem.getItemInfo(), false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit accessoriesInventoryAdapter$lambda$1(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit accessoriesInventoryAdapter$lambda$2(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getItem() != null) {
            inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())), 2);
            inventoryScreen.showSelectorDialog(it);
        }
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.elements.inventory.presentation.BaseInventory
    public UpgradesInventoryAdapter getUpgradesInventoryAdapter() {
        return this.upgradesInventoryAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upgradesInventoryAdapter$lambda$0(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        inventoryScreen.sendData(currentItem.getItemInfo(), inventoryScreen.getSubUpgradesList().get(currentItem.getPosition()));
        inventoryScreen.colorItem(currentItem.getItemInfo(), false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upgradesInventoryAdapter$lambda$1(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit upgradesInventoryAdapter$lambda$2(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getItem() != null) {
            inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())), 2);
            inventoryScreen.showSelectorDialog(it);
        }
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.elements.inventory.presentation.BaseInventory
    public MainInventoryAdapter getWalletInventoryAdapter() {
        return this.walletInventoryAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit walletInventoryAdapter$lambda$0(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        inventoryScreen.sendData(currentItem.getItemInfo(), inventoryScreen.getWalletInventoryList().get(currentItem.getPosition()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit walletInventoryAdapter$lambda$1(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit walletInventoryAdapter$lambda$2(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())), 2);
        inventoryScreen.showSelectorDialog(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit guardSubInventoryAdapter$lambda$0(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        GuardInfo guardInfo = (GuardInfo) CollectionsKt.getOrNull(inventoryScreen.guardInfoList, inventoryScreen.guardNumber);
        if (guardInfo != null) {
            inventoryScreen.sendGuardData(currentItem.getItemInfo(), guardInfo.getAccessoriesList().get(currentItem.getPosition()));
            inventoryScreen.colorItem(currentItem.getItemInfo(), false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit guardSubInventoryAdapter$lambda$1(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit guardSubInventoryAdapter$lambda$2(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlotGuard(it.getSlot(), it.getInventoryType(), it.getId())), 2);
        inventoryScreen.showSelectorDialog(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit guardInventoryAdapter$lambda$0(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        GuardInfo guardInfo = (GuardInfo) CollectionsKt.getOrNull(inventoryScreen.guardInfoList, inventoryScreen.guardNumber);
        if (guardInfo != null) {
            inventoryScreen.sendGuardData(currentItem.getItemInfo(), guardInfo.getInventoryList().get(currentItem.getPosition()));
            inventoryScreen.colorItem(currentItem.getItemInfo(), false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit guardInventoryAdapter$lambda$1(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit guardInventoryAdapter$lambda$2(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlotGuard(it.getSlot(), it.getInventoryType(), it.getId())), 2);
        inventoryScreen.showSelectorDialog(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vehicleAccessoriesAdapter$lambda$0(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        inventoryScreen.sendData(currentItem.getItemInfo(), inventoryScreen.vehicleSubList.get(currentItem.getPosition()));
        inventoryScreen.colorItem(currentItem.getItemInfo(), false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vehicleAccessoriesAdapter$lambda$1(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vehicleAccessoriesAdapter$lambda$2(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())), 2);
        inventoryScreen.showSelectorDialog(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vehicleTechAdapter$lambda$0(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        if (currentItem.getPosition() < 10) {
            inventoryScreen.sendData(currentItem.getItemInfo(), inventoryScreen.vehicleTechnicalList.get(currentItem.getPosition()));
        }
        inventoryScreen.colorItem(currentItem.getItemInfo(), false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vehicleTechAdapter$lambda$1(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vehicleTechAdapter$lambda$2(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())), 2);
        inventoryScreen.showSelectorDialog(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vehicleVisualAdapter$lambda$0(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        if (currentItem.getPosition() < 10) {
            inventoryScreen.sendData(currentItem.getItemInfo(), inventoryScreen.vehicleVisualList.get(currentItem.getPosition()));
        }
        inventoryScreen.colorItem(currentItem.getItemInfo(), false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vehicleVisualAdapter$lambda$1(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vehicleVisualAdapter$lambda$2(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())), 2);
        inventoryScreen.showSelectorDialog(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit warehouseAdapter$lambda$0(InventoryScreen inventoryScreen, DraggedItem currentItem) {
        Intrinsics.checkNotNullParameter(currentItem, "currentItem");
        InventoryItem inventoryItem = (InventoryItem) CollectionsKt.getOrNull(inventoryScreen.warehouseList, currentItem.getPosition());
        if (inventoryItem != null) {
            inventoryScreen.sendData(currentItem.getItemInfo(), inventoryItem);
            inventoryScreen.colorItem(currentItem.getItemInfo(), false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit warehouseAdapter$lambda$1(InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit warehouseAdapter$lambda$2(InventoryScreen inventoryScreen, InventoryItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        inventoryScreen.sendRequestTo(StringKt.toStringJson(new ChangeToSlot(it.getSlot(), it.getInventoryType())), 2);
        inventoryScreen.showSelectorDialog(it);
        return Unit.INSTANCE;
    }

    public final ArizonaRetrofit getClient() {
        return this.client;
    }

    public final InventoryApi getApi() {
        return this.api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(InventoryScreen inventoryScreen, View view, DragEvent dragEvent) {
        Integer id;
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
            GuardInfo guardInfo = (GuardInfo) CollectionsKt.getOrNull(inventoryScreen.guardInfoList, inventoryScreen.guardNumber);
            inventoryScreen.sendRequestTo(StringKt.toStringJson(new GuardItemRequest(changeFromSlot, (guardInfo == null || (id = guardInfo.getId()) == null) ? -1 : id.intValue())), 5);
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
    public static final void _init_$lambda$1(InventoryScreen inventoryScreen) {
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

    private final void initRetrofit() {
        if (UtilsKt.getItemsName().isEmpty()) {
            BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), Dispatchers.getIO(), null, new InventoryScreen$initRetrofit$1(this, null), 2, null);
        } else {
            SAMPUIElement.notifyClick$default(this, 0, 10, null, 4, null);
        }
    }

    private final void initClickListeners() {
        final MainInventoryBinding mainInventoryBinding = this.binding;
        mainInventoryBinding.layoutGuards.btnGuardMenu.btnGuardMenu.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda36
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.initClickListeners$lambda$0$0(InventoryScreen.this, view);
            }
        });
        this.binding.btnBack.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda41
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.initClickListeners$lambda$0$1(InventoryScreen.this, view);
            }
        });
        this.binding.layoutGuards.btnGuardInventory.btnGuardInventory.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.this.observeClickBtnInventoryGuard();
            }
        });
        this.binding.layoutGuards.layoutGuardInfo.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.initClickListeners$lambda$0$3(InventoryScreen.this, view);
            }
        });
        this.binding.layoutGuards.parentLayout.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda45
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.initClickListeners$lambda$0$4(view);
            }
        });
        this.binding.parentLayout.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda46
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.initClickListeners$lambda$0$5(view);
            }
        });
        this.binding.layoutVehicle.btnVehicleTechnical.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda47
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.initClickListeners$lambda$0$6(InventoryScreen.this, view);
            }
        });
        mainInventoryBinding.layoutVehicle.btnVehicleVisual.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda48
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.initClickListeners$lambda$0$7(InventoryScreen.this, mainInventoryBinding, view);
            }
        });
        mainInventoryBinding.btnStats.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda49
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.this.sendRequestToClicks(6, 0);
            }
        });
        mainInventoryBinding.btnPassport.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.this.sendRequestToClicks(6, 1);
            }
        });
        mainInventoryBinding.btnMedbook.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.this.sendRequestToClicks(6, 2);
            }
        });
        mainInventoryBinding.btnVipStatus.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.this.sendRequestToClicks(6, 3);
            }
        });
        mainInventoryBinding.btnSortItems.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.this.sendRequestToClicks(6, 4);
            }
        });
        this.binding.layoutWarehouse.etStoreMoney.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.this.sendRequestTo("", 3);
            }
        });
        guardsTypeClickListeners();
        initViewSize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$0$0(InventoryScreen inventoryScreen, View view) {
        GuardInfo guardInfo;
        int size = inventoryScreen.guardInfoList.size();
        int i = inventoryScreen.guardNumber;
        if (i < 0 || i >= size || (guardInfo = (GuardInfo) CollectionsKt.getOrNull(inventoryScreen.guardInfoList, i)) == null) {
            return;
        }
        byte[] bytes = StringKt.toStringJson(new SendId(guardInfo.getId())).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        inventoryScreen.getNotifier().clickedWrapper(UIElementID.INVENTORY_SECURITY_SCREEN.getId(), -1, 3, bytes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$0$1(InventoryScreen inventoryScreen, View view) {
        RecyclerView rvGuardInventory = inventoryScreen.binding.rvGuardInventory;
        Intrinsics.checkNotNullExpressionValue(rvGuardInventory, "rvGuardInventory");
        if (rvGuardInventory.getVisibility() == 0) {
            inventoryScreen.defaultGuardScreen();
        } else {
            inventoryScreen.defaultInventoryScreen();
            BaseInventory.Companion.setCurrentBackendId(inventoryScreen.getBackendID());
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
    public static final void initClickListeners$lambda$0$3(InventoryScreen inventoryScreen, View view) {
        GuardInfo guardInfo = (GuardInfo) CollectionsKt.getOrNull(inventoryScreen.guardInfoList, inventoryScreen.guardNumber);
        if (guardInfo != null) {
            inventoryScreen.sendRequestTo(StringKt.toStringJson(new SendId(guardInfo.getId())), 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListeners$lambda$0$6(InventoryScreen inventoryScreen, View view) {
        Log.e("inventory", "initClickListeners: " + inventoryScreen.isTechnicalListVisible);
        if (inventoryScreen.isTechnicalListVisible) {
            view.setBackgroundResource(R.drawable.btn_technical_grey);
            ConstraintLayout constraintTechVis = inventoryScreen.binding.layoutVehicle.constraintTechVis;
            Intrinsics.checkNotNullExpressionValue(constraintTechVis, "constraintTechVis");
            constraintTechVis.setVisibility(8);
            RecyclerView rvVehicleAccessories = inventoryScreen.binding.layoutVehicle.rvVehicleAccessories;
            Intrinsics.checkNotNullExpressionValue(rvVehicleAccessories, "rvVehicleAccessories");
            rvVehicleAccessories.setVisibility(0);
            LinearLayout layoutVehicleInfo = inventoryScreen.binding.layoutVehicle.layoutVehicleInfo;
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
    public static final void initClickListeners$lambda$0$7(InventoryScreen inventoryScreen, MainInventoryBinding mainInventoryBinding, View view) {
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
        IBackendNotifier notifier = getNotifier();
        int id = UIElementID.INVENTORY.getId();
        byte[] bytes = StringKt.toStringJson(new ButtonsType(i2)).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        notifier.clickedWrapper(id, -1, i, bytes);
    }

    private final void menuClickHandlerArz(InventoryMenuData inventoryMenuData) {
        getArzWarehouseType(inventoryMenuData.getMenuId());
        Log.e("inventory", "menuClickHandlerArz: " + inventoryMenuData.getMenuId());
        switch (inventoryMenuData.getMenuId()) {
            case 0:
                IBackendNotifier notifier = getNotifier();
                int id = UIElementID.INVENTORY.getId();
                byte[] bytes = "".getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                notifier.clickedWrapper(id, -1, 0, bytes);
                defaultInventoryScreen();
                BaseInventory.Companion.setCurrentBackendId(UIElementID.INVENTORY.getId());
                return;
            case 1:
                IBackendNotifier notifier2 = getNotifier();
                int id2 = UIElementID.INVENTORY_VEHICLE_SCREEN.getId();
                byte[] bytes2 = "".getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                notifier2.clickedWrapper(id2, -1, 0, bytes2);
                BaseInventory.Companion.setCurrentBackendId(UIElementID.INVENTORY_VEHICLE_SCREEN.getId());
                return;
            case 2:
                IBackendNotifier notifier3 = getNotifier();
                int id3 = UIElementID.INVENTORY_SECURITY_SCREEN.getId();
                byte[] bytes3 = "".getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
                notifier3.clickedWrapper(id3, -1, 0, bytes3);
                BaseInventory.Companion.setCurrentBackendId(UIElementID.INVENTORY_SECURITY_SCREEN.getId());
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
                IBackendNotifier notifier4 = getNotifier();
                int id4 = UIElementID.INVENTORY_WAREHOUSE.getId();
                byte[] bytes4 = StringKt.toStringJson(new BlockType(this.currentWarehouse)).getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes4, "getBytes(...)");
                notifier4.clickedWrapper(id4, -1, 0, bytes4);
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
                setVisible(false);
                return;
            default:
                return;
        }
    }

    private final void menuClickHandlerRod(InventoryMenuData inventoryMenuData) {
        getRodWarehouseType(inventoryMenuData.getMenuId());
        switch (inventoryMenuData.getMenuId()) {
            case 0:
                IBackendNotifier notifier = getNotifier();
                int id = UIElementID.INVENTORY.getId();
                byte[] bytes = "".getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                notifier.clickedWrapper(id, -1, 0, bytes);
                defaultInventoryScreen();
                BaseInventory.Companion.setCurrentBackendId(UIElementID.INVENTORY.getId());
                return;
            case 1:
                IBackendNotifier notifier2 = getNotifier();
                int id2 = UIElementID.INVENTORY_VEHICLE_SCREEN.getId();
                byte[] bytes2 = "".getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                notifier2.clickedWrapper(id2, -1, 0, bytes2);
                BaseInventory.Companion.setCurrentBackendId(UIElementID.INVENTORY_VEHICLE_SCREEN.getId());
                return;
            case 2:
                IBackendNotifier notifier3 = getNotifier();
                int id3 = UIElementID.INVENTORY_SECURITY_SCREEN.getId();
                byte[] bytes3 = "".getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
                notifier3.clickedWrapper(id3, -1, 0, bytes3);
                BaseInventory.Companion.setCurrentBackendId(UIElementID.INVENTORY_SECURITY_SCREEN.getId());
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
                IBackendNotifier notifier4 = getNotifier();
                int id4 = UIElementID.INVENTORY_WAREHOUSE.getId();
                byte[] bytes4 = StringKt.toStringJson(new BlockType(this.currentWarehouse)).getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes4, "getBytes(...)");
                notifier4.clickedWrapper(id4, -1, 0, bytes4);
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
        AppCompatTextView appCompatTextView = this.binding.tvInventory;
        GuardInfo guardInfo = (GuardInfo) CollectionsKt.getOrNull(this.guardInfoList, this.guardNumber);
        appCompatTextView.setText("ИНВЕНТАРЬ ОХРАННИКА - " + ((guardInfo == null || (r1 = guardInfo.getName()) == null) ? "" : ""));
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
        BaseInventory.Companion.setCurrentBackendId(UIElementID.INVENTORY_SECURITY_SCREEN.getId());
    }

    private final void initAdapters() {
        this.binding.rvMainInventory.setItemAnimator(null);
        this.binding.rvCategoryMenu.setAdapter(this.inventoryMenuAdapter);
        this.binding.rvMainInventory.setAdapter(this.mainInventoryAdapter);
        this.binding.personSection.rvSubInventory.setAdapter(getSubInventoryAdapter());
        this.binding.personSection.rvAccessoriesInventory.setAdapter(getAccessoriesInventoryAdapter());
        this.binding.personSection.rvUpgradesInventory.setAdapter(getUpgradesInventoryAdapter());
        this.binding.personSection.rvWalletInventory.setAdapter(getWalletInventoryAdapter());
        this.binding.layoutGuards.rvGuardSubInventory.setAdapter(this.guardSubInventoryAdapter);
        this.binding.rvGuardInventory.setAdapter(this.guardInventoryAdapter);
        this.binding.layoutVehicle.rvVehicleAccessories.setAdapter(this.vehicleAccessoriesAdapter);
        this.binding.layoutVehicle.rvVehicleTech.setAdapter(this.vehicleTechAdapter);
        this.binding.layoutVehicle.rvVehicleVisual.setAdapter(this.vehicleVisualAdapter);
        this.binding.layoutWarehouse.rvWarehouse.setAdapter(this.warehouseAdapter);
    }

    private final void defaultInventoryScreen() {
        MainInventoryBinding mainInventoryBinding = this.binding;
        LinearLayout root = mainInventoryBinding.personSection.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(0);
        AppCompatImageView ivCharacterImage = this.binding.ivCharacterImage;
        Intrinsics.checkNotNullExpressionValue(ivCharacterImage, "ivCharacterImage");
        ivCharacterImage.setVisibility(0);
        this.person.defaultPersonSection();
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
            arrayList.add(InventoryItem.copy$default(ConstantsKt.getEmptyInventoryItem(), slot + ((IntIterator) it).nextInt(), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, false, true, null, null, 7340030, null));
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
            arrayList.add(InventoryItem.copy$default(ConstantsKt.getEmptyInventoryItem(), slot + ((IntIterator) it).nextInt(), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, false, true, null, null, 7340030, null));
        }
        list.addAll(arrayList);
        this.vehicleVisualList = list;
        this.vehicleVisualAdapter.submitList(CollectionsKt.toList(list));
    }

    private final void guardsTypeClickListeners() {
        this.binding.layoutGuards.btnGuardTypeOne.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.guardsTypeClickListeners$lambda$0(InventoryScreen.this, view);
            }
        });
        this.binding.layoutGuards.btnGuardTypeTwo.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.guardsTypeClickListeners$lambda$1(InventoryScreen.this, view);
            }
        });
        this.binding.layoutGuards.btnGuardTypeThree.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda44
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.guardsTypeClickListeners$lambda$2(InventoryScreen.this, view);
            }
        });
        this.binding.layoutGuards.btnGuardTypeFour.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda51
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InventoryScreen.guardsTypeClickListeners$lambda$3(InventoryScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void guardsTypeClickListeners$lambda$0(InventoryScreen inventoryScreen, View view) {
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
    public static final void guardsTypeClickListeners$lambda$1(InventoryScreen inventoryScreen, View view) {
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
    public static final void guardsTypeClickListeners$lambda$2(InventoryScreen inventoryScreen, View view) {
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
    public static final void guardsTypeClickListeners$lambda$3(InventoryScreen inventoryScreen, View view) {
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

    private final void setItemBackground(View view, int i) {
        view.setBackgroundResource(i);
    }

    private final void setVisibilityBtnGuards() {
        GuardInfo guardInfo = (GuardInfo) CollectionsKt.getOrNull(this.guardInfoList, 0);
        if ((guardInfo != null ? guardInfo.getSkin() : null) == null) {
            this.binding.layoutGuards.btnGuardTypeOne.setEnabled(false);
            this.binding.layoutGuards.btnGuardTypeOne.setBackgroundResource(R.drawable.btn_guard_1_disabled);
        } else {
            this.binding.layoutGuards.btnGuardTypeOne.setEnabled(true);
        }
        GuardInfo guardInfo2 = (GuardInfo) CollectionsKt.getOrNull(this.guardInfoList, 1);
        if ((guardInfo2 != null ? guardInfo2.getSkin() : null) == null) {
            this.binding.layoutGuards.btnGuardTypeTwo.setEnabled(false);
            this.binding.layoutGuards.btnGuardTypeTwo.setBackgroundResource(R.drawable.btn_guard_2_disabled);
        } else {
            this.binding.layoutGuards.btnGuardTypeTwo.setEnabled(true);
        }
        GuardInfo guardInfo3 = (GuardInfo) CollectionsKt.getOrNull(this.guardInfoList, 2);
        if ((guardInfo3 != null ? guardInfo3.getSkin() : null) == null) {
            this.binding.layoutGuards.btnGuardTypeThree.setEnabled(false);
            this.binding.layoutGuards.btnGuardTypeThree.setBackgroundResource(R.drawable.btn_guard_3_disabled);
        } else {
            this.binding.layoutGuards.btnGuardTypeThree.setEnabled(true);
        }
        GuardInfo guardInfo4 = (GuardInfo) CollectionsKt.getOrNull(this.guardInfoList, 3);
        if ((guardInfo4 != null ? guardInfo4.getSkin() : null) == null) {
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
        GuardInfo guardInfo = (GuardInfo) CollectionsKt.getOrNull(list, this.guardNumber);
        if (guardInfo != null) {
            LayoutGuardInventoryBinding layoutGuardInventoryBinding = this.binding.layoutGuards;
            layoutGuardInventoryBinding.tvGuardName.setText(guardInfo.getName());
            layoutGuardInventoryBinding.tvGuardType.setText(guardInfo.getQuality());
            layoutGuardInventoryBinding.tvGuardLevel.setText(guardInfo.getLevel() + " уровень");
            layoutGuardInventoryBinding.tvGuardExpPoints.setText(guardInfo.getExp() + "/" + guardInfo.getMaxExp());
            layoutGuardInventoryBinding.tvGuardHealthCount.setText(String.valueOf(guardInfo.getHealth()));
            layoutGuardInventoryBinding.tvGuardShieldCount.setText(String.valueOf(guardInfo.getDefence()));
            layoutGuardInventoryBinding.tvGuardDamageCount.setText(String.valueOf(guardInfo.getDamage()));
            AppCompatTextView tvGuardStatus = layoutGuardInventoryBinding.tvGuardStatus;
            Intrinsics.checkNotNullExpressionValue(tvGuardStatus, "tvGuardStatus");
            AppCompatTextView appCompatTextView = tvGuardStatus;
            Integer died = guardInfo.getDied();
            appCompatTextView.setVisibility(died == null || died.intValue() != 0 ? 0 : 8);
            Integer skinBackground = guardInfo.getSkinBackground();
            if (skinBackground != null) {
                this.binding.layoutGuards.layoutGuardInfo.setCardBackgroundColor(UtilsKt.getColorTint(skinBackground.intValue()));
            }
            RecyclerView rvGuardInventory = this.binding.rvGuardInventory;
            Intrinsics.checkNotNullExpressionValue(rvGuardInventory, "rvGuardInventory");
            rvGuardInventory.setVisibility(8);
            if (this.isArizonaType) {
                str = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "projects/arizona-rp/assets/images/inventory/skins/512/" + guardInfo.getSkin() + ".webp";
            } else {
                str = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "projects/rodina-rp/assets/images/inventory/skins/512/" + guardInfo.getSkin() + ".webp";
            }
            String str2 = str;
            AppCompatImageView ivGuardSkin = this.binding.layoutGuards.ivGuardSkin;
            Intrinsics.checkNotNullExpressionValue(ivGuardSkin, "ivGuardSkin");
            observeUserSkin$default(this, ivGuardSkin, str2, 0, 4, null);
            GuardInfo guardInfo2 = (GuardInfo) CollectionsKt.getOrNull(this.guardInfoList, this.guardNumber);
            if (guardInfo2 != null) {
                IBackendNotifier notifier = getNotifier();
                int id = UIElementID.INVENTORY_SECURITY_SCREEN.getId();
                byte[] bytes = StringKt.toStringJson(new SendId(guardInfo2.getId())).getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                notifier.clickedWrapper(id, -1, 6, bytes);
            }
            setVisibilityBtnGuards();
        }
    }

    private final void observeGuardAccessories() {
        GuardInfo guardInfo = (GuardInfo) CollectionsKt.getOrNull(this.guardInfoList, this.guardNumber);
        if (guardInfo != null) {
            Integer spawned = guardInfo.getSpawned();
            if (spawned != null && spawned.intValue() == 0) {
                List<InventoryItem> accessoriesList = guardInfo.getAccessoriesList();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(accessoriesList, 10));
                for (InventoryItem inventoryItem : accessoriesList) {
                    arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, null, null, 1, null, null, null, null, 0, null, null, false, false, null, null, 8386559, null));
                }
                this.guardSubInventoryAdapter.submitList(CollectionsKt.toList(arrayList));
            } else {
                this.guardSubInventoryAdapter.submitList(CollectionsKt.toList(guardInfo.getAccessoriesList()));
            }
            this.guardInventoryAdapter.submitList(CollectionsKt.toList(guardInfo.getInventoryList()));
        }
    }

    private final void initObservers() {
        this.mainInventoryAdapter.submitList(CollectionsKt.toList(this.mainInventoryList));
        this.person.initSub(CollectionsKt.toList(getSubCaseArmorSkinList()));
    }

    private final void refreshItemVisibility() {
        Object obj;
        Iterator<T> it = this.mainInventoryList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Integer item = ((InventoryItem) obj).getItem();
            if (item != null && item.intValue() == 9250) {
                break;
            }
        }
        Log.i("Inventory", "refreshItemVisibility: " + obj);
        List<InventoryItem> list = this.mainInventoryList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (InventoryItem inventoryItem : list) {
            arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, 1, null, 0, null, null, null, null, 0, null, null, false, false, null, null, 8386047, null));
        }
        List<InventoryItem> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        this.mainInventoryList = mutableList;
        this.mainInventoryAdapter.submitList(CollectionsKt.toList(mutableList));
        List<InventoryItem> subCaseArmorSkinList = getSubCaseArmorSkinList();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(subCaseArmorSkinList, 10));
        for (InventoryItem inventoryItem2 : subCaseArmorSkinList) {
            arrayList2.add(InventoryItem.copy$default(inventoryItem2, 0, null, 0, null, null, null, null, null, null, 1, null, 0, null, null, null, null, 0, null, null, false, false, null, null, 8386047, null));
        }
        setSubCaseArmorSkinList(CollectionsKt.toMutableList((Collection) arrayList2));
        this.person.initSub(CollectionsKt.toList(getSubCaseArmorSkinList()));
        List<InventoryItem> subUpgradesList = getSubUpgradesList();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(subUpgradesList, 10));
        for (InventoryItem inventoryItem3 : subUpgradesList) {
            arrayList3.add(InventoryItem.copy$default(inventoryItem3, 0, null, 0, null, null, null, null, null, null, 1, null, 0, null, null, null, null, 0, null, null, false, false, null, null, 8386047, null));
        }
        setSubUpgradesList(CollectionsKt.toMutableList((Collection) arrayList3));
        getUpgradesInventoryAdapter().submitList(CollectionsKt.toList(getSubUpgradesList()));
        this.person.refresh();
        List<InventoryItem> walletInventoryList = getWalletInventoryList();
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(walletInventoryList, 10));
        for (InventoryItem inventoryItem4 : walletInventoryList) {
            arrayList4.add(InventoryItem.copy$default(inventoryItem4, 0, null, 0, null, null, null, null, null, null, 1, null, 0, null, null, null, null, 0, null, null, false, false, null, null, 8386047, null));
        }
        setWalletInventoryList(CollectionsKt.toMutableList((Collection) arrayList4));
        getWalletInventoryAdapter().submitList(CollectionsKt.toList(getWalletInventoryList()));
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessage(String data, int i) {
        Integer id;
        ArrayList arrayList;
        int id2;
        int id3;
        int id4;
        int id5;
        Object obj;
        int id6;
        int id7;
        int id8;
        int id9;
        int id10;
        int id11;
        List<InventoryItem> items;
        List<InventoryItem> items2;
        List<InventoryItem> items3;
        List<InventoryItem> items4;
        List<InventoryItem> items5;
        List<InventoryItem> items6;
        List<InventoryItem> items7;
        List<InventoryItem> items8;
        List<InventoryItem> items9;
        Object obj2;
        List<InventoryItem> items10;
        Object obj3;
        Object obj4;
        Object obj5;
        int id12;
        int id13;
        int id14;
        int id15;
        int id16;
        int id17;
        int id18;
        int id19;
        int id20;
        Intrinsics.checkNotNullParameter(data, "data");
        Log.d("TAG_INVENTORY", "subID: " + i + " ===== data: " + data);
        Object obj6 = null;
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
                                InventoryScreen.onBackendMessage$lambda$0(InventoryScreen.this);
                            }
                        }, 1000L);
                    }
                    CollectionsKt.removeAll((List) this.mainInventoryList, new Function1() { // from class: ru.mrlargha.commonui.elements.inventory.presentation.InventoryScreen$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj7) {
                            boolean onBackendMessage$lambda$1;
                            onBackendMessage$lambda$1 = InventoryScreen.onBackendMessage$lambda$1((InventoryItem) obj7);
                            return Boolean.valueOf(onBackendMessage$lambda$1);
                        }
                    });
                    CollectionsKt.addAll(this.mainInventoryList, editResponseInfo(inventoryResponse));
                    Iterator<T> it = this.mainInventoryList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        Integer item = ((InventoryItem) next).getItem();
                        if (item != null && item.intValue() == 9202) {
                            obj6 = next;
                            break;
                        }
                    }
                    Log.d("TAG_INVENTORY", "init mainInventoryList: " + obj6);
                } else if (type == ArizonaBlockType.BLOCK_TYPE_ATTACH.getId()) {
                    if (inventoryResponse.getItems().get(0).getSlot() == 0) {
                        getSubAccessoriesList().clear();
                        getSubCaseArmorSkinList().clear();
                        setSubAccessoriesList(CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse)));
                        Unit unit = Unit.INSTANCE;
                    } else {
                        Boolean.valueOf(getSubAccessoriesList().addAll(editResponseInfo(inventoryResponse)));
                    }
                } else {
                    if (!this.isArizonaType) {
                        id12 = RodinaBlockType.BLOCK_TYPE_IMPROV_GUN.getId();
                    } else {
                        id12 = ArizonaBlockType.BLOCK_TYPE_GUN.getId();
                    }
                    if (type == id12) {
                        if (inventoryResponse.getItems().get(0).getSlot() == 0) {
                            getSubUpgradesList().clear();
                        }
                        setSubUpgradesList(CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse)));
                    } else {
                        if (!this.isArizonaType) {
                            id13 = RodinaBlockType.BLOCK_TYPE_IMPROV.getId();
                        } else {
                            id13 = ArizonaBlockType.BLOCK_TYPE_IMPROV.getId();
                        }
                        if (type == id13) {
                            BaseInventory.setSubCaseArmorSkinList$default(this, editResponseInfo(inventoryResponse), null, 2, null);
                        } else {
                            if (!this.isArizonaType) {
                                id14 = RodinaBlockType.BLOCK_TYPE_SKIN.getId();
                            } else {
                                id14 = ArizonaBlockType.BLOCK_TYPE_SKIN.getId();
                            }
                            if (type == id14) {
                                BaseInventory.setSubCaseArmorSkinList$default(this, null, editResponseInfo(inventoryResponse), 1, null);
                            } else if (type == ArizonaBlockType.BLOCK_TYPE_MOD_SKIN.getId()) {
                                List<InventoryItem> items11 = inventoryResponse.getItems();
                                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(items11, 10));
                                for (InventoryItem inventoryItem : items11) {
                                    this.currentModSkin = inventoryItem;
                                    arrayList2.add(Unit.INSTANCE);
                                }
                                ArrayList arrayList3 = arrayList2;
                                InventoryItem inventoryItem2 = this.currentModSkin;
                                if ((inventoryItem2 != null ? inventoryItem2.getItem() : null) != null) {
                                    CollectionsKt.addAll(getSubCaseArmorSkinList(), editResponseInfo(inventoryResponse));
                                    if (getSubCaseArmorSkinList().size() >= 3) {
                                        getSubCaseArmorSkinList().set(1, getSubCaseArmorSkinList().get(2));
                                        getSubCaseArmorSkinList().set(2, getSubCaseArmorSkinList().get(1));
                                    }
                                }
                            } else {
                                if (!this.isArizonaType) {
                                    id15 = RodinaBlockType.BLOCK_TYPE_WALLET.getId();
                                } else {
                                    id15 = ArizonaBlockType.BLOCK_TYPE_WALLET.getId();
                                }
                                if (type != id15 && type != ArizonaBlockType.BLOCK_TYPE_FISHBAG.getId()) {
                                    if (type == ArizonaBlockType.BLOCK_TYPE_ACTOR_ATTACH.getId()) {
                                        this.guardAccessoriesList.addAll(editResponseInfo(inventoryResponse));
                                    } else {
                                        if (!this.isArizonaType) {
                                            id16 = RodinaBlockType.BLOCK_TYPE_ACTOR_INVENTORY.getId();
                                        } else {
                                            id16 = ArizonaBlockType.BLOCK_TYPE_ACTOR_INVENTORY.getId();
                                        }
                                        if (type == id16) {
                                            this.guardInventoryList.addAll(editResponseInfo(inventoryResponse));
                                        } else {
                                            if (!this.isArizonaType) {
                                                id17 = RodinaBlockType.BLOCK_TYPE_ACTOR_WEAPON.getId();
                                            } else {
                                                id17 = ArizonaBlockType.BLOCK_TYPE_ACTOR_WEAPON.getId();
                                            }
                                            if (type == id17) {
                                                this.guardWeaponList.clear();
                                                this.guardWeaponList = CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse));
                                            } else {
                                                if (type != ArizonaBlockType.BLOCK_TYPE_VEH_SKIN.getId() && type != ArizonaBlockType.BLOCK_TYPE_VEH_MODIFICATION.getId()) {
                                                    if (this.isArizonaType) {
                                                        id18 = ArizonaBlockType.BLOCK_TYPE_VEH_NUMBER.getId();
                                                    } else {
                                                        id18 = RodinaBlockType.BLOCK_TYPE_VEH_NUMBER.getId();
                                                    }
                                                    if (type != id18) {
                                                        if (type == RodinaBlockType.BLOCK_TYPE_VEH_SKIN.getId()) {
                                                            if (!this.isArizonaType) {
                                                                this.vehicleSubList.clear();
                                                                CollectionsKt.addAll(this.vehicleSubList, CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse)));
                                                            }
                                                        } else {
                                                            if (!this.isArizonaType) {
                                                                id19 = RodinaBlockType.BLOCK_TYPE_TECH_TUNING.getId();
                                                            } else {
                                                                id19 = ArizonaBlockType.BLOCK_TYPE_TECH_TUNING.getId();
                                                            }
                                                            if (type == id19) {
                                                                if (inventoryResponse.getItems().get(0).getSlot() == 0) {
                                                                    this.vehicleTechnicalList.clear();
                                                                }
                                                                this.vehicleTechnicalList = CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse));
                                                            } else {
                                                                if (!this.isArizonaType) {
                                                                    id20 = RodinaBlockType.BLOCK_TYPE_VISUAL_TUNING.getId();
                                                                } else {
                                                                    id20 = ArizonaBlockType.BLOCK_TYPE_VISUAL_TUNING.getId();
                                                                }
                                                                if (type == id20) {
                                                                    if (inventoryResponse.getItems().get(0).getSlot() == 0) {
                                                                        this.vehicleVisualList.clear();
                                                                        this.vehicleVisualList = CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse));
                                                                        Unit unit2 = Unit.INSTANCE;
                                                                    } else {
                                                                        Boolean.valueOf(this.vehicleVisualList.addAll(editResponseInfo(inventoryResponse)));
                                                                    }
                                                                }
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
                                    setWalletInventoryList(CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse)));
                                }
                                if (!this.isArizonaType) {
                                    setWalletInventoryList(CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse)));
                                } else {
                                    setWalletInventoryList(CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse)));
                                    getWalletInventoryAdapter().submitList(CollectionsKt.toList(getWalletInventoryList()));
                                    if (inventoryResponse.getType() == ArizonaBlockType.BLOCK_TYPE_FISHBAG.getId()) {
                                        this.person.openFishing();
                                    }
                                }
                            }
                        }
                    }
                }
                Log.d(ConstantsKt.INVENTORY_TAG, "type " + inventoryResponse.getType());
                if (this.isArizonaType && ConstantsKt.getArizonaWarehouseIds().contains(Integer.valueOf(inventoryResponse.getType()))) {
                    if (inventoryResponse.getItems().get(0).getSlot() == 0) {
                        this.warehouseList.clear();
                    }
                    CollectionsKt.addAll(this.warehouseList, CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse)));
                    BaseInventory.Companion.setCurrentBackendId(UIElementID.INVENTORY_WAREHOUSE.getId());
                    this.currentWarehouse = inventoryResponse.getType();
                    showWarehouseScreen();
                } else if (!this.isArizonaType && ConstantsKt.getRodinaWarehouseIds().contains(Integer.valueOf(inventoryResponse.getType()))) {
                    Log.d(ConstantsKt.INVENTORY_TAG, "openTrash");
                    if (inventoryResponse.getItems().get(0).getSlot() == 0) {
                        this.warehouseList.clear();
                    }
                    CollectionsKt.addAll(this.warehouseList, CollectionsKt.toMutableList((Collection) editResponseInfo(inventoryResponse)));
                    BaseInventory.Companion.setCurrentBackendId(UIElementID.INVENTORY_WAREHOUSE.getId());
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
                    defaultInventoryScreen();
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
                                r14 = 8;
                            }
                            textView.setVisibility(r14);
                            this.binding.layoutWarehouse.etStoreMoney.setText(String.valueOf(warehouseMoney.getMoney()));
                            if (this.isArizonaType) {
                                TextView etStoreMoney2 = this.binding.layoutWarehouse.etStoreMoney;
                                Intrinsics.checkNotNullExpressionValue(etStoreMoney2, "etStoreMoney");
                                UtilsKt.setDrawableEnd(etStoreMoney2, R.drawable.ic_dollar_16, getTargetActivity());
                            } else {
                                TextView etStoreMoney3 = this.binding.layoutWarehouse.etStoreMoney;
                                Intrinsics.checkNotNullExpressionValue(etStoreMoney3, "etStoreMoney");
                                UtilsKt.setDrawableEnd(etStoreMoney3, R.drawable.ic_rubble, getTargetActivity());
                            }
                        }
                    } else {
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
                    }
                } else {
                    Object fromJson5 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) GuardInfoResponse.class);
                    Intrinsics.checkNotNullExpressionValue(fromJson5, "fromJson(...)");
                    showGuardScreen();
                    List<GuardInfo> mutableList = CollectionsKt.toMutableList((Collection) ((GuardInfoResponse) fromJson5).getSecurities());
                    this.guardInfoList = mutableList;
                    List<GuardInfo> list = mutableList;
                    ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (GuardInfo guardInfo : list) {
                        ArrayList arrayList5 = new ArrayList();
                        for (Object obj7 : this.guardAccessoriesList) {
                            int id21 = ((InventoryItem) obj7).getId();
                            Integer id22 = guardInfo.getId();
                            if (id22 != null && id21 == id22.intValue()) {
                                arrayList5.add(obj7);
                            }
                        }
                        List mutableList2 = CollectionsKt.toMutableList((Collection) arrayList5);
                        ArrayList arrayList6 = new ArrayList();
                        for (Object obj8 : this.guardInventoryList) {
                            int id23 = ((InventoryItem) obj8).getId();
                            Integer id24 = guardInfo.getId();
                            if (id24 != null && id23 == id24.intValue()) {
                                arrayList6.add(obj8);
                            }
                        }
                        ArrayList arrayList7 = arrayList6;
                        Iterator<T> it2 = this.guardWeaponList.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj5 = null;
                                break;
                            }
                            obj5 = it2.next();
                            int id25 = ((InventoryItem) obj5).getId();
                            Integer id26 = guardInfo.getId();
                            if (id26 != null && id25 == id26.intValue()) {
                                break;
                            }
                        }
                        InventoryItem inventoryItem3 = (InventoryItem) obj5;
                        if (inventoryItem3 != null) {
                            mutableList2.add(inventoryItem3);
                        }
                        arrayList4.add(GuardInfo.copy$default(guardInfo, null, null, null, null, null, null, null, null, null, null, null, null, null, null, inventoryItem3, mutableList2, CollectionsKt.toMutableList((Collection) arrayList7), 16383, null));
                    }
                    List<GuardInfo> mutableList3 = CollectionsKt.toMutableList((Collection) arrayList4);
                    this.guardInfoList = mutableList3;
                    guardInfoSetUi(mutableList3);
                }
                addAccessPages(data);
            } else if (i == 2) {
                Object fromJson6 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) InventoryEditResponse.class);
                Intrinsics.checkNotNullExpressionValue(fromJson6, "fromJson(...)");
                InventoryEditResponse inventoryEditResponse = (InventoryEditResponse) fromJson6;
                int type2 = inventoryEditResponse.getType();
                List<InventoryItem> items12 = inventoryEditResponse.getItems();
                if (items12 != null) {
                    List<InventoryItem> list2 = items12;
                    ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    for (InventoryItem inventoryItem4 : list2) {
                        Iterator<T> it3 = UtilsKt.getItemsName().iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                obj4 = null;
                                break;
                            }
                            obj4 = it3.next();
                            int id27 = ((ItemsInfo) obj4).getId();
                            Integer item2 = inventoryItem4.getItem();
                            if (item2 != null && id27 == item2.intValue()) {
                                break;
                            }
                        }
                        ItemsInfo itemsInfo = (ItemsInfo) obj4;
                        arrayList8.add(InventoryItem.copy$default(inventoryItem4, 0, null, 0, null, itemsInfo != null ? Integer.valueOf(itemsInfo.getType()) : null, null, null, null, null, null, null, null, null, null, null, null, inventoryEditResponse.getType(), itemsInfo != null ? Integer.valueOf(itemsInfo.getAcs_slot()) : null, null, false, false, itemsInfo != null ? itemsInfo.getEffect() : null, null, 6094831, null));
                    }
                    arrayList = arrayList8;
                } else {
                    arrayList = null;
                }
                InventoryEditResponse inventoryEditResponse2 = new InventoryEditResponse(type2, arrayList, inventoryEditResponse.getMoney());
                int type3 = inventoryEditResponse2.getType();
                if (type3 == ArizonaBlockType.BLOCK_TYPE_MENU.getId()) {
                    ArrayList<Number> arrayList9 = new ArrayList();
                    List<InventoryItem> items13 = inventoryEditResponse2.getItems();
                    if (items13 != null) {
                        for (InventoryItem inventoryItem5 : items13) {
                            if (inventoryItem5.getSlot() < this.mainInventoryList.size() && !this.mainInventoryList.isEmpty()) {
                                Iterator<InventoryItem> it4 = this.mainInventoryList.iterator();
                                int i2 = 0;
                                while (true) {
                                    if (!it4.hasNext()) {
                                        i2 = -1;
                                        break;
                                    } else if (it4.next().getSlot() == inventoryItem5.getSlot()) {
                                        break;
                                    } else {
                                        i2++;
                                    }
                                }
                                Iterator<T> it5 = this.mainInventoryList.iterator();
                                while (true) {
                                    if (!it5.hasNext()) {
                                        obj3 = null;
                                        break;
                                    }
                                    obj3 = it5.next();
                                    if (((InventoryItem) obj3).getSlot() == inventoryItem5.getSlot()) {
                                        break;
                                    }
                                }
                                InventoryItem updateInventoryItem = UtilsKt.updateInventoryItem((InventoryItem) obj3, inventoryItem5);
                                if (i2 >= 0) {
                                    arrayList9.add(Integer.valueOf(i2));
                                    if (inventoryItem5.getItem() != null) {
                                        List<InventoryItem> list3 = this.mainInventoryList;
                                        if (updateInventoryItem == null) {
                                            updateInventoryItem = ConstantsKt.getEmptyInventoryItem();
                                        }
                                        list3.set(i2, updateInventoryItem);
                                    } else {
                                        this.mainInventoryList.set(i2, inventoryItem5);
                                    }
                                }
                            }
                        }
                        Unit unit3 = Unit.INSTANCE;
                    }
                    this.mainInventoryAdapter.submitList(CollectionsKt.toList(this.mainInventoryList));
                    for (Number number : arrayList9) {
                        this.mainInventoryAdapter.notifyItemChanged(number.intValue());
                    }
                    List<InventoryItem> items14 = inventoryEditResponse2.getItems();
                    updateInfoToDatabase(items14 != null ? items14.get(0) : null);
                } else if (type3 == ArizonaBlockType.BLOCK_TYPE_ATTACH.getId()) {
                    this.person.updateAccessories(inventoryEditResponse2);
                } else {
                    if (!this.isArizonaType) {
                        id2 = RodinaBlockType.BLOCK_TYPE_IMPROV_GUN.getId();
                    } else {
                        id2 = ArizonaBlockType.BLOCK_TYPE_GUN.getId();
                    }
                    if (type3 == id2) {
                        if (!getSubUpgradesList().isEmpty() && (items9 = inventoryEditResponse2.getItems()) != null) {
                            for (InventoryItem inventoryItem6 : items9) {
                                Iterator<InventoryItem> it6 = getSubUpgradesList().iterator();
                                int i3 = 0;
                                while (true) {
                                    if (!it6.hasNext()) {
                                        i3 = -1;
                                        break;
                                    } else if (it6.next().getSlot() == inventoryItem6.getSlot()) {
                                        break;
                                    } else {
                                        i3++;
                                    }
                                }
                                Iterator<T> it7 = getSubUpgradesList().iterator();
                                while (true) {
                                    if (!it7.hasNext()) {
                                        obj2 = null;
                                        break;
                                    }
                                    obj2 = it7.next();
                                    if (((InventoryItem) obj2).getSlot() == inventoryItem6.getSlot()) {
                                        break;
                                    }
                                }
                                InventoryItem updateInventoryItem2 = UtilsKt.updateInventoryItem((InventoryItem) obj2, inventoryItem6);
                                if (i3 >= 0) {
                                    if (inventoryItem6.getItem() != null) {
                                        List<InventoryItem> subUpgradesList = getSubUpgradesList();
                                        if (updateInventoryItem2 == null) {
                                            updateInventoryItem2 = ConstantsKt.getEmptyInventoryItem();
                                        }
                                        subUpgradesList.set(i3, updateInventoryItem2);
                                    } else {
                                        getSubUpgradesList().set(i3, inventoryItem6);
                                    }
                                }
                                getUpgradesInventoryAdapter().submitList(CollectionsKt.toList(getSubUpgradesList()));
                            }
                            Unit unit4 = Unit.INSTANCE;
                        }
                    } else {
                        if (!this.isArizonaType) {
                            id3 = RodinaBlockType.BLOCK_TYPE_IMPROV.getId();
                        } else {
                            id3 = ArizonaBlockType.BLOCK_TYPE_IMPROV.getId();
                        }
                        if (type3 == id3) {
                            List<InventoryItem> items15 = inventoryEditResponse2.getItems();
                            if (items15 != null) {
                                for (InventoryItem inventoryItem7 : items15) {
                                    Iterator<InventoryItem> it8 = getSubCaseArmorList().iterator();
                                    int i4 = 0;
                                    while (true) {
                                        if (!it8.hasNext()) {
                                            i4 = -1;
                                            break;
                                        } else if (it8.next().getSlot() == inventoryItem7.getSlot()) {
                                            break;
                                        } else {
                                            i4++;
                                        }
                                    }
                                    getSubCaseArmorList().set(i4, inventoryItem7);
                                    BaseInventory.setSubCaseArmorSkinList$default(this, getSubCaseArmorList(), null, 2, null);
                                    this.person.initSub(CollectionsKt.toList(getSubCaseArmorSkinList()));
                                }
                                Unit unit5 = Unit.INSTANCE;
                            }
                        } else {
                            if (!this.isArizonaType) {
                                id4 = RodinaBlockType.BLOCK_TYPE_SKIN.getId();
                            } else {
                                id4 = ArizonaBlockType.BLOCK_TYPE_SKIN.getId();
                            }
                            if (type3 == id4) {
                                List<InventoryItem> items16 = inventoryEditResponse2.getItems();
                                if (items16 != null) {
                                    for (InventoryItem inventoryItem8 : items16) {
                                        Iterator<InventoryItem> it9 = getSubSkinList().iterator();
                                        int i5 = 0;
                                        while (true) {
                                            if (!it9.hasNext()) {
                                                i5 = -1;
                                                break;
                                            } else if (it9.next().getSlot() == inventoryItem8.getSlot()) {
                                                break;
                                            } else {
                                                i5++;
                                            }
                                        }
                                        getSubSkinList().set(i5, inventoryItem8);
                                        BaseInventory.setSubCaseArmorSkinList$default(this, null, getSubSkinList(), 1, null);
                                        this.person.initSub(CollectionsKt.toList(getSubCaseArmorSkinList()));
                                    }
                                    Unit unit6 = Unit.INSTANCE;
                                }
                            } else if (type3 == ArizonaBlockType.BLOCK_TYPE_MOD_SKIN.getId()) {
                                List<InventoryItem> items17 = inventoryEditResponse2.getItems();
                                if (items17 != null) {
                                    for (InventoryItem inventoryItem9 : items17) {
                                        this.currentModSkin = inventoryItem9;
                                        Iterator<InventoryItem> it10 = getSubCaseArmorSkinList().iterator();
                                        int i6 = 0;
                                        while (true) {
                                            if (!it10.hasNext()) {
                                                i6 = -1;
                                                break;
                                            }
                                            InventoryItem next2 = it10.next();
                                            if (next2.getSlot() == inventoryItem9.getSlot() && (next2.getInventoryType() == inventoryEditResponse2.getType() || next2.getInventoryType() == ArizonaBlockType.BLOCK_TYPE_SKIN.getId())) {
                                                break;
                                            }
                                            i6++;
                                        }
                                        if (i6 >= 0) {
                                            getSubCaseArmorSkinList().set(i6, inventoryItem9);
                                        }
                                        this.person.initSub(CollectionsKt.toList(getSubCaseArmorSkinList()));
                                        getSubInventoryAdapter().notifyItemChanged(i6);
                                    }
                                    Unit unit7 = Unit.INSTANCE;
                                }
                            } else {
                                if (!this.isArizonaType) {
                                    id5 = RodinaBlockType.BLOCK_TYPE_WALLET.getId();
                                } else {
                                    id5 = ArizonaBlockType.BLOCK_TYPE_WALLET.getId();
                                }
                                if (type3 != id5 && type3 != ArizonaBlockType.BLOCK_TYPE_FISHBAG.getId()) {
                                    if (!this.isArizonaType) {
                                        id6 = RodinaBlockType.BLOCK_TYPE_ACTOR_WEAPON.getId();
                                    } else {
                                        id6 = ArizonaBlockType.BLOCK_TYPE_ACTOR_WEAPON.getId();
                                    }
                                    if (type3 == id6) {
                                        if (!this.guardWeaponList.isEmpty() && (items8 = inventoryEditResponse2.getItems()) != null) {
                                            for (InventoryItem inventoryItem10 : items8) {
                                                GuardInfo guardInfo2 = (GuardInfo) CollectionsKt.getOrNull(this.guardInfoList, this.guardNumber);
                                                if (guardInfo2 == null) {
                                                    return;
                                                }
                                                Iterator<InventoryItem> it11 = guardInfo2.getAccessoriesList().iterator();
                                                int i7 = 0;
                                                while (true) {
                                                    if (!it11.hasNext()) {
                                                        i7 = -1;
                                                        break;
                                                    }
                                                    InventoryItem next3 = it11.next();
                                                    if (next3.getInventoryType() == ArizonaBlockType.BLOCK_TYPE_ACTOR_WEAPON.getId() || next3.getInventoryType() == RodinaBlockType.BLOCK_TYPE_ACTOR_WEAPON.getId()) {
                                                        break;
                                                    }
                                                    i7++;
                                                }
                                                if (i7 >= 0) {
                                                    guardInfo2.getAccessoriesList().set(i7, inventoryItem10);
                                                }
                                                this.guardSubInventoryAdapter.submitList(CollectionsKt.toList(guardInfo2.getAccessoriesList()));
                                                this.guardSubInventoryAdapter.notifyItemChanged(i7);
                                            }
                                            Unit unit8 = Unit.INSTANCE;
                                        }
                                    } else if (type3 == ArizonaBlockType.BLOCK_TYPE_ACTOR_ATTACH.getId()) {
                                        GuardInfo guardInfo3 = (GuardInfo) CollectionsKt.getOrNull(this.guardInfoList, this.guardNumber);
                                        if (guardInfo3 == null) {
                                            return;
                                        }
                                        if (!guardInfo3.getAccessoriesList().isEmpty() && (items7 = inventoryEditResponse2.getItems()) != null) {
                                            for (InventoryItem inventoryItem11 : items7) {
                                                Iterator<InventoryItem> it12 = guardInfo3.getAccessoriesList().iterator();
                                                int i8 = 0;
                                                while (true) {
                                                    if (!it12.hasNext()) {
                                                        i8 = -1;
                                                        break;
                                                    }
                                                    InventoryItem next4 = it12.next();
                                                    if (next4.getSlot() == inventoryItem11.getSlot() && next4.getId() == inventoryItem11.getId()) {
                                                        break;
                                                    }
                                                    i8++;
                                                }
                                                if (i8 >= 0) {
                                                    guardInfo3.getAccessoriesList().set(i8, inventoryItem11);
                                                }
                                                this.guardSubInventoryAdapter.submitList(CollectionsKt.toList(guardInfo3.getAccessoriesList()));
                                                this.guardSubInventoryAdapter.notifyItemChanged(i8);
                                            }
                                            Unit unit9 = Unit.INSTANCE;
                                        }
                                    } else {
                                        if (!this.isArizonaType) {
                                            id7 = RodinaBlockType.BLOCK_TYPE_ACTOR_INVENTORY.getId();
                                        } else {
                                            id7 = ArizonaBlockType.BLOCK_TYPE_ACTOR_INVENTORY.getId();
                                        }
                                        if (type3 == id7) {
                                            GuardInfo guardInfo4 = (GuardInfo) CollectionsKt.getOrNull(this.guardInfoList, this.guardNumber);
                                            if (guardInfo4 == null) {
                                                return;
                                            }
                                            if (!guardInfo4.getInventoryList().isEmpty() && (items6 = inventoryEditResponse2.getItems()) != null) {
                                                for (InventoryItem inventoryItem12 : items6) {
                                                    Iterator<InventoryItem> it13 = guardInfo4.getInventoryList().iterator();
                                                    int i9 = 0;
                                                    while (true) {
                                                        if (!it13.hasNext()) {
                                                            i9 = -1;
                                                            break;
                                                        } else if (it13.next().getSlot() == inventoryItem12.getSlot()) {
                                                            break;
                                                        } else {
                                                            i9++;
                                                        }
                                                    }
                                                    if (i9 >= 0) {
                                                        guardInfo4.getInventoryList().set(i9, inventoryItem12);
                                                    }
                                                    this.guardInventoryAdapter.submitList(CollectionsKt.toList(guardInfo4.getInventoryList()));
                                                    this.guardInventoryAdapter.notifyItemChanged(i9);
                                                }
                                                Unit unit10 = Unit.INSTANCE;
                                            }
                                        } else {
                                            if (!this.isArizonaType) {
                                                id8 = RodinaBlockType.BLOCK_TYPE_VISUAL_TUNING.getId();
                                            } else {
                                                id8 = ArizonaBlockType.BLOCK_TYPE_VISUAL_TUNING.getId();
                                            }
                                            if (type3 == id8) {
                                                if (!this.vehicleVisualList.isEmpty() && (items5 = inventoryEditResponse2.getItems()) != null) {
                                                    for (InventoryItem inventoryItem13 : items5) {
                                                        Iterator<InventoryItem> it14 = this.vehicleVisualList.iterator();
                                                        int i10 = 0;
                                                        while (true) {
                                                            if (!it14.hasNext()) {
                                                                i10 = -1;
                                                                break;
                                                            } else if (it14.next().getSlot() == inventoryItem13.getSlot()) {
                                                                break;
                                                            } else {
                                                                i10++;
                                                            }
                                                        }
                                                        if (i10 >= 0) {
                                                            this.vehicleVisualList.set(i10, inventoryItem13);
                                                        }
                                                        this.vehicleVisualAdapter.submitList(CollectionsKt.toList(this.vehicleVisualList));
                                                        this.vehicleVisualAdapter.notifyItemChanged(i10);
                                                        this.vehicleVisualAdapter.notifyDataSetChanged();
                                                    }
                                                    Unit unit11 = Unit.INSTANCE;
                                                }
                                            } else {
                                                if (!this.isArizonaType) {
                                                    id9 = RodinaBlockType.BLOCK_TYPE_TECH_TUNING.getId();
                                                } else {
                                                    id9 = ArizonaBlockType.BLOCK_TYPE_TECH_TUNING.getId();
                                                }
                                                if (type3 == id9) {
                                                    if (!this.vehicleTechnicalList.isEmpty() && (items4 = inventoryEditResponse2.getItems()) != null) {
                                                        for (InventoryItem inventoryItem14 : items4) {
                                                            Iterator<InventoryItem> it15 = this.vehicleTechnicalList.iterator();
                                                            int i11 = 0;
                                                            while (true) {
                                                                if (!it15.hasNext()) {
                                                                    i11 = -1;
                                                                    break;
                                                                } else if (it15.next().getSlot() == inventoryItem14.getSlot()) {
                                                                    break;
                                                                } else {
                                                                    i11++;
                                                                }
                                                            }
                                                            if (i11 >= 0) {
                                                                this.vehicleTechnicalList.set(i11, inventoryItem14);
                                                            }
                                                            this.vehicleTechAdapter.submitList(CollectionsKt.toList(this.vehicleTechnicalList));
                                                            this.vehicleTechAdapter.notifyItemChanged(i11);
                                                            this.vehicleTechAdapter.notifyDataSetChanged();
                                                        }
                                                        Unit unit12 = Unit.INSTANCE;
                                                    }
                                                } else {
                                                    if (!this.isArizonaType) {
                                                        id10 = RodinaBlockType.BLOCK_TYPE_VEH_SKIN.getId();
                                                    } else {
                                                        id10 = ArizonaBlockType.BLOCK_TYPE_VEH_SKIN.getId();
                                                    }
                                                    if (type3 == id10) {
                                                        if (!this.vehicleSubList.isEmpty() && (items3 = inventoryEditResponse2.getItems()) != null) {
                                                            for (InventoryItem inventoryItem15 : items3) {
                                                                Iterator<InventoryItem> it16 = this.vehicleSubList.iterator();
                                                                int i12 = 0;
                                                                while (true) {
                                                                    if (!it16.hasNext()) {
                                                                        i12 = -1;
                                                                        break;
                                                                    }
                                                                    InventoryItem next5 = it16.next();
                                                                    if (next5.getInventoryType() == ArizonaBlockType.BLOCK_TYPE_VEH_SKIN.getId() || next5.getInventoryType() == RodinaBlockType.BLOCK_TYPE_VEH_SKIN.getId()) {
                                                                        break;
                                                                    }
                                                                    i12++;
                                                                }
                                                                if (i12 >= 0) {
                                                                    this.vehicleSubList.set(i12, inventoryItem15);
                                                                }
                                                                this.vehicleAccessoriesAdapter.submitList(CollectionsKt.toList(this.vehicleSubList));
                                                                this.vehicleAccessoriesAdapter.notifyItemChanged(i12);
                                                            }
                                                            Unit unit13 = Unit.INSTANCE;
                                                        }
                                                    } else if (type3 == ArizonaBlockType.BLOCK_TYPE_VEH_MODIFICATION.getId()) {
                                                        if (!this.vehicleSubList.isEmpty() && (items2 = inventoryEditResponse2.getItems()) != null) {
                                                            for (InventoryItem inventoryItem16 : items2) {
                                                                Iterator<InventoryItem> it17 = this.vehicleSubList.iterator();
                                                                int i13 = 0;
                                                                while (true) {
                                                                    if (!it17.hasNext()) {
                                                                        i13 = -1;
                                                                        break;
                                                                    } else if (it17.next().getInventoryType() == ArizonaBlockType.BLOCK_TYPE_VEH_MODIFICATION.getId()) {
                                                                        break;
                                                                    } else {
                                                                        i13++;
                                                                    }
                                                                }
                                                                if (i13 >= 0) {
                                                                    this.vehicleSubList.set(i13, inventoryItem16);
                                                                }
                                                                this.vehicleAccessoriesAdapter.submitList(CollectionsKt.toList(this.vehicleSubList));
                                                                this.vehicleAccessoriesAdapter.notifyItemChanged(i13);
                                                            }
                                                            Unit unit14 = Unit.INSTANCE;
                                                        }
                                                    } else {
                                                        if (this.isArizonaType) {
                                                            id11 = ArizonaBlockType.BLOCK_TYPE_VEH_NUMBER.getId();
                                                        } else {
                                                            id11 = RodinaBlockType.BLOCK_TYPE_VEH_NUMBER.getId();
                                                        }
                                                        if (type3 == id11 && !this.vehicleSubList.isEmpty() && (items = inventoryEditResponse2.getItems()) != null) {
                                                            for (InventoryItem inventoryItem17 : items) {
                                                                Iterator<InventoryItem> it18 = this.vehicleSubList.iterator();
                                                                int i14 = 0;
                                                                while (true) {
                                                                    if (!it18.hasNext()) {
                                                                        i14 = -1;
                                                                        break;
                                                                    }
                                                                    if (it18.next().getInventoryType() == (this.isArizonaType ? ArizonaBlockType.BLOCK_TYPE_VEH_NUMBER.getId() : RodinaBlockType.BLOCK_TYPE_VEH_NUMBER.getId())) {
                                                                        break;
                                                                    }
                                                                    i14++;
                                                                }
                                                                if (i14 >= 0) {
                                                                    this.vehicleSubList.set(i14, inventoryItem17);
                                                                }
                                                                this.vehicleAccessoriesAdapter.submitList(CollectionsKt.toList(this.vehicleSubList));
                                                                this.vehicleAccessoriesAdapter.notifyItemChanged(i14);
                                                            }
                                                            Unit unit15 = Unit.INSTANCE;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                Log.e("wallet", "onBackendMessage: " + inventoryEditResponse2.getType());
                                if (!getWalletInventoryList().isEmpty()) {
                                    this.isWalletListVisible = true;
                                    List<InventoryItem> items18 = inventoryEditResponse2.getItems();
                                    if (items18 != null) {
                                        for (InventoryItem inventoryItem18 : items18) {
                                            Iterator<InventoryItem> it19 = getWalletInventoryList().iterator();
                                            int i15 = 0;
                                            while (true) {
                                                if (!it19.hasNext()) {
                                                    i15 = -1;
                                                    break;
                                                } else if (it19.next().getSlot() == inventoryItem18.getSlot()) {
                                                    break;
                                                } else {
                                                    i15++;
                                                }
                                            }
                                            Iterator<T> it20 = getWalletInventoryList().iterator();
                                            while (true) {
                                                if (!it20.hasNext()) {
                                                    obj = null;
                                                    break;
                                                }
                                                obj = it20.next();
                                                if (((InventoryItem) obj).getSlot() == inventoryItem18.getSlot()) {
                                                    break;
                                                }
                                            }
                                            InventoryItem updateInventoryItem3 = UtilsKt.updateInventoryItem((InventoryItem) obj, inventoryItem18);
                                            if (i15 >= 0) {
                                                if (inventoryItem18.getItem() != null) {
                                                    List<InventoryItem> walletInventoryList = getWalletInventoryList();
                                                    if (updateInventoryItem3 == null) {
                                                        updateInventoryItem3 = ConstantsKt.getEmptyInventoryItem();
                                                    }
                                                    walletInventoryList.set(i15, updateInventoryItem3);
                                                } else {
                                                    getWalletInventoryList().set(i15, inventoryItem18);
                                                }
                                            }
                                        }
                                        Unit unit16 = Unit.INSTANCE;
                                    }
                                    getWalletInventoryAdapter().submitList(CollectionsKt.toList(getWalletInventoryList()));
                                }
                            }
                        }
                    }
                }
                if (this.isArizonaType && ConstantsKt.getArizonaWarehouseIds().contains(Integer.valueOf(inventoryEditResponse2.getType()))) {
                    List<InventoryItem> items19 = inventoryEditResponse2.getItems();
                    if (items19 != null) {
                        for (InventoryItem inventoryItem19 : items19) {
                            Iterator<InventoryItem> it21 = this.warehouseList.iterator();
                            int i16 = 0;
                            while (true) {
                                if (!it21.hasNext()) {
                                    i16 = -1;
                                    break;
                                } else if (it21.next().getSlot() == inventoryItem19.getSlot()) {
                                    break;
                                } else {
                                    i16++;
                                }
                            }
                            if (i16 >= 0) {
                                this.warehouseList.set(i16, inventoryItem19);
                            }
                            this.warehouseAdapter.submitList(CollectionsKt.toList(this.warehouseList));
                            this.warehouseAdapter.notifyItemChanged(i16);
                        }
                        Unit unit17 = Unit.INSTANCE;
                    }
                } else if (!this.isArizonaType && ConstantsKt.getRodinaWarehouseIds().contains(Integer.valueOf(inventoryEditResponse2.getType())) && (items10 = inventoryEditResponse2.getItems()) != null) {
                    for (InventoryItem inventoryItem20 : items10) {
                        Iterator<InventoryItem> it22 = this.warehouseList.iterator();
                        int i17 = 0;
                        while (true) {
                            if (!it22.hasNext()) {
                                i17 = -1;
                                break;
                            } else if (it22.next().getSlot() == inventoryItem20.getSlot()) {
                                break;
                            } else {
                                i17++;
                            }
                        }
                        if (i17 >= 0) {
                            this.warehouseList.set(i17, inventoryItem20);
                        }
                        this.warehouseAdapter.submitList(CollectionsKt.toList(this.warehouseList));
                        this.warehouseAdapter.notifyItemChanged(i17);
                    }
                    Unit unit18 = Unit.INSTANCE;
                }
            } else if (i == 3) {
                Object fromJson7 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) ShowDialogInfo.class);
                Intrinsics.checkNotNullExpressionValue(fromJson7, "fromJson(...)");
                ShowDialogInfo showDialogInfo = (ShowDialogInfo) fromJson7;
                if (this.guardInfoList.isEmpty()) {
                    InventoryItem inventoryItem21 = this.selectedInventoryItem;
                    if (inventoryItem21 != null) {
                        new SelectorDialog(getTargetActivity(), BaseInventory.Companion.getCurrentBackendId(), InventoryItem.copy$default(inventoryItem21, 0, null, 0, null, null, null, null, null, Integer.valueOf(showDialogInfo.getBits()), null, null, null, null, null, null, null, 0, null, null, false, false, null, null, 8388351, null), 0);
                        return;
                    }
                    return;
                }
                InventoryItem inventoryItem22 = this.selectedInventoryItem;
                if (inventoryItem22 != null) {
                    Activity targetActivity = getTargetActivity();
                    int currentBackendId = BaseInventory.Companion.getCurrentBackendId();
                    InventoryItem copy$default = InventoryItem.copy$default(inventoryItem22, 0, null, 0, null, null, null, null, null, Integer.valueOf(showDialogInfo.getBits()), null, null, null, null, null, null, null, 0, null, null, false, false, null, null, 8388351, null);
                    GuardInfo guardInfo5 = (GuardInfo) CollectionsKt.getOrNull(this.guardInfoList, this.guardNumber);
                    if (guardInfo5 != null && (id = guardInfo5.getId()) != null) {
                        r14 = id.intValue();
                    }
                    new SelectorDialog(targetActivity, currentBackendId, copy$default, r14);
                }
            } else if (i == 5) {
                setVisible(true);
                this.clickedMenuButtons = true;
            } else if (i == 6) {
                Object fromJson8 = GsonStore.INSTANCE.getGson().fromJson(data, (Class<Object>) BlockType.class);
                Intrinsics.checkNotNullExpressionValue(fromJson8, "fromJson(...)");
                int type4 = ((BlockType) fromJson8).getType();
                if (type4 == 1) {
                    RecyclerView rvAccessoriesInventory = this.binding.personSection.rvAccessoriesInventory;
                    Intrinsics.checkNotNullExpressionValue(rvAccessoriesInventory, "rvAccessoriesInventory");
                    if (rvAccessoriesInventory.getVisibility() == 0) {
                        return;
                    }
                    this.binding.personSection.btnAccessories.performClick();
                } else if (type4 == 2) {
                    RecyclerView rvUpgradesInventory = this.binding.personSection.rvUpgradesInventory;
                    Intrinsics.checkNotNullExpressionValue(rvUpgradesInventory, "rvUpgradesInventory");
                    if (rvUpgradesInventory.getVisibility() == 0) {
                        return;
                    }
                    this.binding.personSection.btnUpgrades.performClick();
                }
            } else if (i == 10) {
                Integer intOrNull = StringsKt.toIntOrNull(data);
                ConstantsKt.setHealthBar(intOrNull != null ? intOrNull.intValue() : 0);
                this.binding.ivHealthBar.setProgress(ConstantsKt.getHealthBar());
                this.binding.tvHealthCount.setText(data);
            } else if (i == 11) {
                ConstantsKt.setShieldBar(Integer.parseInt(data));
                this.binding.ivShieldBar.setProgress(ConstantsKt.getShieldBar());
                this.binding.tvShieldCount.setText(data);
            } else if (i == 12) {
                Integer intOrNull2 = StringsKt.toIntOrNull(data);
                ConstantsKt.setSatietyBar(intOrNull2 != null ? intOrNull2.intValue() : 0);
                this.binding.ivFoodBar.setProgress(ConstantsKt.getSatietyBar());
                this.binding.tvFoodCount.setText(data);
            } else if (i == UIElementID.INVENTORY_SECURITY_SCREEN.getId()) {
                if (Intrinsics.areEqual(data, "true")) {
                    setVisible(true);
                    BaseInventory.Companion.setCurrentBackendId(UIElementID.INVENTORY_SECURITY_SCREEN.getId());
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
                    BaseInventory.Companion.setCurrentBackendId(UIElementID.INVENTORY_VEHICLE_SCREEN.getId());
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
                    BaseInventory.Companion.setCurrentBackendId(UIElementID.INVENTORY_WALLET_SCREEN.getId());
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
    public static final void onBackendMessage$lambda$0(InventoryScreen inventoryScreen) {
        inventoryScreen.addLockedItems();
        inventoryScreen.mainInventoryAdapter.notifyDataSetChanged();
        inventoryScreen.addInfoToDatabase(inventoryScreen.mainInventoryList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onBackendMessage$lambda$1(InventoryItem it) {
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
        LinearLayout root = mainInventoryBinding.personSection.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
        AppCompatImageView ivCharacterImage = this.binding.ivCharacterImage;
        Intrinsics.checkNotNullExpressionValue(ivCharacterImage, "ivCharacterImage");
        ivCharacterImage.setVisibility(8);
        RecyclerView rvAccessoriesInventory = mainInventoryBinding.personSection.rvAccessoriesInventory;
        Intrinsics.checkNotNullExpressionValue(rvAccessoriesInventory, "rvAccessoriesInventory");
        rvAccessoriesInventory.setVisibility(8);
        RecyclerView rvUpgradesInventory = mainInventoryBinding.personSection.rvUpgradesInventory;
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
        LinearLayout root = mainInventoryBinding.personSection.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
        AppCompatImageView ivCharacterImage = this.binding.ivCharacterImage;
        Intrinsics.checkNotNullExpressionValue(ivCharacterImage, "ivCharacterImage");
        ivCharacterImage.setVisibility(8);
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
        LinearLayout root = mainInventoryBinding.personSection.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(8);
        AppCompatImageView ivCharacterImage = this.binding.ivCharacterImage;
        Intrinsics.checkNotNullExpressionValue(ivCharacterImage, "ivCharacterImage");
        ivCharacterImage.setVisibility(8);
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

    public final void addAccessPages(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (StringsKt.contains$default((CharSequence) data, (CharSequence) ConstantsKt.ACCESS_PAGES, false, 2, (Object) null)) {
            if (MapperKt.isJsonValid(data)) {
                BaseInventory.Companion.setAccessPages(((Skin) new GsonBuilder().setLenient().create().fromJson(data, (Class<Object>) Skin.class)).getAccessPages());
                this.person.updateSet();
                setCurrentCaseArmorSkinListArizona();
                this.person.initSub(CollectionsKt.emptyList());
                return;
            }
            throw new JsonParseException("Json is not valid");
        }
    }

    private final void updateInfoToDatabase(InventoryItem inventoryItem) {
        BuildersKt__Builders_commonKt.launch$default(this.client.getScope(), null, null, new InventoryScreen$updateInfoToDatabase$1(inventoryItem, this, null), 3, null);
    }

    private final void addLockedItems() {
        int nextMultipleOfFive = UtilsKt.nextMultipleOfFive(this.mainInventoryList.size()) - this.mainInventoryList.size();
        int slot = ((InventoryItem) CollectionsKt.last((List<? extends Object>) this.mainInventoryList)).getSlot();
        IntRange intRange = new IntRange(1, nextMultipleOfFive);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(InventoryItem.copy$default(ConstantsKt.getEmptyInventoryItem(), slot + ((IntIterator) it).nextInt(), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, false, true, null, null, 7340030, null));
        }
        this.mainInventoryList.addAll(arrayList);
        initObservers();
    }

    private final List<InventoryItem> editResponseInfo(InventoryResponse inventoryResponse) {
        List<ItemsInfo> itemsName = UtilsKt.getItemsName();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(itemsName, 10)), 16));
        for (Object obj : itemsName) {
            linkedHashMap.put(Integer.valueOf(((ItemsInfo) obj).getId()), obj);
        }
        List<InventoryItem> items = inventoryResponse.getItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
        for (InventoryItem inventoryItem : items) {
            ItemsInfo itemsInfo = (ItemsInfo) linkedHashMap.get(inventoryItem.getItem());
            int type = inventoryResponse.getType();
            String str = null;
            Integer valueOf = itemsInfo != null ? Integer.valueOf(itemsInfo.getType()) : null;
            Integer valueOf2 = itemsInfo != null ? Integer.valueOf(itemsInfo.getAcs_slot()) : null;
            if (itemsInfo != null) {
                str = itemsInfo.getEffect();
            }
            arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, valueOf, null, null, null, null, null, null, null, null, null, null, null, type, valueOf2, null, false, false, str, null, 6094831, null));
        }
        return arrayList;
    }

    private final void colorItem(InventoryItem inventoryItem, boolean z) {
        int slot = inventoryItem.getSlot();
        Log.d("person_section", "colorItem: " + slot + " " + inventoryItem.getItem_type());
        if (this.isArizonaType) {
            Integer item_type = inventoryItem.getItem_type();
            int id = ItemTypes.ITEM_TYPE_ACCESSORIES.getId();
            if (item_type != null && item_type.intValue() == id) {
                ConstraintLayout parentLayout = this.binding.layoutGuards.parentLayout;
                Intrinsics.checkNotNullExpressionValue(parentLayout, "parentLayout");
                if (parentLayout.getVisibility() != 0) {
                    this.person.changeAccessoriesItem(inventoryItem, z);
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
            this.person.changeAccessoriesItem(inventoryItem, z);
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
        GuardInfo guardInfo = (GuardInfo) CollectionsKt.getOrNull(this.guardInfoList, this.guardNumber);
        if (guardInfo != null) {
            List<InventoryItem> accessoriesList = guardInfo.getAccessoriesList();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(accessoriesList, 10));
            for (InventoryItem inventoryItem : accessoriesList) {
                if (inventoryItem.getInventoryType() == ArizonaBlockType.BLOCK_TYPE_ACTOR_WEAPON.getId() || inventoryItem.getInventoryType() == RodinaBlockType.BLOCK_TYPE_ACTOR_WEAPON.getId()) {
                    inventoryItem = InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z, false, null, null, 7864319, null);
                }
                arrayList.add(inventoryItem);
            }
            this.guardSubInventoryAdapter.submitList(CollectionsKt.toList(arrayList));
        }
    }

    private final void changeGunImprovementsItem(boolean z) {
        Object obj;
        Iterator<T> it = getSubUpgradesList().iterator();
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
        List<InventoryItem> subUpgradesList = getSubUpgradesList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subUpgradesList, 10));
        for (InventoryItem inventoryItem2 : subUpgradesList) {
            if (inventoryItem != null && inventoryItem2.getSlot() == inventoryItem.getSlot()) {
                inventoryItem2 = InventoryItem.copy$default(inventoryItem2, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z, false, null, null, 7864319, null);
            }
            arrayList.add(inventoryItem2);
        }
        setSubUpgradesList(CollectionsKt.toMutableList((Collection) arrayList));
        getUpgradesInventoryAdapter().submitList(CollectionsKt.toList(getSubUpgradesList()));
    }

    private final void changeCaseArmorItem(InventoryItem inventoryItem, boolean z) {
        List<InventoryItem> subCaseArmorSkinList = getSubCaseArmorSkinList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subCaseArmorSkinList, 10));
        for (InventoryItem inventoryItem2 : subCaseArmorSkinList) {
            int slot = inventoryItem2.getSlot();
            Integer acsSlot = inventoryItem.getAcsSlot();
            if (acsSlot != null && slot == acsSlot.intValue() && (inventoryItem2.getInventoryType() == ArizonaBlockType.BLOCK_TYPE_IMPROV.getId() || inventoryItem2.getInventoryType() == RodinaBlockType.BLOCK_TYPE_IMPROV.getId())) {
                inventoryItem2 = InventoryItem.copy$default(inventoryItem2, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z, false, null, null, 7864319, null);
            }
            arrayList.add(inventoryItem2);
        }
        setSubCaseArmorSkinList(CollectionsKt.toMutableList((Collection) arrayList));
        this.person.initSub(CollectionsKt.toList(getSubCaseArmorSkinList()));
    }

    private final void changeSkinItem(boolean z) {
        List<InventoryItem> subSkinList = getSubSkinList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subSkinList, 10));
        for (InventoryItem inventoryItem : subSkinList) {
            arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z, false, null, null, 7864319, null));
        }
        setSubSkinList(CollectionsKt.toMutableList((Collection) arrayList));
        List<InventoryItem> subCaseArmorSkinList = getSubCaseArmorSkinList();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(subCaseArmorSkinList, 10));
        for (InventoryItem inventoryItem2 : subCaseArmorSkinList) {
            if (inventoryItem2.getInventoryType() == ArizonaBlockType.BLOCK_TYPE_SKIN.getId() || inventoryItem2.getInventoryType() == RodinaBlockType.BLOCK_TYPE_SKIN.getId()) {
                inventoryItem2 = InventoryItem.copy$default(inventoryItem2, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z, false, null, null, 7864319, null);
            }
            arrayList2.add(inventoryItem2);
        }
        setSubCaseArmorSkinList(CollectionsKt.toMutableList((Collection) arrayList2));
        this.person.initSub(CollectionsKt.toList(getSubCaseArmorSkinList()));
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
                    inventoryItem2 = InventoryItem.copy$default(inventoryItem2, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z, false, null, null, 7864319, null);
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
                        inventoryItem3 = InventoryItem.copy$default(inventoryItem3, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z, false, null, null, 7864319, null);
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
                            inventoryItem4 = InventoryItem.copy$default(inventoryItem4, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z, false, null, null, 7864319, null);
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
                inventoryItem2 = InventoryItem.copy$default(inventoryItem2, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z, false, null, null, 7864319, null);
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
                inventoryItem2 = InventoryItem.copy$default(inventoryItem2, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z, false, null, null, 7864319, null);
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
            str = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "projects/arizona-rp/assets/images/inventory/skins/512/" + skin.getSkin().getModel() + ".webp";
        } else {
            str = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "projects/rodina-rp/assets/images/inventory/skins/512/" + skin.getSkin().getModel() + ".webp";
        }
        String str2 = str;
        AppCompatImageView ivCharacterImage = this.binding.ivCharacterImage;
        Intrinsics.checkNotNullExpressionValue(ivCharacterImage, "ivCharacterImage");
        observeUserSkin$default(this, ivCharacterImage, str2, 0, 4, null);
        getUserInfo();
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
            str = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "projects/arizona-rp/assets/images/inventory/vehicles/512/" + vehicleInfoBars.getSkin().getModel() + ".webp";
        } else {
            str = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null) + "projects/rodina-rp/assets/images/inventory/vehicles/512/" + vehicleInfoBars.getSkin().getModel() + ".webp";
        }
        AppCompatImageView ivVehicleBg = this.binding.layoutVehicle.ivVehicleBg;
        Intrinsics.checkNotNullExpressionValue(ivVehicleBg, "ivVehicleBg");
        observeUserSkin(ivVehicleBg, str, R.drawable.default_car_skin);
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
        IBackendNotifier notifier = getNotifier();
        int id = UIElementID.INVENTORY_SECURITY_SCREEN.getId();
        byte[] bytes = StringKt.toStringJson(new GuardInventorySendRequest(new ChangeFromSlot(inventoryItem.getSlot(), inventoryItem.getInventoryType(), i, inventoryItem.getId()), new ChangeToSlotGuard(inventoryItem2.getSlot(), inventoryItem2.getInventoryType(), inventoryItem2.getId()))).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        notifier.clickedWrapper(id, -1, 1, bytes);
    }

    private final void closeAllInventoryScreens() {
        getNotifier().setUIElementVisible(UIElementID.INVENTORY_SECURITY_SCREEN.getId(), false);
        getNotifier().setUIElementVisible(UIElementID.INVENTORY_WAREHOUSE.getId(), false);
        getNotifier().setUIElementVisible(UIElementID.INVENTORY_VEHICLE_SCREEN.getId(), false);
        getNotifier().setUIElementVisible(UIElementID.INVENTORY_WALLET_SCREEN.getId(), false);
        getNotifier().setUIElementVisible(UIElementID.INVENTORY.getId(), false);
        this.clickedMenuButtons = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendRequestTo(String str, int i) {
        Log.d("TAG_DATA", "backID: " + BaseInventory.Companion.getCurrentBackendId() + " ======= data: " + str);
        IBackendNotifier notifier = getNotifier();
        int currentBackendId = BaseInventory.Companion.getCurrentBackendId();
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        notifier.clickedWrapper(currentBackendId, -1, i, bytes);
    }

    /* compiled from: InventoryScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/InventoryScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.INVENTORY);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new InventoryScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        int i;
        Log.d("Inventory", "setVisible: " + z);
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
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/InventoryScreen$Companion;", "", "<init>", "()V", "isDialogVisible", "", "()Z", "setDialogVisible", "(Z)V", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
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
