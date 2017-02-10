package utils;

import context.AppContext;
import context.ConfigPropKey;

public enum FileTypeBySize {
    LARGE,
    SHORT,
    ;

    public static FileTypeBySize getType(int totalCount) {
        Integer threshold = AppContext.CONTEXT.getIntProp(ConfigPropKey.WORDS_THRESHOLD);
        if (null == threshold)
        	threshold = 0;
        
        if (totalCount > threshold)
            return LARGE;
        
        return SHORT;
    }
    
}
