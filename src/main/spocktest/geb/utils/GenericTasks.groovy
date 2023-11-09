package spocktest.geb.utils

/**
 * Class for common utility methods
 *
 * @author: Renalyn Arguelles
 */
class GenericTask {

    /**
     * Generate random string
     *
     * @param length of the output
     * @return strings
     */
    def generateRandomString(int length) {
        char[] chars = ('abcdefghijklmnopqrstuvwxyz').toCharArray()
        def random = new Random()
        def sb = new StringBuilder()

        1.upto(length, {
            sb.append(chars[random.nextInt(chars.length)])
        })

        return sb.toString()
    }
}