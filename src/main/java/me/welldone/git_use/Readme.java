package me.welldone.git_use;

/**
 * Hello world!
 *
 */
public class Readme {

	/**
	 * Git:<分布式>版本控制系统。SVN与CVS为集中式版本控制系统。
	 * 		集中式版本控制系统：版本库是集中存放在<中央服务器>的，而干活的时候，用的都是自己的电脑，所以要先从中央服务器取得最新的版本，然后开始干活，干完活了，再把自己的活推送给中央服务器。中央服务器就好比是一个图书馆，你要改一本书，必须先从图书馆借出来，然后回到家自己改，改完了，再放回图书馆。
	 * 		分布式版本控制系统：分布式版本控制系统根本没有“中央服务器”，每个人的电脑上都是一个完整的版本库，这样，你工作的时候，就不需要联网了，因为版本库就在你自己的电脑上。
	 * 		注：在实际使用分布式版本控制系统的时候，其实很少在两人之间的电脑上推送版本库的修改，因为可能你们俩不在一个局域网内，两台电脑互相访问不了，也可能今天你的同事病了，他的电脑压根没有开机。
	 * 	                因此，分布式版本控制系统通常也有一台充当“中央服务器”的电脑，但这个服务器的作用仅仅是用来方便“交换”大家的修改，没有它大家也一样干活，只是交换修改不方便而已。如GITHUB与GITLIb
	 * 		GitHub、GitLib：两者都是代码托管平台，使用Git作为代码管理工具，并在此基础上搭建起来的web服务。GitHub和GitLab两个都是<基于Web>的<Git远程仓库>（即：中央服务器）。前者用于开源（GitHub），或者用于商业（GitLib）
	 * 
	 * Git安装：https://git-scm.com/downloads为下载地址，安装完成后，可以在右键显示的菜单栏中找到Git Bash；或者在安装目录下找到git-bash.exe
	 * 	
	 * Git创建版本库：
	 * 		1.选择一个合适的地方，创建一个目录。
	 *  	2.将此目录变成Git可以管理的仓库
	  *              命令如下：
	 *  	welld@welldone MINGW64 ~/Desktop
	 *		$ cd /d     						-- 在桌面打开的bash，目录默认在桌面，切换到d盘
	 *		
	 *		welld@welldone MINGW64 /d
	 *		$ mkdir learn_git && cd $_			-- 在d盘下创建learn_git目录，并进入
	 *		
	 *		welld@welldone MINGW64 /d/learn_git
	 *		$ git init							-- 通过git init命令把这个目录变成Git可以管理的仓库
	 *		Initialized empty Git repository in D:/learn_git/.git/
	 *	
	 *		welld@welldone MINGW64 /d/learn_git (master)  -- 此时路径后面会出现一个master，代表当前所处的分支。这个分支是随着版本库的创建而自动创建的
	 *		
	 *		
	 *	将文件提交到版本库：
	 *		1.在/d/learn_git目录下创建一个文件。注：一定要放到learn_git目录下（子目录也行），因为learn_git一个Git仓库，放到其他地方Git再厉害也找不到这个文件
	 *		2.git add <file> 添加到仓库，把要提交的所有修改放到暂存区（Stage/index）
	 *		3.git commit -m <message> 提交到仓库，把暂存区的所有修改一次性提交到分支（branch）
	 *		welld@welldone MINGW64 /d/learn_git (master)
	 *		$ touch readme.txt
	 *
	 *		welld@welldone MINGW64 /d/learn_git (master)
	 *		$ vim readme.txt
	 *		
	 *		welld@welldone MINGW64 /d/learn_git (master)
	 *		$ git add readme.txt
	 *
	 *		welld@welldone MINGW64 /d/learn_git (master)
	 *		$ git commit -m "添加一个新的文件"
	 *		[master (root-commit) 624c335] 1
	 *		1 file changed, 1 insertion(+)
	 *		create mode 100644 readme.txt
	 *	
	 *	git status当前目录下文件的状态
	 *		Changes not staged for commit（未添加到暂存区）：发生过修改，但是还没有添加到暂存区的文件列表。
	 *		Untracked files（未追踪）：未添加到版本库，且未添加到暂存区的文件列表。 注：如果此时将其添加到暂存区会变成Changes to be committed
	 *		Changes to be committed（可提交）：已添加到暂存区，可以进行提交的文件列表。
	 *		nothing to commit, working tree clean：当前目录未发生过任何更改
	 *
	 *	git diff可以查看修改内容
	 *	git log 查看提交记录
	 *	git reflog 查看提交记录
	 *		注：log只能看当前版本之前的记录，reflog可以查看当前版本之后的记录，用于回退时查询提交id
	 *	git reset --hard HEAD^ 回到当前版本的上一个版本，同理HEAD^^代表当前版本的前两个版本
	 *	git reset --hard  4f36ad5735d75e92d167db410c321f9c43354390  回到制定提交id的版本 
	 *	
	 *
	 *	工作区（Working Directory）：电脑中可以看到的目录，如上述的learn_git文件夹，每个项目对应一个工作区。
	 *	版本库（Repository）：每一个工作区中都有一个隐藏的.git文件夹，它就是Git的版本库，使用git init后，即会在该文件夹下创建。
	 *		版本库中包含两个重要的部分：暂存区和分支，暂存区称为stage或index；默认的分支为master，也是在git init后创建
	 *	注：工作区的文件通过git add添加到暂存区，暂存区的内容通过git commit<一次性>提交到某个分支中。如果某个文件第一次进行了修改并add到暂存区，然后进行第二次修改，此时进行commit只会将第一次的修改提交到分支，第二次修改没有add到暂存区，是不会进行提交的。
	 *
	 *	撤销工作区的更改：git checkout -- Readme.java，  git checkout -- *表示对当前目录下的所有文件都执行撤销，其实就是从分支重新检出。
	 *	撤销工作区的更改，并且已经添加到了暂存区：git reset HEAD Readme.java，然后使用git checkout
	 *	注：使用eclipse的Git插件可以在Git Staging窗口使用Replace with HEAD Rversion进行修改撤回。
	 *
	 *	工作区文件删除：
	 *		误删：git checkout -- Readme.java，恢复到最新版本，但是期间的修改会永远丢失
	 *		正常删除：git rm <file>，其作用于git add类似，无非一个是新增，一个是删除，都是会进入暂存区的，然后commit进行删除的提交
	 *
	 *	关连远程仓库：git remote add origin git@server-name:path/repo-name.git；origin表示给远程仓库取的名字，这是Git默认的叫法，也可以改成别的。一般我们只需要跟扮演“中央服务器”的远程库做关联。
	 *			以上为ssh形式的仓库地址；也可以关联https形式的仓库地址：git remote add origin https://github.com/13476239529/git_use.git。			
	 *	查看关联的远程仓库：git remote -v
	 *		origin  http://10.100.21.13/datacenter/yzbizcenter.git (fetch)
	 *		origin  http://10.100.21.13/datacenter/yzbizcenter.git (push)
	 *		注：fetch、push代表了获取和推送的地址
	 *	删除关联的远程仓库：git remote rm origin；origin表示名称，删除时先查看关联的远程仓库，然后根据名称删除。
	 *	将本地库的当前分支推送到远程库的指定分支上： git push origin master；origin表示远程库名称，master表示远程库的分支名称
	 *		
	 */
}
