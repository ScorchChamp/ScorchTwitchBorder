[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/ScorchChamp/ScorchTwitchBorder">
    <img src="logo.jpg" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">ScorchTwitchBorder Twitch Bot</h3>

  <p align="center">
    Twitch Follower Border
    <br />
    <a href="https://github.com/ScorchChamp/ScorchTwitchBorder/releases/">Releases »</a>
    <br />
    <a href="https://github.com/ScorchChamp/ScorchTwitchBorder/issues">Report Bug</a>
    ·
    <a href="https://github.com/ScorchChamp/ScorchTwitchBorder/issues">Request Feature</a>
  </p>
</p>



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
  - masonisonline
  - theparanormalgirl
  - randompeep83
  - therelaxedjarl
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









<!-- CONTACT -->
## Contact

ScorchChamp - scorchchamp@gmail.com

Project Link: [https://github.com/ScorchChamp/ScorchTwitchBorder](https://github.com/ScorchChamp/ScorchTwitchBorder)

[contributors-shield]: https://img.shields.io/github/contributors/ScorchChamp/ScorchTwitchBorder.svg?style=for-the-badge
[contributors-url]: https://github.com/ScorchChamp/ScorchTwitchBorder/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/ScorchChamp/ScorchTwitchBorder.svg?style=for-the-badge
[forks-url]: https://github.com/ScorchChamp/ScorchTwitchBorder/network/members
[stars-shield]: https://img.shields.io/github/stars/ScorchChamp/ScorchTwitchBorder.svg?style=for-the-badge
[stars-url]: https://github.com/ScorchChamp/ScorchTwitchBorder/stargazers
[issues-shield]: https://img.shields.io/github/issues/ScorchChamp/ScorchTwitchBorder.svg?style=for-the-badge
[issues-url]: https://github.com/ScorchChamp/ScorchTwitchBorder/issues
[license-shield]: https://img.shields.io/github/license/ScorchChamp/ScorchTwitchBorder.svg?style=for-the-badge
[license-url]: https://github.com/ScorchChamp/ScorchTwitchBorder/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/lars-cornelissen-56504520b/
[youtube-url]: https://www.youtube.com/channel/UCYpqUStHIE9CmgDPkAmN4Sg