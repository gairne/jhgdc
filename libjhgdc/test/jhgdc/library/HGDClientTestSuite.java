package jhgdc.library;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ HGDClientTestConnect.class, HGDClientTestDisconnect.class,
		HGDClientTestLogin.class, HGDClientTestPlaylist.class })
public class HGDClientTestSuite {

}
