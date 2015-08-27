package com.digital.backend.common.items;

public enum ItemAction {
	homebanner,
	hotnews, 
	interperspective,
	converage,
	research,
	knowTaiwan,
	database,
	dataaddon,
	researchResource,
	relatedWeb,
	academic;
	
	public static ItemAction getAction(String s){
		if(s != null && !"".equals(s)){
			if("hotnews".equals(s)){
				return ItemAction.hotnews;
			}else if("interperspective".equals(s)){
				return ItemAction.interperspective;
			}else if("converage".equals(s)){
				return ItemAction.converage;
			}else if("research".equals(s)){
				return ItemAction.research;
			}else if("knowTaiwan".equals(s)){
				return ItemAction.knowTaiwan;
			}else if("database".equals(s)){
				return ItemAction.database;
			}else if("dataaddon".equals(s)){
				return ItemAction.dataaddon;
			}else if("researchResource".equals(s)){
				return ItemAction.researchResource;
			}else if("relatedWeb".equals(s)){
				return ItemAction.relatedWeb;
			}else if("academic".equals(s)){
				return ItemAction.academic;
			}else if("homebanner".equals(s)){
				return ItemAction.homebanner;
			}
		}
		return null;
	}
}
