package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution
{

    public class ServerNotAccessibleException extends Exception
    {
        public ServerNotAccessibleException()
        {
            super(Constants.NO_ACCESS);
        }

        public ServerNotAccessibleException(Throwable cause)
        {
            super(Constants.NO_ACCESS, cause);
        }
    }

    public class UnauthorizedUserException extends Exception
    {
        public UnauthorizedUserException()
        {
            super(Constants.NO_AUTHORIZE);
        }

        public UnauthorizedUserException(Throwable cause)
        {
            super(Constants.NO_AUTHORIZE, cause);
        }
    }

    public class BannedUserException extends Exception
    {
        public BannedUserException()
        {
            super(Constants.BANNED);
        }

        public BannedUserException(Throwable cause)
        {
            super(Constants.BANNED, cause);
        }
    }

    public class RestrictionException extends Exception
    {
        public RestrictionException()
        {
            super(Constants.ACCESS_DENIED);
        }

        public RestrictionException(Throwable cause)
        {
            super(Constants.ACCESS_DENIED, cause);
        }
    }

    public static final class Constants
    {
        public final static String NO_ACCESS = "Server is not accessible for now.";
        public final static String NO_AUTHORIZE = "User is not authorized.";
        public final static String BANNED = "User is banned.";
        public final static String ACCESS_DENIED = "Access is denied.";
    }
}
