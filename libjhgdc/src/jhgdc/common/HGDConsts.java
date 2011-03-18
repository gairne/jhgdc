package jhgdc.common;

public final class HGDConsts {
	
	
	/*
	 * This class is based on hgd.h 
	 */
	
	//#define HGD_VERSION "0.3-current"
	public static final String VERSION = "0.3-current"; 

	/* paths */
	//#define HGD_DFL_DIR "/var/hgd"
	public static final String DEFAULT_DIR = "/var/hgd";
	
	//#define HGD_DB_NAME "hgd.db"
	public static final String DB_NAME = "hgd.db";
	
	//#define HGD_MPLAYER_PID_NAME "mplayer.pid"
	public static final String MPLAYER_PID_NAME = "mplayer.pid";
	
	//#define HGD_FILESTORE_NAME "files"
	public static final String FILESTORE_NAME = "files";
	
	//#define HGD_DFL_SVR_CONF_DIR "/etc/hgd"
	public static final String DEFAULT_SERVER_CONFIG_DIR = "/etc/hgd";
	
	
	/* networking */
	public static final String DEFAULT_HOST = "127.0.0.1";
	
	//#define HGD_DFL_PORT 6633
	public static final int DEFAULT_PORT = 6633;
	
	//#define HGD_DFL_BACKLOG 10
	public static final int DEFAULT_BACKLOG = 10;
	
	//#define HGD_DFL_MAX_UPLOAD (1024 * 1024 * 100)
	public static final int DEFAULT_MAX_UPLOAD = (1024 * 1024 * 100);
	
	//#define HGD_MAX_LINE 256
	public static final int MAX_LINE = 256;
	
	//#define HGD_MAX_BAD_COMMANDS 3
	public static final int MAX_BAD_COMMANDS = 3;
	
	//#define HGD_BINARY_CHUNK 4096
	public static final int BINARY_CHUNK = 4096;
	
	//#define HGD_BINARY_RECV_SZ 16384
	public static final int BINARY_RECEIV_SIZE = 16384;
	
	//#define HGD_MAX_PROTO_TOKS 3
	public static final int MAX_PROTO_TOKS = 3;
	
	//#define HGD_GREET "ok|HGD-" HGD_VERSION
	public static final String GREETING = "ok|JHGD" + VERSION;
	
	//#define HGD_BYE "ok|Catch you later d00d!"
	public static final String BYE = "ok|Catch you later d00d!";

	/* SSL */
	//#define HGD_DFL_KEY_FILE HGD_DFL_SVR_CONF_DIR "/privkey.key"
	
	//#define HGD_DFL_CERT_FILE HGD_DFL_SVR_CONF_DIR "/certificate.crt"
	
	
	//#define HGD_CRYPTO_PREF_ALWAYS 0
	
	//#define HGD_CRYPTO_PREF_IF_POSS 1
	
	//#define HGD_CRYPTO_PREF_NEVER 2

	
	/* misc */
	//#define HGD_DFL_REQ_VOTES 3
	public static final int DEFAULT_REQ_VOTES = 3;
	
	//#define HGD_PID_STR_SZ 10
	public static final int PID_STR_SIZE = 10;
	
	//#define HGD_SHA_SALT_SZ 20
	public static final int SHA_SALT_SIZE = 20;
	
	//#define HGD_MAX_PASS_SZ 20
	public static final int MAX_PASSWORD_SIZE = 20;
	
	//#define HGD_MAX_USER_QUEUE 5 /* XXX Make configurable */
	public static final int MAX_USER_QUEUE = 5;
	
	/* Function return values */
	//#define HGD_FAIL (-1)
	public static final int FAILURE = -1;
	//#define HGD_OK (0)
	public static final int SUCCESS = 0;
	
	/* Protocol commands */
}
