package interfaces;

public interface isVault {

	public boolean isOpen();

	public void doOpen();

	public void doClose();
	
	public boolean isLocked();

	public void doLock();

    public void doUnlock(String str);
    
}
