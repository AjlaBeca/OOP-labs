package Week13;

interface OldDevice {
    void operateOldFunction();
}

interface NewDevice {
    void operateNewFunction();
}

class OldDeviceImpl implements OldDevice {
    @Override
    public void operateOldFunction() {
        System.out.println("Old device is operating old function.");
    }
}

class NewDeviceImpl implements NewDevice {
    @Override
    public void operateNewFunction() {
        System.out.println("New device is operating new function.");
    }
}

class DeviceAdapter implements NewDevice {
    private OldDevice oldDevice;

    public DeviceAdapter(OldDevice oldDevice) {
        this.oldDevice = oldDevice;
    }

    @Override
    public void operateNewFunction() {
        System.out.println("Adapter is converting old function to new function.");
        oldDevice.operateOldFunction();
    }
}

public class AdapterDesign {
    public static void main(String[] args) {

        OldDevice oldDevice = new OldDeviceImpl();

        NewDevice newDevice = new DeviceAdapter(oldDevice);
        newDevice.operateNewFunction();
    }
}

