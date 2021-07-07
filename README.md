# ScorchTwitchBorder

## Why use ScorchTwitchBorder?
-----------------------------------

STBorder is a plugin supported on the 1.17 release of minecraft. This plugin uses the Twitch API to find out how many combined followers the players have on Twitch. This number is used to expand the in-game world border.

Every 4 followers on Twitch (combined on all channels) will expand the border by 1 block (with a max 10 secs delay). The plugin will announce when the border expands.

## Building
-----------------------------------
to build STBorder, you need all Maven dependencies *(see pom.xml)*.

## Setting up the plugin
-----------------------------------
To start setting up the plugin, please make sure you have a valid OAUTH token and client-id from the [Twitch Developer Portal](https://dev.twitch.tv/)!

1. Move the *TwitchFollowerBorder-X.X.X-RELEASE/SNAPSHOT* in your */plugins/* folder
2. Start the server up
3. Edit */plugins/Twitch_Follower_Border/config.yml* with any text editor
4. Insert your Authorization (OAUTH) token and your Client-id in their designated spots (see code below)
6. Tweak twitch-update-delay-ticks to make it less heavy on your API (doesn't affect performance)
5. Reload your server


```yml
Authorization: Bearer abcdefghijklmnopqrstuvwxyz
Client-Id: 0123456789101112131415
current-border-size: 0
twitch-update-delay-ticks: 200
streamer_names:
  - ScorchChamp
  - aestheicpixels
  - wish_lea
  - soullesspeach
  - machowings
  - masonisonline
  - theparanormalgirl
  - randompeep83
  - therelaxedjarl
  - keatsheimy
```
*(/plugins/Twitch_Follower_Border/config.yml)*

*NOTE: streamer_names could be empty!*




## Commands/permissions and usage
-----------------------------------

/updateborder
> <b>"/updateborder" - To manually update the border</b><br>
<i>Requires twitchfollowerborder.updateBorder</i>

/getcreators
> <b>"/getcreators" - Returns a list with all current tracking channels</b><br>

/addcreator [TwitchName]
> <b>"/addcreator scorchchamp" - Adds "scorchchamp" to the tracked channels </b><br>
<i>Requires twitchfollowerborder.addCreator</i>

/removecreator [TwitchName]
> <b>"/removecreator pokimane" - Removes "pokimane" from the tracked channels</b><br>
<i>Requires twitchfollowerborder.removeCreator</i>








