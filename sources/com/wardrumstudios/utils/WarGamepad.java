package com.wardrumstudios.utils;

import android.content.res.Configuration;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.ViewParent;
import androidx.core.view.InputDeviceCompat;
import com.bda.controller.Controller;
import com.bda.controller.ControllerListener;
import com.bda.controller.StateEvent;
import com.google.common.base.Ascii;
import java.io.PrintStream;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class WarGamepad extends WarBilling implements ControllerListener {
    private static final int COMMAND_DOWN = 2;
    private static final int COMMAND_FIRE = 16;
    private static final int COMMAND_LEFT = 8;
    private static final int COMMAND_RIGHT = 4;
    private static final int COMMAND_STATUS = 64;
    private static final int COMMAND_STOP = 32;
    private static final int COMMAND_UP = 1;
    static int MAX_GAME_PADS = 4;
    private static final int OSGT_60beat = 2;
    private static final int OSGT_AmazonGamepad = 12;
    private static final int OSGT_AmazonRemote = 11;
    private static final int OSGT_AndroidTV = 13;
    private static final int OSGT_Gamestop = 3;
    private static final int OSGT_Generic = 5;
    private static final int OSGT_IOSExtended = 9;
    private static final int OSGT_IOSSimple = 10;
    private static final int OSGT_Moga = 4;
    private static final int OSGT_MogaPro = 7;
    private static final int OSGT_Nyko = 6;
    private static final int OSGT_PS3 = 8;
    private static final int OSGT_Xbox360 = 0;
    private static final int OSGT_XperiaPlay = 1;
    private static final int OSX360_A = 1;
    private static final int OSX360_AXIS_L2 = 4;
    private static final int OSX360_AXIS_R2 = 5;
    private static final int OSX360_AXIS_X1 = 0;
    private static final int OSX360_AXIS_X2 = 2;
    private static final int OSX360_AXIS_Y1 = 1;
    private static final int OSX360_AXIS_Y2 = 3;
    private static final int OSX360_B = 2;
    private static final int OSX360_BACK = 32;
    private static final int OSX360_DPADDOWN = 512;
    private static final int OSX360_DPADLEFT = 1024;
    private static final int OSX360_DPADRIGHT = 2048;
    private static final int OSX360_DPADUP = 256;
    private static final int OSX360_L1 = 64;
    private static final int OSX360_L3 = 4096;
    private static final int OSX360_R1 = 128;
    private static final int OSX360_R3 = 8192;
    private static final int OSX360_START = 16;
    private static final int OSX360_X = 4;
    private static final int OSX360_Y = 8;
    private static final int OSXP_BACK = 16384;
    private static final int OSXP_GP_MENU = 32768;
    private static final int OSXP_MENU = 4096;
    private static final int OSXP_SEARCH = 8192;
    private static final String TAG = "WarGamepad";
    public GamePad[] GamePads;
    protected boolean IsAndroidTV = false;
    Controller mogaController = null;

    /* loaded from: classes4.dex */
    public class GamePad {
        public boolean GamepadTouchReversed;
        int deviceId;
        private boolean isXperia;
        public long lastConnect;
        public long lastDisconnect;
        private UsbDeviceConnection mGamepadConnection;
        private UsbDevice mGamepadDevice;
        private UsbEndpoint mGamepadEndpointIntr;
        private Thread mGamepadThread;
        private InputDevice mLastGamepadInputDevice;
        public int numGamepadTouchSamples;
        boolean active = false;
        public int GamepadType = -1;
        public float[] GamepadAxes = new float[6];
        public int[] GamepadTouches = new int[16];
        public int GamepadDpadHack = 0;
        public int GamepadButtonMask = 0;
        boolean mightBeNyko = false;
        int NykoCheckHacks = 0;
        boolean is360 = true;
        boolean DpadIsAxis = false;
        public boolean reportPS3as360 = true;
        Controller mogaController = null;
        float mobiX = 0.0f;
        float mobiY = 0.0f;

        public GamePad() {
        }
    }

    private void ClearBadJoystickAxis(GamePad gamePad) {
        if (gamePad.GamepadAxes[0] == -1.0f && gamePad.GamepadAxes[1] == -1.0f && gamePad.GamepadAxes[2] == -1.0f && gamePad.GamepadAxes[3] == -1.0f) {
            System.out.println("Clearing Bad Joystick Axis");
            gamePad.GamepadAxes[0] = 0.0f;
            gamePad.GamepadAxes[1] = 0.0f;
            gamePad.GamepadAxes[2] = 0.0f;
            gamePad.GamepadAxes[3] = 0.0f;
            gamePad.GamepadType = -1;
        }
    }

    private static boolean IsValidAxis(MotionEvent motionEvent, InputDevice inputDevice, int i) {
        return inputDevice.getMotionRange(i, motionEvent.getSource()) != null;
    }

    private static float getCenteredAxis(MotionEvent motionEvent, InputDevice inputDevice, int i, int i2) {
        InputDevice.MotionRange motionRange = inputDevice.getMotionRange(i, motionEvent.getSource());
        if (motionRange != null) {
            float flat = motionRange.getFlat();
            float axisValue = i2 < 0 ? motionEvent.getAxisValue(i) : motionEvent.getHistoricalAxisValue(i, i2);
            if (Math.abs(axisValue) > flat) {
                return axisValue;
            }
            return 0.0f;
        }
        return 0.0f;
    }

    private void processJoystickInput(MotionEvent motionEvent, int i) {
        int GetDeviceIndex = GetDeviceIndex(motionEvent.getDeviceId(), motionEvent.getSource());
        if (GetDeviceIndex == -1) {
            GetDeviceIndex = GetFreeIndex(motionEvent.getDeviceId(), motionEvent.getDevice() != null ? motionEvent.getDevice().getSources() : 0);
            if (GetDeviceIndex == -1) {
                if ((motionEvent.getSource() & 16) != 0) {
                    System.out.println("********************ERROR********* cannot assign controller");
                    return;
                }
                return;
            }
        }
        GamePad gamePad = this.GamePads[GetDeviceIndex];
        gamePad.GamepadAxes[0] = getCenteredAxis(motionEvent, gamePad.mLastGamepadInputDevice, 0, i);
        gamePad.GamepadAxes[1] = getCenteredAxis(motionEvent, gamePad.mLastGamepadInputDevice, 1, i);
        gamePad.GamepadAxes[2] = getCenteredAxis(motionEvent, gamePad.mLastGamepadInputDevice, 11, i);
        gamePad.GamepadAxes[3] = getCenteredAxis(motionEvent, gamePad.mLastGamepadInputDevice, 14, i);
        if (IsValidAxis(motionEvent, gamePad.mLastGamepadInputDevice, 17) || IsValidAxis(motionEvent, gamePad.mLastGamepadInputDevice, 23)) {
            float centeredAxis = getCenteredAxis(motionEvent, gamePad.mLastGamepadInputDevice, 17, i);
            if (centeredAxis == 0.0f) {
                float[] fArr = gamePad.GamepadAxes;
                float centeredAxis2 = getCenteredAxis(motionEvent, gamePad.mLastGamepadInputDevice, 23, i);
                fArr[4] = centeredAxis2;
                centeredAxis = centeredAxis2;
            }
            gamePad.GamepadAxes[4] = centeredAxis;
        }
        if (IsValidAxis(motionEvent, gamePad.mLastGamepadInputDevice, 18) || IsValidAxis(motionEvent, gamePad.mLastGamepadInputDevice, 22)) {
            float centeredAxis3 = getCenteredAxis(motionEvent, gamePad.mLastGamepadInputDevice, 18, i);
            if (centeredAxis3 == 0.0f) {
                float[] fArr2 = gamePad.GamepadAxes;
                float centeredAxis4 = getCenteredAxis(motionEvent, gamePad.mLastGamepadInputDevice, 22, i);
                fArr2[5] = centeredAxis4;
                centeredAxis3 = centeredAxis4;
            }
            gamePad.GamepadAxes[5] = centeredAxis3;
        }
        if (gamePad.GamepadType == 6 || SystemClock.uptimeMillis() - gamePad.lastConnect <= 1000) {
            return;
        }
        float centeredAxis5 = getCenteredAxis(motionEvent, gamePad.mLastGamepadInputDevice, 15, i);
        float centeredAxis6 = getCenteredAxis(motionEvent, gamePad.mLastGamepadInputDevice, 16, i);
        if (gamePad.mightBeNyko) {
            if (gamePad.GamepadAxes[0] > 0.75f && centeredAxis5 > 0.75f) {
                gamePad.NykoCheckHacks |= 1;
            }
            if (gamePad.GamepadAxes[0] < -0.75f && centeredAxis5 < -0.75f) {
                gamePad.NykoCheckHacks |= 2;
            }
            if (gamePad.GamepadAxes[1] > 0.75f && centeredAxis6 > 0.75f) {
                gamePad.NykoCheckHacks |= 4;
            }
            if (gamePad.GamepadAxes[1] < -0.7f && centeredAxis6 < 0.75f) {
                gamePad.NykoCheckHacks |= 8;
            }
            if (gamePad.GamepadAxes[0] > 0.75f && centeredAxis5 == 0.0f) {
                gamePad.mightBeNyko = false;
            }
            if (gamePad.GamepadAxes[0] < -0.75f && centeredAxis5 == 0.0f) {
                gamePad.mightBeNyko = false;
            }
            if (gamePad.GamepadAxes[1] > 0.75f && centeredAxis6 == 0.0f) {
                gamePad.mightBeNyko = false;
            }
            if (gamePad.GamepadAxes[1] < -0.75f && centeredAxis6 == 0.0f) {
                gamePad.mightBeNyko = false;
            }
            if (gamePad.NykoCheckHacks == 15) {
                gamePad.GamepadType = 6;
                System.out.println("detecting NYKO controller");
            }
        }
        if (gamePad.GamepadDpadHack == 1) {
            if (centeredAxis5 <= 0.5f && centeredAxis5 >= -0.5f && centeredAxis6 <= 0.5f && centeredAxis6 >= -0.5f) {
                return;
            }
            gamePad.GamepadDpadHack = 0;
        }
        gamePad.GamepadButtonMask = centeredAxis5 > 0.5f ? gamePad.GamepadButtonMask | 2048 : gamePad.GamepadButtonMask & (-2049);
        gamePad.GamepadButtonMask = centeredAxis5 < -0.5f ? gamePad.GamepadButtonMask | 1024 : gamePad.GamepadButtonMask & (-1025);
        gamePad.GamepadButtonMask = centeredAxis6 > 0.5f ? gamePad.GamepadButtonMask | 512 : gamePad.GamepadButtonMask & (-513);
        if (centeredAxis6 < -0.5f) {
            gamePad.GamepadButtonMask |= 256;
        } else {
            gamePad.GamepadButtonMask &= -257;
        }
    }

    private void sendCommand(int i, int i2) {
        synchronized (this) {
            if (i2 != 64) {
                Log.e(TAG, "sendMove " + i2);
            }
            if (this.GamePads[i].mGamepadConnection != null) {
                byte[] bArr = new byte[1];
                bArr[0] = (byte) i2;
                this.GamePads[i].mGamepadConnection.controlTransfer(33, 9, 512, 0, bArr, 1, 0);
            }
        }
    }

    private void setProcessTouchpadAsPointer(boolean z) {
    }

    public void CheckNavigation(Configuration configuration) {
        if (configuration.navigationHidden == 1 && this.GamePads[0].GamepadType == -1) {
            Log.e(TAG, "Attached xPeria play gamepad.");
            this.GamePads[0].GamepadType = 1;
            this.GamePads[0].is360 = true;
            this.GamePads[0].GamepadButtonMask = 0;
            this.GamePads[0].lastConnect = SystemClock.uptimeMillis();
        } else if (configuration.navigationHidden != 2 || this.GamePads[0].GamepadType == -1) {
        } else {
            Log.e(TAG, "Detaching xPeria play gamepad.");
            this.GamePads[0].GamepadType = -1;
            this.GamePads[0].GamepadButtonMask = 0;
            this.GamePads[0].lastDisconnect = SystemClock.uptimeMillis();
        }
    }

    @Override // com.nvidia.devtech.NvEventQueueActivity
    public void GamepadReportSurfaceCreated(SurfaceHolder surfaceHolder) {
        System.out.println("Processing touchpad as pointer...");
        setProcessTouchpadAsPointer(true);
    }

    int GetDeviceIndex(int i, int i2) {
        if ((i2 & 16) != 0) {
            for (int i3 = 0; i3 < MAX_GAME_PADS; i3++) {
                if (this.GamePads[i3].active && this.GamePads[i3].deviceId == i) {
                    return i3;
                }
            }
            return -1;
        }
        return -1;
    }

    int GetDeviceIndexByName(String str) {
        return -1;
    }

    int GetFreeIndex(int i, int i2) {
        if ((i2 & 16) == 0) {
            return -1;
        }
        for (int i3 = 0; i3 < MAX_GAME_PADS; i3++) {
            if (this.GamePads[i3].active && this.GamePads[i3].deviceId == i) {
                return i3;
            }
        }
        for (int i4 = 0; i4 < MAX_GAME_PADS; i4++) {
            if (!this.GamePads[i4].active) {
                this.GamePads[i4].deviceId = i;
                this.GamePads[i4].active = true;
                return i4;
            }
        }
        return -1;
    }

    public float GetGamepadAxis(int i, int i2) {
        return this.GamePads[i].GamepadAxes[i2];
    }

    public int GetGamepadButtons(int i) {
        return this.GamePads[i].GamepadButtonMask;
    }

    public int GetGamepadTrack(int i, int i2, int i3) {
        if (this.GamePads[i].numGamepadTouchSamples < 4) {
            return 0;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 4; i5++) {
            i4 += this.GamePads[i].GamepadTouches[(i2 * 8) + (i5 * 2) + i3];
        }
        return i4 / 4;
    }

    public int GetGamepadType(int i) {
        return this.GamePads[i].GamepadType;
    }

    int GetMogaControllerType(int i) {
        int state = this.mogaController.getState(4);
        if (state == 0) {
            return 4;
        }
        if (state == 1) {
            return 7;
        }
        System.out.println("Moga controller type = " + state);
        return 7;
    }

    float GetWithDeadZone(float f) {
        double d = f;
        if (d > 0.25d || d < -0.25d) {
            return f;
        }
        return 0.0f;
    }

    public int InitMogaController(int i) {
        try {
            this.GamePads[i].mogaController = Controller.getInstance(this);
            this.GamePads[i].mogaController.init();
            this.GamePads[i].mogaController.setListener(this, new Handler());
            this.GamePads[i].active = true;
            System.out.println("*****Set Moga as index 0");
            return i;
        } catch (IllegalArgumentException unused) {
            this.GamePads[i].mogaController = null;
            return -1;
        }
    }

    @Override // com.wardrumstudios.utils.WarBase
    public void SetGamepad(String str) {
        int GetDeviceIndexByName = GetDeviceIndexByName(str);
        if (GetDeviceIndexByName == -1) {
            return;
        }
        if (str.equals("GS controller")) {
            this.GamePads[GetDeviceIndexByName].GamepadType = 3;
        } else if (str.equals("")) {
            this.GamePads[GetDeviceIndexByName].GamepadType = -1;
        }
    }

    public void SetReportPS3As360(boolean z) {
        for (int i = 0; i < MAX_GAME_PADS; i++) {
            this.GamePads[i].reportPS3as360 = z;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void TouchpadEvent(int i, int i2, int i3, int i4, int i5, int i6) {
        boolean z;
        if (i == 0 || i == 1) {
            this.GamePads[0].numGamepadTouchSamples = 0;
            if (i == 1) {
                UpdateTrack(0, 0, 0, true);
                UpdateTrack(1, 0, 0, true);
                return;
            }
        } else {
            this.GamePads[0].numGamepadTouchSamples++;
        }
        if (i == 6) {
            this.GamePads[0].GamepadTouchReversed = true;
        } else if (i != 5 && i == 2) {
            z = false;
            if (this.GamePads[0].GamepadTouchReversed) {
                UpdateTrack(0, i3, i4, z);
                UpdateTrack(1, i5, i6, z);
                return;
            }
            UpdateTrack(1, i3, i4, z);
            UpdateTrack(0, i5, i6, z);
            return;
        } else {
            this.GamePads[0].GamepadTouchReversed = false;
        }
        z = true;
        if (this.GamePads[0].GamepadTouchReversed) {
        }
    }

    @Override // com.wardrumstudios.utils.WarBase
    public void USBDeviceAttached(UsbDevice usbDevice, String str) {
        String str2;
        Log.e(TAG, "Device Attached : " + usbDevice);
        if (usbDevice == null) {
            str2 = "Given null device?";
        } else if (usbDevice.getInterfaceCount() != 1) {
            str2 = "could not find interface";
        } else {
            UsbInterface usbInterface = usbDevice.getInterface(0);
            if (usbInterface.getEndpointCount() != 1) {
                str2 = "could not find endpoint";
            } else {
                UsbEndpoint endpoint = usbInterface.getEndpoint(0);
                if (endpoint.getType() == 3) {
                    final int GetFreeIndex = GetFreeIndex(usbDevice.getDeviceId(), 16);
                    if (GetFreeIndex != -1) {
                        this.GamePads[GetFreeIndex].is360 = true;
                        UsbDeviceConnection openDevice = this.mUsbManager.openDevice(usbDevice);
                        if (openDevice == null || !openDevice.claimInterface(usbInterface, true)) {
                            Log.e(TAG, "Failed to open USB gamepad");
                            this.GamePads[GetFreeIndex].GamepadType = -1;
                            this.GamePads[GetFreeIndex].mGamepadDevice = null;
                            this.GamePads[GetFreeIndex].mGamepadConnection = null;
                            this.GamePads[GetFreeIndex].active = false;
                        } else {
                            Log.e(TAG, "Success, I have a USB gamepad " + usbDevice.toString());
                            this.GamePads[GetFreeIndex].GamepadType = 0;
                            if (usbDevice.toString().contains("PLAYSTATION")) {
                                this.GamePads[GetFreeIndex].is360 = false;
                                if (!this.GamePads[GetFreeIndex].reportPS3as360) {
                                    this.GamePads[GetFreeIndex].GamepadType = 8;
                                }
                            }
                            this.GamePads[GetFreeIndex].mGamepadDevice = usbDevice;
                            this.GamePads[GetFreeIndex].mGamepadEndpointIntr = endpoint;
                            this.GamePads[GetFreeIndex].mGamepadConnection = openDevice;
                            this.GamePads[GetFreeIndex].mGamepadThread = new Thread(new Runnable() { // from class: com.wardrumstudios.utils.WarGamepad.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    WarGamepad.this.USBDeviceRun(GetFreeIndex);
                                }
                            });
                            this.GamePads[GetFreeIndex].mGamepadThread.start();
                            this.GamePads[GetFreeIndex].lastConnect = SystemClock.uptimeMillis();
                        }
                        super.USBDeviceAttached(usbDevice, str);
                        return;
                    }
                    return;
                }
                str2 = "endpoint is not interrupt type";
            }
        }
        Log.e(TAG, str2);
    }

    @Override // com.wardrumstudios.utils.WarBase
    public void USBDeviceDetached(UsbDevice usbDevice, String str) {
        int GetDeviceIndex = GetDeviceIndex(usbDevice.getDeviceId(), 16);
        if (GetDeviceIndex == -1) {
            Log.e(TAG, "Disconnected gamepad, device not connected");
            return;
        }
        if (this.GamePads[GetDeviceIndex].GamepadType != -1) {
            Log.e(TAG, "Disconnected gamepad, stopping usb thread");
            this.GamePads[GetDeviceIndex].GamepadType = -1;
            this.GamePads[GetDeviceIndex].mGamepadDevice = null;
            this.GamePads[GetDeviceIndex].GamepadButtonMask = 0;
            if (this.GamePads[GetDeviceIndex].mGamepadThread != null) {
                this.GamePads[GetDeviceIndex].mGamepadThread.stop();
            }
            this.GamePads[GetDeviceIndex].lastDisconnect = SystemClock.uptimeMillis();
        }
        this.GamePads[GetDeviceIndex].active = false;
        super.USBDeviceDetached(usbDevice, str);
    }

    public void USBDeviceRun(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(1);
        UsbRequest usbRequest = new UsbRequest();
        usbRequest.initialize(this.GamePads[i].mGamepadConnection, this.GamePads[i].mGamepadEndpointIntr);
        byte b = -1;
        while (true) {
            usbRequest.queue(allocate, 1);
            sendCommand(i, 64);
            if (this.GamePads[i].mGamepadConnection.requestWait() != usbRequest) {
                Log.e(TAG, "requestWait failed, exiting");
                return;
            }
            byte b2 = allocate.get(0);
            Log.e(TAG, "****got status " + ((int) b2));
            if (b2 != b) {
                Log.e(TAG, "got status " + ((int) b2));
                if ((b2 & Ascii.DLE) != 0) {
                    sendCommand(i, 32);
                }
                b = b2;
            }
            try {
                Thread.sleep(100L);
            } catch (InterruptedException unused) {
            }
        }
    }

    public void UpdateTrack(int i, int i2, int i3, boolean z) {
        if (!z) {
            int i4 = (i * 8) + ((this.GamePads[0].numGamepadTouchSamples % 4) * 2);
            this.GamePads[0].GamepadTouches[i4] = i2;
            this.GamePads[0].GamepadTouches[i4 + 1] = i3;
            return;
        }
        for (int i5 = 0; i5 < 4; i5++) {
            int i6 = (i * 8) + (i5 * 2);
            this.GamePads[0].GamepadTouches[i6] = i2;
            this.GamePads[0].GamepadTouches[i6 + 1] = i3;
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (this.GamePads[0].isXperia) {
            CheckNavigation(configuration);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // com.wardrumstudios.utils.WarBilling, com.wardrumstudios.utils.WarBase, com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Controller controller = Controller.getInstance(this);
            this.mogaController = controller;
            controller.init();
            this.mogaController.setListener(this, new Handler());
        } catch (IllegalArgumentException unused) {
            this.mogaController = null;
        }
        this.GamePads = new GamePad[MAX_GAME_PADS];
        for (int i = 0; i < MAX_GAME_PADS; i++) {
            this.GamePads[i] = new GamePad();
        }
        if (!Build.PRODUCT.contains("R800")) {
            Log.e(TAG, "Product " + Build.PRODUCT);
            Log.e(TAG, "Device " + Build.DEVICE);
            return;
        }
        Log.e(TAG, "Xperia Play detected.");
        this.GamePads[0].isXperia = true;
        CheckNavigation(getResources().getConfiguration());
    }

    @Override // com.wardrumstudios.utils.WarBilling, com.wardrumstudios.utils.WarBase, com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public void onDestroy() {
        Controller controller = this.mogaController;
        if (controller != null) {
            controller.exit();
        }
        for (int i = 0; i < MAX_GAME_PADS; i++) {
            if (this.GamePads[i].mogaController != null) {
                this.GamePads[i].mogaController.exit();
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int GetDeviceIndex = GetDeviceIndex(motionEvent.getDeviceId(), motionEvent.getSource());
        if (GetDeviceIndex == -1) {
            GetDeviceIndex = GetFreeIndex(motionEvent.getDeviceId(), motionEvent.getDevice() != null ? motionEvent.getDevice().getSources() : 0);
            if (GetDeviceIndex == -1) {
                if ((motionEvent.getSource() & 16) != 0) {
                    System.out.println("********************ERROR********* cannot assign controller MotionEvent " + motionEvent);
                }
                return super.onGenericMotionEvent(motionEvent);
            }
        }
        if (this.GamePads[GetDeviceIndex].isXperia) {
            return false;
        }
        if ((motionEvent.getSource() & 16) == 0 || motionEvent.getAction() != 2) {
            return super.onGenericMotionEvent(motionEvent);
        }
        if (this.GamePads[GetDeviceIndex].mLastGamepadInputDevice == null || this.GamePads[GetDeviceIndex].mLastGamepadInputDevice.getId() != motionEvent.getDeviceId()) {
            this.GamePads[GetDeviceIndex].mLastGamepadInputDevice = motionEvent.getDevice();
            if (this.GamePads[GetDeviceIndex].mLastGamepadInputDevice == null) {
                return false;
            }
            this.GamePads[GetDeviceIndex].GamepadType = -1;
            this.GamePads[GetDeviceIndex].mightBeNyko = false;
            if (this.GamePads[GetDeviceIndex].mLastGamepadInputDevice.getName().contains("NYKO")) {
                this.GamePads[GetDeviceIndex].GamepadType = 6;
            } else {
                this.GamePads[GetDeviceIndex].mLastGamepadInputDevice.getName().contains("Broadcom Bluetooth HID");
                InputDevice.MotionRange motionRange = this.GamePads[GetDeviceIndex].mLastGamepadInputDevice.getMotionRange(22);
                InputDevice.MotionRange motionRange2 = this.GamePads[GetDeviceIndex].mLastGamepadInputDevice.getMotionRange(23);
                if (motionRange != null && motionRange2 != null) {
                    this.GamePads[GetDeviceIndex].mightBeNyko = true;
                    this.GamePads[GetDeviceIndex].NykoCheckHacks = 0;
                }
            }
        }
        if (this.GamePads[GetDeviceIndex].GamepadType == -1 || this.GamePads[GetDeviceIndex].GamepadType == 11 || this.GamePads[GetDeviceIndex].GamepadType == 3) {
            this.GamePads[GetDeviceIndex].mLastGamepadInputDevice = motionEvent.getDevice();
            String name = this.GamePads[GetDeviceIndex].mLastGamepadInputDevice.getName();
            if (name.contains("Thunder") || name.contains("Amazon Fire Game Controller")) {
                this.GamePads[GetDeviceIndex].GamepadType = 12;
                this.GamePads[GetDeviceIndex].GamepadButtonMask = 0;
                this.GamePads[GetDeviceIndex].lastConnect = SystemClock.uptimeMillis();
                System.out.println("Setting GamepadType to Amazon Controller");
            }
        }
        if (this.GamePads[GetDeviceIndex].GamepadType == -1 || this.GamePads[GetDeviceIndex].GamepadType == 3) {
            if (SystemClock.uptimeMillis() - this.GamePads[GetDeviceIndex].lastDisconnect < 250) {
                return false;
            }
            try {
                this.GamePads[GetDeviceIndex].mLastGamepadInputDevice = motionEvent.getDevice();
                Log.e(TAG, "FIXME! Received joystick event without a valid joystick. " + this.GamePads[GetDeviceIndex].mLastGamepadInputDevice);
                this.GamePads[GetDeviceIndex].GamepadType = 0;
                if (this.IsAndroidTV) {
                    this.GamePads[GetDeviceIndex].GamepadType = 13;
                }
                if (this.GamePads[GetDeviceIndex].mLastGamepadInputDevice != null) {
                    Log.e(TAG, "mLastGamepadInputDevice.getName() " + this.GamePads[GetDeviceIndex].mLastGamepadInputDevice.getName());
                    if (this.GamePads[GetDeviceIndex].mLastGamepadInputDevice.getName().contains("PLAYSTATION")) {
                        this.GamePads[GetDeviceIndex].is360 = false;
                        if (!this.GamePads[GetDeviceIndex].reportPS3as360) {
                            this.GamePads[GetDeviceIndex].GamepadType = 8;
                        }
                    } else {
                        this.GamePads[GetDeviceIndex].is360 = true;
                    }
                }
                this.GamePads[GetDeviceIndex].GamepadButtonMask = 0;
                this.GamePads[GetDeviceIndex].lastConnect = SystemClock.uptimeMillis();
            } catch (Exception unused) {
            }
        }
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            processJoystickInput(motionEvent, i);
        }
        processJoystickInput(motionEvent, -1);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0181, code lost:
        if (r3.is360 != false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0183, code lost:
        r6 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0185, code lost:
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0189, code lost:
        if (r3.is360 != false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x018b, code lost:
        r9 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x018c, code lost:
        r6 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0190, code lost:
        if (r3.is360 != false) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x017c, code lost:
        if (r3.is360 != false) goto L150;
     */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01f9  */
    @Override // com.nvidia.devtech.NvEventQueueActivity, android.app.Activity, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int i2;
        PrintStream printStream;
        String str;
        boolean z;
        int i3 = i;
        int GetDeviceIndex = GetDeviceIndex(keyEvent.getDeviceId(), keyEvent.getSource());
        if (GetDeviceIndex == -1) {
            if (keyEvent.getDevice() != null) {
                keyEvent.getDevice().getSources();
            }
            GetDeviceIndex = GetFreeIndex(keyEvent.getDeviceId(), keyEvent.getDevice().getSources());
            if (GetDeviceIndex == -1) {
                if ((keyEvent.getSource() & 16) != 0) {
                    System.out.println("********************ERROR********* cannot assign controller keyEvent " + keyEvent);
                }
                return super.onKeyDown(i, keyEvent);
            }
        }
        GamePad gamePad = this.GamePads[GetDeviceIndex];
        int i4 = 1;
        try {
            if (!gamePad.isXperia && keyEvent.getDeviceId() > 0 && gamePad.GamepadType != 11) {
                if ((i3 < 7 || i3 > 16) && ((i3 < 20 || i3 > 22) && ((i3 < 37 || i3 > 40) && i3 != 47 && i3 != 29 && i3 != 32 && i3 != 51))) {
                    z = false;
                    if (keyEvent.getDevice() != null || (keyEvent.getDevice().getSources() & 16) == 0) {
                        if (!z || (keyEvent.getDevice() != null && (keyEvent.getDevice().getName().equals("GS controller") || keyEvent.getDevice().getName().equals("Broadcom Bluetooth HID")))) {
                            gamePad.GamepadType = 3;
                        }
                    } else if (gamePad.GamepadType == -1 || gamePad.GamepadType == 3) {
                        gamePad.GamepadType = 5;
                    }
                }
                z = true;
                if (keyEvent.getDevice() != null) {
                }
                if (!z) {
                }
                gamePad.GamepadType = 3;
            }
        } catch (Exception | NoSuchMethodError unused) {
        }
        if (keyEvent.getDevice() != null && (gamePad.GamepadType == -1 || gamePad.GamepadType == 12 || gamePad.GamepadType == 11 || gamePad.GamepadType == 3)) {
            gamePad.mLastGamepadInputDevice = keyEvent.getDevice();
            if (gamePad.mLastGamepadInputDevice != null) {
                String name = gamePad.mLastGamepadInputDevice.getName();
                if (gamePad.GamepadType != 12 && (name.contains("Thunder") || name.contains("Amazon Fire Game Controller"))) {
                    gamePad.GamepadType = 12;
                    gamePad.lastConnect = SystemClock.uptimeMillis();
                    printStream = System.out;
                    str = "Setting GamepadType to Amazon Controller onKeyDown";
                } else if (gamePad.GamepadType != 11 && gamePad.mLastGamepadInputDevice.getName().equals("Amazon")) {
                    gamePad.GamepadType = 11;
                    gamePad.lastConnect = SystemClock.uptimeMillis();
                    printStream = System.out;
                    str = "Setting GamepadType to Amazon Remote";
                }
                printStream.println(str);
            }
        }
        int i5 = 8;
        switch (i3) {
            case 96:
                break;
            case 97:
                break;
            case 98:
            case 101:
            default:
                i2 = 0;
                break;
            case 99:
                break;
            case 100:
                break;
            case 102:
                i2 = 64;
                break;
            case 103:
                i2 = 128;
                break;
            case 104:
                gamePad.GamepadAxes[4] = 1.0f;
                i2 = 0;
                break;
            case 105:
                gamePad.GamepadAxes[5] = 1.0f;
                i2 = 0;
                break;
            case 106:
                i2 = 4096;
                break;
            case 107:
                i2 = 8192;
                break;
            case 108:
                i2 = 16;
                break;
            case 109:
                i2 = 32;
                break;
        }
        if (i2 == 0 && !gamePad.isXperia) {
            switch (i3) {
                case 19:
                    i2 = 256;
                    break;
                case 20:
                    i2 = 512;
                    break;
                case 21:
                    i2 = 1024;
                    break;
                case 22:
                    i2 = 2048;
                    break;
                case 23:
                    i2 = 1;
                    break;
            }
            if (i2 != 0) {
                gamePad.GamepadDpadHack = 1;
            }
        }
        if (i2 == 0 && gamePad.isXperia && gamePad.GamepadType != -1) {
            if (i3 == 4) {
                i4 = keyEvent.getScanCode() == 158 ? InputDeviceCompat.SOURCE_STYLUS : 2;
            } else if (i3 == 82) {
                i4 = keyEvent.getScanCode() == 226 ? 36864 : 4096;
            } else if (i3 != 84) {
                switch (i3) {
                    case 19:
                        i4 = 256;
                        break;
                    case 20:
                        i4 = 512;
                        break;
                    case 21:
                        i4 = 1024;
                        break;
                    case 22:
                        i4 = 2048;
                        break;
                }
            } else {
                i4 = 8192;
            }
            if (gamePad.GamepadType == 3) {
                if (i3 == 111) {
                    i4 |= 32;
                    i3 = 109;
                } else if (i3 == 66) {
                    i4 |= 16;
                    i3 = 108;
                }
            }
            if (i4 != 0 && SystemClock.uptimeMillis() - gamePad.lastConnect > 1000) {
                gamePad.GamepadButtonMask |= i4;
            }
            return super.onKeyDown(i3, keyEvent);
        }
        i4 = i2;
        if (gamePad.GamepadType == 3) {
        }
        if (i4 != 0) {
            gamePad.GamepadButtonMask |= i4;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // com.bda.controller.ControllerListener
    public void onKeyEvent(com.bda.controller.KeyEvent keyEvent) {
        int i;
        int i2;
        int i3;
        int GetDeviceIndex = GetDeviceIndex(keyEvent.getControllerId(), 16);
        if (GetDeviceIndex == -1) {
            return;
        }
        GamePad gamePad = this.GamePads[GetDeviceIndex];
        if (gamePad.GamepadType != 4 && gamePad.GamepadType != 7) {
            gamePad.GamepadType = GetMogaControllerType(GetDeviceIndex);
        }
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 96) {
                i3 = 1;
            } else if (keyCode == 97) {
                i3 = 2;
            } else if (keyCode == 99) {
                i3 = 4;
            } else if (keyCode != 100) {
                switch (keyCode) {
                    case 19:
                        if (gamePad.GamepadType == 7) {
                            i3 = 256;
                            break;
                        }
                        i3 = 0;
                        break;
                    case 20:
                        if (gamePad.GamepadType == 7) {
                            i3 = 512;
                            break;
                        }
                        i3 = 0;
                        break;
                    case 21:
                        if (gamePad.GamepadType == 7) {
                            i3 = 1024;
                            break;
                        }
                        i3 = 0;
                        break;
                    case 22:
                        if (gamePad.GamepadType == 7) {
                            i3 = 2048;
                            break;
                        }
                        i3 = 0;
                        break;
                    default:
                        switch (keyCode) {
                            case 102:
                                i3 = 64;
                                break;
                            case 103:
                                i3 = 128;
                                break;
                            case 104:
                                gamePad.GamepadAxes[4] = 1.0f;
                                i3 = 0;
                                break;
                            case 105:
                                gamePad.GamepadAxes[5] = 1.0f;
                                i3 = 0;
                                break;
                            case 106:
                                i3 = 4096;
                                break;
                            case 107:
                                i3 = 8192;
                                break;
                            case 108:
                                i3 = 16;
                                break;
                            case 109:
                                i3 = 32;
                                break;
                            default:
                                System.out.println("onKeyEvent " + keyEvent.getKeyCode());
                                i3 = 0;
                                break;
                        }
                }
            } else {
                i3 = 8;
            }
            System.out.println("onKeyEvent " + keyEvent.getKeyCode());
            if (i3 == 0) {
                return;
            }
            i2 = gamePad.GamepadButtonMask | i3;
        } else {
            int keyCode2 = keyEvent.getKeyCode();
            if (keyCode2 == 96) {
                i = 1;
            } else if (keyCode2 == 97) {
                i = 2;
            } else if (keyCode2 == 99) {
                i = 4;
            } else if (keyCode2 != 100) {
                switch (keyCode2) {
                    case 19:
                        if (gamePad.GamepadType == 7) {
                            i = 256;
                            break;
                        }
                        i = 0;
                        break;
                    case 20:
                        if (gamePad.GamepadType == 7) {
                            i = 512;
                            break;
                        }
                        i = 0;
                        break;
                    case 21:
                        if (gamePad.GamepadType == 7) {
                            i = 1024;
                            break;
                        }
                        i = 0;
                        break;
                    case 22:
                        if (gamePad.GamepadType == 7) {
                            i = 2048;
                            break;
                        }
                        i = 0;
                        break;
                    default:
                        switch (keyCode2) {
                            case 102:
                                i = 64;
                                break;
                            case 103:
                                i = 128;
                                break;
                            case 104:
                                gamePad.GamepadAxes[4] = 0.0f;
                                i = 0;
                                break;
                            case 105:
                                gamePad.GamepadAxes[5] = 0.0f;
                                i = 0;
                                break;
                            case 106:
                                i = 4096;
                                break;
                            case 107:
                                i = 8192;
                                break;
                            case 108:
                                i = 16;
                                break;
                            case 109:
                                i = 32;
                                break;
                            default:
                                System.out.println("onKeyEvent " + keyEvent);
                                i = 0;
                                break;
                        }
                }
            } else {
                i = 8;
            }
            if (i == 0) {
                return;
            }
            i2 = gamePad.GamepadButtonMask & (~i);
        }
        gamePad.GamepadButtonMask = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x007a, code lost:
        if (r0.is360 != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007c, code lost:
        r1 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007e, code lost:
        r1 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0082, code lost:
        if (r0.is360 != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0084, code lost:
        r1 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0086, code lost:
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008a, code lost:
        if (r0.is360 != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008f, code lost:
        if (r0.is360 != false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010b  */
    @Override // com.nvidia.devtech.NvEventQueueActivity, android.app.Activity, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        int GetDeviceIndex = GetDeviceIndex(keyEvent.getDeviceId(), keyEvent.getSource());
        int i2 = 0;
        if (GetDeviceIndex == -1) {
            GetDeviceIndex = GetFreeIndex(keyEvent.getDeviceId(), keyEvent.getDevice() != null ? keyEvent.getDevice().getSources() : 0);
            if (GetDeviceIndex == -1) {
                if ((keyEvent.getSource() & 16) != 0) {
                    System.out.println("********************ERROR********* cannot assign controller keyEvent " + keyEvent);
                }
                return super.onKeyUp(i, keyEvent);
            }
        }
        GamePad gamePad = this.GamePads[GetDeviceIndex];
        int i3 = 8192;
        switch (i) {
            case 102:
                i2 = 64;
                break;
            case 103:
                i2 = 128;
                break;
            case 104:
                gamePad.GamepadAxes[4] = 0.0f;
                break;
            case 105:
                gamePad.GamepadAxes[5] = 0.0f;
                break;
            case 106:
                i2 = 4096;
                break;
            case 107:
                i2 = 8192;
                break;
            case 108:
                i2 = 16;
                break;
            case 109:
                i2 = 32;
                break;
        }
        if (i2 == 0 && !gamePad.isXperia) {
            switch (i) {
                case 19:
                    i2 = 256;
                    break;
                case 20:
                    i2 = 512;
                    break;
                case 21:
                    i2 = 1024;
                    break;
                case 22:
                    i2 = 2048;
                    break;
                case 23:
                    i2 = 1;
                    break;
            }
            if (i2 != 0) {
                gamePad.GamepadDpadHack = 1;
            }
        }
        if (i2 == 0 && gamePad.isXperia && gamePad.GamepadType != -1) {
            if (i == 4) {
                i3 = keyEvent.getScanCode() == 158 ? InputDeviceCompat.SOURCE_STYLUS : 2;
            } else if (i == 82) {
                i3 = keyEvent.getScanCode() == 226 ? 36864 : 4096;
            } else if (i != 84) {
                switch (i) {
                    case 19:
                        i3 = 256;
                        break;
                    case 20:
                        i3 = 512;
                        break;
                    case 21:
                        i3 = 1024;
                        break;
                    case 22:
                        i3 = 2048;
                        break;
                    case 23:
                        i3 = 1;
                        break;
                }
            }
            if (gamePad.GamepadType == 3) {
                if (i == 111) {
                    i3 |= 32;
                    i = 109;
                } else if (i == 66) {
                    i3 |= 16;
                    i = 108;
                }
            }
            if (i3 != 0) {
                gamePad.GamepadButtonMask &= ~i3;
            }
            return super.onKeyUp(i, keyEvent);
        }
        i3 = i2;
        if (gamePad.GamepadType == 3) {
        }
        if (i3 != 0) {
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // com.bda.controller.ControllerListener
    public void onMotionEvent(com.bda.controller.MotionEvent motionEvent) {
        int GetDeviceIndex = GetDeviceIndex(motionEvent.getControllerId(), 16);
        if (GetDeviceIndex == -1) {
            return;
        }
        GamePad gamePad = this.GamePads[GetDeviceIndex];
        if (gamePad.GamepadType != 4 && gamePad.GamepadType != 7) {
            gamePad.GamepadType = GetMogaControllerType(GetDeviceIndex);
        }
        gamePad.mobiX = GetWithDeadZone(motionEvent.getAxisValue(0));
        gamePad.mobiY = GetWithDeadZone(motionEvent.getAxisValue(1));
        gamePad.GamepadAxes[0] = gamePad.mobiX;
        gamePad.GamepadAxes[1] = gamePad.mobiY;
        gamePad.GamepadAxes[2] = GetWithDeadZone(motionEvent.getAxisValue(11));
        gamePad.GamepadAxes[3] = GetWithDeadZone(motionEvent.getAxisValue(14));
    }

    @Override // com.bda.controller.ControllerListener
    public void onStateEvent(StateEvent stateEvent) {
        int GetFreeIndex;
        int GetDeviceIndex = GetDeviceIndex(stateEvent.getControllerId(), 16);
        System.out.println("onStateEvent " + stateEvent + " getState " + stateEvent.getState() + " action " + stateEvent.getAction());
        int state = stateEvent.getState();
        if (state != 1) {
            if (state != 2) {
                return;
            }
            stateEvent.getAction();
            return;
        }
        int action = stateEvent.getAction();
        if (action == 0) {
            if (GetDeviceIndex > -1) {
                this.GamePads[GetDeviceIndex].GamepadType = -1;
                this.GamePads[GetDeviceIndex].active = false;
            }
        } else if (action == 1 && GetDeviceIndex == -1 && (GetFreeIndex = GetFreeIndex(stateEvent.getControllerId(), 16)) > -1) {
            this.GamePads[GetFreeIndex].GamepadType = GetMogaControllerType(GetFreeIndex);
        }
    }

    @Override // com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int GetDeviceIndex = GetDeviceIndex(motionEvent.getDeviceId(), motionEvent.getSource());
        if (GetDeviceIndex == -1) {
            GetDeviceIndex = GetFreeIndex(motionEvent.getDeviceId(), motionEvent.getDevice() != null ? motionEvent.getDevice().getSources() : 0);
            if (GetDeviceIndex == -1) {
                if ((motionEvent.getSource() & 16) != 0) {
                    System.out.println("********************ERROR********* cannot assign controller - onTouchEvent " + motionEvent);
                }
                return super.onTouchEvent(motionEvent);
            }
        }
        ClearBadJoystickAxis(this.GamePads[GetDeviceIndex]);
        if (motionEvent.getSource() == 1048584) {
            int pointerCount = motionEvent.getPointerCount();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < pointerCount; i6++) {
                motionEvent.getPointerId(i6);
                if (i == 0) {
                    i++;
                    i2 = (int) motionEvent.getX(i6);
                    i3 = (int) motionEvent.getY(i6);
                } else if (i == 1) {
                    i++;
                    i4 = (int) motionEvent.getX(i6);
                    i5 = (int) motionEvent.getY(i6);
                }
            }
            TouchpadEvent(motionEvent.getAction(), i, i2, i3, i4, i5);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public native boolean processTouchpadAsPointer(ViewParent viewParent, boolean z);
}
