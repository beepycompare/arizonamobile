package com.arizona.game.core;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.hardware.usb.UsbRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.InputDevice;
import androidx.core.view.InputDeviceCompat;
import com.arizona.game.core.AdaptiveTriggers;
import com.arizona.game.natives;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
/* loaded from: classes3.dex */
public final class AdaptiveTriggers {
    private static final byte[] OFF_REPORT;
    private static final BroadcastReceiver RECEIVER;
    private static final String TAG = "AdaptiveTriggers";
    private static Activity activity;
    private static long admissionGeneration;
    private static boolean approved;
    private static volatile byte[] desired;
    private static volatile Driver driver;
    private static volatile boolean foreground;
    private static UsbManager manager;
    private static String offered;
    private static volatile boolean ownsInput;
    private static long pendingAdmission;
    private static String permissionAction;
    private static boolean permissionPending;
    private static volatile long recoilExpiresAt;
    private static UsbDevice selected;
    private static volatile boolean shuttingDown;
    private static final Handler UI = new Handler(Looper.getMainLooper());
    private static final Object LIFECYCLE = new Object();

    static {
        byte[] report = AdaptiveTriggerProtocol.report(AdaptiveTriggerProtocol.OFF);
        OFF_REPORT = report;
        desired = report;
        RECEIVER = new BroadcastReceiver() { // from class: com.arizona.game.core.AdaptiveTriggers.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (AdaptiveTriggers.permissionAction.equals(intent.getAction())) {
                    if (UsbAdmissionPolicy.responseMatches(AdaptiveTriggers.permissionPending, AdaptiveTriggers.admissionGeneration, AdaptiveTriggers.pendingAdmission, intent.getLongExtra("admission", -1L), AdaptiveTriggers.selected != null ? AdaptiveTriggers.selected.getDeviceName() : null, intent.getStringExtra("devicePath"))) {
                        UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
                        if (usbDevice == null || AdaptiveTriggers.selected.getDeviceName().equals(usbDevice.getDeviceName())) {
                            AdaptiveTriggers.permissionPending = false;
                            AdaptiveTriggers.pendingAdmission = 0L;
                            AdaptiveTriggers.approved = AdaptiveTriggers.manager.hasPermission(AdaptiveTriggers.selected);
                            AdaptiveTriggers.startIfReady();
                            return;
                        }
                        return;
                    }
                    return;
                }
                UsbDevice usbDevice2 = (UsbDevice) intent.getParcelableExtra("device");
                if (usbDevice2 == null || !"android.hardware.usb.action.USB_DEVICE_DETACHED".equals(intent.getAction())) {
                    return;
                }
                Driver driver2 = AdaptiveTriggers.driver;
                boolean z = true;
                boolean z2 = driver2 != null && usbDevice2.getDeviceName().equals(driver2.device.getDeviceName());
                if (AdaptiveTriggers.selected == null || !usbDevice2.getDeviceName().equals(AdaptiveTriggers.selected.getDeviceName())) {
                    z = false;
                }
                if (z2) {
                    driver2.requestStop();
                }
                if (z) {
                    AdaptiveTriggers.selected = null;
                    AdaptiveTriggers.offered = null;
                    AdaptiveTriggers.admissionGeneration++;
                    AdaptiveTriggers.pendingAdmission = 0L;
                    AdaptiveTriggers.permissionPending = false;
                    AdaptiveTriggers.approved = false;
                    Log.i(AdaptiveTriggers.TAG, "Sony USB detached; the next pad will request its own permission");
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void register(Activity activity2) {
        activity = activity2;
        manager = (UsbManager) activity2.getSystemService("usb");
        permissionAction = activity2.getPackageName() + ".SONY_GAMEPAD_USB_PERMISSION";
        IntentFilter intentFilter = new IntentFilter(permissionAction);
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        if (Build.VERSION.SDK_INT >= 33) {
            activity2.registerReceiver(RECEIVER, intentFilter, 4);
        } else {
            activity2.registerReceiver(RECEIVER, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void unregister(Activity activity2) {
        setForeground(false);
        activity2.unregisterReceiver(RECEIVER);
        activity = null;
        selected = null;
        offered = null;
        admissionGeneration++;
        pendingAdmission = 0L;
        permissionPending = false;
        approved = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean ownsInput() {
        return ownsInput;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0016 A[Catch: all -> 0x000b, TryCatch #0 {all -> 0x000b, blocks: (B:5:0x0005, B:11:0x000e, B:15:0x0018, B:17:0x001c, B:18:0x0024, B:14:0x0016), top: B:27:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x001c A[Catch: all -> 0x000b, TryCatch #0 {all -> 0x000b, blocks: (B:5:0x0005, B:11:0x000e, B:15:0x0018, B:17:0x001c, B:18:0x0024, B:14:0x0016), top: B:27:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void setForeground(boolean z) {
        boolean z2;
        Driver driver2;
        synchronized (LIFECYCLE) {
            if (z) {
                try {
                    if (!shuttingDown) {
                        z2 = true;
                        foreground = z2;
                        driver2 = !foreground ? null : driver;
                        if (!foreground) {
                            desired = OFF_REPORT;
                            recoilExpiresAt = 0L;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            z2 = false;
            foreground = z2;
            if (!foreground) {
            }
            if (!foreground) {
            }
        }
        if (driver2 != null) {
            driver2.stopAndWait();
        }
        if (foreground) {
            startIfReady();
        }
    }

    public static void shutdown() {
        Driver driver2;
        synchronized (LIFECYCLE) {
            shuttingDown = true;
            foreground = false;
            desired = OFF_REPORT;
            recoilExpiresAt = 0L;
            driver2 = driver;
        }
        if (driver2 != null) {
            driver2.stopAndWait();
        }
    }

    public static void notifyWeaponShot(int i) {
        Driver driver2 = driver;
        if (foreground && ownsInput && !shuttingDown && driver2 != null && driver2.adaptiveTriggers) {
            recoilExpiresAt = System.nanoTime() + (Math.max(0, Math.min(70, i)) * 1000000);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void onGamepadActivity(int i) {
        UsbManager usbManager;
        if (!foreground || shuttingDown || activity == null || (usbManager = manager) == null) {
            return;
        }
        if (offered != null) {
            boolean z = false;
            for (UsbDevice usbDevice : usbManager.getDeviceList().values()) {
                z |= offered.equals(usbDevice.getDeviceName());
            }
            if (z) {
                return;
            }
            selected = null;
            offered = null;
            admissionGeneration++;
            pendingAdmission = 0L;
            permissionPending = false;
            approved = false;
        }
        InputDevice device = InputDevice.getDevice(i);
        if (device == null || !AdaptiveTriggerProtocol.supported(device.getVendorId(), device.getProductId())) {
            return;
        }
        int i2 = 0;
        for (int i3 : InputDevice.getDeviceIds()) {
            InputDevice device2 = InputDevice.getDevice(i3);
            if (device2 != null && device2.getVendorId() == device.getVendorId() && device2.getProductId() == device.getProductId() && ((device2.getSources() & 1025) == 1025 || (device2.getSources() & InputDeviceCompat.SOURCE_JOYSTICK) == 16777232)) {
                i2++;
            }
        }
        if (i2 != 1) {
            return;
        }
        UsbDevice usbDevice2 = null;
        for (UsbDevice usbDevice3 : manager.getDeviceList().values()) {
            if (usbDevice3.getVendorId() == device.getVendorId() && usbDevice3.getProductId() == device.getProductId() && hidInterface(usbDevice3) != null) {
                if (usbDevice2 != null) {
                    return;
                }
                usbDevice2 = usbDevice3;
            }
        }
        if (usbDevice2 == null) {
            return;
        }
        selected = usbDevice2;
        final String deviceName = usbDevice2.getDeviceName();
        offered = deviceName;
        final long j = admissionGeneration + 1;
        admissionGeneration = j;
        new AlertDialog.Builder(activity).setTitle("Расширенная поддержка геймпада").setMessage("Доступ к USB-геймпаду нужен для сенсорной панели и гироскопа, а на DualSense — также для адаптивных триггеров. Пока игра открыта, она временно заменит системный драйвер своим. Без разрешения геймпад продолжит работать через обычный драйвер Android.").setPositiveButton("Продолжить", new DialogInterface.OnClickListener() { // from class: com.arizona.game.core.AdaptiveTriggers$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AdaptiveTriggers.requestPermission(j, deviceName);
            }
        }).setNegativeButton("Обычное управление", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void requestPermission(long j, String str) {
        UsbDevice usbDevice;
        if (shuttingDown || activity == null || (usbDevice = selected) == null || j != admissionGeneration || !usbDevice.getDeviceName().equals(str)) {
            return;
        }
        approved = true;
        if (manager.hasPermission(selected)) {
            pendingAdmission = 0L;
            startIfReady();
            return;
        }
        permissionPending = true;
        pendingAdmission = j;
        manager.requestPermission(selected, PendingIntent.getBroadcast(activity, (int) (j ^ (j >>> 32)), new Intent(permissionAction).setPackage(activity.getPackageName()).putExtra("admission", j).putExtra("devicePath", str), 335544320));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void startIfReady() {
        UsbManager usbManager;
        synchronized (LIFECYCLE) {
            if (foreground && !shuttingDown && approved && !permissionPending && selected != null && driver == null && (usbManager = manager) != null && usbManager.hasPermission(selected)) {
                Driver driver2 = new Driver(manager, selected, admissionGeneration);
                desired = OFF_REPORT;
                recoilExpiresAt = 0L;
                driver = driver2;
                driver2.start();
                Handler handler = UI;
                Objects.requireNonNull(driver2);
                handler.postDelayed(new AdaptiveTriggers$$ExternalSyntheticLambda1(driver2), 2000L);
            }
        }
    }

    public static void sendTriggerEffect(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Driver driver2 = driver;
        if (foreground && ownsInput && driver2 != null && driver2.adaptiveTriggers) {
            byte[] report = AdaptiveTriggerProtocol.report(new int[]{i, i2, i3, i4, i5, i6, i7, i8});
            if (AdaptiveTriggerProtocol.safe(report)) {
                desired = report;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static UsbInterface hidInterface(UsbDevice usbDevice) {
        boolean dualSense = AdaptiveTriggerProtocol.dualSense(usbDevice.getVendorId(), usbDevice.getProductId());
        for (int i = 0; i < usbDevice.getInterfaceCount(); i++) {
            UsbInterface usbInterface = usbDevice.getInterface(i);
            if (usbInterface.getInterfaceClass() == 3 && endpoint(usbInterface, 128) != null && (!dualSense || endpoint(usbInterface, 0) != null)) {
                return usbInterface;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static UsbEndpoint endpoint(UsbInterface usbInterface, int i) {
        for (int i2 = 0; i2 < usbInterface.getEndpointCount(); i2++) {
            UsbEndpoint endpoint = usbInterface.getEndpoint(i2);
            if (endpoint.getType() == 3 && endpoint.getDirection() == i && endpoint.getMaxPacketSize() >= 48) {
                return endpoint;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Driver extends Thread {
        final boolean adaptiveTriggers;
        final long admission;
        boolean claimed;
        UsbDeviceConnection connection;
        final UsbDevice device;
        volatile boolean fault;
        boolean forceClaimAttempted;
        UsbInterface iface;
        UsbRequest input;
        volatile long lastInputAt;
        boolean offConfirmed;
        UsbRequest output;
        volatile boolean stopRequested;
        volatile boolean stopping;
        final DualSenseTouchpad touchpad;
        final UsbManager usbManager;

        Driver(UsbManager usbManager, UsbDevice usbDevice, long j) {
            super("Sony gamepad USB");
            this.lastInputAt = System.nanoTime();
            this.touchpad = new DualSenseTouchpad();
            this.usbManager = usbManager;
            this.device = usbDevice;
            this.admission = j;
            boolean dualSense = AdaptiveTriggerProtocol.dualSense(usbDevice.getVendorId(), usbDevice.getProductId());
            this.adaptiveTriggers = dualSense;
            this.offConfirmed = !dualSense;
        }

        void requestStop() {
            synchronized (this) {
                if (this.stopRequested) {
                    return;
                }
                this.stopRequested = true;
                if (!this.adaptiveTriggers) {
                    this.stopping = true;
                }
                AdaptiveTriggers.desired = AdaptiveTriggers.OFF_REPORT;
                AdaptiveTriggers.recoilExpiresAt = 0L;
                UsbRequest usbRequest = this.input;
                if (usbRequest != null) {
                    usbRequest.cancel();
                }
                synchronized (AdaptiveTriggers.class) {
                    natives.GamepadState(0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, true);
                    natives.SetUsbGamepadActive(false);
                }
                AdaptiveTriggers.UI.postDelayed(new Runnable() { // from class: com.arizona.game.core.AdaptiveTriggers$Driver$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AdaptiveTriggers.Driver.this.lambda$requestStop$0();
                    }
                }, 1000L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$requestStop$0() {
            if (isAlive()) {
                forceStopAndClose();
            }
        }

        void stopAndWait() {
            requestStop();
            if (Thread.currentThread() == this) {
                return;
            }
            try {
                join(750L);
                if (isAlive()) {
                    forceStopAndClose();
                    join(250L);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                forceStopAndClose();
            }
        }

        synchronized void forceStopAndClose() {
            this.stopping = true;
            UsbRequest usbRequest = this.input;
            if (usbRequest != null) {
                usbRequest.cancel();
            }
            UsbRequest usbRequest2 = this.output;
            if (usbRequest2 != null) {
                usbRequest2.cancel();
            }
            closeConnection();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void checkHealth() {
            if (!isAlive() || this.stopRequested || this.stopping) {
                return;
            }
            if (System.nanoTime() - this.lastInputAt >= 2000000000) {
                this.fault = true;
                Log.w(AdaptiveTriggers.TAG, "No Sony gamepad input for 2 seconds; restoring Android input");
                requestStop();
                return;
            }
            AdaptiveTriggers.UI.postDelayed(new AdaptiveTriggers$$ExternalSyntheticLambda1(this), 1000L);
        }

        synchronized void closeConnection() {
            if (this.connection == null) {
                return;
            }
            UsbRequest usbRequest = this.input;
            if (usbRequest != null) {
                usbRequest.cancel();
            }
            UsbRequest usbRequest2 = this.output;
            if (usbRequest2 != null) {
                usbRequest2.cancel();
            }
            if (this.forceClaimAttempted) {
                if (this.claimed) {
                    if (this.adaptiveTriggers && !this.offConfirmed) {
                        Log.w(AdaptiveTriggers.TAG, "interrupt OFF was not confirmed; control fallback=" + this.connection.controlTransfer(33, 9, 514, this.iface.getId(), AdaptiveTriggers.OFF_REPORT, AdaptiveTriggers.OFF_REPORT.length, 200));
                    }
                    Log.i(AdaptiveTriggers.TAG, "releaseInterface(" + this.iface.getId() + ")=" + this.connection.releaseInterface(this.iface));
                }
                this.claimed = false;
                int RestoreUsbGamepadDriver = natives.RestoreUsbGamepadDriver(this.connection.getFileDescriptor(), this.iface.getId());
                Log.i(AdaptiveTriggers.TAG, "kernel HID restore(" + this.iface.getId() + ")=" + RestoreUsbGamepadDriver);
                if (RestoreUsbGamepadDriver != 0) {
                    Log.w(AdaptiveTriggers.TAG, "USB HID restoration failed, errno=" + (-RestoreUsbGamepadDriver));
                }
            }
            this.connection.close();
            this.connection = null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:138:0x0261, code lost:
            r4 = -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:176:0x035a, code lost:
            throw new java.lang.IllegalStateException("Input requeue failed");
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x019f, code lost:
            if (r15[r21] == 6) goto L120;
         */
        /* JADX WARN: Removed duplicated region for block: B:350:0x04dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z;
            boolean z2;
            SonyUsbInput dualSenseUsbInput;
            ByteBuffer byteBuffer;
            ByteBuffer byteBuffer2;
            ByteBuffer byteBuffer3;
            char c;
            UsbRequest requestWait;
            boolean z3;
            char c2;
            long j;
            byte[] expireRecoil;
            boolean z4 = true;
            try {
                try {
                    try {
                        UsbInterface hidInterface = AdaptiveTriggers.hidInterface(this.device);
                        this.iface = hidInterface;
                        try {
                            if (hidInterface == null) {
                                throw new IllegalStateException("No compatible HID interface");
                            }
                            try {
                                synchronized (this) {
                                    try {
                                        UsbDeviceConnection openDevice = this.usbManager.openDevice(this.device);
                                        this.connection = openDevice;
                                        if (openDevice == null) {
                                            throw new IllegalStateException("USB open failed");
                                        }
                                        if (!this.stopRequested && !this.stopping) {
                                            this.forceClaimAttempted = true;
                                            boolean claimInterface = this.connection.claimInterface(this.iface, true);
                                            this.claimed = claimInterface;
                                            if (!claimInterface) {
                                                throw new IllegalStateException("USB claim failed");
                                            }
                                            UsbRequest usbRequest = new UsbRequest();
                                            this.input = usbRequest;
                                            if (!usbRequest.initialize(this.connection, AdaptiveTriggers.endpoint(this.iface, 128))) {
                                                throw new IllegalStateException("USB request initialization failed");
                                            }
                                            if (this.adaptiveTriggers) {
                                                UsbRequest usbRequest2 = new UsbRequest();
                                                this.output = usbRequest2;
                                                if (!usbRequest2.initialize(this.connection, AdaptiveTriggers.endpoint(this.iface, 0))) {
                                                    throw new IllegalStateException("USB output initialization failed");
                                                }
                                            }
                                            if (this.adaptiveTriggers) {
                                                try {
                                                    dualSenseUsbInput = new DualSenseUsbInput();
                                                } catch (Throwable th) {
                                                    th = th;
                                                    z2 = false;
                                                    z = false;
                                                    this.touchpad.reset();
                                                    synchronized (this) {
                                                    }
                                                }
                                            } else {
                                                dualSenseUsbInput = new DualShock4UsbInput();
                                            }
                                            if (this.adaptiveTriggers) {
                                                byte[] bArr = new byte[41];
                                                dualSenseUsbInput.calibrate(bArr, this.connection.controlTransfer(161, 1, 773, this.iface.getId(), bArr, 41, 250));
                                            } else {
                                                byte[] bArr2 = new byte[37];
                                                dualSenseUsbInput.calibrate(bArr2, this.connection.controlTransfer(161, 1, 770, this.iface.getId(), bArr2, 37, 250));
                                            }
                                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(64);
                                            ByteBuffer allocateDirect2 = this.adaptiveTriggers ? ByteBuffer.allocateDirect(48) : null;
                                            if (!this.input.queue(allocateDirect, 64)) {
                                                throw new IllegalStateException("Input queue failed");
                                            }
                                            long j2 = 0;
                                            long j3 = Long.MIN_VALUE;
                                            boolean z5 = false;
                                            int i = 0;
                                            byte[] bArr3 = null;
                                            byte[] bArr4 = null;
                                            while (true) {
                                                if (!this.stopping) {
                                                    if (!this.adaptiveTriggers && this.stopRequested) {
                                                        this.stopping = z4;
                                                        break;
                                                    }
                                                    if (this.adaptiveTriggers) {
                                                        if (this.stopRequested) {
                                                            expireRecoil = AdaptiveTriggers.OFF_REPORT;
                                                            byteBuffer = allocateDirect;
                                                            j = j2;
                                                        } else {
                                                            byteBuffer = allocateDirect;
                                                            j = j2;
                                                            expireRecoil = AdaptiveTriggerProtocol.expireRecoil(AdaptiveTriggers.desired, System.nanoTime(), AdaptiveTriggers.recoilExpiresAt);
                                                        }
                                                        if (this.stopRequested && !z5 && Arrays.equals(bArr3, AdaptiveTriggers.OFF_REPORT)) {
                                                            this.offConfirmed = z4;
                                                            this.stopping = z4;
                                                            Log.i(AdaptiveTriggers.TAG, "trigger OFF already confirmed before USB release");
                                                            break;
                                                        }
                                                        if (z5 || Arrays.equals(bArr3, expireRecoil)) {
                                                            j2 = j;
                                                        } else {
                                                            allocateDirect2.clear();
                                                            allocateDirect2.put(expireRecoil).flip();
                                                            if (!this.output.queue(allocateDirect2, expireRecoil.length)) {
                                                                throw new IllegalStateException("Output queue failed");
                                                            }
                                                            j2 = System.nanoTime();
                                                            z5 = z4;
                                                            bArr4 = expireRecoil;
                                                        }
                                                        if (z5 && System.nanoTime() - j2 > 2000000000) {
                                                            throw new IllegalStateException("Trigger output timeout");
                                                        }
                                                    } else {
                                                        byteBuffer = allocateDirect;
                                                    }
                                                    try {
                                                        long j4 = this.stopRequested ? 100L : 250L;
                                                        if (this.adaptiveTriggers) {
                                                            if (bArr3 != null) {
                                                                c2 = 11;
                                                                if (bArr3[11] != 6) {
                                                                }
                                                                j4 = Math.max(1L, Math.min(250L, ((AdaptiveTriggers.recoilExpiresAt - System.nanoTime()) + 999999) / 1000000));
                                                            } else {
                                                                c2 = 11;
                                                            }
                                                            if (z5) {
                                                                if (bArr4 != null) {
                                                                }
                                                            }
                                                        }
                                                        long j5 = j4;
                                                        int i2 = Build.VERSION.SDK_INT;
                                                        UsbDeviceConnection usbDeviceConnection = this.connection;
                                                        requestWait = i2 >= 26 ? usbDeviceConnection.requestWait(j5) : usbDeviceConnection.requestWait();
                                                    } catch (TimeoutException unused) {
                                                    }
                                                    if (this.stopping) {
                                                        break;
                                                    } else if (requestWait == null) {
                                                        throw new IllegalStateException("USB disconnected");
                                                    } else {
                                                        if (this.adaptiveTriggers && requestWait == this.output) {
                                                            if (allocateDirect2.position() != 48) {
                                                                throw new IllegalStateException("Short trigger output: " + allocateDirect2.position());
                                                            }
                                                            if (this.stopRequested && Arrays.equals(bArr4, AdaptiveTriggers.OFF_REPORT)) {
                                                                this.offConfirmed = true;
                                                                this.stopping = true;
                                                                Log.i(AdaptiveTriggers.TAG, "trigger OFF confirmed before USB release");
                                                                break;
                                                            }
                                                            byteBuffer2 = allocateDirect2;
                                                            bArr3 = bArr4;
                                                            z5 = false;
                                                        } else if (requestWait == this.input) {
                                                            if (!this.stopRequested) {
                                                                int position = byteBuffer.position();
                                                                byte[] bArr5 = new byte[position];
                                                                byteBuffer.flip();
                                                                byteBuffer3 = byteBuffer;
                                                                byteBuffer3.get(bArr5);
                                                                boolean decode = dualSenseUsbInput.decode(bArr5);
                                                                if (decode) {
                                                                    z3 = decode;
                                                                    byteBuffer2 = allocateDirect2;
                                                                    i = 0;
                                                                } else {
                                                                    int i3 = i + 1;
                                                                    if (i3 > 3 && (i3 & i) != 0) {
                                                                        z3 = decode;
                                                                        byteBuffer2 = allocateDirect2;
                                                                        i = i3;
                                                                    }
                                                                    int i4 = bArr5[0] & 255;
                                                                    z3 = decode;
                                                                    byteBuffer2 = allocateDirect2;
                                                                    Log.w(AdaptiveTriggers.TAG, "Ignoring unsupported USB input report: size=" + position + " id=" + i4 + " consecutive=" + i3 + " device=" + this.device.getDeviceName());
                                                                    i = i3;
                                                                }
                                                                synchronized (this) {
                                                                    if (!this.stopRequested && !this.stopping) {
                                                                        if (z3) {
                                                                            this.touchpad.update(dualSenseUsbInput);
                                                                            this.lastInputAt = System.nanoTime();
                                                                            synchronized (AdaptiveTriggers.class) {
                                                                                if (!AdaptiveTriggers.ownsInput) {
                                                                                    AdaptiveTriggers.ownsInput = true;
                                                                                    natives.SetUsbGamepadActive(true);
                                                                                    Log.i(AdaptiveTriggers.TAG, "Sony USB input active" + (this.adaptiveTriggers ? " + adaptive triggers: " : ": ") + this.device.getDeviceName());
                                                                                }
                                                                                long controlsSignature = dualSenseUsbInput.controlsSignature();
                                                                                if (controlsSignature != j3) {
                                                                                    natives.GamepadState(dualSenseUsbInput.buttons, dualSenseUsbInput.lx, dualSenseUsbInput.ly, dualSenseUsbInput.rx, dualSenseUsbInput.ry, dualSenseUsbInput.l2, dualSenseUsbInput.r2, false);
                                                                                    j3 = controlsSignature;
                                                                                }
                                                                                if (natives.IsGyroInputNeeded()) {
                                                                                    natives.GamepadGyroState(dualSenseUsbInput.yaw, dualSenseUsbInput.pitch);
                                                                                }
                                                                            }
                                                                        }
                                                                        byteBuffer3.clear();
                                                                        c = '@';
                                                                        if (!this.input.queue(byteBuffer3, 64)) {
                                                                            break;
                                                                        }
                                                                    }
                                                                    c = '@';
                                                                }
                                                                allocateDirect = byteBuffer3;
                                                                allocateDirect2 = byteBuffer2;
                                                                z4 = true;
                                                            }
                                                            byteBuffer2 = allocateDirect2;
                                                        } else {
                                                            byteBuffer2 = allocateDirect2;
                                                        }
                                                        byteBuffer3 = byteBuffer;
                                                        c = '@';
                                                        allocateDirect = byteBuffer3;
                                                        allocateDirect2 = byteBuffer2;
                                                        z4 = true;
                                                    }
                                                } else {
                                                    break;
                                                }
                                            }
                                            this.touchpad.reset();
                                            synchronized (this) {
                                                UsbRequest usbRequest3 = this.input;
                                                if (usbRequest3 != null) {
                                                    usbRequest3.cancel();
                                                }
                                                UsbRequest usbRequest4 = this.output;
                                                if (usbRequest4 != null) {
                                                    usbRequest4.cancel();
                                                }
                                                UsbRequest usbRequest5 = this.input;
                                                if (usbRequest5 != null) {
                                                    usbRequest5.close();
                                                }
                                                UsbRequest usbRequest6 = this.output;
                                                if (usbRequest6 != null) {
                                                    usbRequest6.close();
                                                }
                                                this.output = null;
                                                this.input = null;
                                                synchronized (AdaptiveTriggers.class) {
                                                    natives.SetUsbGamepadActive(false);
                                                    natives.GamepadState(0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, true);
                                                    AdaptiveTriggers.ownsInput = false;
                                                }
                                                closeConnection();
                                            }
                                            final boolean z6 = this.fault;
                                            AdaptiveTriggers.UI.post(new Runnable() { // from class: com.arizona.game.core.AdaptiveTriggers$Driver$$ExternalSyntheticLambda0
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    AdaptiveTriggers.Driver.this.lambda$run$1(z6);
                                                }
                                            });
                                            return;
                                        }
                                        this.touchpad.reset();
                                        synchronized (this) {
                                            UsbRequest usbRequest7 = this.input;
                                            if (usbRequest7 != null) {
                                                usbRequest7.cancel();
                                            }
                                            UsbRequest usbRequest8 = this.output;
                                            if (usbRequest8 != null) {
                                                usbRequest8.cancel();
                                            }
                                            UsbRequest usbRequest9 = this.input;
                                            if (usbRequest9 != null) {
                                                usbRequest9.close();
                                            }
                                            UsbRequest usbRequest10 = this.output;
                                            if (usbRequest10 != null) {
                                                usbRequest10.close();
                                            }
                                            this.output = null;
                                            this.input = null;
                                            synchronized (AdaptiveTriggers.class) {
                                                natives.SetUsbGamepadActive(false);
                                                natives.GamepadState(0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, true);
                                                AdaptiveTriggers.ownsInput = false;
                                            }
                                            closeConnection();
                                        }
                                        final boolean z7 = this.fault;
                                        AdaptiveTriggers.UI.post(new Runnable() { // from class: com.arizona.game.core.AdaptiveTriggers$Driver$$ExternalSyntheticLambda0
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                AdaptiveTriggers.Driver.this.lambda$run$1(z7);
                                            }
                                        });
                                    } catch (Throwable th2) {
                                        th = th2;
                                        throw th;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Exception e) {
                            e = e;
                            boolean z8 = this.stopping;
                            z2 = !z8;
                            try {
                                Log.w(AdaptiveTriggers.TAG, "Sony gamepad USB stopped; restoring Android input", e);
                                this.touchpad.reset();
                                synchronized (this) {
                                    UsbRequest usbRequest11 = this.input;
                                    if (usbRequest11 != null) {
                                        usbRequest11.cancel();
                                    }
                                    UsbRequest usbRequest12 = this.output;
                                    if (usbRequest12 != null) {
                                        usbRequest12.cancel();
                                    }
                                    UsbRequest usbRequest13 = this.input;
                                    if (usbRequest13 != null) {
                                        usbRequest13.close();
                                    }
                                    UsbRequest usbRequest14 = this.output;
                                    if (usbRequest14 != null) {
                                        usbRequest14.close();
                                    }
                                    this.output = null;
                                    this.input = null;
                                    synchronized (AdaptiveTriggers.class) {
                                        natives.SetUsbGamepadActive(false);
                                        natives.GamepadState(0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, true);
                                        AdaptiveTriggers.ownsInput = false;
                                    }
                                    closeConnection();
                                }
                                final boolean z9 = !z8 || this.fault;
                                AdaptiveTriggers.UI.post(new Runnable() { // from class: com.arizona.game.core.AdaptiveTriggers$Driver$$ExternalSyntheticLambda0
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        AdaptiveTriggers.Driver.this.lambda$run$1(z9);
                                    }
                                });
                            } catch (Throwable th4) {
                                th = th4;
                                this.touchpad.reset();
                                synchronized (this) {
                                    UsbRequest usbRequest15 = this.input;
                                    if (usbRequest15 != null) {
                                        usbRequest15.cancel();
                                    }
                                    UsbRequest usbRequest16 = this.output;
                                    if (usbRequest16 != null) {
                                        usbRequest16.cancel();
                                    }
                                    UsbRequest usbRequest17 = this.input;
                                    if (usbRequest17 != null) {
                                        usbRequest17.close();
                                    }
                                    UsbRequest usbRequest18 = this.output;
                                    if (usbRequest18 != null) {
                                        usbRequest18.close();
                                    }
                                    this.output = null;
                                    this.input = null;
                                    synchronized (AdaptiveTriggers.class) {
                                        natives.SetUsbGamepadActive(z);
                                        natives.GamepadState(0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, true);
                                        AdaptiveTriggers.ownsInput = z;
                                    }
                                    closeConnection();
                                }
                                final boolean z10 = (z2 || this.fault) ? true : z;
                                AdaptiveTriggers.UI.post(new Runnable() { // from class: com.arizona.game.core.AdaptiveTriggers$Driver$$ExternalSyntheticLambda0
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        AdaptiveTriggers.Driver.this.lambda$run$1(z10);
                                    }
                                });
                                throw th;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        z2 = false;
                        this.touchpad.reset();
                        synchronized (this) {
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    z = false;
                }
            } catch (Throwable th6) {
                th = th6;
                z = false;
                z2 = false;
                this.touchpad.reset();
                synchronized (this) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1(boolean z) {
            boolean z2;
            synchronized (AdaptiveTriggers.LIFECYCLE) {
                z2 = false;
                if (AdaptiveTriggers.driver == this) {
                    AdaptiveTriggers.driver = null;
                    if (z && UsbAdmissionPolicy.failureBelongsToCurrent(this.admission, AdaptiveTriggers.admissionGeneration)) {
                        AdaptiveTriggers.approved = false;
                    }
                    z2 = true;
                }
            }
            if (z2) {
                AdaptiveTriggers.startIfReady();
            }
        }
    }
}
