# Sirius

[Why so serious?](https://www.youtube.com/watch?v=F_5dP_83O7o) Emoji are all over the place, but they can be a burden for accessibility. Look at that tiny yellow face and figure out if it's crying in joy or horror...

Things would be easier if all the emoji had nice `aria-label` attributes that showed up on hover, right? While Sirius won't generate HTML for you, it will give you the Unicode name of any character you give it.

## Installation

[![Clojars Project](https://img.shields.io/clojars/v/net.valerauko/sirius.svg)](https://clojars.org/net.valerauko/sirius)

```
[net.valerauko/sirius "1.0.0"]
```

```
net.valerauko/sirius {:mvn/version "1.0.0"}
```

## Usage

Ask it about a single character you have at hand. It can be a Character like `\a`, a single-character string (`"a"`), even numeric or byte representations of letters.

```
=> (name-of "♎")
"LIBRA"

=> (name-of \☕)
"HOT BEVERAGE"
```

As you can see, the names are the raw, all-caps name from the [Unicode database](http://www.unicode.org/Public/UNIDATA/UnicodeData.txt). If you need it in any other shape (and you probably will), please convert it yourself.
