package utility;

public enum SelectChoice
{
    VISIBLE_TEXT {
    @Override
    public String toString () {
            return "visibleText";
        }
    },
    VALUE
            {
                @Override
                public String toString() {
                    return "value";
                }
            },
    INDEX
            {
                @Override
                public String toString() {
                    return "index";
                }
            }
}
