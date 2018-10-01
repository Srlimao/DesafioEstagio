public class InternshipChallenge {
	 // The name of the file to open.
	
	public static String whiteListFileName = "whitelist.txt";
	public static String blackListFileName = "blacklist.txt";
	
	public static void main(String [] args) {
		
		if(args.length<1) {
			System.out.println("ERRO! Número inválido de argumentos");
			return;
		}
		UrlList whitelist = null;
		UrlList blacklist = null;
		try {
			whitelist = new UrlList(whiteListFileName);
			blacklist = new UrlList(blackListFileName);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		
		switch(args[0]) {
			case "verify"			: System.out.println(verifyUrl(whitelist, blacklist, args[1]));
				break;
			case "add-whitelist"	: whitelist.writeList(args[1]);
				break;
			case "add-blacklist"	: blacklist.writeList(args[1]);
				break;
			case "show-whitelist"	: System.out.println(whitelist.readList());
				break;
			case "show-blacklist"	: System.out.println(blacklist.readList());
				break;
			case "remove-whitelist" : whitelist.removeUrl(args[1]);
				break;
			case "remove-blacklist" : blacklist.removeUrl(args[1]);
				break;
			default: System.out.println(verifyUrl(whitelist, blacklist, args[0]));
				break;
		}
		
    }
	
	
	public static String verifyUrl(UrlList w,UrlList b,String url) {
		if(w.verifyUrl(url)) {
			return "safe";
		}
		if(b.verifyUrl(url)) {
			return "unsafe";
		}
		return "unknown";
	}
	
}
